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
import com.liferay.sample.service.StudentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class StudentClp extends BaseModelImpl<Student> implements Student {
	public StudentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _sid;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setSid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sid", getSid());
		attributes.put("sname", getSname());
		attributes.put("sgender", getSgender());
		attributes.put("snumber", getSnumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer sid = (Integer)attributes.get("sid");

		if (sid != null) {
			setSid(sid);
		}

		String sname = (String)attributes.get("sname");

		if (sname != null) {
			setSname(sname);
		}

		Integer sgender = (Integer)attributes.get("sgender");

		if (sgender != null) {
			setSgender(sgender);
		}

		String snumber = (String)attributes.get("snumber");

		if (snumber != null) {
			setSnumber(snumber);
		}
	}

	@Override
	public int getSid() {
		return _sid;
	}

	@Override
	public void setSid(int sid) {
		_sid = sid;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setSid", int.class);

				method.invoke(_studentRemoteModel, sid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSname() {
		return _sname;
	}

	@Override
	public void setSname(String sname) {
		_sname = sname;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setSname", String.class);

				method.invoke(_studentRemoteModel, sname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSgender() {
		return _sgender;
	}

	@Override
	public void setSgender(int sgender) {
		_sgender = sgender;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setSgender", int.class);

				method.invoke(_studentRemoteModel, sgender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSnumber() {
		return _snumber;
	}

	@Override
	public void setSnumber(String snumber) {
		_snumber = snumber;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setSnumber", String.class);

				method.invoke(_studentRemoteModel, snumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStudentRemoteModel() {
		return _studentRemoteModel;
	}

	public void setStudentRemoteModel(BaseModel<?> studentRemoteModel) {
		_studentRemoteModel = studentRemoteModel;
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

		Class<?> remoteModelClass = _studentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_studentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentLocalServiceUtil.addStudent(this);
		}
		else {
			StudentLocalServiceUtil.updateStudent(this);
		}
	}

	@Override
	public Student toEscapedModel() {
		return (Student)ProxyUtil.newProxyInstance(Student.class.getClassLoader(),
			new Class[] { Student.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentClp clone = new StudentClp();

		clone.setSid(getSid());
		clone.setSname(getSname());
		clone.setSgender(getSgender());
		clone.setSnumber(getSnumber());

		return clone;
	}

	@Override
	public int compareTo(Student student) {
		int primaryKey = student.getPrimaryKey();

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

		if (!(obj instanceof StudentClp)) {
			return false;
		}

		StudentClp student = (StudentClp)obj;

		int primaryKey = student.getPrimaryKey();

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

		sb.append("{sid=");
		sb.append(getSid());
		sb.append(", sname=");
		sb.append(getSname());
		sb.append(", sgender=");
		sb.append(getSgender());
		sb.append(", snumber=");
		sb.append(getSnumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Student");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sid</column-name><column-value><![CDATA[");
		sb.append(getSid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sname</column-name><column-value><![CDATA[");
		sb.append(getSname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgender</column-name><column-value><![CDATA[");
		sb.append(getSgender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>snumber</column-name><column-value><![CDATA[");
		sb.append(getSnumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _sid;
	private String _sname;
	private int _sgender;
	private String _snumber;
	private BaseModel<?> _studentRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}