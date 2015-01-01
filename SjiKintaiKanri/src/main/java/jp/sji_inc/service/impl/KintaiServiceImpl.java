/**
 *
 */
package jp.sji_inc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import jp.sji_inc.action.form.JqGridForm;
import jp.sji_inc.action.form.KintaiCopyForm;
import jp.sji_inc.action.form.KintaiForm;
import jp.sji_inc.action.form.KintaiGridForm;
import jp.sji_inc.action.form.KintaiGridSaveForm;
import jp.sji_inc.action.form.KintaiMgrSaveForm;
import jp.sji_inc.action.form.KintaiMgrSearchForm;
import jp.sji_inc.action.form.KintaiMgrSearchGrid;
import jp.sji_inc.action.form.KintaiSagyoAnbunGridForm;
import jp.sji_inc.action.form.KintaiSagyoAnbunSaveForm;
import jp.sji_inc.action.form.KintaiShiftDelForm;
import jp.sji_inc.action.form.KintaiShiftGridForm;
import jp.sji_inc.action.form.KintaiShiftSaveForm;
import jp.sji_inc.common.DateUtil;
import jp.sji_inc.common.LabelBean;
import jp.sji_inc.common.StringUtil;
import jp.sji_inc.db.dao.EmpDao;
import jp.sji_inc.db.dao.KintaiDao;
import jp.sji_inc.db.dao.KintaiHoursDao;
import jp.sji_inc.db.dao.KintaiMgrDao;
import jp.sji_inc.db.dao.KintaiSagyoAnbunDao;
import jp.sji_inc.db.dao.KyukaDao;
import jp.sji_inc.db.dao.ProjectDao;
import jp.sji_inc.db.dao.SagyoDao;
import jp.sji_inc.db.dao.ShiftDao;
import jp.sji_inc.db.dao.ShiftTableDao;
import jp.sji_inc.db.entity.base.Emp;
import jp.sji_inc.db.entity.base.Kintai;
import jp.sji_inc.db.entity.base.KintaiMgr;
import jp.sji_inc.db.entity.base.KintaiSagyoAnbun;
import jp.sji_inc.db.entity.base.Office;
import jp.sji_inc.db.entity.base.Shift;
import jp.sji_inc.db.entity.base.ShiftTable;
import jp.sji_inc.service.KintaiService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kyon
 *
 */
@Service
public class KintaiServiceImpl implements KintaiService {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(KintaiServiceImpl.class);

	/** 社員Dao */
	@Autowired
	private EmpDao empDao;

	/** 勤怠Dao */
	@Autowired
	private KintaiDao kintaiDao;

	/** 勤怠時間Dao */
	@Autowired
	private KintaiHoursDao kintaiHoursDao;

	/** 作業按分Dao */
	@Autowired
	private KintaiSagyoAnbunDao kintaiSagyoAnbunDao;

	/** シフトDao */
	@Autowired
	private ShiftDao shiftDao;

	/** ﾌﾟﾛｼﾞｪｸﾄDao */
	@Autowired
	private ProjectDao projectDao;

	/** 作業Dao */
	@Autowired
	private SagyoDao sagyoDao;

//	/** ｼﾌﾄデフォルト */
//	@Autowired
//	private ShiftDefaultDao shiftDefaultDao;

	/** 休暇Dao */
	@Autowired
	private KyukaDao kyukaDao;

	/** ｼﾌﾄDao */
	@Autowired
	private ShiftTableDao shiftTableDao;

	/** 勤怠管理者Dao */
	@Autowired
	private KintaiMgrDao kintaiMgrDao;

