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
@Table(name = "SAGYO")
public class Sagyo implements Serializable {

	@Id
	@Column(name = "SAGYO_CD")
	private String sagyoCd;

	@Column(name = "SAGYO_NAME")
	private String sagyoName;

	/**
	 * @return sagyoCd
	 */
	public String getSagyoCd() {
		return sagyoCd;
	}

	/**
	 * @param sagyoCd セットする sagyoCd
	 */
	public void setSagyoCd(String sagyoCd) {
		this.sagyoCd = sagyoCd;
	}

	/**
	 * @return sagyoName
	 */
	public String getSagyoName() {
		return sagyoName;
	}

	/**
	 * @param sagyoName セットする sagyoName
	 */
	public void setSagyoName(String sagyoName) {
		this.sagyoName = sagyoName;
	}

}
