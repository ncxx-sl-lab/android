// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.service;

import jp.co.ctc_g.presentation.controller.common.JqGridForm;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
public interface ProService {

	/**
	 * プロジェクト一覧を検索する
	 * @return JqGridForm
	 */
	public JqGridForm searchProject();

	/**
	 * プロジェクト一覧を検索する
	 * @return JqGridForm
	 */
	public String searchProjectJsonString();

}
