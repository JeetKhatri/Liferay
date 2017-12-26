package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FirstMVCDemo
 */
public class FirstMVCDemo extends MVCPortlet {

	@ProcessAction(name = "myActionMethod")
	public void myActionMethod(ActionRequest request, ActionResponse response) throws PortletException, IOException {

		//String name = request.getParameter("name");
		//                 OR
		String name = ParamUtil.getString(request, "name");
		response.setRenderParameter("jspPage", "/html/firstmvcdemo/greeting.jsp");
		//PortalUtil.copyRequestParameters(request, response);
		//                 OR
		response.setRenderParameter("name", name);
		System.out.println("name : "+name);
	}
}
