package jp.sji_inc.db.dao;

import java.util.List;

import jp.sji_inc.db.entity.base.Emp;

/**
 *
 * @author z1j7663
 *
 */
public interface EmpDao {

	/**
	 * 全件検索
	 * @return List<Emp>
	 */
	public List<Emp> findAll();

	/**
	 * プライマリー検索
	 * @param empNo 社員番号
	 * @return Emp
	 */
	public Emp findById(String empNo);

	/**
	 * 更新
	 * @param emp 社員エンティティ
	 * @return Emp
	 */
	public void update(Emp emp);

	/**
	 * 保存
	 * @param emp 社員エンティティ
	 */
	public void save(Emp emp);

	/**
	 * 削除
	 * @param emp 社員エンティティ
	 * @return int 削除件数
	 */
	public void delete(Emp emp);

	public List<Emp> aimaiSearch(String empNo,
			String empNameLast,
			String empNameFirst,
			String empNameLastFuriKana,
			String empNameFirstFuriKana,
			String email,
			String tel);

}
