package jp.sji_inc.api;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import jp.sji_inc.RuntimeException.BadRequestException;
import jp.sji_inc.api.form.ApiKintaiByDateForm;
import jp.sji_inc.api.form.ApiKintaiByMonthForm;
import jp.sji_inc.api.form.ApiKintaiForm;
import jp.sji_inc.db.dao.KintaiDao;
import jp.sji_inc.db.entity.base.Kintai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Transactional
@RequestMapping(value="/api/kintai")
public class ApiKintaiController {

	/** 勤怠Dao */
	@Autowired
	private KintaiDao kintaiDao;

	/**
	 * テスト用
	 * @return 遷移先
	 */
	@RequestMapping(value = "/test")
	public String show() {
		return "api/kintai/test";
	}

	/**
	 *
	 * @param empNo
	 * @param kintaiDate
	 * @param bean
	 * @param result
	 * @return Kintai
	 * @throws ParseException
	 */
	@RequestMapping(value="/{empNo}/date/{kintaiDate}", method=RequestMethod.GET)
	@ResponseBody
	public Kintai getKintaiByDate(@Valid ApiKintaiByDateForm bean, BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		Kintai k = new Kintai();
		k.setEmpNo(bean.getEmpNo());
		k.setKintaiDate(bean.getKintaiDate());
		Kintai kintai = kintaiDao.findById(k);
		return kintai;
	}

	/**
	 *
	 * @param empNo
	 * @param kintaiDate
	 * @param bean
	 * @param result
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/{empNo}/month/{kintaiDate}", method=RequestMethod.GET)
	@ResponseBody
	public List<Kintai> getKintaiByMonth(@Valid ApiKintaiByMonthForm bean, BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		List<Kintai> kintai = kintaiDao.findByMonth(bean.getEmpNo(), bean.getKintaiDate());
		return kintai;
	}

	/**
	 * 保存
	 * @param bean
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Kintai save(@Valid ApiKintaiForm bean, BindingResult result) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		System.out.println("EmpNo:"+bean.getEmpNo());
		System.out.println("KintaiDate:"+bean.getKintaiDate());
		System.out.println("ShiftNo:"+bean.getShiftNo());
		System.out.println("TokkiJiko:"+bean.getTokkiJiko());
		System.out.println("KoumokuNo:"+bean.getKoumokuNo());
		System.out.println("ProjectNo:"+bean.getProjectNo());

		Kintai kintai = new Kintai();
		kintai.setEmpNo(bean.getEmpNo());
		kintai.setKintaiDate(bean.getKintaiDate());
		kintai = kintaiDao.findById(kintai);
		if (kintai == null) {
			kintai = new Kintai();
			kintai.setEmpNo(bean.getEmpNo());
			kintai.setKintaiDate(bean.getKintaiDate());
		}
		if (bean.getShiftNo() != null) {
			kintai.setShiftNo(bean.getShiftNo());
		}
		if (bean.getTokkiJiko() != null) {
			kintai.setTokkiJiko(bean.getTokkiJiko());
		}
		if (bean.getKoumokuNo() != null) {
			kintai.setKoumokuNo(bean.getKoumokuNo());
		}
		if (bean.getProjectNo() != null) {
			kintai.setProjectNo(bean.getProjectNo());
		}
		kintai = kintaiDao.save(kintai);
		return kintai;
	}



	/**
	 * BadRequestExceptionハンドラー
	 * @param ex BadRequestException
	 * @return エラー情報
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public Object BadRequestHandler(BadRequestException ex) {
		//return ex.getBindingResultErrorMessages();
		return null;
	}

}
