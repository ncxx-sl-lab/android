package jp.sji.kansai.demo.plugin;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 * WEBアプリケーションの初期処理用プラグイン
 *
 * @author teraoka
 */
public class AppPlugIn implements PlugIn {

	private static final long serialVersionUID = 1L;

	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {

		System.out.println("-->AppPlugIn init...");

		try {
			Class.forName("jp.littlesoft.sql4g.Driver");
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	public void destroy() {
		System.out.println("-->AppPlugIn destroy...");
	}
}

