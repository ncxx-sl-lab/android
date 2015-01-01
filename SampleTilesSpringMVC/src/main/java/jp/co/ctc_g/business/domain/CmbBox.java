package jp.co.ctc_g.business.domain;

public class CmbBox {

    /**
     * 値.
     */
    private String value;

    /**
     * ラベル.
     */
    private String label;

    /**
     * コンストラクタ.
     */
    public CmbBox() {

        super();
    }

    /**
     * コンストラクタ.
     */
    public CmbBox(String v_wk,String l_wk) {
    	this.value = v_wk;
    	this.label = l_wk;
    }

    /**
     * @return 値.
     */
    public String getValue() {

        return value;
    }

    /**
     * @param 値.
     */
    public void setValue(String str_wk) {

        this.value = str_wk;
    }

    /**
     * @return ラベル.
     */
    public String getLabel() {

        return label;
    }

    /**
     * @param ラベル.
     */
    public void setLabel(String str_wk) {

        this.label = str_wk;
    }

}
