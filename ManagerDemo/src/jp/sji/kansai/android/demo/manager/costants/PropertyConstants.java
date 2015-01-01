package jp.sji.kansai.android.demo.manager.costants;

import jp.sji.kansai.android.demo.manager.util.SystemUtil;

/**
 * プロパティ用の定数クラス
 *
 * @author teraoka
 */
public class PropertyConstants {

	/** C2DMサーバーを利用する際に申請したGoogleアカウント */
	public static final String GOOGLE_ACCOUNT = SystemUtil.getProperty("GOOGLE_ACCOUNT");

	/** APサーバーのURL */
	public final static String AP_SERVER_URL = SystemUtil.getProperty("AP_SERVER_URL");

	/** 端末のC2DM区分(B：バイヤー M：管理者) */
	public final static String C2DM_DIVISION_DEVICE = SystemUtil.getProperty("C2DM_DIVISION_DEVICE");

	/** プッシュ通知対象のC2DM区分(B：バイヤー M：管理者) */
	public final static String C2DM_DIVISION_PUSH = SystemUtil.getProperty("C2DM_DIVISION_PUSH");

	/** プッシュ通知使用可否(true：プッシュ通知を行う false：プッシュ通知を行わない) */
	public final static String PUSH_ENABLE = SystemUtil.getProperty("PUSH_ENABLE");
}
