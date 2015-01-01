/**
 *
 */
package jp.sji_inc.db.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author z1j7663
 *
 */
@Entity
@Table(name="KINTAI_MGR")
public class KintaiMgr implements Serializable {

	/** 社員番号 */
	@Id
	@Column(name = "EMP_NO", length = 5)
	private String empNo;

	/** 勤務月 */
	@Id
	@Column(name = "KINTAI_MONTH", length = 6)
	private String kintaiMonth;

	/** 管理者NO */
	@Id
	@Column(name = "NO", length = 1)
	private String no;

	/** 管理者社員番号 */
	@Column(name = "MGR_NO", length = 5)
	private String mgrNo;

	/** 開始日 */
	@Column(name = "DATE_FROM", length = 8)
	private String dateFrom;

	/** 終了日 */
	@Column(name = "DATE_TO", length = 8)
	private String dateTo;

	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="MGR_NO", referencedColumnName="EMP_NO", insertable=false, updatable=false)
	private Emp mgr;

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
	 * @return kintaiMonth
	 */
	public String getKintaiMonth() {
		return kintaiMonth;
	}

	/**
	 * @param kintaiMonth セットする kintaiMonth
	 */
	public void setKintaiMonth(String kintaiMonth) {
		this.kintaiMonth = kintaiMonth;
	}

	/**
	 * @return no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @param no セットする no
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @return mgrNo
	 */
	public String getMgrNo() {
		return mgrNo;
	}

	/**
	 * @param mgrNo セットする mgrNo
	 */
	public void setMgrNo(String mgrNo) {
		this.mgrNo = mgrNo;
	}

	/**
	 * @return dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}

	/**
	 * @param dateFrom セットする dateFrom
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 * @return dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}

	/**
	 * @param dateTo セットする dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 * @return mgr
	 */
	public Emp getMgr() {
		return mgr;
	}

	/**
	 * @param mgr セットする mgr
	 */
	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}


}
