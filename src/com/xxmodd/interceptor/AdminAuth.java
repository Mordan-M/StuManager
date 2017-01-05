package com.xxmodd.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 类名: AdminAuth
 * 描述: 管理员权限认证
 * @author xxmodd
 * @data 2016-12-27 t下午5:04:50
 */
public class AdminAuth extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		
		if(session.get("admin")==null){
			return "login";
		}
		//System.out.println(session.get("admin"));
		return invocation.invoke();
	}
}
