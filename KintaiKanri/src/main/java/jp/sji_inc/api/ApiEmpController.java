package jp.sji_inc.api;

import javax.validation.Valid;

import jp.sji_inc.RuntimeException.BadRequestException;
import jp.sji_inc.api.form.ApiEmpForm;
import jp.sji_inc.api.form.ApiEmpSaveForm;
import jp.sji_inc.db.dao.EmpDao;
import jp.sji_inc.db.entity.base.Emp;

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
@RequestMapping(value="/api/emp")
public class ApiEmpController {

	@Autowired
	private EmpDao empDao;

	/**
	 * テスト用
	 * @return String
	 */
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		return "api/emp/test";
	}

	/**
	 * 取得
	 * @param empNo 社員番号
	 * @param token トークン
	 * @return Emp 社員エンティティ
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Emp get(@Valid ApiEmpForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		Emp emp = empDao.findById(form.getEmpNo());
		if (emp == null) {
			//throw new BadRequestException("見つかりませんでした");
		}
		return emp;
	}

	/**
	 * 削除
	 * @param empNo
	 * @param token
	 * @return
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseBody
	public Emp delete(@Valid ApiEmpForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		Emp emp = empDao.findById(form.getEmpNo());
		if (emp == null) {
			//throw new BadRequestException("見つかりませんでした");
		}
		//emp.setEnable(false);
		empDao.update(emp);
		return emp;
	}

	/**
	 * 削除
	 * @param empNo
	 * @param token
	 * @return
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Emp save(@Valid ApiEmpSaveForm form, BindingResult result) {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}
		Emp emp = empDao.findById(form.getEmpNo());
		if (emp == null) {
			emp = new Emp();
		}
		emp.setEmpNo(form.getEmpNo());
		//emp.setEmpName(form.getEmpName());
		emp.setDeptNo(form.getDeptNo());
		//emp.setEnable(form.isEnable());
		System.out.println("save before");
		empDao.save(emp);
		return emp;
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
