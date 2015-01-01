// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.presentation.controller;

import java.util.Date;
import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.SagyoMst;
import jp.co.ctc_g.business.domain.ShosaiMst;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
public class ProEntForm {

	/** 前画面情報 */
	private String preFormJsonString;

	/** プロジェクト区分リスト */
	private List<CmbBox> pjkbnList;

	/** 顧客マスタリスト */
	private List<CmbBox> kokyakuList;

	/** 開発分類リスト */
	private List<CmbBox> mitumoriKeitaiList;

	/** 顧客部門リスト */
	private List<CmbBox> kokyakuBumonList;

	/** グループリスト */
	private List<CmbBox> groupList;

	/** OTLプロジェクトリスト */
	private List<CmbBox> otlProjectList;

	/** OTL作業リスト */
	private List<CmbBox> otlSagyoList;

	/** OTLタイプリスト */
	private List<CmbBox> otlTypeList;

	/** OTL営業リスト */
	private List<CmbBox> otlEigyoList;

	/** 社員一覧リスト */
	private List<CmbBox> syainList;

	/** ＱＡ管理Noリスト */
	private List<CmbBox> qaKanriList;

	/** 有り/無しリスト */
	private List<CmbBox> onOffList;

	/** 業務区分リスト */
	private List<CmbBox> gmKbnList;

	/** 作業グループリスト */
	private List<SagyoMst> sagyoList;

	/** 作業詳細リスト */
	private List<ShosaiMst> shosaiList;

	/** プロジェクトコード */
	private String pjCd;

	/** プロジェクト名 */
	private String pjName;

	/** 期間(From) */
	private Date kikanFrom;

	/** 期間(To) */
	private Date kikanTo;

	/** プロジェクト区分 */
	private String pjkbnCd;

	/** 顧客コード */
	private String kokyakuCd;

	/** 開発分類コード */
	private String mitumoriKeitaiCd;

	/** 顧客部門コード */
	private String kokyakuBumonCd;

	/** OTLプロジェクトコード */
	private String otlProjectCd;

	/** OTL作業コード */
	private String otlSagyoCd;

	/** OTLタイプコード */
	private String otlTypeCd;

	/** OTL営業番号 */
	private String otlEigyoSyainNo;

	/** OTLコメント */
	private String otlComment;

	/** 案件担当 */
	private String ankenTanto;

	/** SEQNO */
	private String seqNo;

	/** SB番号 */
	private String sbNo;

	/** 担当コード */
	private String tantoCd;

	/** 内担当社員 */
	private String uchitantoCd;

	/** 完了日 */
	private Date kanryoDate;

	/** ＱＡ管理No */
	private String qaNo;

	/** 注文書有無 */
	private String tyumonFlg;

	/** ＳＴ受入 */
	private String ukeireFlg;

	/** 完了フラグ */
	private String kanryoFlg;

	/** 検収受領 */
	private String jyuryoFlg;

	/** 予定 着手 */
	private Date ytyakusyu;

	/** 予定 変更概要Rev */
	private Date ygaiyoRev;

	/** 予定 ITｹｰｽRev */
	private Date yitRev;

	/** 予定 IT07 */
	private Date yit1;

	/** 予定 IT08 */
	private Date yit2;

	/** 予定 ST01 */
	private Date yst1;

	/** 予定 ST02 */
	private Date yst2;

	/** 予定 本番(西) */
	private Date yhonbanW;

	/** 予定 本番(東) */
	private Date yhonbanE;

	/** 実績 着手 */
	private Date htyakusyu;

	/** 実績 変更概要Rev */
	private Date hgaiyoRev;

	/** 実績 ITケースRev */
	private Date hitRev;

	/** 実績 IT07 */
	private Date hit1;

	/** 実績 IT08 */
	private Date hit2;

	/** 実績 ST01 */
	private Date hst1;

	/** 実績 ST02 */
	private Date hst2;

	/** 実績 本番(西) */
	private Date hhonbanW;

	/** 実績 本番(東) */
	private Date hhonbanE;

	/** 備考 */
	private String biko;

	/** 業務区分 */
	private String gmKbn;

	/**
	 * @return pjkbnList
	 */
	public List<CmbBox> getPjkbnList() {
		return pjkbnList;
	}

