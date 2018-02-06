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

import com.liferay.sample.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author admin
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{sid=");
		sb.append(sid);
		sb.append(", sname=");
		sb.append(sname);
		sb.append(", sgender=");
		sb.append(sgender);
		sb.append(", snumber=");
		sb.append(snumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setSid(sid);

		if (sname == null) {
			studentImpl.setSname(StringPool.BLANK);
		}
		else {
			studentImpl.setSname(sname);
		}

		studentImpl.setSgender(sgender);

		if (snumber == null) {
			studentImpl.setSnumber(StringPool.BLANK);
		}
		else {
			studentImpl.setSnumber(snumber);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sid = objectInput.readInt();
		sname = objectInput.readUTF();
		sgender = objectInput.readInt();
		snumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(sid);

		if (sname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sname);
		}

		objectOutput.writeInt(sgender);

		if (snumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(snumber);
		}
	}

	public int sid;
	public String sname;
	public int sgender;
	public String snumber;
}