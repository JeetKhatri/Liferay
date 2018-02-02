/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.sample.service.ClpSerializer;
import com.liferay.sample.service.EmployeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class EmployeeClp extends BaseModelImpl<Employee> implements Employee {
	public EmployeeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _eid;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setEid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eid", getEid());
		attributes.put("ename", getEname());
		attributes.put("ecountry", getEcountry());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer eid = (Integer)attributes.get("eid");

		if (eid != null) {
			setEid(eid);
		}

		String ename = (String)attributes.get("ename");

		if (ename != null) {
			setEname(ename);
		}

		String ecountry = (String)attributes.get("ecountry");

		if (ecountry != null) {
			setEcountry(ecountry);
		}
	}

	@Override
	public int getEid() {
		return _eid;
	}

	@Override
	public void setEid(int eid) {
		_eid = eid;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setEid", int.class);

				method.invoke(_employeeRemoteModel, eid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEname() {
		return _ename;
	}

	@Override
	public void setEname(String ename) {
		_ename = ename;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setEname", String.class);

				method.invoke(_employeeRemoteModel, ename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEcountry() {
		return _ecountry;
	}

	@Override
	public void setEcountry(String ecountry) {
		_ecountry = ecountry;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setEcountry", String.class);

				method.invoke(_employeeRemoteModel, ecountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmployeeRemoteModel() {
		return _employeeRemoteModel;
	}

	public void setEmployeeRemoteModel(BaseModel<?> employeeRemoteModel) {
		_employeeRemoteModel = employeeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _employeeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_employeeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmployeeLocalServiceUtil.addEmployee(this);
		}
		else {
			EmployeeLocalServiceUtil.updateEmployee(this);
		}
	}

	@Override
	public Employee toEscapedModel() {
		return (Employee)ProxyUtil.newProxyInstance(Employee.class.getClassLoader(),
			new Class[] { Employee.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmployeeClp clone = new EmployeeClp();

		clone.setEid(getEid());
		clone.setEname(getEname());
		clone.setEcountry(getEcountry());

		return clone;
	}

	@Override
	public int compareTo(Employee employee) {
		int primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeClp)) {
			return false;
		}

		EmployeeClp employee = (EmployeeClp)obj;

		int primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{eid=");
		sb.append(getEid());
		sb.append(", ename=");
		sb.append(getEname());
		sb.append(", ecountry=");
		sb.append(getEcountry());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Employee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eid</column-name><column-value><![CDATA[");
		sb.append(getEid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ename</column-name><column-value><![CDATA[");
		sb.append(getEname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ecountry</column-name><column-value><![CDATA[");
		sb.append(getEcountry());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _eid;
	private String _ename;
	private String _ecountry;
	private BaseModel<?> _employeeRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}