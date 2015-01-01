/**
 *
 */
package jp.sji_inc.db.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author z1j7663
 *
 */
@Entity
@Table(name="DEPT")
public class Dept implements Serializable {

	/** 部署番号 */
	@Id
	@Column(name = "DEPT_NO")
	private String deptNo;

	/** 部署名 */
	@Column(name = "DEPT_NAME")
	private String deptName;

	/** 部署名ふりがな */
	@Column(name = "DEPT_NAME_FURI_KANA")
	private String deptNameFuriKana;

	/**
	 * @return deptNo
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * @param deptNo セットする deptNo
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
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

	/**
	 * @return deptNameFuriKana
	 */
	public String getDeptNameFuriKana() {
		return deptNameFuriKana;
	}

	/**
	 * @param deptNameFuriKana セットする deptNameFuriKana
	 */
	public void setDeptNameFuriKana(String deptNameFuriKana) {
		this.deptNameFuriKana = deptNameFuriKana;
	}

}