	/**
	 * @param pjkbnList セットする pjkbnList
	 */
	public void setPjkbnList(List<CmbBox> pjkbnList) {
		this.pjkbnList = pjkbnList;
	}

	/**
	 * @return kokyakuList
	 */
	public List<CmbBox> getKokyakuList() {
		return kokyakuList;
	}

	/**
	 * @param kokyakuList セットする kokyakuList
	 */
	public void setKokyakuList(List<CmbBox> kokyakuList) {
		this.kokyakuList = kokyakuList;
	}

	/**
	 * @return mitumoriKeitaiList
	 */
	public List<CmbBox> getMitumoriKeitaiList() {
		return mitumoriKeitaiList;
	}

	/**
	 * @param mitumoriKeitaiList セットする mitumoriKeitaiList
	 */
	public void setMitumoriKeitaiList(List<CmbBox> mitumoriKeitaiList) {
		this.mitumoriKeitaiList = mitumoriKeitaiList;
	}

	/**
	 * @return kokyakuBumonList
	 */
	public List<CmbBox> getKokyakuBumonList() {
		return kokyakuBumonList;
	}

	/**
	 * @param kokyakuBumonList セットする kokyakuBumonList
	 */
	public void setKokyakuBumonList(List<CmbBox> kokyakuBumonList) {
		this.kokyakuBumonList = kokyakuBumonList;
	}

	/**
	 * @return groupList
	 */
	public List<CmbBox> getGroupList() {
		return groupList;
	}

	/**
	 * @param groupList セットする groupList
	 */
	public void setGroupList(List<CmbBox> groupList) {
		this.groupList = groupList;
	}

	/**
	 * @return otlProjectList
	 */
	public List<CmbBox> getOtlProjectList() {
		return otlProjectList;
	}

	/**
	 * @param otlProjectList セットする otlProjectList
	 */
	public void setOtlProjectList(List<CmbBox> otlProjectList) {
		this.otlProjectList = otlProjectList;
	}

	/**
	 * @return otlSagyoList
	 */
	public List<CmbBox> getOtlSagyoList() {
		return otlSagyoList;
	}

	/**
	 * @param otlSagyoList セットする otlSagyoList
	 */
	public void setOtlSagyoList(List<CmbBox> otlSagyoList) {
		this.otlSagyoList = otlSagyoList;
	}

	/**
	 * @return otlTypeList
	 */
	public List<CmbBox> getOtlTypeList() {
		return otlTypeList;
	}

	/**
	 * @param otlTypeList セットする otlTypeList
	 */
	public void setOtlTypeList(List<CmbBox> otlTypeList) {
		this.otlTypeList = otlTypeList;
	}

	/**
	 * @return otlEigyoList
	 */
	public List<CmbBox> getOtlEigyoList() {
		return otlEigyoList;
	}

	/**
	 * @param otlEigyoList セットする otlEigyoList
	 */
	public void setOtlEigyoList(List<CmbBox> otlEigyoList) {
		this.otlEigyoList = otlEigyoList;
	}

	/**
	 * @return syainList
	 */
	public List<CmbBox> getSyainList() {
		return syainList;
	}

	/**
	 * @param syainList セットする syainList
	 */
	public void setSyainList(List<CmbBox> syainList) {
		this.syainList = syainList;
	}

	/**
	 * @return qaKanriList
	 */
	public List<CmbBox> getQaKanriList() {
		return qaKanriList;
	}

	/**
	 * @param qaKanriList セットする qaKanriList
	 */
	public void setQaKanriList(List<CmbBox> qaKanriList) {
		this.qaKanriList = qaKanriList;
	}

	/**
	 * @return onOffList
	 */
	public List<CmbBox> getOnOffList() {
		return onOffList;
	}

	/**
	 * @param onOffList セットする onOffList
	 */
	public void setOnOffList(List<CmbBox> onOffList) {
		this.onOffList = onOffList;
	}

	/**
	 * @return gmKbnList
	 */
	public List<CmbBox> getGmKbnList() {
		return gmKbnList;
	}

	/**
	 * @param gmKbnList セットする gmKbnList
	 */
	public void setGmKbnList(List<CmbBox> gmKbnList) {
		this.gmKbnList = gmKbnList;
	}

	/**
	 * @return pjkbnCd
	 */
	public String getPjkbnCd() {
		return pjkbnCd;
	}

