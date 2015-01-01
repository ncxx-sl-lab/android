/**
 *
 */
package jp.sji_inc.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jp.sji_inc.common.DateUtil;
import jp.sji_inc.common.ExcelCell;
import jp.sji_inc.common.StringUtil;
import jp.sji_inc.db.dao.ExcelTemplateDao;
import jp.sji_inc.db.dao.KintaiDao;
import jp.sji_inc.db.dao.KintaiMgrDao;
import jp.sji_inc.db.dao.ShiftDao;
import jp.sji_inc.db.entity.KintaiSum;
import jp.sji_inc.db.entity.base.Emp;
import jp.sji_inc.db.entity.base.ExcelTemplate;
import jp.sji_inc.db.entity.base.Kintai;
import jp.sji_inc.db.entity.base.KintaiMgr;
import jp.sji_inc.db.entity.base.KintaiSagyoAnbun;
import jp.sji_inc.db.entity.base.Shift;
import jp.sji_inc.service.ExcelService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author z1j7663
 *
 */
@Service
public class ExcelServiceImpl implements ExcelService {

	private final ExcelCell CELL_SHIFT = new ExcelCell(3, 5);
	private final ExcelCell CELL_DEPT = new ExcelCell(2, 30);
	private final ExcelCell CELL_EMP_NO = new ExcelCell(3, 30);
	private final ExcelCell CELL_EMP_NAME = new ExcelCell(3, 31);
	private final ExcelCell CELL_MONTH = new ExcelCell(3, 40);
	private final ExcelCell CELL_MGR = new ExcelCell(3, 192);
	private final ExcelCell CELL_KINTAI = new ExcelCell(11, 4);
	private final ExcelCell COL_SHIFT = new ExcelCell(-1, 4);
	private final ExcelCell COL_START_TIME = new ExcelCell(-1, 5);
	private final ExcelCell COL_END_TIME = new ExcelCell(-1, 6);
	private final ExcelCell COL_TOKKI = new ExcelCell(-1, 8);
	private final ExcelCell COL_KOUMOKU = new ExcelCell(-1, 10);
	private final ExcelCell COL_KYUKA_MISYUTOKU = new ExcelCell(-1, 47);
	private final ExcelCell COL_PROJECT = new ExcelCell(-1, 192);
	private final ExcelCell COL_SAGYO = new ExcelCell(-1, 193);
	private final ExcelCell CELL_SUM = new ExcelCell(44, 192);

	/** ｼﾌﾄDao */
	@Autowired
	private ShiftDao shiftDao;

	/** 勤怠Dao */
	@Autowired
	private KintaiDao kintaiDao;

	/** 勤怠管理者Dao */
	@Autowired
	private KintaiMgrDao kintaiMgrDao;

	/** エクセルテンプレートDao */
	@Autowired
	private ExcelTemplateDao excelTemplateDao;

