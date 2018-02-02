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

package com.liferay.sample.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.sample.model.Employee;

import java.util.List;

/**
 * The persistence utility for the employee service. This utility wraps {@link EmployeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author admin
 * @see EmployeePersistence
 * @see EmployeePersistenceImpl
 * @generated
 */
public class EmployeeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Employee employee) {
		getPersistence().clearCache(employee);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Employee> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Employee update(Employee employee) throws SystemException {
		return getPersistence().update(employee);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Employee update(Employee employee,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(employee, serviceContext);
	}

	/**
	* Returns all the employees where ecountry = &#63;.
	*
	* @param ecountry the ecountry
	* @return the matching employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Employee> findByEcountry(
		java.lang.String ecountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEcountry(ecountry);
	}

	/**
	* Returns a range of all the employees where ecountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ecountry the ecountry
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of matching employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Employee> findByEcountry(
		java.lang.String ecountry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEcountry(ecountry, start, end);
	}

	/**
	* Returns an ordered range of all the employees where ecountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ecountry the ecountry
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Employee> findByEcountry(
		java.lang.String ecountry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEcountry(ecountry, start, end, orderByComparator);
	}

	/**
	* Returns the first employee in the ordered set where ecountry = &#63;.
	*
	* @param ecountry the ecountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws com.liferay.sample.NoSuchEmployeeException if a matching employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee findByEcountry_First(
		java.lang.String ecountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEmployeeException {
		return getPersistence().findByEcountry_First(ecountry, orderByComparator);
	}

	/**
	* Returns the first employee in the ordered set where ecountry = &#63;.
	*
	* @param ecountry the ecountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee fetchByEcountry_First(
		java.lang.String ecountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEcountry_First(ecountry, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where ecountry = &#63;.
	*
	* @param ecountry the ecountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws com.liferay.sample.NoSuchEmployeeException if a matching employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee findByEcountry_Last(
		java.lang.String ecountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEmployeeException {
		return getPersistence().findByEcountry_Last(ecountry, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where ecountry = &#63;.
	*
	* @param ecountry the ecountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee fetchByEcountry_Last(
		java.lang.String ecountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEcountry_Last(ecountry, orderByComparator);
	}

	/**
	* Returns the employees before and after the current employee in the ordered set where ecountry = &#63;.
	*
	* @param eid the primary key of the current employee
	* @param ecountry the ecountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee
	* @throws com.liferay.sample.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee[] findByEcountry_PrevAndNext(
		int eid, java.lang.String ecountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEmployeeException {
		return getPersistence()
				   .findByEcountry_PrevAndNext(eid, ecountry, orderByComparator);
	}

	/**
	* Removes all the employees where ecountry = &#63; from the database.
	*
	* @param ecountry the ecountry
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEcountry(java.lang.String ecountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEcountry(ecountry);
	}

	/**
	* Returns the number of employees where ecountry = &#63;.
	*
	* @param ecountry the ecountry
	* @return the number of matching employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEcountry(java.lang.String ecountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEcountry(ecountry);
	}

	/**
	* Caches the employee in the entity cache if it is enabled.
	*
	* @param employee the employee
	*/
	public static void cacheResult(com.liferay.sample.model.Employee employee) {
		getPersistence().cacheResult(employee);
	}

	/**
	* Caches the employees in the entity cache if it is enabled.
	*
	* @param employees the employees
	*/
	public static void cacheResult(
		java.util.List<com.liferay.sample.model.Employee> employees) {
		getPersistence().cacheResult(employees);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param eid the primary key for the new employee
	* @return the new employee
	*/
	public static com.liferay.sample.model.Employee create(int eid) {
		return getPersistence().create(eid);
	}

	/**
	* Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eid the primary key of the employee
	* @return the employee that was removed
	* @throws com.liferay.sample.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee remove(int eid)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEmployeeException {
		return getPersistence().remove(eid);
	}

	public static com.liferay.sample.model.Employee updateImpl(
		com.liferay.sample.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(employee);
	}

	/**
	* Returns the employee with the primary key or throws a {@link com.liferay.sample.NoSuchEmployeeException} if it could not be found.
	*
	* @param eid the primary key of the employee
	* @return the employee
	* @throws com.liferay.sample.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee findByPrimaryKey(int eid)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEmployeeException {
		return getPersistence().findByPrimaryKey(eid);
	}

	/**
	* Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eid the primary key of the employee
	* @return the employee, or <code>null</code> if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Employee fetchByPrimaryKey(int eid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eid);
	}

	/**
	* Returns all the employees.
	*
	* @return the employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Employee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmployeePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmployeePersistence)PortletBeanLocatorUtil.locate(com.liferay.sample.service.ClpSerializer.getServletContextName(),
					EmployeePersistence.class.getName());

			ReferenceRegistry.registerReference(EmployeeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmployeePersistence persistence) {
	}

	private static EmployeePersistence _persistence;
}