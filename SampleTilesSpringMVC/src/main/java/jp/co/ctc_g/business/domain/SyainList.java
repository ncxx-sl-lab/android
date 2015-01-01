package jp.co.ctc_g.business.domain;

public class SyainList {

    /**
     * 選択.
     */
    private int sel_value = 0;

    /**
     * 社員番号.
     */
    private String syain_no;

    /**
     * 社員名.
     */
    private String syain_name;

    /**
     * 部署名.
     */
    private String busho_name;

    /**
     * グループ名.
     */
    private String group_name;

    /**
     * 権限名.
     */
    private String kengen_name;

    /**
     * 削除フラグ.
     */
    private String del_flg;

    /**
     * OTL出力フラグ.
     */
    private String otl_flg;

    /**
     * コンストラクタ.
     */
    public SyainList() {

        super();
    }

    /**
     * @return sel_value を取得する.
     */
    public int getSelValue() {

        return sel_value;
    }

    /**
     * @param sel_value sel_value を設定する.
     */
    public void setSelValue(int sel_value) {

        this.sel_value = sel_value;
    }

    /**
     * @return syain_no を取得する.
     */
    public String getSyainNo() {

        return syain_no;
    }

    /**
     * @param syain_no syain_no を設定する.
     */
    public void setSyainNo(String syain_no) {

        this.syain_no = syain_no;
    }

    /**
     * @return syain_name を取得する.
     */
    public String getSyainName() {

        return syain_name;
    }

    /**
     * @param syain_name syain_name を設定する.
     */
    public void setSyainName(String syain_name) {

        this.syain_name = syain_name;
    }

    /**
     * @return busho_name を取得する.
     */
    public String getBushoName() {

        return busho_name;
    }

    /**
     * @param busho_name busho_name を設定する.
     */
    public void setBushoName(String busho_name) {

        this.busho_name = busho_name;
    }

    /**
     * @return group_name を取得する.
     */
    public String getGroupName() {

        return group_name;
    }

    /**
     * @param group_name group_name を設定する.
     */
    public void setGroupName(String group_name) {

        this.group_name = group_name;
    }

    /**
     * @return kengen_name を取得する.
     */
    public String getKengenName() {

        return kengen_name;
    }

    /**
     * @param kengen_name kengen_name を設定する.
     */
    public void setKengenName(String kengen_name) {

        this.kengen_name = kengen_name;
    }
    
    /**
     * @return del_flg を取得する.
     */
    public String getDelFlg() {

        return del_flg;
    }

    /**
     * @param del_flg del_flg を設定する.
     */
    public void setDelFlg(String del_flg) {

        this.del_flg = del_flg;
    }
    
    /**
     * @return otl_flg を取得する.
     */
    public String getOtlFlg() {

        return otl_flg;
    }

    /**
     * @param otl_flg otl_flg を設定する.
     */
    public void setOtlFlg(String otl_flg) {

        this.otl_flg = otl_flg;
    }


}
