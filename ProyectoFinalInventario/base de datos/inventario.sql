use inventario;

create table usuario(
	nombre varchar(100) primary key,
    contrasenia varchar(100)
);

create table producto(
  nombre varchar(100) ,
  codigo varchar(100) primary key,
  tipo varchar(100),
  stock varchar(100)
);
