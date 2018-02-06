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

import com.liferay.sample.model.StudentAddress;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StudentAddress in entity cache.
 *
 * @author admin
 * @see StudentAddress
 * @generated
 */
public class StudentAddressCacheModel implements CacheModel<StudentAddress>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{addressId=");
		sb.append(addressId);
		sb.append(", city=");
		sb.append(city);
		sb.append(", country=");
		sb.append(country);
		sb.append(", sid=");
		sb.append(sid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentAddress toEntityModel() {
		StudentAddressImpl studentAddressImpl = new StudentAddressImpl();

		studentAddressImpl.setAddressId(addressId);

		if (city == null) {
			studentAddressImpl.setCity(StringPool.BLANK);
		}
		else {
			studentAddressImpl.setCity(city);
		}

		if (country == null) {
			studentAddressImpl.setCountry(StringPool.BLANK);
		}
		else {
			studentAddressImpl.setCountry(country);
		}

		studentAddressImpl.setSid(sid);

		studentAddressImpl.resetOriginalValues();

		return studentAddressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressId = objectInput.readInt();
		city = objectInput.readUTF();
		country = objectInput.readUTF();
		sid = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(addressId);

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		objectOutput.writeInt(sid);
	}

	public int addressId;
	public String city;
	public String country;
	public int sid;
}