// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.integration.dao.persistence;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.OtlProjectConvertDao;
import jp.co.ctc_g.business.domain.OtlProjectConvert;

import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
@Repository
public class OtlProjectConvertDaoImpl implements OtlProjectConvertDao {

	@Override
	public List<OtlProjectConvert> findByPrimaryKey(String projectCode, String otlProjectCode) {
		List<OtlProjectConvert> l = new ArrayList<OtlProjectConvert>();
		OtlProjectConvert tmp = new OtlProjectConvert();
		tmp.setOtlComment("てすとコメント");
		l.add(tmp);
		return l;
	}

}
