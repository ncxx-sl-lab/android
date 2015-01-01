/*
 * Created on 2006/03/31
 * Copyright (c) 2006 ITOCHU Techno-Solutions Corporation. All Rights Reserved.
 */

package jp.co.ctc_g.business.domain;

import jp.co.ctc_g.business.common.domain.BaseDomain;

/**
 * <p>
 * グループマスタドメイン.
 * </p>
 * @author ITOCHU Techno-Solutions Corporation
 */
public class Group extends BaseDomain {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -7014053809794067938L;

    /**
     * 選択.
     */
    private String item_chk;

    /**
     * グループコード.
     */
    private String group_cd;

    /**
     * グループ名.
     */
    private String group_name;

    /**
     * コンストラクタ.
     */
    public Group() {

        super();
    }

    /**
     * @return item_chk を取得する.
     */
    public String getItemChk() {

        return item_chk;
    }

    /**
     * @param item_chk item_chk を設定する.
     */
    public void setItemChk(String item_chk) {

        this.item_chk = item_chk;
    }

    /**
     * @return group_cd を取得する.
     */
    public String getGroupCd() {

        return group_cd;
    }

    /**
     * @param group_cd group_cd を設定する.
     */
    public void setGroupCd(String group_cd) {

        this.group_cd = group_cd;
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

}
