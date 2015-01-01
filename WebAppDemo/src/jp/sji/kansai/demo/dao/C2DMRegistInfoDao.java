package jp.sji.kansai.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * c2dm_regist_infoテーブルのDaoクラス
 */
public class C2DMRegistInfoDao {

	/**
	 * プッシュ通知対象のregistrationIDを取得
	 *
	 * @param conn コネクション
	 * @param empNo 社員番号
	 * @param division C2DM区分(B：バイヤー、M：管理者)
	 *
	 * @return プッシュ通知対象のregistrationID
	 * @throws SQLException
	 */
	public static String selectRegistrationId(Connection conn, String empNo, String division) throws SQLException {

		// SQL文の作成
		StringBuilder sql = new StringBuilder();
		sql.append("select registration_id")
			.append(" from c2dm_regist_info")
			.append(" where emp_no = ?")
			.append("	and division = ?")
			.append("	and delete_flg = '0'")
			.append(" order by update_date desc");

		// 可変項目のバインド
		PreparedStatement statement = conn.prepareStatement(sql.toString());
		statement.setString(1, empNo);
		statement.setString(2, division);

		// SQL文の実行
		ResultSet rs = statement.executeQuery();

		String registrationId = null;
		if (rs.next()) {
			registrationId = rs.getString("registration_id");
		}

		return registrationId;

	}

	/**
	 * プッシュ通知の設定を登録する。
	 *
	 * @param conn コネクション
	 * @param empNo 社員番号
	 * @param division C2DM区分(B：バイヤー、M：管理者)
	 * @param registrationId C2DMサーバーに登録したID
	 * @param deviceId Android端末のデバイスID
	 *
	 * @return 登録件数
	 * @throws SQLException SQL例外
	 */
	public static int insertRegistrationInfo(Connection conn, String empNo, String division, String registrationId, String deviceId) throws SQLException {

		// SQL文の作成
		StringBuilder sql = new StringBuilder();
		sql.append("insert into c2dm_regist_info")
			.append(" (emp_no, division, registration_id, device_id, delete_flg, create_date, create_id, update_date, update_id)")
			.append(" values (?, ?, ?, ?, '0', SYSDATE, 'C2DMRegist', SYSDATE, 'C2DMRegist')");

		// 可変項目のバインド
		PreparedStatement statement = conn.prepareStatement(sql.toString());
		statement.setString(1, empNo);
		statement.setString(2, division);
		statement.setString(3, registrationId);
		statement.setString(4, deviceId);

		// SQL文の実行
		int count = statement.executeUpdate();

		return count;

	}

	/**
	 * プッシュ通知の設定を論理削除する。
	 *
	 * @param conn コネクション
	 * @param division C2DM区分(B：バイヤー、M：管理者)
	 * @param deviceId Android端末のデバイスID
	 *
	 * @return 登録件数
	 * @throws SQLException SQL例外
	 */
	public static int deleteRegistrationInfo(Connection conn, String division, String deviceId) throws SQLException {

		// SQL文の作成
		StringBuilder sql = new StringBuilder();
		sql.append("update c2dm_regist_info")
			.append(" set delete_flg = '1'")
			.append(" 		,update_date = SYSDATE")
			.append(" 		,update_id = 'C2DMUnRegist'")
			.append(" where division = ?")
			.append("	and device_id = ?");

		// 可変項目のバインド
		PreparedStatement statement = conn.prepareStatement(sql.toString());
		statement.setString(1, division);
		statement.setString(2, deviceId);

		// SQL文の実行
		int count = statement.executeUpdate();

		return count;

	}

}
