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
@Table(name="KINTAI_SAGYO_ANBUN")
public class KintaiSagyoAnbun implements Serializable {

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

	/** 通常 按分率 */
	@Column(name = "NORMAL_ANBUN_RITU")
	private BigDecimal normalAnbunRitu;

	/** 残業 按分率 */
	@Column(name = "OVER_ANBUN_RITU")
	private BigDecimal overAnbunRitu;

	/** 深夜 按分率 */
	@Column(name = "LATE_OVER_ANBUN_RITU")
	private BigDecimal lateOverAnbunRitu;

	/** 作業マスタ */
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
	 * @return normalAnbunRitu
	 */
	public BigDecimal getNormalAnbunRitu() {
		return normalAnbunRitu;
	}

	/**
	 * @param normalAnbunRitu セットする normalAnbunRitu
	 */
	public void setNormalAnbunRitu(BigDecimal normalAnbunRitu) {
		this.normalAnbunRitu = normalAnbunRitu;
	}

	/**
	 * @return overAnbunRitu
	 */
	public BigDecimal getOverAnbunRitu() {
		return overAnbunRitu;
	}

	/**
	 * @param overAnbunRitu セットする overAnbunRitu
	 */
	public void setOverAnbunRitu(BigDecimal overAnbunRitu) {
		this.overAnbunRitu = overAnbunRitu;
	}

	/**
	 * @return lateOverAnbunRitu
	 */
	public BigDecimal getLateOverAnbunRitu() {
		return lateOverAnbunRitu;
	}

	/**
	 * @param lateOverAnbunRitu セットする lateOverAnbunRitu
	 */
	public void setLateOverAnbunRitu(BigDecimal lateOverAnbunRitu) {
		this.lateOverAnbunRitu = lateOverAnbunRitu;
	}

	/**
	 * @return sagyo
	 */
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
