package jp.co.ctc_g.business.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.BushoDao;
import jp.co.ctc_g.business.dao.GroupDao;
import jp.co.ctc_g.business.dao.KengenDao;
import jp.co.ctc_g.business.dao.SyainDao;
import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.Syain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SyainServiceImpl implements SyainService {

	@Autowired
	private BushoDao bushoDao;

	@Autowired
	private GroupDao groupDao;

	@Autowired
	private KengenDao kengenDao;

	@Autowired
	private SyainDao syainDao;

    @Autowired
    private HibernateTemplate hibernateTemplate;

	@Override
	public List<CmbBox> getBushoList() {
		return bushoDao.findBushoCmb();
	}

	@Override
	public List<CmbBox> getGroupList() {
		return groupDao.findGroupCmb();
	}

	@Override
	public List<CmbBox> getKengenList() {
		return kengenDao.findKengenCmb();
	}

	@Override
	public List<CmbBox> getDelList() {
		List<CmbBox> delList = new ArrayList<CmbBox>();
		delList.add(new CmbBox("0","通常"));
		delList.add(new CmbBox("1","削除"));
		return delList;
	}

	@Override
	public List<CmbBox> getOtlList() {
		List<CmbBox> otlList = new ArrayList<CmbBox>();
		otlList.add(new CmbBox("0","なし"));
		otlList.add(new CmbBox("1","あり"));
		return otlList;
	}

	@Override
	public List<Syain> getSyainLst(Syain syain){
		return syainDao.findSyainLstBySearch(syain);
	}

	@Override
	public Syain getSyainInfo(String syainNo) {

		Syain syain = new Syain();

		List<Syain> syainList = syainDao.findSyainInfoBySyainNo(syainNo);
		if(syainList.size() > 0){
			syain = syainList.get(0);
		}
		return syain;
	}

	@Transactional(readOnly=false, rollbackFor=RuntimeException.class)
    public void entrySyain(Syain syain ,String mode_flg ,String kengen_flg) {

	}



}
