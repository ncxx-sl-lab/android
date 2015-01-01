/**
 *
 */
package jp.sji_inc.db.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author z1j7663
 *
 */
@Entity
@Table(name = "TEST_CHILD")
public class TestChild implements Serializable {

	@Id
	@Column(name = "C_ID1")
	private Integer cId1;

	@Id
	@Column(name = "C_ID2")
	private Integer cId2;

	@Column(name = "NAME")
	private String name;

	/**
	 * @return cId1
	 */
	public Integer getcId1() {
		return cId1;
	}

	/**
	 * @param cId1 セットする cId1
	 */
	public void setcId1(Integer cId1) {
		this.cId1 = cId1;
	}

	/**
	 * @return cId2
	 */
	public Integer getcId2() {
		return cId2;
	}

	/**
	 * @param cId2 セットする cId2
	 */
	public void setcId2(Integer cId2) {
		this.cId2 = cId2;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
