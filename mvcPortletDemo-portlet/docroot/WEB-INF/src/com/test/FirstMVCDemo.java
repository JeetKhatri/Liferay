package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FirstMVCDemo
 */
public class FirstMVCDemo extends MVCPortlet {

	@ProcessAction(name = "myActionMethod")
	public void myActionMethod(ActionRequest request, ActionResponse response) throws PortletException, IOException {

		String name = request.getParameter("name");
		String name1 = ParamUtil.getString(request, "name");
		System.out.println(name + " || " + name1);
	}
}
