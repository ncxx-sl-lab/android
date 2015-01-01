// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.presentation.controller.common;

import java.util.List;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
public class JqGridForm {

	/** トータルページ数 */
	private int total;

	/** 現在表示しているページ */
	private int page;

	/** 何レコード表示するか */
	private int records;

	/** コンテンツ */
	private List<Object> rows;

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
