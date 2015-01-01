// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import jp.co.ctc_g.business.dao.GroupDao;
import jp.co.ctc_g.business.dao.GyomuKbnMstDao;
import jp.co.ctc_g.business.dao.KokyakuBumonMstDao;
import jp.co.ctc_g.business.dao.KokyakuMstDao;
import jp.co.ctc_g.business.dao.MitumoriKeitaiMstDao;
import jp.co.ctc_g.business.dao.OtlProjectConvertDao;
import jp.co.ctc_g.business.dao.OtlProjectMstDao;
import jp.co.ctc_g.business.dao.OtlSagyoMstDao;
import jp.co.ctc_g.business.dao.OtlTypeMstDao;
import jp.co.ctc_g.business.dao.ProjectkbnMstDao;
import jp.co.ctc_g.business.dao.QaKanriMstDao;
import jp.co.ctc_g.business.dao.SagyoMstDao;
import jp.co.ctc_g.business.dao.ShosaiMstDao;
import jp.co.ctc_g.business.dao.SyainDao;
import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.ErrorMessage;
import jp.co.ctc_g.business.service.ProService;
import jp.co.ctc_g.common.HtmlEscapeObjectMapperFactory;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
@Controller
@RequestMapping(value = "/pro")
public class ProController {

	/** プロジェクトサービス */
	@Autowired
	private ProService proService;

	/** プロジェクト区分Dao */
	@Autowired
	private ProjectkbnMstDao projectkbnMstDao;

	/** 顧客マスタDao */
	@Autowired
	private KokyakuMstDao kokyakuMstDao;

	/** グループマスタDao */
	@Autowired
	private GroupDao groupDao;

	/** 見積もり形態マスタDao */
	@Autowired
	private MitumoriKeitaiMstDao mitumoriKeitaiMstDao;

	/** 顧客部門マスタDao */
	@Autowired
	private KokyakuBumonMstDao kokyakuBumonMstDao;

	/** OTLプロジェクトマスタDao */
	@Autowired
	private OtlProjectMstDao otlProjectMstDao;

	/** OTL作業マスタDao */
	@Autowired
	private OtlSagyoMstDao otlSagyoMstDao;

	/** OTLタイプマスタDao */
	@Autowired
	private OtlTypeMstDao otlTypeMstDao;

	/** 社員マスタDao */
	@Autowired
	private SyainDao syainDao;

	/** OTLプロジェクト変換Dao */
	@Autowired
	private OtlProjectConvertDao otlProjectConvertDao;

	/** QA管理マスタDao */
	@Autowired
	private QaKanriMstDao qaKanriMstDao;

	/** 業務区分Dao */
	@Autowired
	private GyomuKbnMstDao gyomuKbnMstDao;

	/** 作業マスタDao */
	@Autowired
	private SagyoMstDao sagyoMstDao;

	/** 作業詳細マスタDao */
	@Autowired
	private ShosaiMstDao shosaiMstDao;

	/**
	 * プロジェクト一覧初期表示
	 * @param bean 画面フォーム
	 * @param result 入力チェック結果
	 * @param model 画面モデル
	 * @return 画面遷移先
	 */
	@RequestMapping(value = "/init")
	public String serShow(@Valid ProSerForm bean, BindingResult result, Model model) {
		bean.setPjkbnList(projectkbnMstDao.findCmbBox());
		bean.setKokyakuList(kokyakuMstDao.findCmbBox());
		bean.setPjListJsonString(proService.searchProjectJsonString());
		return "pro.ser";
	}

	/**
	 * プロジェクト一覧検索
	 * @param bean 画面フォーム
	 * @param result 入力チェック結果
	 * @param model 画面モデル
	 * @return 画面遷移先
	 */
	@RequestMapping(value = "/ajax/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@Valid ProSerForm bean, BindingResult result, Model model)  {
		bean.setValErrFlag(false);
		if (result.hasErrors()) {
			bean.setValErrFlag(true);
			List<FieldError> allErrors = result.getFieldErrors();
			List<ErrorMessage> errorMesages = new ArrayList<ErrorMessage>();
			for (FieldError objectError : allErrors) {
				errorMesages.add(new ErrorMessage(objectError.getField(), objectError.getDefaultMessage()));
			}
			bean.setValErrMsgList(errorMesages);
			return bean;
		}

		return proService.searchProject();
	}

	/**
	 * 編集画面初期表示
	 * @param serBean 画面フォーム
	 * @param result 入力チェック結果
	 * @param model 画面モデル
	 * @return 画面遷移先
	 */
	@RequestMapping(value = "/ent")
	public String entShow(@Valid ProSerForm serBean, BindingResult result, Model model) {
		try {
			ProEntForm bean = new ProEntForm();
			// 前画面情報設定
			ObjectMapper om = HtmlEscapeObjectMapperFactory.createObjectMapper();
			bean.setPreFormJsonString(om.writeValueAsString(serBean));

			// プロジェクト区分マスタ
			bean.setPjkbnList(projectkbnMstDao.findCmbBox());
			// 顧客マスタ
			bean.setKokyakuList(kokyakuMstDao.findCmbBox());
			// 開発分類
			bean.setMitumoriKeitaiList(mitumoriKeitaiMstDao.findCmbBox());
			// 顧客部門
			bean.setKokyakuBumonList(kokyakuBumonMstDao.findCmbBox());
			// OTLプロジェクトマスタ
			bean.setOtlProjectList(otlProjectMstDao.findCmbBox());
			// OTL作業マスタ
			bean.setOtlSagyoList(otlSagyoMstDao.findCmbBox());
			// OTLタイプマスタ
			bean.setOtlTypeList(otlTypeMstDao.findCmbBox());
			// OTL営業
			bean.setOtlEigyoList(syainDao.findCmbBoxByGroup("5"));
			// グループマスタ
			bean.setGroupList(groupDao.findGroupCmb());
			// 社員一覧
			bean.setSyainList(null);
			// QA管理NO
			bean.setQaKanriList(qaKanriMstDao.findCmbBox());
			// ON/OFF
			List<CmbBox> l = new ArrayList<CmbBox>();
			l.add(new CmbBox("", ""));
			l.add(new CmbBox("1", "有り"));
			l.add(new CmbBox("0", "無し"));
			bean.setOnOffList(l);
			// 業務区分
			bean.setGmKbnList(gyomuKbnMstDao.findCmbBox());
			// 作業グループ
			bean.setSagyoList(sagyoMstDao.findAll());
			// 詳細マスタ
			bean.setShosaiList(shosaiMstDao.findAll());
			model.addAttribute("proEntForm", bean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pro.ent";
	}

}
