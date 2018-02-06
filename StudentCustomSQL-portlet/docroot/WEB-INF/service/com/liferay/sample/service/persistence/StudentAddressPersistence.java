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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.sample.model.StudentAddress;

/**
 * The persistence interface for the student address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author admin
 * @see StudentAddressPersistenceImpl
 * @see StudentAddressUtil
 * @generated
 */
public interface StudentAddressPersistence extends BasePersistence<StudentAddress> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentAddressUtil} to access the student address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the student address in the entity cache if it is enabled.
	*
	* @param studentAddress the student address
	*/
	public void cacheResult(
		com.liferay.sample.model.StudentAddress studentAddress);

	/**
	* Caches the student addresses in the entity cache if it is enabled.
	*
	* @param studentAddresses the student addresses
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.StudentAddress> studentAddresses);

	/**
	* Creates a new student address with the primary key. Does not add the student address to the database.
	*
	* @param addressId the primary key for the new student address
	* @return the new student address
	*/
	public com.liferay.sample.model.StudentAddress create(int addressId);

	/**
	* Removes the student address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the student address
	* @return the student address that was removed
	* @throws com.liferay.sample.NoSuchStudentAddressException if a student address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.StudentAddress remove(int addressId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchStudentAddressException;

	public com.liferay.sample.model.StudentAddress updateImpl(
		com.liferay.sample.model.StudentAddress studentAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student address with the primary key or throws a {@link com.liferay.sample.NoSuchStudentAddressException} if it could not be found.
	*
	* @param addressId the primary key of the student address
	* @return the student address
	* @throws com.liferay.sample.NoSuchStudentAddressException if a student address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.StudentAddress findByPrimaryKey(
		int addressId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchStudentAddressException;

	/**
	* Returns the student address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressId the primary key of the student address
	* @return the student address, or <code>null</code> if a student address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.StudentAddress fetchByPrimaryKey(
		int addressId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the student addresses.
	*
	* @return the student addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.StudentAddress> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the student addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.StudentAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student addresses
	* @param end the upper bound of the range of student addresses (not inclusive)
	* @return the range of student addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.StudentAddress> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the student addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.StudentAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student addresses
	* @param end the upper bound of the range of student addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of student addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.StudentAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the student addresses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of student addresses.
	*
	* @return the number of student addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}