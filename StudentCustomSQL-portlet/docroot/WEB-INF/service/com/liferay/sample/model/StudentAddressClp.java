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
import com.liferay.sample.service.StudentAddressLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class StudentAddressClp extends BaseModelImpl<StudentAddress>
	implements StudentAddress {
	public StudentAddressClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StudentAddress.class;
	}

	@Override
	public String getModelClassName() {
		return StudentAddress.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _addressId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setAddressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("city", getCity());
		attributes.put("country", getCountry());
		attributes.put("sid", getSid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer addressId = (Integer)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		Integer sid = (Integer)attributes.get("sid");

		if (sid != null) {
			setSid(sid);
		}
	}

	@Override
	public int getAddressId() {
		return _addressId;
	}

	@Override
	public void setAddressId(int addressId) {
		_addressId = addressId;

		if (_studentAddressRemoteModel != null) {
			try {
				Class<?> clazz = _studentAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressId", int.class);

				method.invoke(_studentAddressRemoteModel, addressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_studentAddressRemoteModel != null) {
			try {
				Class<?> clazz = _studentAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_studentAddressRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_studentAddressRemoteModel != null) {
			try {
				Class<?> clazz = _studentAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_studentAddressRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSid() {
		return _sid;
	}

	@Override
	public void setSid(int sid) {
		_sid = sid;

		if (_studentAddressRemoteModel != null) {
			try {
				Class<?> clazz = _studentAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setSid", int.class);

				method.invoke(_studentAddressRemoteModel, sid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStudentAddressRemoteModel() {
		return _studentAddressRemoteModel;
	}

	public void setStudentAddressRemoteModel(
		BaseModel<?> studentAddressRemoteModel) {
		_studentAddressRemoteModel = studentAddressRemoteModel;
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

		Class<?> remoteModelClass = _studentAddressRemoteModel.getClass();

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

		Object returnValue = method.invoke(_studentAddressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentAddressLocalServiceUtil.addStudentAddress(this);
		}
		else {
			StudentAddressLocalServiceUtil.updateStudentAddress(this);
		}
	}

	@Override
	public StudentAddress toEscapedModel() {
		return (StudentAddress)ProxyUtil.newProxyInstance(StudentAddress.class.getClassLoader(),
			new Class[] { StudentAddress.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentAddressClp clone = new StudentAddressClp();

		clone.setAddressId(getAddressId());
		clone.setCity(getCity());
		clone.setCountry(getCountry());
		clone.setSid(getSid());

		return clone;
	}

	@Override
	public int compareTo(StudentAddress studentAddress) {
		int primaryKey = studentAddress.getPrimaryKey();

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

		if (!(obj instanceof StudentAddressClp)) {
			return false;
		}

		StudentAddressClp studentAddress = (StudentAddressClp)obj;

		int primaryKey = studentAddress.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{addressId=");
		sb.append(getAddressId());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", sid=");
		sb.append(getSid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.StudentAddress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sid</column-name><column-value><![CDATA[");
		sb.append(getSid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _addressId;
	private String _city;
	private String _country;
	private int _sid;
	private BaseModel<?> _studentAddressRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}