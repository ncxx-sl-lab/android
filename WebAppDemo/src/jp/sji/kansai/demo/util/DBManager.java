package jp.sji.kansai.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	/**
	 * コネクションを取得する。
	 */
	public static Connection getConnection() throws SQLException {

		Connection con = DriverManager.getConnection("DEMODB", "sjikansai", "sj1test");

		con.setAutoCommit(false);

		return con;
	}
}
