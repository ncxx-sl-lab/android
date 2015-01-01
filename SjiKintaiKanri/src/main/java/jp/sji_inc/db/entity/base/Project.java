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
@Table(name="PROJECT")
public class Project implements Serializable {

	/** 社員番号 */
	@Id
	@Column(name = "EMP_NO", length = 5)
	private String empNo;

	/** ﾌﾟﾛｼﾞｪｸﾄ番号 */
	@Id
	@Column(name = "PROJECT_NO")
	private String projectNo;

	/** ﾌﾟﾛｼﾞｪｸﾄ名 */
	@Column(name = "PROJECT_NAME")
	private String projectName;

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
	 * @return projectNo
	 */
	public String getProjectNo() {
		return projectNo;
	}

	/**
	 * @param projectNo セットする projectNo
	 */
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	/**
	 * @return projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName セットする projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
