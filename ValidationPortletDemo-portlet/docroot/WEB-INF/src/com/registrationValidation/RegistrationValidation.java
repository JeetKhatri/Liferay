package com.registrationValidation;

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
		if (validation(obj, request)) {
			System.out.println("successfully submited");
		} else {
			// next 2 lines for hiding default message
			PortletConfig config = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages.add(request, ((LiferayPortletConfig)config).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			System.out.println("error msg");
			request.setAttribute("bean", obj);
		}
	}

	public boolean validation(RegistrationBean obj, ActionRequest request) {
		boolean flag = true;
		if (!Validator.isEmailAddress(obj.getEmail())) {
			SessionErrors.add(request, "email.errorMsg.missing");
			flag = false;
		}  
		if (!Validator.isName(obj.getName())) {
			SessionErrors.add(request, "name.errorMsg.missing");
			flag = false;
		}  
		if (!Validator.isPhoneNumber(obj.getNumber())) {
			SessionErrors.add(request, "number.errorMsg.missing");
			flag = false;
		}
		return flag;
	}
}
