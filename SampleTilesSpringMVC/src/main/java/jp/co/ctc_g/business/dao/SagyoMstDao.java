// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.dao;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.SagyoMst;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
public interface SagyoMstDao {

	/**
	 * 作業マスタのリストボックス用データ取得
	 * @return リストボックス
	 */
	public List<CmbBox> findCmbBox();

	/**
	 * 全作業マスタ取得する
	 * @return List<SagyoMst>
	 */
	public List<SagyoMst> findAll();

}
