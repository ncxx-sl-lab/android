// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.integration.dao.persistence;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.KokyakuMstDao;
import jp.co.ctc_g.business.domain.CmbBox;

import org.springframework.stereotype.Repository;

/**
*
* @author z1j7663
* @version 1.0.0
*/
@Repository
public class KokyakuMstDaoImpl implements KokyakuMstDao {

	@Override
	public List<CmbBox> findCmbBox() {
		List<CmbBox> l = new ArrayList<CmbBox>();
		l.add(new CmbBox("", ""));
		l.add(new CmbBox("00000", "テスト顧客"));
		return l;
	}

}
