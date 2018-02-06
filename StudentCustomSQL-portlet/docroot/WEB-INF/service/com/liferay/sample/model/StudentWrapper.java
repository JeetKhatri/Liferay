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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author admin
 * @see Student
 * @generated
 */
public class StudentWrapper implements Student, ModelWrapper<Student> {
	public StudentWrapper(Student student) {
		_student = student;
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

	/**
	* Returns the primary key of this student.
	*
	* @return the primary key of this student
	*/
	@Override
	public int getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student.
	*
	* @param primaryKey the primary key of this student
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_student.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sid of this student.
	*
	* @return the sid of this student
	*/
	@Override
	public int getSid() {
		return _student.getSid();
	}

	/**
	* Sets the sid of this student.
	*
	* @param sid the sid of this student
	*/
	@Override
	public void setSid(int sid) {
		_student.setSid(sid);
	}

	/**
	* Returns the sname of this student.
	*
	* @return the sname of this student
	*/
	@Override
	public java.lang.String getSname() {
		return _student.getSname();
	}

	/**
	* Sets the sname of this student.
	*
	* @param sname the sname of this student
	*/
	@Override
	public void setSname(java.lang.String sname) {
		_student.setSname(sname);
	}

	/**
	* Returns the sgender of this student.
	*
	* @return the sgender of this student
	*/
	@Override
	public int getSgender() {
		return _student.getSgender();
	}

	/**
	* Sets the sgender of this student.
	*
	* @param sgender the sgender of this student
	*/
	@Override
	public void setSgender(int sgender) {
		_student.setSgender(sgender);
	}

	/**
	* Returns the snumber of this student.
	*
	* @return the snumber of this student
	*/
	@Override
	public java.lang.String getSnumber() {
		return _student.getSnumber();
	}

	/**
	* Sets the snumber of this student.
	*
	* @param snumber the snumber of this student
	*/
	@Override
	public void setSnumber(java.lang.String snumber) {
		_student.setSnumber(snumber);
	}

	@Override
	public boolean isNew() {
		return _student.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_student.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_student.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_student.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_student.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentWrapper((Student)_student.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Student student) {
		return _student.compareTo(student);
	}

	@Override
	public int hashCode() {
		return _student.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Student> toCacheModel() {
		return _student.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Student toEscapedModel() {
		return new StudentWrapper(_student.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Student toUnescapedModel() {
		return new StudentWrapper(_student.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _student.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_student.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentWrapper)) {
			return false;
		}

		StudentWrapper studentWrapper = (StudentWrapper)obj;

		if (Validator.equals(_student, studentWrapper._student)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Student getWrappedStudent() {
		return _student;
	}

	@Override
	public Student getWrappedModel() {
		return _student;
	}

	@Override
	public void resetOriginalValues() {
		_student.resetOriginalValues();
	}

	private Student _student;
}