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
 * This class is a wrapper for {@link StudentAddress}.
 * </p>
 *
 * @author admin
 * @see StudentAddress
 * @generated
 */
public class StudentAddressWrapper implements StudentAddress,
	ModelWrapper<StudentAddress> {
	public StudentAddressWrapper(StudentAddress studentAddress) {
		_studentAddress = studentAddress;
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

	/**
	* Returns the primary key of this student address.
	*
	* @return the primary key of this student address
	*/
	@Override
	public int getPrimaryKey() {
		return _studentAddress.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student address.
	*
	* @param primaryKey the primary key of this student address
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_studentAddress.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address ID of this student address.
	*
	* @return the address ID of this student address
	*/
	@Override
	public int getAddressId() {
		return _studentAddress.getAddressId();
	}

	/**
	* Sets the address ID of this student address.
	*
	* @param addressId the address ID of this student address
	*/
	@Override
	public void setAddressId(int addressId) {
		_studentAddress.setAddressId(addressId);
	}

	/**
	* Returns the city of this student address.
	*
	* @return the city of this student address
	*/
	@Override
	public java.lang.String getCity() {
		return _studentAddress.getCity();
	}

	/**
	* Sets the city of this student address.
	*
	* @param city the city of this student address
	*/
	@Override
	public void setCity(java.lang.String city) {
		_studentAddress.setCity(city);
	}

	/**
	* Returns the country of this student address.
	*
	* @return the country of this student address
	*/
	@Override
	public java.lang.String getCountry() {
		return _studentAddress.getCountry();
	}

	/**
	* Sets the country of this student address.
	*
	* @param country the country of this student address
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_studentAddress.setCountry(country);
	}

	/**
	* Returns the sid of this student address.
	*
	* @return the sid of this student address
	*/
	@Override
	public int getSid() {
		return _studentAddress.getSid();
	}

	/**
	* Sets the sid of this student address.
	*
	* @param sid the sid of this student address
	*/
	@Override
	public void setSid(int sid) {
		_studentAddress.setSid(sid);
	}

	@Override
	public boolean isNew() {
		return _studentAddress.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_studentAddress.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _studentAddress.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_studentAddress.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _studentAddress.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _studentAddress.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_studentAddress.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _studentAddress.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_studentAddress.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_studentAddress.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_studentAddress.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentAddressWrapper((StudentAddress)_studentAddress.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.StudentAddress studentAddress) {
		return _studentAddress.compareTo(studentAddress);
	}

	@Override
	public int hashCode() {
		return _studentAddress.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.StudentAddress> toCacheModel() {
		return _studentAddress.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.StudentAddress toEscapedModel() {
		return new StudentAddressWrapper(_studentAddress.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.StudentAddress toUnescapedModel() {
		return new StudentAddressWrapper(_studentAddress.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _studentAddress.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _studentAddress.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_studentAddress.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentAddressWrapper)) {
			return false;
		}

		StudentAddressWrapper studentAddressWrapper = (StudentAddressWrapper)obj;

		if (Validator.equals(_studentAddress,
					studentAddressWrapper._studentAddress)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StudentAddress getWrappedStudentAddress() {
		return _studentAddress;
	}

	@Override
	public StudentAddress getWrappedModel() {
		return _studentAddress;
	}

	@Override
	public void resetOriginalValues() {
		_studentAddress.resetOriginalValues();
	}

	private StudentAddress _studentAddress;
}