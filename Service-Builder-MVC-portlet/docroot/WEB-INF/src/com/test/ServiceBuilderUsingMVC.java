package com.test;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.sample.model.Employee;
import com.liferay.sample.model.impl.EmployeeImpl;
import com.liferay.sample.service.EmployeeLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

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

		/*Employee obj =new EmployeeImpl();
    	obj.setEid(1);
    	obj.setEname("darshil");
    	obj.setEcountry("US");*/
    	try {
			//EmployeeLocalServiceUtil.addEmployee(obj);
			//System.out.println(EmployeeLocalServiceUtil.getEmployee(1).getEname());
    		
			System.out.println("Total employee : "+EmployeeLocalServiceUtil.getEmployeesCount());
			List<Employee> countryEmpList = EmployeeLocalServiceUtil.findByEcountry("india");
			System.out.println("Total Indian employee : "+countryEmpList.size());
			
			
			//dynamic query - 18
			/*DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Employee.class, "emp", PortletClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.ne("emp.ecountry", "india"));
												//OR
			//dynamicQuery.add(PropertyFactoryUtil.forName("emp.ecountry").ne("india"));
			List<Employee> otherCountryEmpList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery); 
			System.out.println("Other Country's employee : "+otherCountryEmpList.size()+"\nDetails:-");
			for (Employee employee : otherCountryEmpList) {
				System.out.println(employee.getEname()+"\t"+employee.getEcountry());
			}*/
			
			
			// 19  -  projection : use for get specific column data not all column
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Employee.class, "emp", PortletClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.ne("emp.ecountry", "india"));
						// For only 1 column
			//dynamicQuery.setProjection(PropertyFactoryUtil.forName("emp.ename"));
						// More than 1 column
			ProjectionList plist = ProjectionFactoryUtil.projectionList();
			plist.add(PropertyFactoryUtil.forName("emp.ename"));
			plist.add(PropertyFactoryUtil.forName("emp.ecountry"));
			dynamicQuery.setProjection(plist);
			List<Object[]> otherCountryEmpList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery); 
			System.out.println("Other Country's employee : "+otherCountryEmpList.size()+"\nDetails:-");
			for (Object employee[] : otherCountryEmpList) {
				System.out.println(employee[0]+"\t"+employee[1]);
			}
			
			
			/* Order   ::>
			   plist.addOrder(OrderFactoryUtil.desc("emp.eid"));
			*/
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		super.doView(renderRequest, renderResponse);
	}

}