	/**
	 * @param pjkbnCd セットする pjkbnCd
	 */
	public void setPjkbnCd(String pjkbnCd) {
		this.pjkbnCd = pjkbnCd;
	}

	/**
	 * @return kokyakuCd
	 */
	public String getKokyakuCd() {
		return kokyakuCd;
	}

	/**
	 * @param kokyakuCd セットする kokyakuCd
	 */
	public void setKokyakuCd(String kokyakuCd) {
		this.kokyakuCd = kokyakuCd;
	}

	/**
	 * @return mitumoriKeitaiCd
	 */
	public String getMitumoriKeitaiCd() {
		return mitumoriKeitaiCd;
	}

	/**
	 * @param mitumoriKeitaiCd セットする mitumoriKeitaiCd
	 */
	public void setMitumoriKeitaiCd(String mitumoriKeitaiCd) {
		this.mitumoriKeitaiCd = mitumoriKeitaiCd;
	}

	/**
	 * @return kokyakuBumonCd
	 */
	public String getKokyakuBumonCd() {
		return kokyakuBumonCd;
	}

	/**
	 * @param kokyakuBumonCd セットする kokyakuBumonCd
	 */
	public void setKokyakuBumonCd(String kokyakuBumonCd) {
		this.kokyakuBumonCd = kokyakuBumonCd;
	}

	/**
	 * @return otlProjectCd
	 */
	public String getOtlProjectCd() {
		return otlProjectCd;
	}

	/**
	 * @param otlProjectCd セットする otlProjectCd
	 */
	public void setOtlProjectCd(String otlProjectCd) {
		this.otlProjectCd = otlProjectCd;
	}

	/**
	 * @return otlSagyoCd
	 */
	public String getOtlSagyoCd() {
		return otlSagyoCd;
	}

	/**
	 * @param otlSagyoCd セットする otlSagyoCd
	 */
	public void setOtlSagyoCd(String otlSagyoCd) {
		this.otlSagyoCd = otlSagyoCd;
	}

	/**
	 * @return otlTypeCd
	 */
	public String getOtlTypeCd() {
		return otlTypeCd;
	}

	/**
	 * @param otlTypeCd セットする otlTypeCd
	 */
	public void setOtlTypeCd(String otlTypeCd) {
		this.otlTypeCd = otlTypeCd;
	}

	/**
	 * @return otlEigyoSyainNo
	 */
	public String getOtlEigyoSyainNo() {
		return otlEigyoSyainNo;
	}

	/**
	 * @param otlEigyoSyainNo セットする otlEigyoSyainNo
	 */
	public void setOtlEigyoSyainNo(String otlEigyoSyainNo) {
		this.otlEigyoSyainNo = otlEigyoSyainNo;
	}

	/**
	 * @return otlComment
	 */
	public String getOtlComment() {
		return otlComment;
	}

	/**
	 * @param otlComment セットする otlComment
	 */
	public void setOtlComment(String otlComment) {
		this.otlComment = otlComment;
	}

	/**
	 * @return tantoCd
	 */
	public String getTantoCd() {
		return tantoCd;
	}

	/**
	 * @param tantoCd セットする tantoCd
	 */
	public void setTantoCd(String tantoCd) {
		this.tantoCd = tantoCd;
	}

	/**
	 * @return uchitantoCd
	 */
	public String getUchitantoCd() {
		return uchitantoCd;
	}

	/**
	 * @param uchitantoCd セットする uchitantoCd
	 */
	public void setUchitantoCd(String uchitantoCd) {
		this.uchitantoCd = uchitantoCd;
	}

	/**
	 * @return kanryoDate
	 */
	public Date getKanryoDate() {
		return kanryoDate;
	}

	/**
	 * @param kanryoDate セットする kanryoDate
	 */
	public void setKanryoDate(Date kanryoDate) {
		this.kanryoDate = kanryoDate;
	}

	/**
	 * @return qaNo
	 */
	public String getQaNo() {
		return qaNo;
	}

	/**
	 * @param qaNo セットする qaNo
	 */
	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

	/**
	 * @return tyumonFlg
	 */
	public String getTyumonFlg() {
		return tyumonFlg;
	}

	/**
	 * @param tyumonFlg セットする tyumonFlg
	 */
	public void setTyumonFlg(String tyumonFlg) {
		this.tyumonFlg = tyumonFlg;
	}

