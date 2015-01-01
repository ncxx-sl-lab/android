package jp.sji.kansai.android.demo.db.dao;

import java.util.HashMap;
import java.util.Map;

import jp.sji.kansai.android.demo.db.KintaiKanriDBHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * 勤怠管理システムDao
 * @author Hiroshi Tsuji
 *
 */
public class KintaiKanriDao {

	private static final String LOGGING_TAG = "KintaiKanriDao";

	private KintaiKanriDBHelper kintaiKanriDBHelper;

	public KintaiKanriDao(Context context) {
		this.kintaiKanriDBHelper = new KintaiKanriDBHelper(context);
//		db = serviceManagementDBHelper.getWritableDatabase();
	}

	/**
	 * SELECT文を実行します
	 * @param query SQL文
	 * @param params バインドパラメータ
	 * @return
	 */
	protected Cursor selectNativeQuery(String query, String... params) {
		SQLiteDatabase db = this.kintaiKanriDBHelper.getWritableDatabase();
		try {
			Cursor cursor = db.rawQuery(query, params);
			return cursor;
		} finally {
			// TODO [Tsuji] DBのクローズ方法については検討中　このタイミングでクローズを行うとカーソルのオープンができない
			// db.close();
		}
	}

	/**
	 * SQLiteDatabase#insertを実行します
	 *
	 * @param tableName
	 *            テーブル名
	 * @param insertValuesMap
	 *            登録値保持マップ
	 * @return
	 */
	protected long insertQuery(String tableName, Map<String, String> insertValuesMap) {

		long result = -1;
		if (insertValuesMap == null || insertValuesMap.isEmpty()) {
			Log.w(LOGGING_TAG, "Insert値が設定されていません。");
			return result;
		}

		ContentValues contentValues = createContentValues(insertValuesMap);

		SQLiteDatabase db = this.kintaiKanriDBHelper.getWritableDatabase();
		try {
			db.beginTransaction();
			try {
				result = db.insert(tableName, null, contentValues);
				db.setTransactionSuccessful();
			} finally {
				db.endTransaction();
			}
		} finally {
			db.close();
		}

		return result;
	}

	/**
	 * SQLiteDatabase#updateを実行します
	 *
	 * @param tableName
	 *            テーブル名
	 * @param updateValuesMap
	 *            更新対象値保持マップ（KEY：更新対象カラム名、VALUE：更新値）
	 * @param whereClauseMap
	 *            WHERE句保持マップ（KEY：カラム名、VALUE：条件値）
	 * @return
	 */
	protected int updateQuery(String tableName,
			Map<String, String> updateValuesMap,
			Map<String, String> whereClauseMap) {

		int result = -1;
		if (updateValuesMap == null || updateValuesMap.isEmpty()) {
			Log.w(LOGGING_TAG, "Update値が設定されていません。");
			return result;
		}

		// Update対象の値を設定
		ContentValues contentValues = createContentValues(updateValuesMap);

		// WHERE句を作成
		String whereClause = "";
		String[] whereArgs = null;
		if (whereClauseMap != null && !whereClauseMap.isEmpty()) {
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			whereArgs = new String[whereClauseMap.size()];
			for (Map.Entry<String, String> entry : whereClauseMap.entrySet()) {
				if (cnt > 0) {
					sb.append("AND ");
				}
				sb.append(entry.getKey() + " = ? ");

				whereArgs[cnt] = entry.getValue();
				cnt++;
			}

			whereClause = sb.toString();
		}

		SQLiteDatabase db = this.kintaiKanriDBHelper.getWritableDatabase();
		try {
			db.beginTransaction();
			try {
				result = db.update(tableName, contentValues, whereClause, whereArgs);
				db.setTransactionSuccessful();
			} finally {
				db.endTransaction();
			}
		} finally {
			db.close();
		}

		return result;
	}

	/**
	 * SQLiteDatabase#deleteを実行します
	 *
	 * @param tableName
	 *            テーブル名
	 * @param whereClauseMap
	 *            WHERE句保持マップ（KEY：カラム名、VALUE：条件値）
	 * @return 削除件数
	 */
	protected int deleteQuery(String tableName, Map<String, String> whereClauseMap) {

		int result = -1;

		// WHERE句を作成
		String whereClause = "";
		String[] whereArgs = null;
		if (whereClauseMap != null && !whereClauseMap.isEmpty()) {
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			whereArgs = new String[whereClauseMap.size()];
			for (Map.Entry<String, String> entry : whereClauseMap.entrySet()) {
				if (cnt > 0) {
					sb.append("AND ");
				}
				sb.append(entry.getKey() + " = ? ");
				whereArgs[cnt] = entry.getValue();
				cnt++;
			}

			whereClause = sb.toString();
		}

		SQLiteDatabase db = this.kintaiKanriDBHelper.getWritableDatabase();
		try {
			db.beginTransaction();
			try {
				result = db.delete(tableName, whereClause, whereArgs);
				db.setTransactionSuccessful();
			} finally {
				db.endTransaction();
			}
		} finally {
			db.close();
		}

		return result;
	}

	/**
	 *
	 * @param query
	 * @param params
	 */
	@Deprecated
	protected void updateNativeQuery(String query, Object... params) {
		executeQuery(query, params);
	}

	/**
	 *
	 * @param query
	 * @param params
	 */
	@Deprecated
	protected void insertNativeQuery(String query, Object... params) {
		executeQuery(query, params);
	}

	/**
	 *
	 * @param query
	 * @param params
	 */
	@Deprecated
	protected void deleteNativeQuery(String query, Object... params) {
		executeQuery(query, params);
	}

	/**
	 *
	 * @param query
	 * @param params
	 */
	@Deprecated
	private void executeQuery(String query, Object... params) {
		SQLiteDatabase db = this.kintaiKanriDBHelper.getWritableDatabase();

		try {
			db.beginTransaction();
			try {
				db.execSQL(query, params);
				db.setTransactionSuccessful();
			} finally {
				db.endTransaction();
			}
		} finally {
			if (db != null) {
				db.close();
			}
		}

	}

	/**
	 * 引数からContentValuesを生成します
	 * @param valuesMap
	 * @return ContentValues
	 */
	private ContentValues createContentValues(Map<String, String> valuesMap) {
		if (valuesMap == null) {
			return null;
		}

		ContentValues contentValues = new ContentValues();
		for (Map.Entry<String, String> entry : valuesMap.entrySet()) {
			contentValues.put(entry.getKey(), entry.getValue());
		}

		return contentValues;
	}

	/**
	 * WHERE句のカラムと値のマッピングを作成します
	 * @param columnNames
	 * @param whereClauseValues
	 * @return
	 */
	protected Map<String, String> createWhereClauseMap(String[] columnNames, String... whereClauseValues) {

		if (columnNames.length != whereClauseValues.length) {
			return null;
		}

		Map<String, String> whereClauseMap = new HashMap<String, String>();

		for (int i = 0; i < columnNames.length; i++) {
			whereClauseMap.put(columnNames[i], whereClauseValues[i]);
		}

		return whereClauseMap;
	}
}
