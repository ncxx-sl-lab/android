/**
 *
 */
package jp.sji_inc.db.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author z1j7663
 *
 */
@Entity
@Table(name="OFFICE")
public class Office {

	/** オフィス番号 */
	@Id
	@Column(name = "OFFICE_NO", length = 3)
	private String officeNo;

	/** オフィス番号 */
	@Column(name = "OFFICE_NAME", length = 50)
	private String officeName;

	/**
	 * @return officeNo
	 */
	public String getOfficeNo() {
		return officeNo;
	}

	/**
	 * @param officeNo セットする officeNo
	 */
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
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


}
