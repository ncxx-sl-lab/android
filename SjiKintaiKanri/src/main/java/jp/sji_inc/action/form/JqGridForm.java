/**
 *
 */
package jp.sji_inc.action.form;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kyon
 *
 */
public class JqGridForm {

	/** トータルページ数 */
	private int total;

	/** ページ数 */
	private int page;

	/** レコード数 */
	private int records;

	/** レコード */
	private List<Object> rows = new ArrayList<Object>();

	/**
	 * @return total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total セットする total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page セットする page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return records
	 */
	public int getRecords() {
		return records;
	}

	/**
	 * @param records セットする records
	 */
	public void setRecords(int records) {
		this.records = records;
	}

	/**
	 * @return rows
	 */
	public List<Object> getRows() {
		return rows;
	}

	/**
	 * @param rows セットする rows
	 */
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
}
