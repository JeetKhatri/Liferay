package com.demo2;

import java.io.IOException;
import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class autoDetectLanguage extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Locale.setDefault(Locale.ENGLISH);
		Locale defaultLocale = Locale.getDefault();
		System.out.println("defaultLocale : " + defaultLocale);

		PortletConfig config = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String msg = LanguageUtil.get(config, defaultLocale, "welcome_message");
		System.out.println(msg);
		renderRequest.setAttribute("msg", msg);

		super.doView(renderRequest, renderResponse);
	}

}
