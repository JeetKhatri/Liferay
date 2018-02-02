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
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author admin
 * @see Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
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

	/**
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	@Override
	public int getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eid of this employee.
	*
	* @return the eid of this employee
	*/
	@Override
	public int getEid() {
		return _employee.getEid();
	}

	/**
	* Sets the eid of this employee.
	*
	* @param eid the eid of this employee
	*/
	@Override
	public void setEid(int eid) {
		_employee.setEid(eid);
	}

	/**
	* Returns the ename of this employee.
	*
	* @return the ename of this employee
	*/
	@Override
	public java.lang.String getEname() {
		return _employee.getEname();
	}

	/**
	* Sets the ename of this employee.
	*
	* @param ename the ename of this employee
	*/
	@Override
	public void setEname(java.lang.String ename) {
		_employee.setEname(ename);
	}

	/**
	* Returns the ecountry of this employee.
	*
	* @return the ecountry of this employee
	*/
	@Override
	public java.lang.String getEcountry() {
		return _employee.getEcountry();
	}

	/**
	* Sets the ecountry of this employee.
	*
	* @param ecountry the ecountry of this employee
	*/
	@Override
	public void setEcountry(java.lang.String ecountry) {
		_employee.setEcountry(ecountry);
	}

	@Override
	public boolean isNew() {
		return _employee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Employee toUnescapedModel() {
		return new EmployeeWrapper(_employee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeWrapper)) {
			return false;
		}

		EmployeeWrapper employeeWrapper = (EmployeeWrapper)obj;

		if (Validator.equals(_employee, employeeWrapper._employee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Employee getWrappedEmployee() {
		return _employee;
	}

	@Override
	public Employee getWrappedModel() {
		return _employee;
	}

	@Override
	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private Employee _employee;
}