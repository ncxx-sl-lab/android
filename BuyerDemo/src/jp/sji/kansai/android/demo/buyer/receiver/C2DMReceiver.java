package jp.sji.kansai.android.demo.buyer.receiver;

import jp.sji.kansai.android.demo.buyer.service.C2DMReceiverService;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * C2DMサーバーから送信される情報を受信するレシーバークラス<br>
 * (受信する情報には、registrationIDの登録・解除結果、プッシュされたメッセージがある)
 */
public class C2DMReceiver extends BroadcastReceiver {

	/**
	 * C2DMサーバーから送信される情報(registrationIDの登録・解除結果、プッシュされたメッセージ)を受信する。<br>
	 *
	 * @param context コンテキスト
	 * @param intent インテント
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		// C2DMサーバーから受信した情報を処理するサービスを開始する
		C2DMReceiverService.start(context, intent);

		setResult(Activity.RESULT_OK, null, null);
	}

}