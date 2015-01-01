package jp.co.ctc_g.integration.dao.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jp.co.ctc_g.business.dao.KengenDao;
import jp.co.ctc_g.business.domain.CmbBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class KengenDaoImpl extends JdbcDaoSupport implements KengenDao {

	@Autowired
	KengenDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<CmbBox> findKengenCmb() {

		RowMapper<CmbBox> cmbBoxMapper = new CmbBoxRowMapper();

		StringBuffer sql = new StringBuffer();
        sql.append(" select");
        sql.append(" KENGEN_CODE,");
        sql.append(" KENGEN_NAME");
        sql.append(" from");
        sql.append(" KENGEN_MST");
        sql.append(" order by KENGEN_CODE");

        JdbcTemplate jt = new JdbcTemplate(getDataSource());
		return jt.query(sql.toString(), cmbBoxMapper);

	}

	protected class CmbBoxRowMapper implements RowMapper<CmbBox> {

		public CmbBox mapRow(ResultSet rset, int row) throws SQLException {
			CmbBox cmbBox = new CmbBox();
			cmbBox.setValue(rset.getString("KENGEN_CODE"));
			cmbBox.setLabel(rset.getString("KENGEN_NAME"));
			return cmbBox;
		}
	}

}
