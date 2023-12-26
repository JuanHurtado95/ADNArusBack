create table registro (
 id integer not null auto_increment,
 tipo_documento varchar(45) not null,
 identificacion varchar(45) not null,
 primer_nombre varchar(45) not null,
 segundo_nombre varchar(45),
 primer_apellido varchar(45) not null,
 segundo_apellido varchar(45),
 administradora_salud varchar(30) not null,
 fecha_salud date not null,
 administradora_pension varchar(30) not null,
 fecha_pension date not null,
 primary key (id)
);