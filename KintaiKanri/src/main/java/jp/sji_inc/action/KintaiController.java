/**
 *
 */
package jp.sji_inc.action;

import java.security.Principal;

import javax.validation.Valid;

import jp.sji_inc.RuntimeException.BadRequestException;
import jp.sji_inc.action.form.JqGridForm;
import jp.sji_inc.action.form.KintaiCopyForm;
import jp.sji_inc.action.form.KintaiForm;
import jp.sji_inc.action.form.KintaiGridForm;
import jp.sji_inc.action.form.KintaiGridSaveForm;
import jp.sji_inc.action.form.KintaiMgrSaveForm;
import jp.sji_inc.action.form.KintaiMgrSearchForm;
import jp.sji_inc.action.form.KintaiSagyoAnbunForm;
import jp.sji_inc.action.form.KintaiSagyoAnbunSaveForm;
import jp.sji_inc.action.form.KintaiShiftDelForm;
import jp.sji_inc.action.form.KintaiShiftForm;
import jp.sji_inc.action.form.KintaiShiftSaveForm;
import jp.sji_inc.common.DateUtil;
import jp.sji_inc.db.entity.base.Kintai;
import jp.sji_inc.service.KintaiService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kyon
 *
 */
@Controller
@Transactional
@RequestMapping(value = "/kintai")
public class KintaiController {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(KintaiController.class);

	@Autowired
	private KintaiService kintaiService;

	/**
	 * 不正リクエストハンドラー
	 * @return
	 */
	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public Object BadRequestExceptionHandler(BadRequestException ex) {
		return ex.getErrors();
	}

	/**
	 * 初期表示
	 * @return 遷移先
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String show(@Valid KintaiForm bean, BindingResult result, Model model, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		bean.setEmpNo(principal.getName());
		if (bean.getKintaiMonth() == null) {
			bean.setDatepickerDate(DateUtil.getCurrentKintaiDate());
			bean.setKintaiMonth(bean.getDatepickerDate().substring(0, 6));
		} else {
			bean.setDatepickerDate(bean.getKintaiMonth() + "01");
		}
		kintaiService.kintaiShow(bean);
		return "kintai.show";
	}

	/**
	 * 初期表示
	 * @return 遷移先
	 */
	@RequestMapping(value="/{kintaiMonth}", method = RequestMethod.GET)
	public String show2(@Valid KintaiForm bean, BindingResult result, Model model, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		bean.setEmpNo(principal.getName());
		if (bean.getKintaiMonth() == null) {
			bean.setDatepickerDate(DateUtil.getCurrentKintaiDate());
			bean.setKintaiMonth(bean.getDatepickerDate().substring(0, 6));
		} else {
			bean.setDatepickerDate(bean.getKintaiMonth() + "01");
		}
		kintaiService.kintaiShow(bean);
		return "kintai.show";
	}

	/**
	 * 勤怠グリッド表示
	 * Ajaxで呼ばれる
	 * @return JqGridForm 勤怠のグリッド一月分
	 */
	@RequestMapping(value = "/ajax/show")
	@ResponseBody
	public JqGridForm kintaiGridShow(@Valid KintaiForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		if (bean.getKintaiMonth() == null) {
			bean.setKintaiMonth(DateUtil.getCurrentKintaiMonth());
		}
		String empNo = principal.getName();
		JqGridForm jqgrid = kintaiService.getKintaiGrid(empNo, bean.getKintaiMonth());
		return jqgrid;
	}

