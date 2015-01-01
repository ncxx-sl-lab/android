package jp.co.ctc_g.integration.dao.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jp.co.ctc_g.business.dao.GroupDao;
import jp.co.ctc_g.business.domain.CmbBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl extends JdbcDaoSupport implements GroupDao {

	@Autowired
	GroupDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<CmbBox> findGroupCmb() {

		RowMapper<CmbBox> cmbBoxMapper = new CmbBoxRowMapper();

		StringBuffer sql = new StringBuffer();
        sql.append(" select");
        sql.append(" GROUP_CODE,");
        sql.append(" GROUP_NAME");
        sql.append(" from");
        sql.append(" GROUP_MST");
        sql.append(" order by GROUP_CODE");

        JdbcTemplate jt = new JdbcTemplate(getDataSource());
		return jt.query(sql.toString(), cmbBoxMapper);

	}

	protected class CmbBoxRowMapper implements RowMapper<CmbBox> {

		public CmbBox mapRow(ResultSet rset, int row) throws SQLException {
			CmbBox cmbBox = new CmbBox();
			cmbBox.setValue(rset.getString("GROUP_CODE"));
			cmbBox.setLabel(rset.getString("GROUP_NAME"));
			return cmbBox;
		}
	}



}
