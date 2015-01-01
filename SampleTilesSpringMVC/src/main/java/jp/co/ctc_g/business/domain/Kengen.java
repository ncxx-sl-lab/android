/*
 * Created on 2006/03/31
 * Copyright (c) 2006 ITOCHU Techno-Solutions Corporation. All Rights Reserved.
 */

package jp.co.ctc_g.business.domain;

import jp.co.ctc_g.business.common.domain.BaseDomain;

/**
 * <p>
 * 権限マスタドメイン.
 * </p>
 * @author ITOCHU Techno-Solutions Corporation
 */
public class Kengen extends BaseDomain {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -7014053809794067938L;

    /**
     * 権限コード.
     */
    private String kengen_cd;

    /**
     * 権限名.
     */
    private String kengen_name;

    /**
     * コンストラクタ.
     */
    public Kengen() {

        super();
    }

    /**
     * @return kengen_cd を取得する.
     */
    public String getKengenCd() {

        return kengen_cd;
    }

    /**
     * @param kengen_cd kengen_cd を設定する.
     */
    public void setKengenCd(String kengen_cd) {

        this.kengen_cd = kengen_cd;
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

}
