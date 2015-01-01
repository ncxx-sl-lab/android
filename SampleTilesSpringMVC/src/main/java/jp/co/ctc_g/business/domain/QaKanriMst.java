// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.domain;

import java.util.Date;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
public class QaKanriMst {

	/** QA番号 */
	private String pqNo;

	/** プロジェクトコード */
	private String projectCode;

	/** 概要 */
	private String gaiyo;

	/** 関連プロジェクト */
	private String kanrenProj;

	/** QA種別コード */
	private String qaSyubetuCode;

	/** シーケンス番号 */
	private String seqNo;

	/** ユーザー担当 */
	private String userTanto;

	/** 発生日 */
	private Date hasseiDate;

	/** 回答日 */
	private Date kaitokiboDate;

	/** QA制度コード */
	private String qaSeidoCode;

	/** QA状況コード */
	private String qaJokyoCode;

	/** 担当コード */
	private String tantouCode;

	/** 回答予定日 */
	private Date kaitoYoteiDate;

	/** 回答日 */
	private Date kaitoDate;

	/** 範囲 */
	private String hani;

	/** アプリ工数 */
	private String aplKosu;

	/** インフラ工数 */
	private String infKosu;

	/** トータル工数 */
	private String totalKosu;

	/** 工期 */
	private String kouki;

	/** 備考 */
	private String biko;

	/** QA分類 */
	private String qaBunrui;

	/** 削除フラグ */
	private String delFlg;

	/** 顧客部門コード */
	private String kokyakuBumonCode;

	/**
	 * @return pqNo
	 */
	public String getPqNo() {
		return pqNo;
	}

	/**
	 * @param pqNo セットする pqNo
	 */
	public void setPqNo(String pqNo) {
		this.pqNo = pqNo;
	}

	/**
	 * @return projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode セットする projectCode
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @return gaiyo
	 */
	public String getGaiyo() {
		return gaiyo;
	}

	/**
	 * @param gaiyo セットする gaiyo
	 */
	public void setGaiyo(String gaiyo) {
		this.gaiyo = gaiyo;
	}

	/**
	 * @return kanrenProj
	 */
	public String getKanrenProj() {
		return kanrenProj;
	}

	/**
	 * @param kanrenProj セットする kanrenProj
	 */
	public void setKanrenProj(String kanrenProj) {
		this.kanrenProj = kanrenProj;
	}

	/**
	 * @return qaSyubetuCode
	 */
	public String getQaSyubetuCode() {
		return qaSyubetuCode;
	}

	/**
	 * @param qaSyubetuCode セットする qaSyubetuCode
	 */
	public void setQaSyubetuCode(String qaSyubetuCode) {
		this.qaSyubetuCode = qaSyubetuCode;
	}

	/**
	 * @return seqNo
	 */
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo セットする seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return userTanto
	 */
	public String getUserTanto() {
		return userTanto;
	}

	/**
	 * @param userTanto セットする userTanto
	 */
	public void setUserTanto(String userTanto) {
		this.userTanto = userTanto;
	}

	/**
	 * @return hasseiDate
	 */
	public Date getHasseiDate() {
		return hasseiDate;
	}

	/**
	 * @param hasseiDate セットする hasseiDate
	 */
	public void setHasseiDate(Date hasseiDate) {
		this.hasseiDate = hasseiDate;
	}

	/**
	 * @return kaitokiboDate
	 */
	public Date getKaitokiboDate() {
		return kaitokiboDate;
	}

	/**
	 * @param kaitokiboDate セットする kaitokiboDate
	 */
	public void setKaitokiboDate(Date kaitokiboDate) {
		this.kaitokiboDate = kaitokiboDate;
	}

	/**
	 * @return qaSeidoCode
	 */
	public String getQaSeidoCode() {
		return qaSeidoCode;
	}

	/**
	 * @param qaSeidoCode セットする qaSeidoCode
	 */
	public void setQaSeidoCode(String qaSeidoCode) {
		this.qaSeidoCode = qaSeidoCode;
	}

	/**
	 * @return qaJokyoCode
	 */
	public String getQaJokyoCode() {
		return qaJokyoCode;
	}

	/**
	 * @param qaJokyoCode セットする qaJokyoCode
	 */
	public void setQaJokyoCode(String qaJokyoCode) {
		this.qaJokyoCode = qaJokyoCode;
	}

	/**
	 * @return tantouCode
	 */
	public String getTantouCode() {
		return tantouCode;
	}

	/**
	 * @param tantouCode セットする tantouCode
	 */
	public void setTantouCode(String tantouCode) {
		this.tantouCode = tantouCode;
	}

	/**
	 * @return kaitoYoteiDate
	 */
	public Date getKaitoYoteiDate() {
		return kaitoYoteiDate;
	}

	/**
	 * @param kaitoYoteiDate セットする kaitoYoteiDate
	 */
	public void setKaitoYoteiDate(Date kaitoYoteiDate) {
		this.kaitoYoteiDate = kaitoYoteiDate;
	}

	/**
	 * @return kaitoDate
	 */
	public Date getKaitoDate() {
		return kaitoDate;
	}

	/**
	 * @param kaitoDate セットする kaitoDate
	 */
	public void setKaitoDate(Date kaitoDate) {
		this.kaitoDate = kaitoDate;
	}

	/**
	 * @return hani
	 */
	public String getHani() {
		return hani;
	}

	/**
	 * @param hani セットする hani
	 */
	public void setHani(String hani) {
		this.hani = hani;
	}

	/**
	 * @return aplKosu
	 */
	public String getAplKosu() {
		return aplKosu;
	}

	/**
	 * @param aplKosu セットする aplKosu
	 */
	public void setAplKosu(String aplKosu) {
		this.aplKosu = aplKosu;
	}

	/**
	 * @return infKosu
	 */
	public String getInfKosu() {
		return infKosu;
	}

	/**
	 * @param infKosu セットする infKosu
	 */
	public void setInfKosu(String infKosu) {
		this.infKosu = infKosu;
	}

	/**
	 * @return totalKosu
	 */
	public String getTotalKosu() {
		return totalKosu;
	}

	/**
	 * @param totalKosu セットする totalKosu
	 */
	public void setTotalKosu(String totalKosu) {
		this.totalKosu = totalKosu;
	}

	/**
	 * @return kouki
	 */
	public String getKouki() {
		return kouki;
	}

	/**
	 * @param kouki セットする kouki
	 */
	public void setKouki(String kouki) {
		this.kouki = kouki;
	}

	/**
	 * @return biko
	 */
	public String getBiko() {
		return biko;
	}

	/**
	 * @param biko セットする biko
	 */
	public void setBiko(String biko) {
		this.biko = biko;
	}

	/**
	 * @return qaBunrui
	 */
	public String getQaBunrui() {
		return qaBunrui;
	}

	/**
	 * @param qaBunrui セットする qaBunrui
	 */
	public void setQaBunrui(String qaBunrui) {
		this.qaBunrui = qaBunrui;
	}

	/**
	 * @return delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * @return kokyakuBumonCode
	 */
	public String getKokyakuBumonCode() {
		return kokyakuBumonCode;
	}

	/**
	 * @param kokyakuBumonCode セットする kokyakuBumonCode
	 */
	public void setKokyakuBumonCode(String kokyakuBumonCode) {
		this.kokyakuBumonCode = kokyakuBumonCode;
	}

}
