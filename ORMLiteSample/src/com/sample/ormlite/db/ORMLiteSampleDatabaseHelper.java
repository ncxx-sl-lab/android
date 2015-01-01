package com.sample.ormlite.db;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sample.ormlite.db.entity.MProjectEntity;

public class ORMLiteSampleDatabaseHelper extends OrmLiteSqliteOpenHelper {

	/** データベース名 */
	private static final String DATABASE_NAME = "OrmLiteSampel.db";
	/** データベースバージョン */
	private static final int DATABASE_VERSION = 1;

	/**
	 * コンストラクタ
	 * @param context
	 */
	public ORMLiteSampleDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * コンストラクタ
	 * @param context
	 * @param databaseName
	 * @param factory
	 * @param databaseVersion
	 */
	public ORMLiteSampleDatabaseHelper(Context context, String databaseName, CursorFactory factory, int databaseVersion) {
		super(context, databaseName, factory, databaseVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource) {
		try {
			TableUtils.createTableIfNotExists(connectionsource, MProjectEntity.class);
		} catch (SQLException e) {
			Log.e(ORMLiteSampleDatabaseHelper.class.getName(), "データベースの作成に失敗しました。");
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
