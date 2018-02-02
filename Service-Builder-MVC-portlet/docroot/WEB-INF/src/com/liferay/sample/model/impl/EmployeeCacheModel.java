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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author admin
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{eid=");
		sb.append(eid);
		sb.append(", ename=");
		sb.append(ename);
		sb.append(", ecountry=");
		sb.append(ecountry);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEid(eid);

		if (ename == null) {
			employeeImpl.setEname(StringPool.BLANK);
		}
		else {
			employeeImpl.setEname(ename);
		}

		if (ecountry == null) {
			employeeImpl.setEcountry(StringPool.BLANK);
		}
		else {
			employeeImpl.setEcountry(ecountry);
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eid = objectInput.readInt();
		ename = objectInput.readUTF();
		ecountry = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(eid);

		if (ename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ename);
		}

		if (ecountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ecountry);
		}
	}

	public int eid;
	public String ename;
	public String ecountry;
}