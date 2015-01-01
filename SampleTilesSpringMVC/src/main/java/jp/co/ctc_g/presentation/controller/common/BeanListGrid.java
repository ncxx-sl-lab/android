package jp.co.ctc_g.presentation.controller.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanWrapperImpl;

public class BeanListGrid implements Grid  {

	private List<Object> beanList;
	private String[] props;
	private BeanWrapperImpl beanWrapper = new BeanWrapperImpl();
	
	public BeanListGrid(List<?> beanList, String... props) {
		this.beanList = new ArrayList<Object>(beanList);
		this.props = props;
	}
	
	@Override
	public Object get(int row, int column) {
		beanWrapper.setWrappedInstance(beanList.get(row));
		return beanWrapper.getPropertyValue(props[column]);
	}

	@Override
	public void set(int row, int column, Object val) {
		beanWrapper.setWrappedInstance(beanList.get(row));
		beanWrapper.setPropertyValue(props[column], val);
	}

	@Override
	public int columns() {
		return props.length;
	}

	@Override
	public int rows() {
		return beanList.size();
	}

}
