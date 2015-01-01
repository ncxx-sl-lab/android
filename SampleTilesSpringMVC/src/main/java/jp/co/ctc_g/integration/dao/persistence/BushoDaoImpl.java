package jp.co.ctc_g.integration.dao.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jp.co.ctc_g.business.dao.BushoDao;
import jp.co.ctc_g.business.domain.CmbBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BushoDaoImpl extends JdbcDaoSupport implements BushoDao {

	@Autowired
	BushoDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public List<CmbBox> findBushoCmb() {

		RowMapper<CmbBox> cmbBoxMapper = new CmbBoxRowMapper();

		StringBuffer sql = new StringBuffer();
        sql.append(" select");
        sql.append(" BUSHO_CODE,");
        sql.append(" BUSHO_NAME");
        sql.append(" from");
        sql.append(" BUSHO_MST");
        sql.append(" order by BUSHO_CODE");

        JdbcTemplate jt = new JdbcTemplate(getDataSource());
		return jt.query(sql.toString(), cmbBoxMapper);

	}

	protected class CmbBoxRowMapper implements RowMapper<CmbBox> {

		public CmbBox mapRow(ResultSet rset, int row) throws SQLException {
			CmbBox cmbBox = new CmbBox();
			cmbBox.setValue(rset.getString("BUSHO_CODE"));
			cmbBox.setLabel(rset.getString("BUSHO_NAME"));
			return cmbBox;
		}
	}


}