	/**
	 * @return ukeireFlg
	 */
	public String getUkeireFlg() {
		return ukeireFlg;
	}

	/**
	 * @param ukeireFlg セットする ukeireFlg
	 */
	public void setUkeireFlg(String ukeireFlg) {
		this.ukeireFlg = ukeireFlg;
	}

	/**
	 * @return kanryoFlg
	 */
	public String getKanryoFlg() {
		return kanryoFlg;
	}

	/**
	 * @param kanryoFlg セットする kanryoFlg
	 */
	public void setKanryoFlg(String kanryoFlg) {
		this.kanryoFlg = kanryoFlg;
	}

	/**
	 * @return jyuryoFlg
	 */
	public String getJyuryoFlg() {
		return jyuryoFlg;
	}

	/**
	 * @param jyuryoFlg セットする jyuryoFlg
	 */
	public void setJyuryoFlg(String jyuryoFlg) {
		this.jyuryoFlg = jyuryoFlg;
	}

	/**
	 * @return ytyakusyu
	 */
	public Date getYtyakusyu() {
		return ytyakusyu;
	}

	/**
	 * @param ytyakusyu セットする ytyakusyu
	 */
	public void setYtyakusyu(Date ytyakusyu) {
		this.ytyakusyu = ytyakusyu;
	}

	/**
	 * @return ygaiyoRev
	 */
	public Date getYgaiyoRev() {
		return ygaiyoRev;
	}

	/**
	 * @param ygaiyoRev セットする ygaiyoRev
	 */
	public void setYgaiyoRev(Date ygaiyoRev) {
		this.ygaiyoRev = ygaiyoRev;
	}

	/**
	 * @return yitRev
	 */
	public Date getYitRev() {
		return yitRev;
	}

	/**
	 * @param yitRev セットする yitRev
	 */
	public void setYitRev(Date yitRev) {
		this.yitRev = yitRev;
	}

	/**
	 * @return yit1
	 */
	public Date getYit1() {
		return yit1;
	}

	/**
	 * @param yit1 セットする yit1
	 */
	public void setYit1(Date yit1) {
		this.yit1 = yit1;
	}

	/**
	 * @return yit2
	 */
	public Date getYit2() {
		return yit2;
	}

	/**
	 * @param yit2 セットする yit2
	 */
	public void setYit2(Date yit2) {
		this.yit2 = yit2;
	}

	/**
	 * @return yst1
	 */
	public Date getYst1() {
		return yst1;
	}

	/**
	 * @param yst1 セットする yst1
	 */
	public void setYst1(Date yst1) {
		this.yst1 = yst1;
	}

	/**
	 * @return yst2
	 */
	public Date getYst2() {
		return yst2;
	}

	/**
	 * @param yst2 セットする yst2
	 */
	public void setYst2(Date yst2) {
		this.yst2 = yst2;
	}

	/**
	 * @return yhonbanW
	 */
	public Date getYhonbanW() {
		return yhonbanW;
	}

	/**
	 * @param yhonbanW セットする yhonbanW
	 */
	public void setYhonbanW(Date yhonbanW) {
		this.yhonbanW = yhonbanW;
	}

	/**
	 * @return yhonbanE
	 */
	public Date getYhonbanE() {
		return yhonbanE;
	}

	/**
	 * @param yhonbanE セットする yhonbanE
	 */
	public void setYhonbanE(Date yhonbanE) {
		this.yhonbanE = yhonbanE;
	}

	/**
	 * @return htyakusyu
	 */
	public Date getHtyakusyu() {
		return htyakusyu;
	}

	/**
	 * @param htyakusyu セットする htyakusyu
	 */
	public void setHtyakusyu(Date htyakusyu) {
		this.htyakusyu = htyakusyu;
	}

	/**
	 * @return hgaiyoRev
	 */
	public Date getHgaiyoRev() {
		return hgaiyoRev;
	}

	/**
	 * @param hgaiyoRev セットする hgaiyoRev
	 */
	public void setHgaiyoRev(Date hgaiyoRev) {
		this.hgaiyoRev = hgaiyoRev;
	}

	/**
	 * @return hitRev
	 */
	public Date getHitRev() {
		return hitRev;
	}

	/**
	 * @param hitRev セットする hitRev
	 */
	public void setHitRev(Date hitRev) {
		this.hitRev = hitRev;
	}

