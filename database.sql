create database walmart;
use database walmart;

create table usuario(
id int not null auto_increment primary key,
userName varchar(50) not null,
password varchar(100) not null,
firstName varchar(50) not null,
lastName varchar(50), 
email varchar(50) not null, 
enabled boolean not null,
lastPasswordResetDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table producto(
id int not null auto_increment primary key,
nombreProducto varchar(250) not null,
descripcion varchar(250) not null,
precio decimal(10,2) not null

);

create table AUTHORITY(
id int not null primary key auto_increment,
name varchar(15) not null
);

create table USER_AUTHORITY(
user_Id int not null primary key,
authority_Id int not null
);


insert into usuario (userName, password, firstName, lastName, email, enabled) values("admin", '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', "Juan Antonio", "Gonzalez", "ju1121an@hotmail.com", 1);
insert into usuario (userName, password, firstName, lastName, email, enabled) values("user", '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', "Victor", "Lopez", "victor.lopez@hotmail.com" ,1);

insert into AUTHORITY(name) values ("ROLE_USER");
insert into AUTHORITY(name) values ("ROLE_ADMIN");

insert into USER_AUTHORITY (user_Id, authority_Id) VALUES (1, 1);
insert into USER_AUTHORITY (user_Id, authority_Id) VALUES (2, 2);

