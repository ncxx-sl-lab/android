package jp.co.ctc_g.business.service;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.Syain;

public interface SyainService {

	/**
     * 部署リストを取得します.
     * @return 部署マスタ情報。見つからない場合はnull.
     * @throws BusinessException 業務例外.
     */
	public List<CmbBox> getBushoList();

	/**
     * グループリストを取得します.
     * @return グループマスタ情報。見つからない場合はnull.
     * @throws BusinessException 業務例外.
     */
	public List<CmbBox> getGroupList();

	/**
     * 権限リストを取得します.
     * @return 権限マスタ情報。見つからない場合はnull.
     * @throws BusinessException 業務例外.
     */
	public List<CmbBox> getKengenList();

	/**
     * 削除フラグリストを取得します.
     * @return 0：通常、1：削除.
     * @throws BusinessException 業務例外.
     */
	public List<CmbBox> getDelList();

	/**
     * OTLフラグリストを取得します.
     * @return 0：なし、1：あり.
     * @throws BusinessException 業務例外.
     */
	public List<CmbBox> getOtlList();

	/**
     * 社員リストを取得します.
     * @param syain 検索条件(Object型).
     * @return 社員マスタ情報。見つからない場合はnull.
     * @throws BusinessException 業務例外.
     */
	public List<Syain> getSyainLst(Syain syain);

	/**
     * 社員番号より社員情報を取得します.
     * @param 社員番号(String型).
     * @return 社員情報(Syain型).
     * @throws BusinessException 業務例外.
     */
	public Syain getSyainInfo(String syainNo);

}