	@Override
	public HSSFWorkbook getKintaiWorkBook(Emp emp, String kintaiMonth) {

		HSSFWorkbook wb = null;
		try {
			ExcelTemplate excelTemplate = excelTemplateDao.findById(kintaiMonth);

			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession();
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
			Resource resource = wac.getResource("classpath:excel/" + excelTemplate.getFilename());

			POIFSFileSystem fs = new POIFSFileSystem(resource.getInputStream());
			wb = new HSSFWorkbook(fs);

			this.setShiftInfo(wb, emp.getEmpNo(), kintaiMonth);
			this.setEmpInfo(wb, emp, kintaiMonth);
			this.setKintaiInfo(wb, emp.getEmpNo(), kintaiMonth);
			this.setKintaiSumInfo(wb, emp.getEmpNo(), kintaiMonth);
			HSSFSheet sheet = wb.getSheetAt(0);
			sheet.setForceFormulaRecalculation(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return wb;
	}

	private void setShiftInfo(HSSFWorkbook wb, String empNo, String kintaiMonth) {
		List<Shift> shiftList = shiftDao.findByMonth(empNo, kintaiMonth);
		HSSFSheet sheet = wb.getSheetAt(0);
		int i = 0;
		for (Shift shift : shiftList) {
			HSSFRow row = sheet.getRow(CELL_SHIFT.getRow() + i);
			HSSFCell cell = row.getCell(CELL_SHIFT.getCol());
			cell.setCellValue(DateUtil.getSerial(shift.getStartTime()));
			cell = row.getCell(CELL_SHIFT.getCol()+1);
			cell.setCellValue(DateUtil.getSerial(shift.getEndTime()));
			cell = row.getCell(CELL_SHIFT.getCol()+5);
			cell.setCellValue(DateUtil.getSerial(shift.getRest1Start()));
			cell = row.getCell(CELL_SHIFT.getCol()+6);
			cell.setCellValue(DateUtil.getSerial(shift.getRest1End()));
			cell = row.getCell(CELL_SHIFT.getCol()+7);
			cell.setCellValue(DateUtil.getSerial(shift.getRest2Start()));
			cell = row.getCell(CELL_SHIFT.getCol()+8);
			cell.setCellValue(DateUtil.getSerial(shift.getRest2End()));
			i++;
		}
	}

	private void setEmpInfo(HSSFWorkbook wb, Emp emp, String kintaiMonth) {
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFCell cell = this.getCell(sheet, CELL_DEPT);
		cell.setCellValue(Integer.parseInt(emp.getDeptNo()));
		cell = this.getCell(sheet, CELL_EMP_NO);
		cell.setCellValue(emp.getEmpNo());
		cell = this.getCell(sheet, CELL_EMP_NAME);
		cell.setCellValue(emp.getEmpNameLast() + " " + emp.getEmpNameFirst());
		cell = this.getCell(sheet, CELL_MONTH);
		cell.setCellValue(DateUtil.getMonth(kintaiMonth));

		// 管理者
		List<KintaiMgr> kintaiMgrList = kintaiMgrDao.findByMonth(emp.getEmpNo(), kintaiMonth);
		int i = 0;
		for (KintaiMgr kintaiMgr : kintaiMgrList) {
			cell = this.getCell(sheet, CELL_MGR.getRow() + i, CELL_MGR.getCol());
			Emp mgr = kintaiMgr.getMgr();
			if (mgr != null) {
				cell.setCellValue(mgr.getEmpNameLast() + " " + mgr.getEmpNameFirst());
			}
			i++;

			cell = this.getCell(sheet, CELL_MGR.getRow() + i, CELL_MGR.getCol());
			cell.setCellValue(kintaiMgr.getDateFrom().substring(6) + "～" + kintaiMgr.getDateTo().substring(6));
			i++;
		}
	}

	private void setKintaiInfo(HSSFWorkbook wb, String empNo, String kintaiMonth) {
		Map<String,Kintai> kintaiMap = kintaiDao.findMapByMonth(empNo, kintaiMonth);

		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0; i < 31; i++) {
			Kintai kintai = kintaiMap.get(kintaiMonth + String.format("%02d", i+1));
			if (kintai == null) {
				continue;
			}
			HSSFRow row = sheet.getRow(CELL_KINTAI.getRow() + i);
			HSSFCell cell = row.getCell(COL_SHIFT.getCol());
			if (StringUtil.isNull(kintai.getShiftNo())) {
				cell.setCellValue("");
			} else {
				cell.setCellValue(Integer.parseInt(kintai.getShiftNo()));
			}
			double tmp = -1;
			cell = row.getCell(COL_START_TIME.getCol());
			tmp = DateUtil.getSerial(kintai.getStartTime());
			cell.setCellValue("");
			if (tmp > 0) {
				cell.setCellValue(tmp);
			}
			cell = row.getCell(COL_END_TIME.getCol());
			cell.setCellValue("");
			tmp = DateUtil.getSerial(kintai.getEndTime());
			if (tmp > 0) {
				cell.setCellValue(tmp);
			}
			cell = row.getCell(COL_TOKKI.getCol());
			cell.setCellValue(kintai.getTokkiJiko());
			if (!StringUtil.isNull(kintai.getKoumokuNo())) {
				cell = row.getCell(COL_KOUMOKU.getCol());
				cell.setCellValue(Integer.parseInt(kintai.getKoumokuNo()));
			}

			cell = row.getCell(COL_KYUKA_MISYUTOKU.getCol());
			cell.setCellValue(kintai.getKyukaMisyutokuSinsei2());
			cell = row.getCell(COL_KYUKA_MISYUTOKU.getCol()+1);
			cell.setCellValue(kintai.getKyukaMisyutokuSinsei3());
			cell = row.getCell(COL_KYUKA_MISYUTOKU.getCol()+2);
			cell.setCellValue(kintai.getKyukaMisyutokuSinsei4());
			cell = row.getCell(COL_KYUKA_MISYUTOKU.getCol()+3);
			cell.setCellValue(kintai.getKyukaMisyutokuSinsei5());
			cell = row.getCell(COL_KYUKA_MISYUTOKU.getCol()+4);
			cell.setCellValue(kintai.getKyukaMisyutokuSinsei6());

			cell = row.getCell(COL_PROJECT.getCol());
			cell.setCellValue(kintai.getProjectNo());
			StringBuffer sb = new StringBuffer();
			List<KintaiSagyoAnbun> kintaiSagyoAnbunList = kintai.getKintaiSagyoAnbun();
			if (kintaiSagyoAnbunList != null) {
				for (KintaiSagyoAnbun sagyoList : kintaiSagyoAnbunList) {
					sb.append(sagyoList.getSagyoCd()).append(",");
				}
			}
			if (sb.length() > 0) {
				sb.setLength(sb.length()-1);
			}
			cell = row.getCell(COL_SAGYO.getCol());
			cell.setCellValue(sb.toString());
		}
	}

	private void setKintaiSumInfo(HSSFWorkbook wb, String empNo, String kintaiMonth) {
		HSSFSheet sheet = wb.getSheetAt(0);
		List<KintaiSum> kintaiSumList = kintaiDao.findKintaiSum(empNo, kintaiMonth);
		int i = 0;
		for (KintaiSum ks : kintaiSumList) {
			HSSFCell cell = this.getCell(sheet, CELL_SUM.getRow()+i, CELL_SUM.getCol());
			cell.setCellValue(ks.getProjectNo());
			cell = this.getCell(sheet, CELL_SUM.getRow()+i, CELL_SUM.getCol()+1);
			cell.setCellValue(ks.getSagyoCd());
			cell = this.getCell(sheet, CELL_SUM.getRow()+i, CELL_SUM.getCol()+2);
			cell.setCellValue(ks.getNormal().doubleValue());
			cell = this.getCell(sheet, CELL_SUM.getRow()+i, CELL_SUM.getCol()+3);
			cell.setCellValue(ks.getOver().doubleValue());
			cell = this.getCell(sheet, CELL_SUM.getRow()+i, CELL_SUM.getCol()+4);
			cell.setCellValue(ks.getLateOver().doubleValue());
			i++;
		}
	}

	private HSSFCell getCell(HSSFSheet sheet, ExcelCell cell) {
		HSSFRow row = sheet.getRow(cell.getRow());
		return row.getCell(cell.getCol());
	}

	private HSSFCell getCell(HSSFSheet sheet, int row, int col) {
		HSSFRow r = sheet.getRow(row);
		return r.getCell(col);
	}
}
