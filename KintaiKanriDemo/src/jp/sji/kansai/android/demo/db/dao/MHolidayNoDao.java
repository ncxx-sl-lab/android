package jp.sji.kansai.android.demo.db.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.sji.kansai.android.demo.db.entity.MHolidayNoEntity;
import jp.sji.kansai.android.demo.util.SystemUtil;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * 休暇番号Dao
 * @author Hiroshi Tsuji
 *
 */
public class MHolidayNoDao extends KintaiKanriDao {

	/** テーブル名 */
	private static final String TABLE_NAME = "M_HOLIDAY_NO";

	/** プライマリキー */
	private static final String[] PRIMARY_KEY_COLUMN = {
		MHolidayNoEntity.COLUMN_NAME_HOLIDAY_NO
	};

	/**
	 * コンストラクタ
	 * @param context
	 */
	public MHolidayNoDao(Context context) {
		super(context);
	}

	/**
	 * プライマリーキーを条件にデータを取得します
	 * @param holidayNo 休暇番号
	 * @return
	 */
	public MHolidayNoEntity selectPK(String holidayNo) {
		String query
				= "SELECT "
				+ "    HOLIDAY_NO "
				+ "    ,HOLIDAY_NAME "
				+ "FROM "
				+ "    M_HOLIDAY_NO "
				+ "WHERE 1 = 1 "
				+ "AND HOLIDAY_NO = ? ";

		// SQL実行
		Cursor cursor = super.selectNativeQuery(query, holidayNo);
		MHolidayNoEntity entity = null;

		if (cursor.moveToFirst()) {
			entity = new MHolidayNoEntity();
			// 休暇番号
			entity.setHolidayNo(cursor.getString(cursor.getColumnIndex(MHolidayNoEntity.COLUMN_NAME_HOLIDAY_NO)));
			// 日付
			entity.setHolidayName(cursor.getString(cursor.getColumnIndex(MHolidayNoEntity.COLUMN_NAME_HOLIDAY_NAME)));
		}
		cursor.close();
		return entity;
	}

	/**
	 * データの登録を行います
	 * @param entity
	 */
	public void insert(MHolidayNoEntity entity) {
		Map<String, String> insertValuesMap = new HashMap<String, String>();

		// 休暇番号
		insertValuesMap.put(MHolidayNoEntity.COLUMN_NAME_HOLIDAY_NO, entity.getHolidayNo());
		// 休暇名
		if (SystemUtil.isNotEmpty(entity.getHolidayName())) {
			insertValuesMap.put(MHolidayNoEntity.COLUMN_NAME_HOLIDAY_NAME, entity.getHolidayName());
		}

		super.insertQuery(TABLE_NAME, insertValuesMap);
	}

	/**
	 * プライマリーキーを条件に指定された値を変更します
	 * @param holidayNo
	 * @param updParamMap
	 * @return
	 */
	public int updatePK(String holidayNo, Map<String, String> updParamMap) {
		int result = -1;
		if (updParamMap == null || updParamMap.isEmpty()) {
			Log.d(this.getClass().getName(), "Update値が指定されていません。");
			return result;
		}

		result = super.updateQuery(TABLE_NAME, updParamMap, super.createWhereClauseMap(PRIMARY_KEY_COLUMN, holidayNo));
		return result;
	}

	/**
	 * プライマリーキーを条件にレコードを削除します
	 * @return
	 */
	public int deletePK(String holidayNo) {
		int result = -1;

		result = super.deleteQuery(TABLE_NAME, super.createWhereClauseMap(PRIMARY_KEY_COLUMN, holidayNo));
		return result;
	}

	/**
	 * 全データを取得します
	 * @return
	 */
	public List<MHolidayNoEntity> selectAll() {

		String query
				= "SELECT"
				+ "    HOLIDAY_NO "
				+ "    ,HOLIDAY_NAME "
				+ "FROM "
				+ "    M_HOLIDAY_NO "
				+ "WHERE 1 = 1"
				+ "ORDER BY HOLIDAY_NO";


		Cursor cursor = super.selectNativeQuery(query);
		List<MHolidayNoEntity> holidayEntityList = new ArrayList<MHolidayNoEntity>();

		if (cursor.moveToFirst()) {
			do {
				MHolidayNoEntity entity = new MHolidayNoEntity();
				// 休暇番号
				entity.setHolidayNo(cursor.getString(cursor.getColumnIndex(MHolidayNoEntity.COLUMN_NAME_HOLIDAY_NO)));
				// 日付
				entity.setHolidayName(cursor.getString(cursor.getColumnIndex(MHolidayNoEntity.COLUMN_NAME_HOLIDAY_NAME)));

				holidayEntityList.add(entity);
			} while(cursor.moveToNext());
		}
		cursor.close();

		return holidayEntityList;
	}
}
