/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.util.List;

import jp.sji_inc.db.dao.KintaiSagyoAnbunDao;
import jp.sji_inc.db.entity.base.KintaiSagyoAnbun;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class KintaiSagyoAnbunDaoImpl implements KintaiSagyoAnbunDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(KintaiSagyoAnbunDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public KintaiSagyoAnbun findById(KintaiSagyoAnbun kintaiSagyoAnbun) {
		return (KintaiSagyoAnbun)sessionFactory.getCurrentSession().get(KintaiSagyoAnbun.class, kintaiSagyoAnbun);
	}

	@Override
	public KintaiSagyoAnbun save(KintaiSagyoAnbun kintaiSagyoAnbun) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void saveOrUpdate(KintaiSagyoAnbun kintaiSagyoAnbun) {
		sessionFactory.getCurrentSession().saveOrUpdate(kintaiSagyoAnbun);
	}

	@Override
	public void delete(KintaiSagyoAnbun kintaiSagyoAnbun) {
		sessionFactory.getCurrentSession().delete(kintaiSagyoAnbun);
	}

	@Override
	public void delete(List<KintaiSagyoAnbun> kintaiSagyoAnbunList) {
		for (KintaiSagyoAnbun l : kintaiSagyoAnbunList) {
			this.delete(l);
		}
	}

	@Override
	public void delete(String empNo, String kintaiDate) {
		int num = sessionFactory.getCurrentSession()
			.createQuery("delete from KintaiSagyoAnbun where empNo=:empNo and kintaiDate=:kintaiDate")
			.setString("empNo", empNo)
			.setString("kintaiDate", kintaiDate)
			.executeUpdate();
	}
}