	@Override
	public void kintaiShow(KintaiForm kintaiForm) {
		List<LabelBean> shiftCombo = shiftDao.findCombo(kintaiForm.getEmpNo(), kintaiForm.getKintaiMonth());
		kintaiForm.setShiftGridCombo(StringUtil.cmbJqGridComboString(shiftCombo));
		kintaiForm.setProjectGridCombo(StringUtil.cmbJqGridComboString(projectDao.findCombo()));
		kintaiForm.setSagyoGridCombo(StringUtil.cmbJqGridComboString(sagyoDao.findCombo()));
		kintaiForm.setKyukaGridCombo(StringUtil.cmbJqGridComboString(kyukaDao.findCombo()));
		KintaiMgr kintaiMgr = new KintaiMgr();
		kintaiMgr.setEmpNo(kintaiForm.getEmpNo());
		kintaiMgr.setKintaiMonth(kintaiForm.getKintaiMonth());
		kintaiMgr.setNo("1");
		KintaiMgr kintaiMgr1 = kintaiMgrDao.findById(kintaiMgr);
		if (kintaiMgr1!=null) {
			Emp mgr = kintaiMgr1.getMgr();
			if (mgr != null) {
				kintaiForm.setMgr1Name(mgr.getEmpNameLast() + " " + mgr.getEmpNameFirst());
			}
			kintaiForm.setMgr1DateFrom(kintaiMgr1.getDateFrom());
			kintaiForm.setMgr1DateTo(kintaiMgr1.getDateTo());
		}
		kintaiMgr.setNo("2");
		KintaiMgr kintaiMgr2 = kintaiMgrDao.findById(kintaiMgr);
		if (kintaiMgr2!=null) {
			Emp mgr = kintaiMgr2.getMgr();
			if (mgr != null) {
				kintaiForm.setMgr2Name(mgr.getEmpNameLast() + " " + mgr.getEmpNameFirst());
			}
			kintaiForm.setMgr2DateFrom(kintaiMgr2.getDateFrom());
			kintaiForm.setMgr2DateTo(kintaiMgr2.getDateTo());
		}

		// TODO
		kintaiDao.findKintaiSum(kintaiForm.getEmpNo(), kintaiForm.getKintaiMonth());
	}

