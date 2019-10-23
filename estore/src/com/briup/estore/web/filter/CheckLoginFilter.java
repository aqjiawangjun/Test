package com.briup.estore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/user/*")
public class CheckLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("拦截："+((HttpServletRequest)request).getRequestURI());
		HttpServletRequest req = (HttpServletRequest)request;
		if(req.getSession(false)!=null&&req.getSession(false).getAttribute("customer")!=null)
			chain.doFilter(request, response);
		else
		{
			req.getSession().setAttribute("msg", "请先登录");
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
			
		}
			

	@Override
	public void destroy() {
		
	}

}