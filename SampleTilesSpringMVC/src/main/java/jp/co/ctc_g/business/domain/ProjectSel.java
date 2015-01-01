/*
 * Created on 2006/03/31
 * Copyright (c) 2006 ITOCHU Techno-Solutions Corporation. All Rights Reserved.
 */

package jp.co.ctc_g.business.domain;

import jp.co.ctc_g.business.common.domain.BaseDomain;

/**
 * <p>
 * プロジェクトグループ情報ドメイン.
 * </p>
 * @author ITOCHU Techno-Solutions Corporation
 */
public class ProjectSel extends BaseDomain {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -5095760455270670787L;

    /**
     * グループコード.
     */
    private String group_code;

    /**
     * プロジェクトコード.
     */
    private String project_code;

    /**
     * コンストラクタ.
     */
    public ProjectSel() {

        super();
    }

    /**
     * @return group_code を取得する.
     */
    public String getGroupCode() {

        return group_code;
    }

    /**
     * @param group_code group_code を設定する.
     */
    public void setGroupCode(String group_code) {

        this.group_code = group_code;
    }

	/**
     * @return project_code を取得する.
     */
    public String getProjectCode() {

        return project_code;
    }

    /**
     * @param project_code project_code を設定する.
     */
    public void setProjectCode(String project_code) {

        this.project_code = project_code;
    }

}
