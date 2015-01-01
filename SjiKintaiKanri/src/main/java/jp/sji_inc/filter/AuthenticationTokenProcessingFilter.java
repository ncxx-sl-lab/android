package jp.sji_inc.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class AuthenticationTokenProcessingFilter extends AbstractAuthenticationProcessingFilter {

	private static final String DEFAULT_FILTER_PROCESSES_URL = "/api/*";
	
	protected AuthenticationTokenProcessingFilter(){
		super(DEFAULT_FILTER_PROCESSES_URL);
	}
	
	protected AuthenticationTokenProcessingFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
		//System.out.println("attemptAuthentication");
		//Authentication auth = new UsernamePasswordAuthenticationToken(null, null);
		//return auth;
		return null;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
		    FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter");
		chain.doFilter(req, res);
	}
}
