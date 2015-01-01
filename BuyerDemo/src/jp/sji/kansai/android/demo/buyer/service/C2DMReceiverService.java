package jp.sji.kansai.android.demo.buyer.service;

import jp.sji.kansai.android.demo.buyer.OrderListActivity;
import jp.sji.kansai.android.demo.buyer.PushSetUpActivity;
import jp.sji.kansai.android.demo.buyer.util.APServerManager;
import jp.sji.kansai.android.demo.buyer.util.C2DMManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * C2DMサーバーから受信した情報を処理するサービスクラス<br>
 * (受信する情報には、registrationIDの登録・解除結果、プッシュされたメッセージがある)
 */
public class C2DMReceiverService extends IntentService {

	/**
	 * コンストラクタ
	 */
	public C2DMReceiverService() {
		super("C2DMReceiverService");
	}

	/**
	 * 本サービスを開始する。
	 *
	 * @param context コンテキスト
	 * @param intent インテント
	 */
	public static void start(Context context, Intent intent) {
		intent.setClass(context, C2DMReceiverService.class);
		context.startService(intent);
	}

	/**
	 * C2DMサーバーから受信した情報のハンドリングを行う。
	 *
	 * @param intent インテント
	 */
	@Override
	public final void onHandleIntent(Intent intent) {
		Context context = getApplicationContext();
		if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
			// registrationIDの登録・解除結果を受信した場合
			handleRegistration(context, intent);
		} else if (intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE")) {
			// プッシュされたメッセージを受信した場合
			handleMessage(context, intent);
		} else if (intent.getAction().equals("com.google.android.c2dm.intent.RETRY")) {
			// リトライの指示を受信を場合、Android端末の登録処理をもう一度行う。
			C2DMManager.register(context);
		}
	}

	/**
	 * C2DMサーバーから受信したregistrationIDの登録・解除結果のハンドリングを行う。
	 *
	 * @param context コンテキスト
	 * @param intent インテント
	 */
	private void handleRegistration(Context context, Intent intent) {

		// registrationIDを取得する
		String registrationId = intent.getStringExtra("registration_id");

		Log.i(this.getClass().getName(), "registration ID = " + registrationId);

		if (intent.getStringExtra("error") != null) {
			//------------------------
			// 登録が失敗した場合
			//------------------------
			// 後で再度トライの必要あり。
			Log.e(this.getClass().getName(), "registration IDの登録が失敗");

			// 端末に保存したC2DMの設定情報をクリアする。
			C2DMManager.clearC2dmInfo(context);

			// インテントの作成(C2DMの登録結果画面表示)
			Intent nextIntent = new Intent(PushSetUpActivity.REGIST_RESULT_DISP_ACTION);
			// インテントに実行結果(失敗)を設定
			nextIntent.putExtra(PushSetUpActivity.PARAM_RESULT, PushSetUpActivity.RESULT_FAILED);

			// インテントのブロードキャスト(C2DMの登録結果画面表示へ)
			context.sendBroadcast(nextIntent);

		} else if (intent.getStringExtra("unregistered") != null) {
			//------------------------
			// 登録解除が完了した場合
			//------------------------
			// インテントの作成(C2DMの登録結果画面表示)
			Intent nextIntent = new Intent(PushSetUpActivity.REGIST_RESULT_DISP_ACTION);
			try {
				// APサーバーに登録したregistrationIDを解除する。(別スレッドで実施する必要あり)
				APServerManager.unregister(context);

				// 端末に保存したC2DMの設定情報をクリアする。
				C2DMManager.clearC2dmInfo(context);

				// インテントに実行結果(成功)を設定
				nextIntent.putExtra(PushSetUpActivity.PARAM_RESULT, PushSetUpActivity.RESULT_SUCCESS);

			} catch (Exception ex) {
				// インテントに実行結果(失敗)を設定
				nextIntent.putExtra(PushSetUpActivity.PARAM_RESULT, PushSetUpActivity.RESULT_FAILED);
			}

			// インテントのブロードキャスト(C2DMの登録結果画面表示へ)
			context.sendBroadcast(nextIntent);

		} else if (registrationId != null) {
			//------------------------
			// 登録が完了した場合
			//------------------------
			// インテントの作成(C2DMの登録結果画面表示)
			Intent nextIntent = new Intent(PushSetUpActivity.REGIST_RESULT_DISP_ACTION);
			try {
				// APサーバーにregistrationIDを登録する。(別スレッドで実施する必要あり)
				APServerManager.register(context, C2DMManager.getEmpNo(context), registrationId);

				// registration IDを端末に保存する。
				C2DMManager.saveRegistrationId(context, registrationId);

				// インテントに実行結果(失敗)を設定
				nextIntent.putExtra(PushSetUpActivity.PARAM_RESULT, PushSetUpActivity.RESULT_SUCCESS);

			} catch (Exception ex) {
				// 端末に保存したC2DMの設定情報をクリアする。
				C2DMManager.clearC2dmInfo(context);

				// インテントに実行結果(失敗)を設定
				nextIntent.putExtra(PushSetUpActivity.PARAM_RESULT, PushSetUpActivity.RESULT_FAILED);

			}

			// インテントのブロードキャスト(C2DMの登録結果画面表示へ)
			context.sendBroadcast(nextIntent);
		}
	}

	/**
	 * C2DMサーバーからプッシュされたメッセージのハンドリングを行う。
	 *
	 * @param context コンテキスト
	 * @param intent インテント
	 */
	private void handleMessage(Context context, Intent intent) {

		// C2DMサーバーから送信されたメッセージを受信する。
		String message = intent.getExtras().getString("message");

		Log.i(this.getClass().getName(), "★★★★★★★★★★★★");
		Log.i(this.getClass().getName(), message);
		Log.i(this.getClass().getName(), "★★★★★★★★★★★★");

		// NotificationManager の参照
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

		// Notification をインスタンス化
		int icon = android.R.drawable.ic_notification_overlay;
		CharSequence tickerText = "新しい通知が届きました。";
		long when = System.currentTimeMillis();

		Notification notification = new Notification(icon, tickerText, when);
		notification.flags =Notification.FLAG_AUTO_CANCEL;

		// 通知メッセージの作成
		CharSequence contentTitle = "購入依頼";
		CharSequence contentText = message;

		// TODO [teraoka] 通知履歴が未作成のため、とりあえず遷移先を発注履歴に設定
		Intent notificationIntent = new Intent(this, OrderListActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		mNotificationManager.notify(1, notification);
	}
}
