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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.sample.NoSuchStudentAddressException;
import com.liferay.sample.model.StudentAddress;
import com.liferay.sample.model.impl.StudentAddressImpl;
import com.liferay.sample.model.impl.StudentAddressModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the student address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author admin
 * @see StudentAddressPersistence
 * @see StudentAddressUtil
 * @generated
 */
public class StudentAddressPersistenceImpl extends BasePersistenceImpl<StudentAddress>
	implements StudentAddressPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentAddressUtil} to access the student address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentAddressImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
			StudentAddressModelImpl.FINDER_CACHE_ENABLED,
			StudentAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
			StudentAddressModelImpl.FINDER_CACHE_ENABLED,
			StudentAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
			StudentAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StudentAddressPersistenceImpl() {
		setModelClass(StudentAddress.class);
	}

	/**
	 * Caches the student address in the entity cache if it is enabled.
	 *
	 * @param studentAddress the student address
	 */
	@Override
	public void cacheResult(StudentAddress studentAddress) {
		EntityCacheUtil.putResult(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
			StudentAddressImpl.class, studentAddress.getPrimaryKey(),
			studentAddress);

		studentAddress.resetOriginalValues();
	}

	/**
	 * Caches the student addresses in the entity cache if it is enabled.
	 *
	 * @param studentAddresses the student addresses
	 */
	@Override
	public void cacheResult(List<StudentAddress> studentAddresses) {
		for (StudentAddress studentAddress : studentAddresses) {
			if (EntityCacheUtil.getResult(
						StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
						StudentAddressImpl.class, studentAddress.getPrimaryKey()) == null) {
				cacheResult(studentAddress);
			}
			else {
				studentAddress.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student addresses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentAddressImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentAddressImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student address.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentAddress studentAddress) {
		EntityCacheUtil.removeResult(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
			StudentAddressImpl.class, studentAddress.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StudentAddress> studentAddresses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentAddress studentAddress : studentAddresses) {
			EntityCacheUtil.removeResult(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
				StudentAddressImpl.class, studentAddress.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student address with the primary key. Does not add the student address to the database.
	 *
	 * @param addressId the primary key for the new student address
	 * @return the new student address
	 */
	@Override
	public StudentAddress create(int addressId) {
		StudentAddress studentAddress = new StudentAddressImpl();

		studentAddress.setNew(true);
		studentAddress.setPrimaryKey(addressId);

		return studentAddress;
	}

	/**
	 * Removes the student address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the student address
	 * @return the student address that was removed
	 * @throws com.liferay.sample.NoSuchStudentAddressException if a student address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentAddress remove(int addressId)
		throws NoSuchStudentAddressException, SystemException {
		return remove((Serializable)addressId);
	}

	/**
	 * Removes the student address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student address
	 * @return the student address that was removed
	 * @throws com.liferay.sample.NoSuchStudentAddressException if a student address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentAddress remove(Serializable primaryKey)
		throws NoSuchStudentAddressException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StudentAddress studentAddress = (StudentAddress)session.get(StudentAddressImpl.class,
					primaryKey);

			if (studentAddress == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studentAddress);
		}
		catch (NoSuchStudentAddressException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StudentAddress removeImpl(StudentAddress studentAddress)
		throws SystemException {
		studentAddress = toUnwrappedModel(studentAddress);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentAddress)) {
				studentAddress = (StudentAddress)session.get(StudentAddressImpl.class,
						studentAddress.getPrimaryKeyObj());
			}

			if (studentAddress != null) {
				session.delete(studentAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (studentAddress != null) {
			clearCache(studentAddress);
		}

		return studentAddress;
	}

	@Override
	public StudentAddress updateImpl(
		com.liferay.sample.model.StudentAddress studentAddress)
		throws SystemException {
		studentAddress = toUnwrappedModel(studentAddress);

		boolean isNew = studentAddress.isNew();

		Session session = null;

		try {
			session = openSession();

			if (studentAddress.isNew()) {
				session.save(studentAddress);

				studentAddress.setNew(false);
			}
			else {
				session.merge(studentAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
			StudentAddressImpl.class, studentAddress.getPrimaryKey(),
			studentAddress);

		return studentAddress;
	}

	protected StudentAddress toUnwrappedModel(StudentAddress studentAddress) {
		if (studentAddress instanceof StudentAddressImpl) {
			return studentAddress;
		}

		StudentAddressImpl studentAddressImpl = new StudentAddressImpl();

		studentAddressImpl.setNew(studentAddress.isNew());
		studentAddressImpl.setPrimaryKey(studentAddress.getPrimaryKey());

		studentAddressImpl.setAddressId(studentAddress.getAddressId());
		studentAddressImpl.setCity(studentAddress.getCity());
		studentAddressImpl.setCountry(studentAddress.getCountry());
		studentAddressImpl.setSid(studentAddress.getSid());

		return studentAddressImpl;
	}

	/**
	 * Returns the student address with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student address
	 * @return the student address
	 * @throws com.liferay.sample.NoSuchStudentAddressException if a student address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentAddress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentAddressException, SystemException {
		StudentAddress studentAddress = fetchByPrimaryKey(primaryKey);

		if (studentAddress == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return studentAddress;
	}

	/**
	 * Returns the student address with the primary key or throws a {@link com.liferay.sample.NoSuchStudentAddressException} if it could not be found.
	 *
	 * @param addressId the primary key of the student address
	 * @return the student address
	 * @throws com.liferay.sample.NoSuchStudentAddressException if a student address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentAddress findByPrimaryKey(int addressId)
		throws NoSuchStudentAddressException, SystemException {
		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the student address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student address
	 * @return the student address, or <code>null</code> if a student address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentAddress fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StudentAddress studentAddress = (StudentAddress)EntityCacheUtil.getResult(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
				StudentAddressImpl.class, primaryKey);

		if (studentAddress == _nullStudentAddress) {
			return null;
		}

		if (studentAddress == null) {
			Session session = null;

			try {
				session = openSession();

				studentAddress = (StudentAddress)session.get(StudentAddressImpl.class,
						primaryKey);

				if (studentAddress != null) {
					cacheResult(studentAddress);
				}
				else {
					EntityCacheUtil.putResult(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
						StudentAddressImpl.class, primaryKey,
						_nullStudentAddress);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StudentAddressModelImpl.ENTITY_CACHE_ENABLED,
					StudentAddressImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return studentAddress;
	}

	/**
	 * Returns the student address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the student address
	 * @return the student address, or <code>null</code> if a student address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentAddress fetchByPrimaryKey(int addressId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns all the student addresses.
	 *
	 * @return the student addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentAddress> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StudentAddress> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StudentAddress> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<StudentAddress> list = (List<StudentAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENTADDRESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTADDRESS;

				if (pagination) {
					sql = sql.concat(StudentAddressModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StudentAddress>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StudentAddress>(list);
				}
				else {
					list = (List<StudentAddress>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the student addresses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StudentAddress studentAddress : findAll()) {
			remove(studentAddress);
		}
	}

	/**
	 * Returns the number of student addresses.
	 *
	 * @return the number of student addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENTADDRESS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the student address persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.StudentAddress")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StudentAddress>> listenersList = new ArrayList<ModelListener<StudentAddress>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StudentAddress>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StudentAddressImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STUDENTADDRESS = "SELECT studentAddress FROM StudentAddress studentAddress";
	private static final String _SQL_COUNT_STUDENTADDRESS = "SELECT COUNT(studentAddress) FROM StudentAddress studentAddress";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studentAddress.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudentAddress exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentAddressPersistenceImpl.class);
	private static StudentAddress _nullStudentAddress = new StudentAddressImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StudentAddress> toCacheModel() {
				return _nullStudentAddressCacheModel;
			}
		};

	private static CacheModel<StudentAddress> _nullStudentAddressCacheModel = new CacheModel<StudentAddress>() {
			@Override
			public StudentAddress toEntityModel() {
				return _nullStudentAddress;
			}
		};
}