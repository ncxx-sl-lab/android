package jp.sji_inc.db.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="KINTAI_HOURS")
public class KintaiHours implements Serializable {

	/** 社員番号 */
	@Id
	@Column(name = "EMP_NO", length = 5)
	private String empNo;

	/** 勤務日 */
	@Id
	@Column(name = "KINTAI_DATE", length = 8)
	private String kintaiDate;

	/** 作業ｺｰﾄﾞ */
	@Id
	@Column(name = "SAGYO_CD")
	private String sagyoCd;

	/** 勤務時間 */
	@Column(name = "HOURS")
	private BigDecimal Hours;

	/** ｼﾌﾄ */
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name = "SAGYO_CD", referencedColumnName = "SAGYO_CD", insertable = false, updatable = false)
	private Sagyo sagyo;

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
	 * @return kintaiDate
	 */
	public String getKintaiDate() {
		return kintaiDate;
	}

	/**
	 * @param kintaiDate セットする kintaiDate
	 */
	public void setKintaiDate(String kintaiDate) {
		this.kintaiDate = kintaiDate;
	}

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
	 * @return hours
	 */
	public BigDecimal getHours() {
		return Hours;
	}

	/**
	 * @param hours セットする hours
	 */
	public void setHours(BigDecimal hours) {
		Hours = hours;
	}

	public Sagyo getSagyo() {
		return sagyo;
	}

	/**
	 * @param sagyo セットする sagyo
	 */
	public void setSagyo(Sagyo sagyo) {
		this.sagyo = sagyo;
	}

}
