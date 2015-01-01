package jp.co.ctc_g.business.dao;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.Syain;

public interface SyainDao {

	Syain findLoginSyain(String syain_no);
	List<Syain> findSyain();
	List<Syain> findTantoSyain(String syain_no);
	List<Syain> findSyainLstBySearch(Syain syain);
	Syain findSyainBySyainCd(String syain_no);
	List<Syain> findSyainByProject(String pj_cd);
	List<Syain> findSyainByGroup(String group_cd);
	int getSyainCount(String syain_no);
	int insert(Syain syain);
	int update(Syain syain, String kengen_flg);
	int delete(String syain_no);
	List<Syain> findSyainInfoBySyainNo(String syain_no);
	List<CmbBox> findCmbBoxByGroup(String groupCd);
}
