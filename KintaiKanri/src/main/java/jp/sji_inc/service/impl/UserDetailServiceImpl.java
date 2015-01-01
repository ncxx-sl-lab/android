/**
 *
 */
package jp.sji_inc.service.impl;

import jp.sji_inc.db.dao.EmpDao;
import jp.sji_inc.db.entity.base.Emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 認証用に使用
 *
 * @author z1j7663
 * @version 1.0.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	/** 社員マスタDao */
	@Autowired
	private EmpDao empDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Emp emp = empDao.findById(userName);
		if (emp == null) {
			throw new UsernameNotFoundException("ユーザが見つかりません");
		}
		return emp;
	}

}
