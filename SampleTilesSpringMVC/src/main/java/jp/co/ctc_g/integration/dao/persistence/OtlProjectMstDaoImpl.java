// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.integration.dao.persistence;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.OtlProjectMstDao;
import jp.co.ctc_g.business.domain.CmbBox;

import org.springframework.stereotype.Repository;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
@Repository
public class OtlProjectMstDaoImpl implements OtlProjectMstDao {

	@Override
	public List<CmbBox> findCmbBox() {
		List<CmbBox> l = new ArrayList<CmbBox>();
		l.add(new CmbBox("", ""));
		l.add(new CmbBox("2011000108", "不正検知システム更改"));
		l.add(new CmbBox("2011000536", "スイッチ設定変更(ビジネクスト)"));
		return l;
	}


}
