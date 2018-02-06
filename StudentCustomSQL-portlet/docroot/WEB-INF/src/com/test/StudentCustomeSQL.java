package com.test;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.sample.model.Student;
import com.liferay.sample.model.StudentAddress;
import com.liferay.sample.model.impl.StudentAddressImpl;
import com.liferay.sample.model.impl.StudentImpl;
import com.liferay.sample.service.StudentAddressLocalServiceUtil;
import com.liferay.sample.service.StudentLocalServiceUtil;
import com.liferay.sample.service.impl.StudentLocalServiceImpl;
import com.liferay.sample.service.persistence.StudentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class StudentCustomeSQL extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		
	/*	Student stu = new StudentImpl();
		stu.setSid(1);
		stu.setSname("Mansi");
		stu.setSnumber("888546555");
		stu.setSgender(2);								1 for male 2 for woman
		try {
			StudentLocalServiceUtil.addStudent(stu);
			System.out.println("Id : "+stu.getSid());
			StudentAddress sa = new StudentAddressImpl();
			sa.setAddressId(1);
			sa.setCity("Ahmedabad");
			sa.setCountry("india");
			sa.setSid(stu.getSid());
			StudentAddressLocalServiceUtil.addStudentAddress(sa);
		} catch (SystemException e) {
			e.printStackTrace();
		}*/
		
		List<Object[]> data = StudentLocalServiceUtil.getDetailsByCountryName("india");
		for (Object[] objects : data) {
			int studentId = (int)objects[0];
			String name = (String)objects[1];
			int gender= (int)objects[2];
			String phone = (String)objects[3];
			String city = (String)objects[5];
			String country = (String)objects[6];
			System.out.println("sid=>"+studentId+"  Name=>"+name+"   Phone=>"+phone+"   Gender=>"+gender+"    City=>"+city+"   Country=>"+country);
		}
		
		/*try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(StudentAddress.class, "sa",
					PortletClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("sa.country", "india"))
					.add(PropertyFactoryUtil.forName("sid").in(DynamicQueryFactoryUtil.forClass(Student.class, "st",
							PortletClassLoaderUtil.getClassLoader())));
			dynamicQuery.setProjection(PropertyFactoryUtil.forName("sa.country"));
			List<Object[]> otherCountryEmpList = StudentLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println(" Country's employee : " + otherCountryEmpList.size() + "\nDetails:-");
		} catch (SystemException e) {
			e.printStackTrace();
		}*/
		
		
		super.doView(renderRequest, renderResponse);
	}

}
