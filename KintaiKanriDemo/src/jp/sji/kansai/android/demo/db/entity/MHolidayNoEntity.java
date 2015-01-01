package jp.sji.kansai.android.demo.db.entity;

import java.io.Serializable;

/**
 * 休暇番号エンティティ
 * @author Hiroshi Tsuji
 *
 */
public class MHolidayNoEntity implements Serializable {

	/** カラム名　休暇番号 */
	public static final String COLUMN_NAME_HOLIDAY_NO = "HOLIDAY_NO";

	/** カラム名　休暇名 */
	public static final String COLUMN_NAME_HOLIDAY_NAME = "HOLIDAY_NAME";

	/** 休暇番号 */
	private String holidayNo;

	/** 休暇名 */
	private String holidayName;

	/**
	 * 休暇番号を取得します。
	 * @return 休暇番号
	 */
	public String getHolidayNo() {
	    return holidayNo;
	}

	/**
	 * 休暇番号を設定します。
	 * @param holidayNo 休暇番号
	 */
	public void setHolidayNo(String holidayNo) {
	    this.holidayNo = holidayNo;
	}

	/**
	 * 休暇名を取得します。
	 * @return 休暇名
	 */
	public String getHolidayName() {
	    return holidayName;
	}

	/**
	 * 休暇名を設定します。
	 * @param holidayName 休暇名
	 */
	public void setHolidayName(String holidayName) {
	    this.holidayName = holidayName;
	}
}
