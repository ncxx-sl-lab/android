package com.sample.frontier.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.sample.frontier.db.dao.MProjectDao;
import com.sample.frontier.db.entity.MProjectEntity;

import frontier.db.FRDatabaseManager;

public class FrontierSampleActivity extends Activity {

	private static final String DATABASE_NAME = "FrontierSample.db";

	private static final String TAG = FrontierSampleActivity.class.getName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frontier_sample);

		// DBファイルをassetsからコピーする
		// TODO [Tsuji] 第三引数のブール値は、端末(エミュレータ内)のDBファイルを上書きするかどうか
		FRDatabaseManager.copyDatabaseFromAssets(this, DATABASE_NAME, true);

		// デフォルトDBファイル名を指定する
		FRDatabaseManager.setDefaultDatabaseName(this, DATABASE_NAME);

		// プロジェクトマスタDaoを取得する
		MProjectDao dao = FRDatabaseManager.getInstance(this).getDao(
				this
				, MProjectDao.class
		);

		// 一覧取得
		Log.d(TAG, "-----一覧取得開始-----");
		List<MProjectEntity> entityList = dao.getFindAll();
		for (MProjectEntity entity : entityList) {
			Log.d(TAG, entity.toString());
		}
		Log.d(TAG, "-----一覧取得終了-----");

		// プライマリキーでエンティティ取得
		Log.d(TAG, "-----プライマリキーでエンティティ取得開始-----");
		MProjectEntity entity1 = dao.getEntity("90002", "001");
		Log.d(FrontierSampleActivity.class.getName(), entity1.toString());
		Log.d(TAG, "-----プライマリキーでエンティティ取得終了-----");

		// エンティティの登録
		Log.d(TAG, "-----エンティティの登録開始-----");
		MProjectEntity insEntity = null;
		insEntity = new MProjectEntity();
		insEntity.setProjectCd("77777");
		insEntity.setBranchNo("777");
		insEntity.setProjectName("プロジェクト７");
		insEntity.setValidPeriodStart("77");
		insEntity.setValidPeriodEnd("77");
		dao.insert(insEntity);

		MProjectEntity insConfirmEntity = dao.getEntity("77777", "777");
		Log.d(TAG, insConfirmEntity.toString());
		Log.d(TAG, "-----エンティティの登録終了-----");

		// エンティティの更新
		Log.d(TAG, "-----エンティティの更新開始-----");
		// 更新用エンティティを登録
		insEntity = new MProjectEntity();
		insEntity.setProjectCd("88888");
		insEntity.setBranchNo("888");
		insEntity.setProjectName("プロジェクト８");
		insEntity.setValidPeriodStart("88");
		insEntity.setValidPeriodEnd("88");
		dao.insert(insEntity);

		// 更新用エンティティの登録確認
		MProjectEntity updConfirmEntity = dao.getEntity("88888", "888");
		Log.d(TAG, updConfirmEntity.toString());

		MProjectEntity updEntity = new MProjectEntity();
		updEntity.setProjectCd("88888");
		updEntity.setBranchNo("888");
		updEntity.setProjectName("プロジェクト８８８");
		updEntity.setValidPeriodStart("888");
		updEntity.setValidPeriodEnd("888");

		dao.update(updEntity);

		updConfirmEntity = dao.getEntity("88888", "888");
		Log.d(TAG, updConfirmEntity.toString());
		Log.d(TAG, "-----エンティティの更新終了-----");

		// エンティティの削除
		Log.d(TAG, "-----エンティティの削除開始-----");
		// 削除用エンティティを登録
		insEntity = new MProjectEntity();
		insEntity.setProjectCd("99999");
		insEntity.setBranchNo("999");
		insEntity.setProjectName("プロジェクト９");
		insEntity.setValidPeriodStart("99");
		insEntity.setValidPeriodEnd("99");
		dao.insert(insEntity);

		// 削除用エンティティの登録確認
		MProjectEntity delConfirmEntity = dao.getEntity("99999", "999");
		Log.d(TAG, delConfirmEntity.toString());

		MProjectEntity delEntity = new MProjectEntity();
		delEntity.setProjectCd("99999");
		delEntity.setBranchNo("999");
		dao.delete(delEntity);

		delConfirmEntity = dao.getEntity("99999", "999");
		if (delConfirmEntity == null) {
			Log.d(TAG, "エンティティが取得できませんでした。");
		} else {
			Log.d(TAG, delConfirmEntity.toString());
		}
		Log.d(TAG, "-----エンティティの削除終了-----");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_frontier_sample, menu);
		return true;
	}

}
