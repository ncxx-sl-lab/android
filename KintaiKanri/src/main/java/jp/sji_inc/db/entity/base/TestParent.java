/**
 *
 */
package jp.sji_inc.db.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author z1j7663
 *
 */
@Entity
@Table(name="TEST_PARENT")
public class TestParent implements Serializable {

	@Id
	@Column(name = "P_ID")
	private Integer pId;

	@Column(name = "C_ID1")
	private Integer cId1;

	@Column(name = "C_ID2")
	private Integer cId2;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="C_ID1", referencedColumnName="C_ID1", insertable=false, updatable=false),
		@JoinColumn(name="C_ID2", referencedColumnName="C_ID2", insertable=false, updatable=false)
	})
	private TestChild testChild = new TestChild();

	/**
	 * @return pId
	 */
	public Integer getpId() {
		return pId;
	}

	/**
	 * @param pId セットする pId
	 */
	public void setpId(Integer pId) {
		this.pId = pId;
	}

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
	 * @return testChild
	 */
	public TestChild getTestChild() {
		return testChild;
	}

	/**
	 * @param testChild セットする testChild
	 */
	public void setTestChild(TestChild testChild) {
		this.testChild = testChild;
	}

}
