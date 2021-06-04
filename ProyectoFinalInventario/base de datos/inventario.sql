use inventario;

create table usuario(
	nombre varchar(100) primary key,
    contrasenia varchar(100)
);

INSERT INTO usuario (nombre,contrasenia)
VALUES ('fede','12345678');

create table producto(
  nombre varchar(100) ,
  codigo varchar(100) primary key,
  tipo varchar(100),
  stock varchar(100)
);

INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('M1 GARAND','A001','Fusil','11');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('G.Fragmentación','B001','Granada','200');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('G.conmoción','B002','Granada','150');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('M16','A002','Fusil','20');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('FN FAL','A003','Fusil','9');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('RPG-7','A004','Cohete antiaéreo','5');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('Remington 870','A005','Magnum','30');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('UZI','A006','Subfusil','25');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('MAUSER K98K','A007','Carabina','3');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('M1911','A008','Pistola','56');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('LEE-ENFIELD SMLE','A009','Fusil','18');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('Winchester 70','A010','Fusil','41');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('AK_47','A011','Fusil','41');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('Ilyshin il-2','C001','Avión ataque-tierra','1');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('Messerschmitt Bf 109','C002','Spitefire','2');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('B-24 Liberator','A014','CazaBombardero','1');
INSERT INTO producto (nombre,codigo,tipo,stock)
VALUES ('MIG-15','A015','CazaBombardero','1');