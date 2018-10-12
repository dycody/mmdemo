package com.wdsite.demo.shiro.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;

public class FormLoginFilter extends PathMatchingFilter {
	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = SecurityUtils.getSubject();
		boolean isAuthenticated = subject.isAuthenticated();
		if (!isAuthenticated) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			resp.getWriter().print("NO AUTH!");
			return false;
		}
		return true;
	}
}
