// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.dao;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
public interface MitumoriKeitaiMstDao {

	/**
	 * リストボックス用データ取得
	 * @return リストボックス
	 */
	public List<CmbBox> findCmbBox();

}
