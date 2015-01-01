package com.sample.ormlite.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.sample.ormlite.db.ORMLiteSampleDatabaseHelper;
import com.sample.ormlite.db.entity.MProjectEntity;

/**
 *
 * @author Hiroshi Tsuji
 *
 */
public class MProjectDao {

	private Context context;

	private ORMLiteSampleDatabaseHelper ormLiteSampleDatabaseHelper;

	private static final String TAG = MProjectDao.class.getName();

	/**
	 * コンストラクタ
	 * @param context
	 */
	public MProjectDao(Context context) {
		this.context = context;
		this.ormLiteSampleDatabaseHelper = new ORMLiteSampleDatabaseHelper(this.context);
	}

	public void save(MProjectEntity entity) {
		try {
			Dao<MProjectEntity, Integer> dao = this.ormLiteSampleDatabaseHelper.getDao(MProjectEntity.class);
			dao.createOrUpdate(entity);
		} catch(SQLException e) {
			Log.e(MProjectDao.class.getName(), "例外が発生しました。");
		}
	}

	public List<MProjectEntity> findAll() {
		List<MProjectEntity> list = new ArrayList<MProjectEntity>();
		try {
			Dao<MProjectEntity, Integer> dao = this.ormLiteSampleDatabaseHelper.getDao(MProjectEntity.class);
			list = dao.queryForAll();
		} catch (SQLException e) {
			Log.e(MProjectDao.class.getName(), "例外が発生しました。", e);
		}

		return list;
	}

	public MProjectEntity getEntity(MProjectEntity entity) {
		try {
			Dao<MProjectEntity, Integer> dao = this.ormLiteSampleDatabaseHelper.getDao(MProjectEntity.class);
//			return dao.queryForSameId(entity);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("PROJECT_CD", entity.getProjectCd());
			map.put("BRANCH_NO", entity.getBranchNo());
			List<MProjectEntity> list = dao.queryForFieldValuesArgs(map);
			return list.isEmpty() ? new MProjectEntity() : list.get(0);
		} catch (SQLException e) {
			Log.e(TAG, "例外が発生しました。", e);
		}

		return null;
	}

	/**
	 * エンティティの更新を行います
	 * @param entity
	 */
	public void update(MProjectEntity entity) {
		try {
			Dao<MProjectEntity, Integer> dao = this.ormLiteSampleDatabaseHelper.getDao(MProjectEntity.class);
			dao.update(entity);
		} catch (SQLException e) {
			Log.e(TAG, "例外が発生しました。", e);
		}
	}

	/**
	 * エンティティの削除を行います
	 * @param entity
	 */
	public void delete(MProjectEntity entity) {
		try {
			Dao<MProjectEntity, Integer> dao = this.ormLiteSampleDatabaseHelper.getDao(MProjectEntity.class);
			dao.delete(entity);
		} catch (SQLException e) {
			Log.e(TAG, "例外が発生しました。", e);
		}
	}

	public void delete(MProjectEntity... entity) {
		try {
			Dao<MProjectEntity, Integer> dao = this.ormLiteSampleDatabaseHelper.getDao(MProjectEntity.class);
			dao.delete(Arrays.asList(entity));
		} catch (SQLException e) {
			Log.e(TAG, "例外が発生しました。", e);
		}
	}
}
