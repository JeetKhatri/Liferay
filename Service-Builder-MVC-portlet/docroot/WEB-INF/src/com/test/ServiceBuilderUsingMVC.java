package com.test;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.sample.model.Employee;
import com.liferay.sample.model.impl.EmployeeImpl;
import com.liferay.sample.service.EmployeeLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class ServiceBuilderUsingMVC
 */
public class ServiceBuilderUsingMVC extends MVCPortlet {
 
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		Employee obj =new EmployeeImpl();
    	obj.setEid(1);
    	obj.setEname("darshil");
    	obj.setEcountry("US");
    	try {
			EmployeeLocalServiceUtil.addEmployee(obj);
			System.out.println(EmployeeLocalServiceUtil.getEmployee(1).getEname());
			System.out.println("Total employee : "+EmployeeLocalServiceUtil.getEmployeesCount());
			System.out.println("Total Indian employee : "+EmployeeLocalServiceUtil.findByEcountry("india").size());
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		super.doView(renderRequest, renderResponse);
	}

}
