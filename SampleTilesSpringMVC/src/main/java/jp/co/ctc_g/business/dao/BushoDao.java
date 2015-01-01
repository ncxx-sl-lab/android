package jp.co.ctc_g.business.dao;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;


public interface BushoDao {

    /**
     *
     * @return aa
     */
    public List<CmbBox> findBushoCmb();
}
