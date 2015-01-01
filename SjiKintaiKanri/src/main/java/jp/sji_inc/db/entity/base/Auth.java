package jp.sji_inc.db.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
*
* @author z1j7663
* @version 1.0.0
*/
@Entity
@Table(name = "AUTH")
public class Auth implements GrantedAuthority {

	/** 権限 */
	@Id
	@Column(name = "AUTHORITY")
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
