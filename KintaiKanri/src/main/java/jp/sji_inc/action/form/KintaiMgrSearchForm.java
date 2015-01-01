/**
 *
 */
package jp.sji_inc.action.form;

import java.io.Serializable;

/**
 * @author z1j7663
 *
 */
public class KintaiMgrSearchForm implements Serializable {

	private String empNo;

	private String empName;

	private String empNameFuriKana;

	private String email;

	private String tel;

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
	 * @return empNameFuriKana
	 */
	public String getEmpNameFuriKana() {
		return empNameFuriKana;
	}

	/**
	 * @param empNameFuriKana セットする empNameFuriKana
	 */
	public void setEmpNameFuriKana(String empNameFuriKana) {
		this.empNameFuriKana = empNameFuriKana;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel セットする tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


}
