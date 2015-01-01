// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.common.HtmlEscapeObjectMapperFactory;
import jp.co.ctc_g.presentation.controller.ProSerGridForm;
import jp.co.ctc_g.presentation.controller.common.JqGridForm;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
@Service
public class ProServiceImpl implements ProService {

	@Override
	public JqGridForm searchProject() {
		JqGridForm form = new JqGridForm();
		List<Object> rows = new ArrayList<Object>();
		ProSerGridForm row;
		for (int i = 0; i < 30; i++) {
			row = new ProSerGridForm();
			row.setPjCd("0000" + String.format("%02d", i));
			row.setPjName("テストプロジェクト");
			row.setKikanFrom("2012/01/" + String.format("%02d", i));
			row.setKikanTo("2013/04/" + String.format("%02d", i));
			row.setQaNo("");
			row.setAnkenTanto("");
			row.setSbNo("ABCDE");
			row.setTantouName("溝口 一徳");
			row.setUchiTantouName("溝口 一徳");
			row.setYst1("2013/01/" + String.format("%02d", i));
			row.setYhonbanW("2013/03/" + String.format("%02d", i));
			row.setKanryoDate("2013/03/" + String.format("%02d", i));
			rows.add(row);
		}
		form.setTotal(1);
		form.setPage(1);
		form.setRecords(rows.size());
		form.setRows(rows);
		return form;
	}

	@Override
	public String searchProjectJsonString() {
		JqGridForm form = this.searchProject();
		ObjectMapper om = HtmlEscapeObjectMapperFactory.createObjectMapper();
		String ret = "";
		try {
			ret = om.writeValueAsString(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
