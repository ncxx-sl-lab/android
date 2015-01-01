package jp.sji.kansai.demo.action.api;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import jp.sji.kansai.demo.action.BaseApiAction;
import jp.sji.kansai.demo.dao.C2DMRegistInfoDao;
import jp.sji.kansai.demo.exception.SystemErrorException;
import jp.sji.kansai.demo.form.BaseApiForm;
import jp.sji.kansai.demo.util.DBManager;

/**
 * C2DM用registrationID解除APIのアクションクラス
 *
 * @author teraoka
 */
public class C2DMUnRegistAction extends BaseApiAction {

	private static final long serialVersionUID = 1L;

	/**
	 * APIの処理を実行する。
	 */
	public void process(BaseApiForm baseForm, HttpServletRequest request) {

		// リクエストパラメータの取得
		String division = request.getParameter("division");
		String deviceId = request.getParameter("deviceId");

		Connection conn=null;
		try{
			// C2DMの設定情報を論理削除
			conn = DBManager.getConnection();
			C2DMRegistInfoDao.deleteRegistrationInfo(conn, division, deviceId);
			conn.commit();
		}catch(Exception ex){
			try{
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException e) {}

			throw new SystemErrorException(ex);

		}finally{
			try{
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e){}
		}

	}
}
