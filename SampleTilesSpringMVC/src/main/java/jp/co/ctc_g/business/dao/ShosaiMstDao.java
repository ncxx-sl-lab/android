// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.dao;

import java.util.List;

import jp.co.ctc_g.business.domain.ShosaiMst;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
public interface ShosaiMstDao {

	/**
	 * 詳細マスタを全件取得する。
	 * @return <ShosaiMst>
	 */
	List<ShosaiMst> findAll();

}