	/**
	 * @return hit1
	 */
	public Date getHit1() {
		return hit1;
	}

	/**
	 * @param hit1 セットする hit1
	 */
	public void setHit1(Date hit1) {
		this.hit1 = hit1;
	}

	/**
	 * @return hit2
	 */
	public Date getHit2() {
		return hit2;
	}

	/**
	 * @param hit2 セットする hit2
	 */
	public void setHit2(Date hit2) {
		this.hit2 = hit2;
	}

	/**
	 * @return hst1
	 */
	public Date getHst1() {
		return hst1;
	}

	/**
	 * @param hst1 セットする hst1
	 */
	public void setHst1(Date hst1) {
		this.hst1 = hst1;
	}

	/**
	 * @return hst2
	 */
	public Date getHst2() {
		return hst2;
	}

	/**
	 * @param hst2 セットする hst2
	 */
	public void setHst2(Date hst2) {
		this.hst2 = hst2;
	}

	/**
	 * @return hhonbanW
	 */
	public Date getHhonbanW() {
		return hhonbanW;
	}

	/**
	 * @param hhonbanW セットする hhonbanW
	 */
	public void setHhonbanW(Date hhonbanW) {
		this.hhonbanW = hhonbanW;
	}

	/**
	 * @return hhonbanE
	 */
	public Date getHhonbanE() {
		return hhonbanE;
	}

	/**
	 * @param hhonbanE セットする hhonbanE
	 */
	public void setHhonbanE(Date hhonbanE) {
		this.hhonbanE = hhonbanE;
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
	 * @return gmKbn
	 */
	public String getGmKbn() {
		return gmKbn;
	}

	/**
	 * @param gmKbn セットする gmKbn
	 */
	public void setGmKbn(String gmKbn) {
		this.gmKbn = gmKbn;
	}

	/**
	 * @return sagyoList
	 */
	public List<SagyoMst> getSagyoList() {
		return sagyoList;
	}

	/**
	 * @param sagyoList セットする sagyoList
	 */
	public void setSagyoList(List<SagyoMst> sagyoList) {
		this.sagyoList = sagyoList;
	}

	/**
	 * @return shosaiList
	 */
	public List<ShosaiMst> getShosaiList() {
		return shosaiList;
	}

	/**
	 * @param shosaiList セットする shosaiList
	 */
	public void setShosaiList(List<ShosaiMst> shosaiList) {
		this.shosaiList = shosaiList;
	}

	/**
	 * @return pjCd
	 */
	public String getPjCd() {
		return pjCd;
	}

	/**
	 * @param pjCd セットする pjCd
	 */
	public void setPjCd(String pjCd) {
		this.pjCd = pjCd;
	}

	/**
	 * @return pjName
	 */
	public String getPjName() {
		return pjName;
	}

	/**
	 * @param pjName セットする pjName
	 */
	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	/**
	 * @return kikanFrom
	 */
	public Date getKikanFrom() {
		return kikanFrom;
	}

	/**
	 * @param kikanFrom セットする kikanFrom
	 */
	public void setKikanFrom(Date kikanFrom) {
		this.kikanFrom = kikanFrom;
	}

	/**
	 * @return kikanTo
	 */
	public Date getKikanTo() {
		return kikanTo;
	}

	/**
	 * @param kikanTo セットする kikanTo
	 */
	public void setKikanTo(Date kikanTo) {
		this.kikanTo = kikanTo;
	}

	/**
	 * @return ankenTanto
	 */
	public String getAnkenTanto() {
		return ankenTanto;
	}

	/**
	 * @param ankenTanto セットする ankenTanto
	 */
	public void setAnkenTanto(String ankenTanto) {
		this.ankenTanto = ankenTanto;
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
	 * @return sbNo
	 */
	public String getSbNo() {
		return sbNo;
	}

	/**
	 * @param sbNo セットする sbNo
	 */
	public void setSbNo(String sbNo) {
		this.sbNo = sbNo;
	}

	/**
	 * @return preFormJsonString
	 */
	public String getPreFormJsonString() {
		return preFormJsonString;
	}

	/**
	 * @param preFormJsonString セットする preFormJsonString
	 */
	public void setPreFormJsonString(String preFormJsonString) {
		this.preFormJsonString = preFormJsonString;
	}

}
