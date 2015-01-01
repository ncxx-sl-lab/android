// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.integration.dao.persistence;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.ShosaiMstDao;
import jp.co.ctc_g.business.domain.ShosaiMst;

import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
@Repository
public class ShosaiMstDaoImpl implements ShosaiMstDao {

	@Override
	public List<ShosaiMst> findAll() {
		List<ShosaiMst> l = new ArrayList<ShosaiMst>();
		ShosaiMst s = new ShosaiMst();
		s.setShosaiCode("ASSEN.xls");
		s.setShosaiName("業務実績日報（斡旋）帳票フォーマット");
		l.add(s);

		s = new ShosaiMst();
		s.setShosaiCode("Aiful_Clist");
		s.setShosaiName("Mosaixコールリスト作成");
		l.add(s);

		s = new ShosaiMst();
		s.setShosaiCode("Aiful_Ncon");
		s.setShosaiName("Mosaix不出話中");
		l.add(s);

		return l;
	}

}
