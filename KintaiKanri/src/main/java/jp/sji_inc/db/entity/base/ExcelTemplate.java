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
@Table(name = "EXCEL_TEMPLATE")
public class ExcelTemplate {

	/** ファイル名 */
	@Id
	@Column(name = "FILENAME", length=40)
	private String filename;

	/** 期間 開始 */
	@Column(name = "KINTAI_MONTH_FROM", length=6)
	private String kintaiMonthFrom;

	/** 期間 終了 */
	@Column(name = "KINTAI_MONTH_TO", length=6)
	private String kintaiMonthTo;

	/**
	 * @return filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename セットする filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return kintaiMonthFrom
	 */
	public String getKintaiMonthFrom() {
		return kintaiMonthFrom;
	}

	/**
	 * @param kintaiMonthFrom セットする kintaiMonthFrom
	 */
	public void setKintaiMonthFrom(String kintaiMonthFrom) {
		this.kintaiMonthFrom = kintaiMonthFrom;
	}

	/**
	 * @return kintaiMonthTo
	 */
	public String getKintaiMonthTo() {
		return kintaiMonthTo;
	}

	/**
	 * @param kintaiMonthTo セットする kintaiMonthTo
	 */
	public void setKintaiMonthTo(String kintaiMonthTo) {
		this.kintaiMonthTo = kintaiMonthTo;
	}


}
