/**
 *
 */
package jp.sji_inc.common;

/**
 * @author z1j7663
 *
 */
public class ExcelCell {

	/** 行 */
	private int row;

	/** 列 */
	private int col;

	/**
	 *
	 * @param row
	 * @param col
	 */
	public ExcelCell(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row セットする row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col セットする col
	 */
	public void setCol(int col) {
		this.col = col;
	}

}
