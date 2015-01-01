package jp.sji.kansai.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 文字コード用フィルター
 *
 * @author teraoka
 * @version 1.0 (2007/01/08)i
 */
public class CharacterEncodeFilter implements javax.servlet.Filter {

	/** FilterConfig */
	private FilterConfig filterConfig;

	/**
	 * 初期処理を行う
	 */
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	/**
	 * サーブレット実行前の文字コード変換を行う
	 *
	 * @param request リクエスト
	 * @param response レスポンス
	 * @param chain フィルターチェイン
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		((HttpServletRequest) request).setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);
	}

	/**
	 * 終了処理を行う
	 */
	public void destroy() {
		this.filterConfig = null;
	}
}