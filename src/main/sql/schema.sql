create database userapp;

use userapp;
create table users(
	id integer auto_increment primary key,
	username varchar(100) not null,
	email varchar(100) not null,
	password varchar(50) not null
);