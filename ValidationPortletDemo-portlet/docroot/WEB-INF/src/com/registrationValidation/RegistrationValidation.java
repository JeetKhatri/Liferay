package com.registrationValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.apache.catalina.ha.session.SessionMessage;

import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class RegistrationValidation
 */
public class RegistrationValidation extends MVCPortlet {

	@ProcessAction(name = "myActionMethod")
	public void myActionMethod(ActionRequest request, ActionResponse response) throws PortletException, IOException {

		String name = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		String number = ParamUtil.getString(request, "number");
		RegistrationBean obj = new RegistrationBean(name, number, email);
		ArrayList<String> list = validation(obj, request);
		if (list.size()==0) {
			System.out.println("successfully submited");
		} else {
			// next 2 lines for hiding default message
			PortletConfig config = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages.add(request, ((LiferayPortletConfig)config).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			System.out.println("error msg");
			request.setAttribute("bean", obj);
			request.setAttribute("errorList", list);
		}
	}

	public ArrayList<String> validation(RegistrationBean obj, ActionRequest request) {
		ArrayList<String> list = new ArrayList<>();

		ResourceBundle bundle = getPortletConfig().getResourceBundle(request.getLocale());
		
		if (!Validator.isEmailAddress(obj.getEmail())) {
			list.add(bundle.getString("email.errorMsg.missing"));
		}  
		if (!Validator.isName(obj.getName())) {
			list.add(bundle.getString("name.errorMsg.missing"));
		}  
		if (!Validator.isPhoneNumber(obj.getNumber())) {
			list.add(bundle.getString("number.errorMsg.missing"));
		}
		return list;
	}
}
