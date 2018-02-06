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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author admin
 * @generated
 */
public class StudentSoap implements Serializable {
	public static StudentSoap toSoapModel(Student model) {
		StudentSoap soapModel = new StudentSoap();

		soapModel.setSid(model.getSid());
		soapModel.setSname(model.getSname());
		soapModel.setSgender(model.getSgender());
		soapModel.setSnumber(model.getSnumber());

		return soapModel;
	}

	public static StudentSoap[] toSoapModels(Student[] models) {
		StudentSoap[] soapModels = new StudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[][] toSoapModels(Student[][] models) {
		StudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[] toSoapModels(List<Student> models) {
		List<StudentSoap> soapModels = new ArrayList<StudentSoap>(models.size());

		for (Student model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentSoap[soapModels.size()]);
	}

	public StudentSoap() {
	}

	public int getPrimaryKey() {
		return _sid;
	}

	public void setPrimaryKey(int pk) {
		setSid(pk);
	}

	public int getSid() {
		return _sid;
	}

	public void setSid(int sid) {
		_sid = sid;
	}

	public String getSname() {
		return _sname;
	}

	public void setSname(String sname) {
		_sname = sname;
	}

	public int getSgender() {
		return _sgender;
	}

	public void setSgender(int sgender) {
		_sgender = sgender;
	}

	public String getSnumber() {
		return _snumber;
	}

	public void setSnumber(String snumber) {
		_snumber = snumber;
	}

	private int _sid;
	private String _sname;
	private int _sgender;
	private String _snumber;
}