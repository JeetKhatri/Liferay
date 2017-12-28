package com.colorSelection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.persistence.PortletUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ColorSelection
 */
public class ColorSelection extends MVCPortlet {
 
	@ProcessAction(name="colorSelection")
	public void colorSelection(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		String str = ParamUtil.getString(request, "name");
		System.out.println(str);
		response.setRenderParameter("jspPage", "/html/colorselection/view.jsp");
		request.setAttribute("color", str);
		response.setPortletMode(PortletMode.VIEW);
	}

}
