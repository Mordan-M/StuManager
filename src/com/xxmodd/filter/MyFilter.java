package com.xxmodd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 类名: MyFilter
 * 描述: 过滤Manager文件加下的任何文件
 * @author xxmodd
 * @data 2017-1-1 t下午2:56:51
 */
public class MyFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
				(HttpServletResponse) servletResponse);
		wrapper.sendRedirect("/StuManager");
		return ;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
	
}
