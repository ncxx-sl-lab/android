package com.sample.ormlite.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.sample.ormlite.R;
import com.sample.ormlite.db.dao.MProjectDao;
import com.sample.ormlite.db.entity.MProjectEntity;

public class ORMLiteSampleActivity extends Activity {

	private MProjectDao dao = new MProjectDao(this);

	private static final String TAG = ORMLiteSampleActivity.class.getName();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		selectTest();
		insertTest();
		updateTest();
		deleteTest();

//		MProjectEntity entity1 = new MProjectEntity();
//		entity1.setProjectCd("90001");
//		entity1.setBranchNo("001");
//		entity1.setProjectName("プロジェクト１");
//		entity1.setValidPeriodStart("4");
//		entity1.setValidPeriodEnd("6");

//		dao.save(entity1);

	}

	private void initData() {
		MProjectEntity delEntity1 = new MProjectEntity();
		delEntity1.setProjectCd("90001");
		delEntity1.setBranchNo("001");
		delEntity1.setProjectName("プロジェクト１");
		delEntity1.setValidPeriodStart("4");
		delEntity1.setValidPeriodEnd("4");

		MProjectEntity delEntity2 = new MProjectEntity();
		delEntity2.setProjectCd("90001");
		delEntity2.setBranchNo("002");
		delEntity2.setProjectName("プロジェクト１");
		delEntity2.setValidPeriodStart("5");
		delEntity2.setValidPeriodEnd("5");

		MProjectEntity delEntity3 = new MProjectEntity();
		delEntity3.setProjectCd("90001");
		delEntity3.setBranchNo("003");
		delEntity3.setProjectName("プロジェクト１");
		delEntity3.setValidPeriodStart("6");
		delEntity3.setValidPeriodEnd("6");

		MProjectEntity delEntity4 = new MProjectEntity();
		delEntity4.setProjectCd("90002");
		delEntity4.setBranchNo("001");
		delEntity4.setProjectName("プロジェクト２");
		delEntity4.setValidPeriodStart("4");
		delEntity4.setValidPeriodEnd("4");

		MProjectEntity delEntity5 = new MProjectEntity();
		delEntity5.setProjectCd("90002");
		delEntity5.setBranchNo("002");
		delEntity5.setProjectName("プロジェクト２");
		delEntity5.setValidPeriodStart("5");
		delEntity5.setValidPeriodEnd("5");

		MProjectDao dao = new MProjectDao(this);
		dao.delete(delEntity1, delEntity2, delEntity3, delEntity4, delEntity5);
	}

	private void selectTest() {

		Log.d(TAG, "-----一覧取得開始-----");

		List<MProjectEntity> mProjectEntityList = this.dao.findAll();
		for (MProjectEntity e : mProjectEntityList) {
			Log.d(ORMLiteSampleActivity.class.getName(), e.toString());
		}

		Log.d(TAG, "-----一覧取得終了-----");

		Log.d(TAG, "-----プライマリキーでエンティティ取得開始-----");

		MProjectEntity selEntity = new MProjectEntity();
		selEntity.setProjectCd("90002");
		selEntity.setBranchNo("002");

		MProjectEntity resultEntity = this.dao.getEntity(selEntity);
		Log.d(TAG, resultEntity.toString());

		Log.d(TAG, "-----プライマリキーでエンティティ取得終了-----");
	}

	private void insertTest() {
		Log.d(TAG, "-----エンティティの登録開始-----");

		MProjectEntity delEntity = new MProjectEntity();
		delEntity.setProjectCd("77777");
		delEntity.setBranchNo("777");
		this.dao.delete(delEntity);

		MProjectEntity insEntity = new MProjectEntity();
		insEntity.setProjectCd("77777");
		insEntity.setBranchNo("777");
		insEntity.setProjectName("プロジェクト７");
		insEntity.setValidPeriodStart("77");
		insEntity.setValidPeriodEnd("77");
		this.dao.save(insEntity);

		MProjectEntity selEntity = new MProjectEntity();
		selEntity.setProjectCd("77777");
		selEntity.setBranchNo("777");
		MProjectEntity resultEntity = this.dao.getEntity(selEntity);
		Log.d(TAG, resultEntity.toString());

		Log.d(TAG, "-----エンティティの登録終了-----");
	}

	private void updateTest() {
		Log.d(TAG, "-----エンティティの更新開始-----");

		MProjectEntity delEntity = new MProjectEntity();
		delEntity.setProjectCd("88888");
		delEntity.setBranchNo("888");
		this.dao.delete(delEntity);

		MProjectEntity insEntity = new MProjectEntity();
		insEntity.setProjectCd("88888");
		insEntity.setBranchNo("888");
		insEntity.setProjectName("プロジェクト８");
		insEntity.setValidPeriodStart("88");
		insEntity.setValidPeriodEnd("88");
		this.dao.save(insEntity);

		MProjectEntity selEntity = new MProjectEntity();
		selEntity.setProjectCd("88888");
		selEntity.setBranchNo("888");
		Log.d(TAG, "---更新前---");
		MProjectEntity resultEntity = this.dao.getEntity(selEntity);
		Log.d(TAG, resultEntity.toString());

		MProjectEntity updEntity = new MProjectEntity();
		updEntity.setProjectCd("88888");
		updEntity.setBranchNo("888");
		updEntity.setProjectName("プロジェクト８８８");
		updEntity.setValidPeriodStart("888");
		updEntity.setValidPeriodEnd("888");
		this.dao.update(updEntity);

		resultEntity = this.dao.getEntity(selEntity);
		Log.d(TAG, "---更新後---");
		Log.d(TAG, resultEntity.toString());

		Log.d(TAG, "-----エンティティの更新終了-----");
	}

	private void deleteTest() {
		Log.d(TAG, "-----エンティティの削除開始-----");

		MProjectEntity delEntity = new MProjectEntity();
		delEntity.setProjectCd("99999");
		delEntity.setBranchNo("999");
		this.dao.delete(delEntity);

		MProjectEntity insEntity = new MProjectEntity();
		insEntity.setProjectCd("99999");
		insEntity.setBranchNo("999");
		insEntity.setProjectName("プロジェクト９");
		insEntity.setValidPeriodStart("99");
		insEntity.setValidPeriodEnd("99");
		this.dao.save(insEntity);

		MProjectEntity selEntity = new MProjectEntity();
		selEntity.setProjectCd("99999");
		selEntity.setBranchNo("999");
		Log.d(TAG, "---削除前---");
		MProjectEntity resultEntity = this.dao.getEntity(selEntity);
		Log.d(TAG, resultEntity.toString());

		MProjectEntity delEntity2 = new MProjectEntity();
		delEntity2.setProjectCd("99999");
		delEntity2.setBranchNo("999");
		this.dao.delete(delEntity2);

		resultEntity = this.dao.getEntity(selEntity);
		Log.d(TAG, "---削除後---");
		if (resultEntity == null) {
			Log.d(TAG, "エンティティが取得できませんでした。");
		} else {
			Log.d(TAG, resultEntity.toString());
		}

		Log.d(TAG, "-----エンティティの削除終了-----");
	}
}