// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
public class Authority implements GrantedAuthority {

	/** 権限 */
	private String authority;

	/**
	 * @return authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority セットする authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
