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
public class StudentAddressSoap implements Serializable {
	public static StudentAddressSoap toSoapModel(StudentAddress model) {
		StudentAddressSoap soapModel = new StudentAddressSoap();

		soapModel.setAddressId(model.getAddressId());
		soapModel.setCity(model.getCity());
		soapModel.setCountry(model.getCountry());
		soapModel.setSid(model.getSid());

		return soapModel;
	}

	public static StudentAddressSoap[] toSoapModels(StudentAddress[] models) {
		StudentAddressSoap[] soapModels = new StudentAddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentAddressSoap[][] toSoapModels(StudentAddress[][] models) {
		StudentAddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentAddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentAddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentAddressSoap[] toSoapModels(List<StudentAddress> models) {
		List<StudentAddressSoap> soapModels = new ArrayList<StudentAddressSoap>(models.size());

		for (StudentAddress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentAddressSoap[soapModels.size()]);
	}

	public StudentAddressSoap() {
	}

	public int getPrimaryKey() {
		return _addressId;
	}

	public void setPrimaryKey(int pk) {
		setAddressId(pk);
	}

	public int getAddressId() {
		return _addressId;
	}

	public void setAddressId(int addressId) {
		_addressId = addressId;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public int getSid() {
		return _sid;
	}

	public void setSid(int sid) {
		_sid = sid;
	}

	private int _addressId;
	private String _city;
	private String _country;
	private int _sid;
}