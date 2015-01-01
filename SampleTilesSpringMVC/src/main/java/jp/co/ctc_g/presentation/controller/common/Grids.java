package jp.co.ctc_g.presentation.controller.common;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.domain.DhtmlXGridRow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Grids {

    /**
     * ログ.
     */
    private static final Log LOG = LogFactory.getLog(Grids.class);
 
	private Grids() {}
	
	public static List<Object> toArray(List<?> beanList, String... props) {
		
		List<Object> listRows = new ArrayList<Object>();

		Grid grid = new BeanListGrid(beanList, props);
		for (int row = 0; row < grid.rows(); row++) {
			DhtmlXGridRow beanRow = new DhtmlXGridRow();
			beanRow.setId(String.valueOf(row + 1));
			beanRow.setData(toArray(grid,row));
			listRows.add(beanRow);
		}
		
		return listRows;

	}
	
	public static Object[] toArray(Grid grid,int row) {
		Object[] result = new Object[grid.columns()];
		for (int col = 0; col < grid.columns(); col++) {
			result[col] = grid.get(row, col);
		}	
		
		return result;
	}

}
