package jp.sji.kansai.demo.constants;

import jp.sji.kansai.demo.util.SystemUtil;

/**
 * プロパティ用の定数クラス
 *
 * @author teraoka
 */
public class PropertyConstants {

	/** プッシュ通知用URL */
	public final static String GOOGLE_PUSH_URL = SystemUtil.getProperty("GOOGLE_PUSH_URL");

	/** クライアント認証トークン発行用URL */
	public final static String GOOGLE_CLIENT_LOGIN_URL = SystemUtil.getProperty("GOOGLE_CLIENT_LOGIN_URL");

	/** クライアント認証用ID(Gmailのメールアドレス) */
	public final static String GOOGLE_CLIENT_ID = SystemUtil.getProperty("GOOGLE_CLIENT_ID");

	/** クライアント認証用パスワード */
	public final static String GOOGLE_CLIENT_PASSWORD= SystemUtil.getProperty("GOOGLE_CLIENT_PASSWORD");

}
