/**
 *
 */
package jp.sji_inc.action.form;

import java.io.Serializable;

/**
 * @author z1j7663
 *
 */
public class KintaiMgrSearchGrid implements Serializable {

	/** 社員番号 */
	private String empNo;

	/** 社員名 */
	private String empName;

	/** 事業所 */
	private String officeName;

	/** 部署名 */
	private String deptName;

	/**
	 * @return empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo セットする empNo
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName セットする empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName セットする officeName
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName セットする deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
