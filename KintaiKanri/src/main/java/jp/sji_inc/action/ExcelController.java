/**
 *
 */
package jp.sji_inc.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import jp.sji_inc.RuntimeException.BadRequestException;
import jp.sji_inc.action.form.ExcelForm;
import jp.sji_inc.common.CommonUtil;
import jp.sji_inc.db.dao.ExcelTemplateDao;
import jp.sji_inc.db.entity.base.Emp;
import jp.sji_inc.db.entity.base.ExcelTemplate;
import jp.sji_inc.service.ExcelService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author z1j7663
 *
 */
@Controller
@Transactional
@RequestMapping(value = "/excel")
public class ExcelController {

	private final String MIME_TYPE_EXCEL = "application/vnd.ms-excel";

	@Autowired
	private ExcelService excelService;

	@Autowired
	private ExcelTemplateDao excelTemplateDao;

	/**
	 * エクセルダウンロード
	 * @param res
	 * @throws Exception
	 */
	@RequestMapping("/download")
	public void download(@Valid ExcelForm bean, BindingResult result, HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}

		Emp emp = (Emp)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HSSFWorkbook wb = excelService.getKintaiWorkBook(emp, bean.getKintaiMonth());

		res.setContentType(MIME_TYPE_EXCEL);
		ExcelTemplate template = excelTemplateDao.findById(bean.getKintaiMonth());
		String excelName = CommonUtil.getExcelTemplateFilename(emp, template.getFilename(), bean.getKintaiMonth());
		String fileName = new String(excelName.getBytes("MS932"), "ISO-8859-1");
		res.setHeader("Content-Disposition", "attachment; filename="+fileName);
		ServletOutputStream sos = res.getOutputStream();

		wb.write(sos);

		sos.close();
	}

	/**
	 * エクセル確認
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public void view(@Valid ExcelForm bean, BindingResult result, HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (result.hasErrors()) {
			throw new BadRequestException(result);
		}

		Emp emp = (Emp)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HSSFWorkbook wb = excelService.getKintaiWorkBook(emp, bean.getKintaiMonth());

		res.setContentType(MIME_TYPE_EXCEL);
		ServletOutputStream sos = res.getOutputStream();

		wb.write(sos);

		sos.close();

	}
}
