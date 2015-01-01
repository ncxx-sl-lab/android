package jp.co.ctc_g.business.dao;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;

public interface GroupDao {

    /**
     * グループマスタを検索します(値：グループコード、ラベル：グループ名).
     * @return グループマスタ(CmbBox型)のリスト。見つからない場合はnull.
     */
	public List<CmbBox> findGroupCmb();

}
