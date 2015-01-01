package jp.co.ctc_g.presentation.controller.common;

public interface Grid {

	Object get(int row, int column);
	
	void set(int row, int column, Object val);
	
	int columns();
	
	int rows();

}
