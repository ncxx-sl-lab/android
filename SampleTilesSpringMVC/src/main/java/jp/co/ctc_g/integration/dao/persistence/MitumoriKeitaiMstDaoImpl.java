// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.integration.dao.persistence;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.MitumoriKeitaiMstDao;
import jp.co.ctc_g.business.domain.CmbBox;

import org.springframework.stereotype.Repository;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
@Repository
public class MitumoriKeitaiMstDaoImpl implements MitumoriKeitaiMstDao {

	@Override
	public List<CmbBox> findCmbBox() {
		List<CmbBox> l = new ArrayList<CmbBox>();
		l.add(new CmbBox("", ""));
		l.add(new CmbBox("1", "作業"));
		l.add(new CmbBox("2", "開発"));
		l.add(new CmbBox("9", "その他"));
		l.add(new CmbBox("A", "A保守"));
		return l;
	}

}
