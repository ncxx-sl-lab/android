// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jp.co.ctc_g.business.dao.SyainDao;
import jp.co.ctc_g.business.domain.Authority;
import jp.co.ctc_g.business.domain.Syain;
import jp.co.ctc_g.business.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
	private SyainDao syainDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<Syain> list = syainDao.findSyainInfoBySyainNo(userName);
		if (list.size() <= 0) {
			throw new UsernameNotFoundException("ユーザが見つかりません");
		}
		Syain s = list.get(0);
		User user = new User();
		user.setUsername(s.getSyainNo());
		user.setDisplayUsername(s.getSyainName());
		user.setPassword(s.getPassword());
		if (s.getDelFlg().equals("0")) {
			user.setEnabled(true);
		} else {
			user.setEnabled(false);
		}

		// TODO とりあえず権限 DBの構造直す
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Authority authority = new Authority();
		authority.setAuthority("ROLE_ADMIN");
		authorities.add(authority);

		authority = new Authority();
		authority.setAuthority("ROLE_LEADER");
		authorities.add(authority);

		authority = new Authority();
		authority.setAuthority("ROLE_STAFF");
		authorities.add(authority);

		user.setAuthorities(authorities);
		return user;

	}

}
