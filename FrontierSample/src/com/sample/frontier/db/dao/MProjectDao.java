package com.sample.frontier.db.dao;

import java.util.List;

import com.sample.frontier.activity.R;
import com.sample.frontier.db.entity.MProjectEntity;

import frontier.annotation.FRMappingXml;
import frontier.app.FRNameValuePair;
import frontier.db.FRDatabaseDao;

/**
 * プロジェクトマスタテーブルDao
 * @author Hiroshi Tsuji
 *
 */
@FRMappingXml(R.xml.sql_mproject)
public class MProjectDao extends FRDatabaseDao {

	/**
	 * プライマリキーでエンティティを取得します
	 * @param projectCd プロジェクトコード
	 * @param branchNo 枝番
	 * @return MProjectエンティティ
	 */
	public MProjectEntity getEntity(String projectCd, String branchNo) {
		return getSqlMapper().selectForObject(
				"getEntity"
				, MProjectEntity.class
				, new FRNameValuePair("projectCd", projectCd)
				, new FRNameValuePair("branchNo", branchNo)
		);
	}

	/**
	 * 全エンティティを取得します
	 * @return
	 */
	public List<MProjectEntity> getFindAll() {
		return getSqlMapper().selectForList("getEntity", MProjectEntity.class);
	}

	/**
	 * データの登録を行います
	 * @param entity
	 */
	public void insert(MProjectEntity entity) {
		getSqlMapper().insert("insert", entity);
	}

	/**
	 * データの更新を行います
	 * @param entity
	 */
	public void update(MProjectEntity entity) {
		getSqlMapper().update("update", entity);
	}

	/**
	 * データの削除を行います
	 * @param entity
	 */
	public void delete(MProjectEntity entity) {
		getSqlMapper().delete("delete", entity);
	}
}
