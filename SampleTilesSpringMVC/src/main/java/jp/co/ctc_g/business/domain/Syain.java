package jp.co.ctc_g.business.domain;

public class Syain {

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
     * パスワード.
     */
    private String password;

    /**
     * 確認用パスワード.
     */
    private String confPassword;

    /**
     * 部署コード.
     */
//    private String busho_cd;

    /**
     * 部署名.
     */
//    private String busho_name;

    /**
     * グループコード.
     */
//    private String group_cd;

    /**
     * グループ名.
     */
//    private String group_name;

    /**
     * 権限コード.
     */
//    private String kengen_cd;

    /**
     * 権限名.
     */
//    private String kengen_name;

    /**
     * 削除フラグ.
     */
    private String del_flg;

    /**
     * OTL出力フラグ.
     */
    private String otl_flg;

	private Busho busho;

	private Group group;

	private Kengen kengen;


    /**
     * コンストラクタ.
     */
    public Syain() {

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
     * @return password を取得する.
     */
    public String getPassword() {

        return password;
    }

    /**
     * @param password password を設定する.
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * @return confPassword を取得する.
     */
    public String getConfPassword() {

        return confPassword;
    }

    /**
     * @param confPassword confPassword を設定する.
     */
    public void setConfPassword(String confPassword) {

        this.confPassword = confPassword;
    }

    /**
     * @return busho_cd を取得する.
     */
    public String getBushoCd() {

    	if (busho == null) return null;
    	return busho.getBushoCd();
    }

    /**
     * @param busho_cd busho_cd を設定する.
     */
    public void setBushoCd(String busho_cd) {

    	if (busho == null) busho = new Busho();
    	busho.setBushoCd(busho_cd);
    }

    /**
     * @return busho_name を取得する.
     */
    public String getBushoName() {

    	if (busho == null) return null;
    	return busho.getBushoName();
    }

    /**
     * @param busho_name busho_name を設定する.
     */
    public void setBushoName(String busho_name) {

    	if (busho == null) busho = new Busho();
    	busho.setBushoName(busho_name);
    }

    /**
     * @return group_cd を取得する.
     */
    public String getGroupCd() {

    	if (group == null) return null;
    	return group.getGroupCd();
    }

    /**
     * @param group_cd group_cd を設定する.
     */
    public void setGroupCd(String group_cd) {

    	if (group == null) group = new Group();
        group.setGroupCd(group_cd);
    }

    /**
     * @return group_name を取得する.
     */
    public String getGroupName() {

    	if (group == null) return null;
    	return group.getGroupName();
    }

    /**
     * @param group_name group_name を設定する.
     */
    public void setGroupName(String group_name) {

    	if (group == null) group = new Group();
        group.setGroupName(group_name);
    }

    /**
     * @return kengen_cd を取得する.
     */
    public String getKengenCd() {

    	if (kengen == null) return null;
    	return kengen.getKengenName();
    }

    /**
     * @param kengen_cd kengen_cd を設定する.
     */
    public void setKengenCd(String kengen_cd) {

    	if (kengen == null) kengen = new Kengen();
        kengen.setKengenCd(kengen_cd);
    }

    /**
     * @return kengen_name を取得する.
     */
    public String getKengenName() {

    	if (kengen == null) return null;
    	return kengen.getKengenName();
    }

    /**
     * @param kengen_name kengen_name を設定する.
     */
    public void setKengenName(String kengen_name) {

       	if (kengen == null) kengen = new Kengen();
        this.kengen.setKengenName(kengen_name);
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

    /**
     * @return busho を取得する.
     */
    public Busho getBusho() {
		return busho;
	}

    /**
     * @param busho busho を設定する.
     */
	public void setBusho(Busho busho) {
		this.busho = busho;
	}

    /**
     * @return group を取得する.
     */
	public Group getGroup() {
		return group;
	}

    /**
     * @param group group を設定する.
     */
	public void setGroup(Group group) {
		this.group = group;
	}

    /**
     * @return kengen を取得する.
     */
    public Kengen getKengen() {
		return kengen;
	}

    /**
     * @param kengen kengen を設定する.
     */
	public void setKengen(Kengen kengen) {
		this.kengen = kengen;
	}

}
