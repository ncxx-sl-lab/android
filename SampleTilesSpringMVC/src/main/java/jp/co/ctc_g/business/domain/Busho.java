package jp.co.ctc_g.business.domain;

/**
 * <p>
 * 部署マスタドメイン.
 * </p>
 * @author ITOCHU Techno-Solutions Corporation
 */
public class Busho {

	/**
     * 部署コード.
     */
    private String busho_cd;

    /**
     * 部署名.
     */
    private String busho_name;

    /**
     * コンストラクタ.
     */
    public Busho() {

        super();
    }

    /**
     * @return busho_cd を取得する.
     */
    public String getBushoCd() {

        return busho_cd;
    }

    /**
     * @param busho_cd busho_cd を設定する.
     */
    public void setBushoCd(String busho_cd) {

        this.busho_cd = busho_cd;
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

}
