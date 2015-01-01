package jp.co.ctc_g.business.dao;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;

public interface KengenDao {

    /**
     * 権限マスタを検索します(値：権限コード、ラベル：権限名).
     * @return 権限マスタ(CmbBox型)のリスト。見つからない場合はnull.
     */
	public List<CmbBox> findKengenCmb();

}
