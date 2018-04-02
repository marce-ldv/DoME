create database dome;

use dome;

--Tabla Elemento
create table elemento(
	idElemento int primary key not null,
	duracion VARCHAR(10), --el varchar es como un string
	loTengo bit,
	comentario VARCHAR(100),
	select *from elemento;
	--select *from elemento values(1,'1:45',1,'Registro de prueba'); --select es una consulta
)

--Tabla CD Musica
create table cd(
	idCd int primary key not null,
	interprete VARCHAR(20),
	numeroDeCanciones int,
	idElemento int,
	constraint fk_IdElementoCD foreign key(idElemento) references elemento
)

--Tabla DVD Peliculas
create table dvd(
	idDvd int primary key not null,
	director VARCHAR(20),
	idElemento int,
	constraint fk_IdElementoDVD foreign key(idElemento) references elemento
)

create table prueba(
	idprueba int primary key not null,
	nombrePrueba VARCHAR(30),
	apellidoPrueba VARCHAR(30),
	select *from prueba;
)

drop table elemento;
drop table cd;
drop table dvd;