package jp.sji_inc.db.entity.base;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="EMP")
public class Emp implements Serializable,UserDetails {

	/** 社員番号 */
	@Id
	@Column(name = "EMP_NO", length = 5)
	private String empNo;

	/** 社員名（姓）*/
	@Column(name = "EMP_NAME_LAST", length = 10)
	private String empNameLast;

	/** 社員名（名）*/
	@Column(name = "EMP_NAME_FIRST", length = 10)
	private String empNameFirst;

	/** 社員名（姓 ふりがな）*/
	@Column(name = "EMP_NAME_LAST_FURI_KANA", length = 20)
	private String empNameLastFuriKana;

	/** 社員名（姓 ふりがな）*/
	@Column(name = "EMP_NAME_FIRST_FURI_KANA", length = 20)
	private String empNameFirstFuriKana;

	/** パスワード */
	@Column(name = "PASSWORD")
	private String password;

	/** 部署番号 */
	@Column(name = "DEPT_NO")
	private String deptNo;

	/** オフィス番号 */
	@Column(name = "OFFICE_NO", length = 3)
	private String officeNo;

	/** メール */
	@Column(name = "EMAIL")
	private String email;

	/** 電話番号 */
	@Column(name = "TEL")
	private String tel;

	/** 有効フラグ */
	@Column(name = "ENABLED")
	private boolean enabled;

	/** 保有権限 */
	@OneToMany(fetch=FetchType.EAGER, targetEntity=EmpAuth.class)
	@JoinColumn(name = "EMP_NO", referencedColumnName="EMP_NO")
	private Collection<GrantedAuthority> authorities;

	/** パスワード有効期限切れ可否 */
	@Column(name = "ACCOUNT_NON_EXPIRED")
	private boolean accountNonExpired = true;

	/** ユーザロック可否 */
	@Column(name = "ACCOUNT_NON_LOCKED")
	private boolean accountNonLocked = true;

	/** 資格可否 */
	@Column(name = "CREDENTIALS_NON_EXPIRED")
	private boolean credentialsNonExpired = true;

	/** 部署 */
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="DEPT_NO", referencedColumnName="DEPT_NO", insertable=false, updatable=false)
	private Dept dept;

	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="OFFICE_NO", referencedColumnName="OFFICE_NO", insertable=false, updatable=false)
	private Office office;

	/**
	 * @return empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo セットする empNo
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return empNameLast
	 */
	public String getEmpNameLast() {
		return empNameLast;
	}

	/**
	 * @param empNameLast セットする empNameLast
	 */
	public void setEmpNameLast(String empNameLast) {
		this.empNameLast = empNameLast;
	}

	/**
	 * @return empNameFirst
	 */
	public String getEmpNameFirst() {
		return empNameFirst;
	}

	/**
	 * @param empNameFirst セットする empNameFirst
	 */
	public void setEmpNameFirst(String empNameFirst) {
		this.empNameFirst = empNameFirst;
	}

	/**
	 * @return empNameLastFuriKana
	 */
	public String getEmpNameLastFuriKana() {
		return empNameLastFuriKana;
	}

	/**
	 * @param empNameLastFuriKana セットする empNameLastFuriKana
	 */
	public void setEmpNameLastFuriKana(String empNameLastFuriKana) {
		this.empNameLastFuriKana = empNameLastFuriKana;
	}

	/**
	 * @return empNameFirstFuriKana
	 */
	public String getEmpNameFirstFuriKana() {
		return empNameFirstFuriKana;
	}

	/**
	 * @param empNameFirstFuriKana セットする empNameFirstFuriKana
	 */
	public void setEmpNameFirstFuriKana(String empNameFirstFuriKana) {
		this.empNameFirstFuriKana = empNameFirstFuriKana;
	}

	/**
	 * @param accountNonExpired セットする accountNonExpired
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked セットする accountNonLocked
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired セットする credentialsNonExpired
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @return deptNo
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * @param deptNo セットする deptNo
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled セットする enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return authorities
	 */
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities セットする authorities
	 */
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return this.empNo;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	/**
	 * @return dept
	 */
	public Dept getDept() {
		return dept;
	}

	/**
	 * @param dept セットする dept
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel セットする tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return officeNo
	 */
	public String getOfficeNo() {
		return officeNo;
	}

	/**
	 * @param officeNo セットする officeNo
	 */
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	/**
	 * @return office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office セットする office
	 */
	public void setOffice(Office office) {
		this.office = office;
	}


}
