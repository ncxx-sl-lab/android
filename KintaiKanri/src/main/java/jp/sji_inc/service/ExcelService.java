/**
 *
 */
package jp.sji_inc.service;

import jp.sji_inc.db.entity.base.Emp;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author z1j7663
 *
 */
public interface ExcelService {

	/**
	 *
	 * @param emp
	 * @param kintaiMonth
	 * @return
	 */
	public HSSFWorkbook getKintaiWorkBook(Emp emp, String kintaiMonth);

}
