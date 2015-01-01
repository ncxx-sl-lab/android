/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.sji_inc.common.DateUtil;
import jp.sji_inc.db.dao.ShiftTableDao;
import jp.sji_inc.db.entity.base.Shift;
import jp.sji_inc.db.entity.base.ShiftTable;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class ShiftTableDaoImpl implements ShiftTableDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(ShiftTableDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ShiftTable> findByMonth(String empNo, String kintaiMonth, String shiftNo) {
		List<ShiftTable> l = sessionFactory.getCurrentSession()
			.createCriteria(ShiftTable.class)
			.add(Restrictions.eq("empNo", empNo))
			.add(Restrictions.eq("kintaiMonth", kintaiMonth))
			.add(Restrictions.eq("shiftNo", shiftNo))
			.addOrder(Order.asc("time")).list();
		return l;
	}

	@Override
	public Map<String, ShiftTable> findByMonthMap(String empNo, String kintaiMonth, String shiftNo) {
		List<ShiftTable> l = this.findByMonth(empNo, kintaiMonth, shiftNo);
		Map<String, ShiftTable> m = new HashMap<String, ShiftTable>();
		for (ShiftTable st : l) {
			m.put(DateUtil.parse(st.getTime().doubleValue()), st);
		}
		return m;
	}

	@Override
	public Map<String, ShiftTable> findByMonthMap(Shift shift) {
		return this.findByMonthMap(shift.getEmpNo(), shift.getKintaiMonth(), shift.getShiftNo());
	}

	@Override
	public ShiftTable findById(ShiftTable shiftTable) {
		return (ShiftTable) sessionFactory.getCurrentSession().get(ShiftTable.class, shiftTable);
	}

	@Override
	public ShiftTable findById(ShiftTable shiftTable, String hh_mm) {
		shiftTable.setTime(new BigDecimal(DateUtil.parse(hh_mm)));
		return this.findById(shiftTable);
	}

	@Override
	public ShiftTable findById(Shift shift, String hh_mm) {
		ShiftTable shiftTable = new ShiftTable();
		shiftTable.setEmpNo(shift.getEmpNo());
		shiftTable.setKintaiMonth(shift.getKintaiMonth());
		shiftTable.setShiftNo(shift.getShiftNo());
		return this.findById(shiftTable, hh_mm);
	}

	@Override
	public void saveOrUpdate(ShiftTable shiftTable) {
		sessionFactory.getCurrentSession().saveOrUpdate(shiftTable);
	}

	@Override
	public void saveOrUpdate(Shift shift) {
		Map<String,ShiftTable> st = this.getShiftTableMap(shift);
		for (Map.Entry<String,ShiftTable> me : st.entrySet()) {
			this.saveOrUpdate(me.getValue());
		}
	}

	/**
	 * ｼﾌﾄテーブル取得
	 * @param shift
	 * @return
	 */
	private Map<String,ShiftTable> getShiftTableMap(Shift shift) {
		Map<String,ShiftTable> timeTable = new HashMap<String,ShiftTable>();
		double dLp     = DateUtil.parse(shift.getStartTime());
		double dEnd    = DateUtil.parse(shift.getEndTime());
		double dLateS  = DateUtil.parse("22:00");
		double dLateE  = DateUtil.parse("29:00");
		double dRest1S = DateUtil.parse(shift.getRest1Start());
		double dRest1E = DateUtil.parse(shift.getRest1End());
		double dRest2S = DateUtil.parse(shift.getRest2Start());
		double dRest2E = DateUtil.parse(shift.getRest2End());
		double dRest3S = DateUtil.parse(shift.getRest3Start());
		double dRest3E = DateUtil.parse(shift.getRest3End());
		double dRest4S = DateUtil.parse(shift.getRest4Start());
		double dRest4E = DateUtil.parse(shift.getRest4End());
		double dRest5S = DateUtil.parse(shift.getRest5Start());
		double dRest5E = DateUtil.parse(shift.getRest5End());
		double dRest6S = DateUtil.parse(shift.getRest6Start());
		double dRest6E = DateUtil.parse(shift.getRest6End());
		BigDecimal hours = BigDecimal.ZERO;
		BigDecimal lateOver = BigDecimal.ZERO;
		for (int i = 0; i < 97; i++, dLp+=0.25) {
			ShiftTable shiftTable = new ShiftTable();
			shiftTable.setEmpNo(shift.getEmpNo());
			shiftTable.setKintaiMonth(shift.getKintaiMonth());
			shiftTable.setShiftNo(shift.getShiftNo());
			shiftTable.setHours(hours);
			shiftTable.setTime(new BigDecimal(dLp));
			if (dLp > dEnd) {
				ShiftTable st = timeTable.get(shift.getEndTime());
				shiftTable.setOver(hours.subtract(st.getHours()));
			} else {
				shiftTable.setOver(BigDecimal.ZERO);
			}
			if (dLp > dLateS && dLp <= dLateE) {
				ShiftTable st = timeTable.get("22:00");
				lateOver = shiftTable.getOver().subtract(st.getOver());
			}
			shiftTable.setLateOver(lateOver);
			timeTable.put(DateUtil.parse(dLp), shiftTable);
			hours = hours.add(new BigDecimal(0.25));
			if ((dLp >= dRest1S && dLp < dRest1E)
				|| (dLp >= dRest2S && dLp < dRest2E)
				|| (dLp >= dRest3S && dLp < dRest3E)
				|| (dLp >= dRest4S && dLp < dRest4E)
				|| (dLp >= dRest5S && dLp < dRest5E)
				|| (dLp >= dRest6S && dLp < dRest6E)) {
				hours = hours.subtract(new BigDecimal(0.25));
			}
		}
		return timeTable;
	}

}
