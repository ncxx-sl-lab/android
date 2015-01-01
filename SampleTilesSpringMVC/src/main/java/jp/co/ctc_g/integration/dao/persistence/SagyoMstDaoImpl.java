// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.integration.dao.persistence;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.SagyoMstDao;
import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.SagyoMst;

import org.springframework.stereotype.Repository;

/**
*
* @author z1j7663
* @version 1.0.0
*/
@Repository
public class SagyoMstDaoImpl implements SagyoMstDao {

	@Override
	public List<CmbBox> findCmbBox() {
		List<CmbBox> l = new ArrayList<CmbBox>();
		l.add(new CmbBox("", ""));
		l.add(new CmbBox("B1239", "作業実施"));
		l.add(new CmbBox("B1249", "消耗品保守作業全般"));
		return l;
	}

	@Override
	public List<SagyoMst> findAll() {
		List<SagyoMst> l = new ArrayList<SagyoMst>();
		SagyoMst s = new SagyoMst();
		s.setSagyoCode("B1239");
		s.setSagyoName("作業実施");
		l.add(s);

		s = new SagyoMst();
		s.setSagyoCode("B1249");
		s.setSagyoName("消耗品保守作業全般");
		s.setGroupCode("2");
		l.add(s);

		s = new SagyoMst();
		s.setSagyoCode("B2400");
		s.setSagyoName("独自開発ソフトウェア変更");
		s.setGroupCode("1");
		l.add(s);

		return l;
	}

}