	@Override
	public JqGridForm getKintaiGrid(String empNo, String kintaiMonth) {
		try {
			JqGridForm jqgrid = new JqGridForm();
			jqgrid.setTotal(1);
			jqgrid.setPage(1);

			// 勤怠テーブル検索
			List<Kintai> kintaiList = kintaiDao.findByMonth(empNo, kintaiMonth);
			jqgrid.setRecords(kintaiList.size());
			for (Kintai k : kintaiList) {
				jqgrid.getRows().add(kintaiGridFormRowMapper(k));
			}
			return jqgrid;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Kintai saveKintaiGrid(KintaiGridSaveForm kintaiGridSaveForm) {

		Kintai kintai = new Kintai();
		kintai.setEmpNo(kintaiGridSaveForm.getEmpNo());
		kintai.setKintaiDate(kintaiGridSaveForm.getKintaiDate());
		kintai.setKintaiMonth(kintaiGridSaveForm.getKintaiDate().substring(6));
		kintai = kintaiDao.findById(kintai);
		if (kintai == null) {
			kintai = new Kintai();
			kintai.setEmpNo(kintaiGridSaveForm.getEmpNo());
			kintai.setKintaiDate(kintaiGridSaveForm.getKintaiDate());
			kintai.setKintaiMonth(kintaiGridSaveForm.getKintaiDate().substring(6));
		}
		if (kintaiGridSaveForm.getShiftNo() != null) {
			kintai.setShiftNo(kintaiGridSaveForm.getShiftNo());
		}
		if (kintaiGridSaveForm.getStartTime() != null) {
			kintai.setStartTime(kintaiGridSaveForm.getStartTime());
			kintai.setStartTimeRound(DateUtil.getRoundedTime(kintaiGridSaveForm.getStartTime()));
		}
		if (kintaiGridSaveForm.getEndTime() != null) {
			kintai.setEndTime(kintaiGridSaveForm.getEndTime());
			kintai.setEndTimeRound(DateUtil.getRoundedTime(kintaiGridSaveForm.getEndTime()));
		}
		if (kintaiGridSaveForm.getTokkiJiko() != null) {
			kintai.setTokkiJiko(kintaiGridSaveForm.getTokkiJiko());
		}
		if (kintaiGridSaveForm.getKoumokuNo() != null) {
			kintai.setKoumokuNo(null);
			if (!kintaiGridSaveForm.getKoumokuNo().equals("")) {
				kintai.setKoumokuNo(kintaiGridSaveForm.getKoumokuNo());
				kintai.setStartTime(null);
				kintai.setStartTimeRound(null);
				kintai.setEndTime(null);
				kintai.setEndTimeRound(null);
			}
		}
		if (kintaiGridSaveForm.getKyukaMisyutokuSinsei2() != null) {
			kintai.setKyukaMisyutokuSinsei2(kintaiGridSaveForm.getKyukaMisyutokuSinsei2());
		}
		if (kintaiGridSaveForm.getKyukaMisyutokuSinsei3() != null) {
			kintai.setKyukaMisyutokuSinsei3(kintaiGridSaveForm.getKyukaMisyutokuSinsei3());
		}
		if (kintaiGridSaveForm.getKyukaMisyutokuSinsei4() != null) {
			kintai.setKyukaMisyutokuSinsei4(kintaiGridSaveForm.getKyukaMisyutokuSinsei4());
		}
		if (kintaiGridSaveForm.getKyukaMisyutokuSinsei5() != null) {
			kintai.setKyukaMisyutokuSinsei5(kintaiGridSaveForm.getKyukaMisyutokuSinsei5());
		}
		if (kintaiGridSaveForm.getKyukaMisyutokuSinsei6() != null) {
			kintai.setKyukaMisyutokuSinsei6(kintaiGridSaveForm.getKyukaMisyutokuSinsei6());
		}
		if (kintaiGridSaveForm.getProjectNo()!=null) {
			kintai.setProjectNo(null);
			if (!kintaiGridSaveForm.getProjectNo().equals("")) {
				kintai.setProjectNo(kintaiGridSaveForm.getProjectNo());
			}
		}
		this.setHours(kintai);

		kintaiDao.save(kintai);
		// TODO ? @ManyToOneの値がとれない？？？
//		Kintai test = new Kintai();
//		test.setEmpNo(kintai.getEmpNo());
//		test.setKintaiDate(kintai.getKintaiDate());
//		test = kintaiDao.findById(test);
		return kintai;
	}

	@Override
	public JqGridForm getKintaiSagyoAnbunGrid(String empNo, String kintaiDate) {
		JqGridForm jqgrid = new JqGridForm();
		jqgrid.setTotal(1);
		jqgrid.setPage(1);

		Kintai kintai = new Kintai();
		kintai.setEmpNo(empNo);
		kintai.setKintaiDate(kintaiDate);
		kintai = kintaiDao.findById(kintai);
		List<KintaiSagyoAnbun> kintaiSagyoAnbunList = kintai.getKintaiSagyoAnbun();

		jqgrid.setRecords(kintaiSagyoAnbunList.size());
		for (KintaiSagyoAnbun kh : kintaiSagyoAnbunList) {
			KintaiSagyoAnbunGridForm row = new KintaiSagyoAnbunGridForm();
			row.setKintaiDate(kh.getKintaiDate());
			row.setSagyoCd(kh.getSagyo().getSagyoName());
			row.setNormalAnbunRitu(kh.getNormalAnbunRitu());
			row.setOverAnbunRitu(kh.getOverAnbunRitu());
			row.setLateOverAnbunRitu(kh.getLateOverAnbunRitu());
			jqgrid.getRows().add(row);
		}
		return jqgrid;
	}

	@Override
	public void saveKintaiSagyoAnbunGrid(KintaiSagyoAnbunSaveForm kintaiSagyoAnbunSaveForm) {
		KintaiSagyoAnbun kintaiSagyoAnbun = new KintaiSagyoAnbun();
		kintaiSagyoAnbun.setEmpNo(kintaiSagyoAnbunSaveForm.getEmpNo());
		kintaiSagyoAnbun.setKintaiDate(kintaiSagyoAnbunSaveForm.getKintaiDate());
		kintaiSagyoAnbun.setSagyoCd(kintaiSagyoAnbunSaveForm.getSagyoCd());
		kintaiSagyoAnbun.setNormalAnbunRitu(kintaiSagyoAnbunSaveForm.getNormalAnbunRitu());
		kintaiSagyoAnbun.setOverAnbunRitu(kintaiSagyoAnbunSaveForm.getOverAnbunRitu());
		kintaiSagyoAnbun.setLateOverAnbunRitu(kintaiSagyoAnbunSaveForm.getLateOverAnbunRitu());
		kintaiSagyoAnbunDao.saveOrUpdate(kintaiSagyoAnbun);
	}

	@Override
	public JqGridForm getKintaiShiftGrid(String empNo, String kintaiMonth) {
		JqGridForm jqgrid = new JqGridForm();
		jqgrid.setTotal(1);
		jqgrid.setPage(1);
		List<Shift> shiftList = shiftDao.findByMonth(empNo, kintaiMonth);
		for (Shift s : shiftList) {
			KintaiShiftGridForm row = new KintaiShiftGridForm();
			row.setShiftNo(s.getShiftNo());
			row.setStartTime(s.getStartTime());
			row.setEndTime(s.getEndTime());
			row.setTyouka(s.getTyouka().toString());
			row.setDayHours(s.getDayHours());
			row.setHankyuKbn(s.getHankyuKbn());
			row.setRest1Start(s.getRest1Start());
			row.setRest1End(s.getRest1End());
			row.setRest2Start(s.getRest2Start());
			row.setRest2End(s.getRest2End());
			jqgrid.getRows().add(row);
		}
		return jqgrid;
	}

	@Override
	public void saveKintaiShiftGrid(KintaiShiftSaveForm kintaiShiftSaveForm) {
		List<Shift> shiftList = shiftDao.findByMonth(kintaiShiftSaveForm.getEmpNo(), kintaiShiftSaveForm.getKintaiMonth());
		int shiftNo = 0;
		if (shiftList.size() > 0) {
			shiftNo = Integer.parseInt(shiftList.get(shiftList.size()-1).getShiftNo());
		}
		shiftNo++;
		Shift shift = new Shift();
		shift.setEmpNo(kintaiShiftSaveForm.getEmpNo());
		shift.setKintaiMonth(kintaiShiftSaveForm.getKintaiMonth());
		shift.setShiftNo(String.valueOf(shiftNo));
		shift.setStartTime(kintaiShiftSaveForm.getStartTime());
		shift.setEndTime(kintaiShiftSaveForm.getEndTime());
		shift.setRest1Start(kintaiShiftSaveForm.getRest1Start());
		shift.setRest1End(kintaiShiftSaveForm.getRest1End());
		shift.setRest2Start(kintaiShiftSaveForm.getRest2Start());
		shift.setRest2End(kintaiShiftSaveForm.getRest2End());
		shiftDao.saveOrUpdate(shift);
	}

	@Override
	public KintaiGridForm kintaiGridFormRowMapper(Kintai kintai) {
		KintaiGridForm row = new KintaiGridForm();
		row.setKintaiDate(kintai.getKintaiDate());
		row.setStartTime(kintai.getStartTime());
		row.setEndTime(kintai.getEndTime());
		row.setShiftNo(kintai.getShift());
		row.setTokkiJiko(kintai.getTokkiJiko());
		row.setKoumokuNo(kintai.getKyuka());
		row.setKyukaMisyutokuSinsei2(kintai.getKyukaMisyutokuSinsei2());
		row.setKyukaMisyutokuSinsei3(kintai.getKyukaMisyutokuSinsei3());
		row.setKyukaMisyutokuSinsei4(kintai.getKyukaMisyutokuSinsei4());
		row.setKyukaMisyutokuSinsei5(kintai.getKyukaMisyutokuSinsei5());
		row.setKyukaMisyutokuSinsei6(kintai.getKyukaMisyutokuSinsei6());
		row.setProjectNo(kintai.getProject());
		row.setSagyoCd(kintai.getKintaiSagyoAnbun());
		row.setHours(kintai.getHours());
		row.setOvertime(kintai.getOvertime());
		row.setLateOvertime(kintai.getLateOvertime());
		return row;
	}

	/**
	 * 勤務時刻から遅刻時間や、勤務時間を設定する
	 * @param kintai
	 */
	public void setHours(Kintai kintai) {
		try {
			if (StringUtil.isNull(kintai.getStartTimeRound()) ||
				StringUtil.isNull(kintai.getEndTimeRound())) {
				kintai.setLateTime(null);
				kintai.setLeaveEarlyTime(null);
				kintai.setHours(null);
				kintai.setOvertime(null);
				kintai.setLateOvertime(null);
			} else {
				if (StringUtil.isNull(kintai.getShiftNo())) {
					Shift shift = new Shift();
					shift.setEmpNo(kintai.getEmpNo());
					shift.setKintaiMonth(kintai.getKintaiMonth());
					shift.setShiftNo("1");
					shift = shiftDao.findById(shift);
					ShiftTable st = shiftTableDao.findById(shift, kintai.getEndTimeRound());
					if (st == null) {
						kintai.setLateTime(null);
						kintai.setLeaveEarlyTime(null);
						kintai.setHours(null);
						kintai.setOvertime(null);
						kintai.setLateOvertime(null);
						return;
					}
					kintai.setHours(BigDecimal.ZERO);
					BigDecimal late = DateUtil.getDiff(kintai.getStartTime(), shift.getStartTime());
					if (late.compareTo(BigDecimal.ZERO) < 0) {
						late = BigDecimal.ZERO;
					}
					BigDecimal early = DateUtil.getDiff(shift.getEndTime(), kintai.getEndTimeRound());
					if (early.compareTo(BigDecimal.ZERO) < 0) {
						early = BigDecimal.ZERO;
					}
					kintai.setOvertime(st.getHours().subtract(late).subtract(early).subtract(st.getLateOver()));
					kintai.setLateOvertime(st.getLateOver());
					kintai.setHoursSum(kintai.getOvertime().add(kintai.getLateOvertime()));

				} else {
					Shift shift = new Shift();
					shift.setEmpNo(kintai.getEmpNo());
					shift.setKintaiMonth(kintai.getKintaiMonth());
					shift.setShiftNo(kintai.getShiftNo());
					shift = shiftDao.findById(shift);

					if (!StringUtil.isNull(kintai.getKoumokuNo())) {
						kintai.setLateTime(BigDecimal.ZERO);
						kintai.setLeaveEarlyTime(BigDecimal.ZERO);
						kintai.setHours(new BigDecimal(7.75));
						kintai.setOvertime(BigDecimal.ZERO);
						kintai.setLateOvertime(BigDecimal.ZERO);
						return;
					}

					ShiftTable st = shiftTableDao.findById(shift, kintai.getEndTimeRound());
					if (st == null) {
						kintai.setLateTime(null);
						kintai.setLeaveEarlyTime(null);
						kintai.setHours(null);
						kintai.setOvertime(null);
						kintai.setLateOvertime(null);
						return;
					}
					BigDecimal tmp = DateUtil.getDiff(kintai.getStartTimeRound(), shift.getStartTime());
					kintai.setLateTime(BigDecimal.ZERO);
					if (tmp.compareTo(BigDecimal.ZERO) > 0) {
						kintai.setLateTime(tmp);
					}
					tmp = DateUtil.getDiff(shift.getEndTime(), kintai.getEndTimeRound());
					kintai.setLeaveEarlyTime(BigDecimal.ZERO);
					if (tmp.compareTo(BigDecimal.ZERO) > 0) {
						kintai.setLeaveEarlyTime(tmp);
					}
					kintai.setHoursSum(st.getHours().subtract(kintai.getLateTime()).subtract(kintai.getLeaveEarlyTime()));
					kintai.setHours(new BigDecimal(7.75));
					kintai.setOvertime(st.getOver());
					kintai.setLateOvertime(st.getLateOver());
				}
			}
		} catch (Exception e) {
			kintai.setLateTime(null);
			kintai.setLeaveEarlyTime(null);
			kintai.setHours(null);
			kintai.setOvertime(null);
			kintai.setLateOvertime(null);
		}
	}

	@Override
	public void saveMgr(KintaiMgrSaveForm kintaiMgrSaveForm) {
		KintaiMgr kintaiMgr = new KintaiMgr();
		kintaiMgr.setEmpNo(kintaiMgrSaveForm.getEmpNo());
		kintaiMgr.setKintaiMonth(kintaiMgrSaveForm.getKintaiMonth());
		kintaiMgr.setNo(kintaiMgrSaveForm.getNo());
		kintaiMgr = kintaiMgrDao.findById(kintaiMgr);
		if (kintaiMgr == null) {
			kintaiMgr = new KintaiMgr();
			kintaiMgr.setEmpNo(kintaiMgrSaveForm.getEmpNo());
			kintaiMgr.setKintaiMonth(kintaiMgrSaveForm.getKintaiMonth());
			kintaiMgr.setNo(kintaiMgrSaveForm.getNo());
		}
		if (kintaiMgrSaveForm.getMgrNo() != null) {
			kintaiMgr.setMgrNo(kintaiMgrSaveForm.getMgrNo());
		}
		if (kintaiMgrSaveForm.getDateFrom() != null) {
			kintaiMgr.setDateFrom(kintaiMgrSaveForm.getDateFrom());
		}
		if (kintaiMgrSaveForm.getDateTo() != null ) {
			kintaiMgr.setDateTo(kintaiMgrSaveForm.getDateTo());
		}
		kintaiMgrDao.saveOrUpdate(kintaiMgr);
	}

	@Override
	public JqGridForm searchMgr(KintaiMgrSearchForm kintaiMgrSearchForm) {
		String[] nm = StringUtil.NameSprit(kintaiMgrSearchForm.getEmpName());
		String[] nmKana = StringUtil.NameSprit(kintaiMgrSearchForm.getEmpNameFuriKana());
		List<Emp> empList = empDao.aimaiSearch(kintaiMgrSearchForm.getEmpNo()
									, nm[0], nm[1]
									, nmKana[0], nmKana[1]
									,kintaiMgrSearchForm.getEmail()
									,kintaiMgrSearchForm.getTel());

		JqGridForm jqGridForm = new JqGridForm();

		for (Emp emp : empList) {
			KintaiMgrSearchGrid row = new KintaiMgrSearchGrid();
			row.setEmpNo(emp.getEmpNo());
			row.setEmpName(emp.getEmpNameLast() + " " + emp.getEmpNameFirst());
			Office office = emp.getOffice();
			if (office != null) {
				row.setOfficeName(office.getOfficeName());
			}
			row.setDeptName(emp.getDept().getDeptName());
			jqGridForm.getRows().add(row);
		}
		jqGridForm.setTotal(1);
		jqGridForm.setPage(1);
		jqGridForm.setRecords(jqGridForm.getRows().size());
		return jqGridForm;
	}

	@Override
	public void copyKintai(KintaiCopyForm kintaiCopyForm) {
		Kintai org = kintaiDao.findById(kintaiCopyForm.getEmpNo(), kintaiCopyForm.getOrgKintaiDate());
		if (org == null) {
			return;
		}
		KintaiGridSaveForm kintaiGridSaveForm = new KintaiGridSaveForm();
		kintaiGridSaveForm.setEmpNo(kintaiCopyForm.getEmpNo());
		kintaiGridSaveForm.setKintaiDate(kintaiCopyForm.getDstKintaiDate());
		kintaiGridSaveForm.setShiftNo(StringUtil.nullToString(org.getShiftNo()));
		kintaiGridSaveForm.setStartTime(StringUtil.nullToString(org.getStartTime()));
		kintaiGridSaveForm.setEndTime(StringUtil.nullToString(org.getEndTime()));
		kintaiGridSaveForm.setTokkiJiko(StringUtil.nullToString(org.getTokkiJiko()));
		kintaiGridSaveForm.setKoumokuNo(StringUtil.nullToString(org.getKoumokuNo()));
		kintaiGridSaveForm.setKyukaMisyutokuSinsei2(StringUtil.nullToString(org.getKyukaMisyutokuSinsei2()));
		kintaiGridSaveForm.setKyukaMisyutokuSinsei3(StringUtil.nullToString(org.getKyukaMisyutokuSinsei3()));
		kintaiGridSaveForm.setKyukaMisyutokuSinsei4(StringUtil.nullToString(org.getKyukaMisyutokuSinsei4()));
		kintaiGridSaveForm.setKyukaMisyutokuSinsei5(StringUtil.nullToString(org.getKyukaMisyutokuSinsei5()));
		kintaiGridSaveForm.setKyukaMisyutokuSinsei6(StringUtil.nullToString(org.getKyukaMisyutokuSinsei6()));
		kintaiGridSaveForm.setProjectNo(StringUtil.nullToString(org.getProjectNo()));
		this.saveKintaiGrid(kintaiGridSaveForm);

		kintaiSagyoAnbunDao.delete(kintaiCopyForm.getEmpNo(), kintaiCopyForm.getDstKintaiDate());
		for (KintaiSagyoAnbun anbun : org.getKintaiSagyoAnbun()) {
			KintaiSagyoAnbun dstS = new KintaiSagyoAnbun();
			dstS.setEmpNo(kintaiCopyForm.getEmpNo());
			dstS.setKintaiDate(kintaiCopyForm.getDstKintaiDate());
			dstS.setSagyoCd(anbun.getSagyoCd());
			dstS.setNormalAnbunRitu(anbun.getNormalAnbunRitu());
			dstS.setOverAnbunRitu(anbun.getOverAnbunRitu());
			dstS.setLateOverAnbunRitu(anbun.getLateOverAnbunRitu());
			kintaiSagyoAnbunDao.saveOrUpdate(dstS);
		}
	}

	@Override
	public void delKintaiShiftGrid(KintaiShiftDelForm kintaiShiftDelForm) {
		Shift shift = new Shift();
		shift.setEmpNo(kintaiShiftDelForm.getEmpNo());
		shift.setKintaiMonth(kintaiShiftDelForm.getKintaiMonth());
		shift.setShiftNo(kintaiShiftDelForm.getShiftNo());
		shift = shiftDao.findById(shift);
		shiftDao.delete(shift);
	}

}
