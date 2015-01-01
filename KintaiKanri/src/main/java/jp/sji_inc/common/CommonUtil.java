package jp.sji_inc.common;

import jp.sji_inc.db.entity.base.Emp;

/**
 *
 */

/**
 * @author kyon
 *
 */
public class CommonUtil {


	/**
	 * エクセルファイル名取得
	 * @param emp
	 * @param filename
	 */
	public static String getExcelTemplateFilename(Emp emp, String filename, String kintiMonth) {
		filename = filename.replaceAll("\\{MONTH\\}", kintiMonth.substring(4));
		filename = filename.replaceAll("\\{BUSYOCD\\}", emp.getDeptNo());
		filename = filename.replaceAll("\\{EMPNO\\}", emp.getEmpNo());
		filename = filename.replaceAll("\\{EMPNAME\\}", emp.getEmpNameLast() + emp.getEmpNameFirst());
		return filename;
	}
}
