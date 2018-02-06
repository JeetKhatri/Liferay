create table student (
	sid INTEGER not null primary key,
	sname VARCHAR(75) null,
	sgender INTEGER,
	snumber VARCHAR(75) null
);

create table student_address (
	addressId INTEGER not null primary key,
	city VARCHAR(75) null,
	country VARCHAR(75) null,
	sid INTEGER
);