	/**
	 * 勤怠グリッド保存
	 * Ajaxで呼ばれる
	 * @param form
	 * @param result
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/ajax/save", method = RequestMethod.POST)
	@ResponseBody
	public KintaiGridForm kintaiGridSave(
			@RequestParam(value="shiftNo",  required=false) String shiftNo,
			@RequestParam(value="startTime",required=false) String startTime,
			@RequestParam(value="endTime",  required=false) String endTime,
			@RequestParam(value="tokkiJiko",required=false) String tokkiJiko,
			@RequestParam(value="koumokuNo",required=false) String koumokuNo,
			@RequestParam(value="kyukaMisyutokuSinsei2",required=false) String kyukaMisyutokuSinsei2,
			@RequestParam(value="kyukaMisyutokuSinsei3",required=false) String kyukaMisyutokuSinsei3,
			@RequestParam(value="kyukaMisyutokuSinsei4",required=false) String kyukaMisyutokuSinsei4,
			@RequestParam(value="kyukaMisyutokuSinsei5",required=false) String kyukaMisyutokuSinsei5,
			@RequestParam(value="kyukaMisyutokuSinsei6",required=false) String kyukaMisyutokuSinsei6,
			@RequestParam(value="projectNo",required=false) String projectNo,
			@Valid KintaiGridSaveForm bean, BindingResult result, Principal principal) {

		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}

		// NULLと空文字分けたいので
		bean.setShiftNo(shiftNo);
		bean.setStartTime(startTime);
		bean.setEndTime(endTime);
		bean.setTokkiJiko(tokkiJiko);
		bean.setKoumokuNo(koumokuNo);
		bean.setKyukaMisyutokuSinsei2(kyukaMisyutokuSinsei2);
		bean.setKyukaMisyutokuSinsei3(kyukaMisyutokuSinsei3);
		bean.setKyukaMisyutokuSinsei4(kyukaMisyutokuSinsei4);
		bean.setKyukaMisyutokuSinsei5(kyukaMisyutokuSinsei5);
		bean.setKyukaMisyutokuSinsei6(kyukaMisyutokuSinsei6);
		bean.setProjectNo(projectNo);

		bean.setEmpNo(principal.getName());
		Kintai kintai = kintaiService.saveKintaiGrid(bean);
		KintaiGridForm kintaiGridForm = kintaiService.kintaiGridFormRowMapper(kintai);
		return kintaiGridForm;
	}

	/**
	 * 作業按分入力グリッド表示
	 * Ajaxで呼ばれる
	 * @param bean
	 * @param result
	 * @param principal
	 * @return JqGridForm 勤怠のグリッド一月分
	 */
	@RequestMapping(value = "/ajax/anbun/show")
	@ResponseBody
	public JqGridForm kintaiSagyoAnbunGridShow(@Valid KintaiSagyoAnbunForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		String empNo = principal.getName();
		return kintaiService.getKintaiSagyoAnbunGrid(empNo, bean.getKintaiDate());
	}

	/**
	 * 作業按分保存
	 * @param bean
	 * @param result
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/ajax/anbun/save")
	@ResponseBody
	public Object kintaiSagyoAnbunGridSave(@Valid KintaiSagyoAnbunSaveForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		String empNo = principal.getName();
		bean.setEmpNo(empNo);
		kintaiService.saveKintaiSagyoAnbunGrid(bean);
		return null;
	}

	/**
	 * ｼﾌﾄグリッド表示
	 * @param bean
	 * @param result
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/ajax/shift/show")
	@ResponseBody
	public JqGridForm shiftGridShow(@Valid KintaiShiftForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		String empNo = principal.getName();
		return kintaiService.getKintaiShiftGrid(empNo, bean.getKintaiMonth());
	}

	/**
	 * ｼﾌﾄグリッド保存
	 * @param bean
	 * @param result
	 * @param principal
	 */
	@RequestMapping(value = "/ajax/shift/save")
	@ResponseBody
	public void shiftGridSave(@Valid KintaiShiftSaveForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		String empNo = principal.getName();
		bean.setEmpNo(empNo);
		kintaiService.saveKintaiShiftGrid(bean);
	}

	/**
	 * ｼﾌﾄグリッド削除
	 * @param bean
	 * @param result
	 * @param principal
	 */
	@RequestMapping(value = "/ajax/shift/del")
	@ResponseBody
	public void shiftGridDel(@Valid KintaiShiftDelForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		String empNo = principal.getName();
		bean.setEmpNo(empNo);
		kintaiService.delKintaiShiftGrid(bean);
	}

	/**
	 * 管理者保存
	 * @param bean
	 * @param result
	 * @param principal
	 */
	@RequestMapping(value = "/ajax/mgr/save")
	@ResponseBody
	public void mgrSave(
			@RequestParam(value="mgrNo",    required=false) String mgrNo,
			@RequestParam(value="dateFrom", required=false) String dateFrom,
			@RequestParam(value="dateTo",   required=false) String dateTo,
			@Valid KintaiMgrSaveForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		String empNo = principal.getName();
		bean.setEmpNo(empNo);
		bean.setMgrNo(mgrNo);
		bean.setDateFrom(dateFrom);
		bean.setDateTo(dateTo);
		kintaiService.saveMgr(bean);
	}

	/**
	 * 勤怠管理者検索
	 * @param bean
	 * @param result
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/ajax/mgr/search")
	@ResponseBody
	public JqGridForm searchMgr(@Valid KintaiMgrSearchForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		return kintaiService.searchMgr(bean);
	}

	/**
	 * 勤怠コピー
	 * @param bean
	 * @param result
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/ajax/copy")
	@ResponseBody
	public void copyKintai(@Valid KintaiCopyForm bean, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		String empNo = principal.getName();
		bean.setEmpNo(empNo);
		kintaiService.copyKintai(bean);
	}
}
