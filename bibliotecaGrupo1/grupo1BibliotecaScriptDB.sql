/*  Drop table g1lib.prestamos;
 *  Drop table g1lib.libro;
 *  Drop table g1lib.Autor;
 *  Drop table g1lib.usuario;    
*/

/*CREATE TABLE g1lib.Autor (
    autor_id INT AUTO_INCREMENT PRIMARY KEY,
    nombreAutor VARCHAR(255) NOT NULL,
    apellidoAutor VARCHAR(255),
    sexo VARCHAR(2) NOT NULL,
    fechaNacimiento DATE,
    nationality VARCHAR(255),
    biografia VARCHAR(255)
);

CREATE TABLE g1lib.libro(
	libro_id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(255) NOT NULL,
	autor_id INT,
	isbn VARCHAR(255),
	disponible boolean,
	genero VARCHAR(100),
	FOREIGN KEY (autor_id) REFERENCES Autor(autor_id)
);

CREATE TABLE g1lib.usuario(
	usuario_id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(255),
	apellidos VARCHAR(255),
	dni VARCHAR(15) NOT NULL,
	email VARCHAR(100),
	telefono VARCHAR(50),
	direccion VARCHAR(255),
	fechaAlta DATE,
	activo INT,
	numeroPrestamos INT
);

CREATE TABLE prestamos (
    prestamo_id INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT,
    usuario_id INT,
    fecha_prestamo DATE DEFAULT (CURRENT_DATE),
    fecha_retorno DATE,
    FOREIGN KEY (libro_id) REFERENCES libro(libro_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE ventas (
    venta_id INT PRIMARY KEY AUTO_INCREMENT,
    fechaVenta DATE NOT NULL,
    usuario_id INT,
    valorTotal FLOAT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE ventas_detalle(
	venta_id INT NOT NULL,
	venta_item INT NOT NULL,
	libro_id int,
	precioVentaLibro FLOAT,
	PRIMARY KEY(venta_id, venta_item),
	FOREIGN KEY (venta_id) REFERENCES ventas(venta_id),
	FOREIGN KEY (libro_id) REFERENCES libro(libro_id)
)

*/

INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nacionalidad, biografia) VALUES ('Gabriel', 'García Márquez', 'M', '1927-03-06', 'Colombiana', 'Novelista, cuentista, dramaturgo y periodista colombiano, ganador del Premio Nobel de Literatura.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Jane', 'Austen', 'F', '1775-12-16', 'Británica', 'Novelista famosa por sus obras que critican la sociedad y la moral de su tiempo.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Mark', 'Twain', 'M', '1835-11-30', 'Estadounidense', 'Escritor humorista y conferencista, conocido por sus novelas sobre la vida en el río Mississippi.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Franz', 'Kafka', 'M', '1883-07-03', 'Checa', 'Escritor que influyó en la literatura moderna con su estilo único y su enfoque en la alienación.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Virginia', 'Woolf', 'F', '1882-01-25', 'Británica', 'Escritora y feminista, es conocida por sus novelas que exploran la conciencia y el tiempo.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Herman', 'Melville', 'M', '1819-08-01', 'Estadounidense', 'Novelista y poeta, conocido por su obra más famosa "Moby Dick".');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('J.K.', 'Rowling', 'F', '1965-07-31', 'Británica', 'Autora de la popular serie de libros de Harry Potter.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('George', 'Orwell', 'M', '1903-06-25', 'Británico', 'Novelista y ensayista, conocido por su crítica social y política en sus obras.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Mario', 'Vargas Llosa', 'M', '1936-03-28', 'Peruano', 'Novelista y político, ganador del Premio Nobel de Literatura en 2010.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Gabriel', 'Garcia', 'M', '1944-01-27', 'Colombiano', 'Escritor y periodista, conocido por su enfoque en el realismo mágico.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Toni', 'Morrison', 'F', '1931-02-18', 'Estadounidense', 'Novelista y ensayista, ganó el Premio Nobel de Literatura en 1993.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Leo', 'Tolstoy', 'M', '1828-09-09', 'Ruso', 'Considerado uno de los más grandes autores de la literatura universal.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Charles', 'Dickens', 'M', '1812-02-07', 'Británico', 'Novelista que retrató la vida en la Inglaterra victoriana.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Albert', 'Camus', 'M', '1913-11-07', 'Francés', 'Filósofo y escritor, conocido por su contribución al existencialismo.');
INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES ('Isabel', 'Allende', 'F', '1942-08-02', 'Chilena', 'Novelista y escritora, ha sido reconocida por su narrativa mágica.');

INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Cien años de soledad', 1, '978-0060883287', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Orgullo y prejuicio', 2, '978-0141439518', 1, 'Romance');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Las aventuras de Tom Sawyer', 3, '978-0543215006', 1, 'Aventura');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('La metamorfosis', 4, '978-0143039433', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Al faro', 5, '978-0156716852', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Moby Dick', 6, '978-1503280786', 1, 'Aventura');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Harry Potter y la piedra filosofal', 7, '978-0747532699', 1, 'Fantasía');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Rebelión en la granja', 8, '978-0451526342', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('La ciudad y los perros', 9, '978-8420418171', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Beloved', 10, '978-1400033416', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Guerra y paz', 11, '978-1420957756', 1, 'Ficción histórica');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('David Copperfield', 12, '978-1503212898', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('El extranjero', 13, '978-0140177398', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('La casa de los espíritus', 14, '978-0345805066', 1, 'Ficción mágica');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Asfixia', 15, '978-0060515015', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Cien años de soledad', 1, '978-0060883287', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Los miserables', 11, '978-0140444308', 1, 'Ficción histórica');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('Crónica de una muerte anunciada', 1, '978-0307389782', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('La tregua', 9, '978-8447332736', 1, 'Ficción');
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('El túnel', 4, '978-8403391795', 1, 'Ficción psicológica');

INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Juan', 'Pérez', '12345678A', 'juan.perez@example.com', '600123456', 'Calle Falsa 123, Madrid', '2025-01-01', 1, 2);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('María', 'Gómez', '23456789B', 'maria.gomez@example.com', '601234567', 'Avenida Siempre Viva 742, Barcelona', '2025-01-02', 1, 1);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Pedro', 'López', '34567890C', 'pedro.lopez@example.com', '602345678', 'Calle del Sol 98, Valencia', '2025-01-03', 1, 0);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Lucía', 'Hernández', '45678901D', 'lucia.hernandez@example.com', '603456789', 'Calle Luna 45, Sevilla', '2025-01-04', 1, 3);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('José', 'Martínez', '56789012E', 'jose.martinez@example.com', '604567890', 'Calle Estrella 12, Zaragoza', '2025-01-05', 1, 1);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Ana', 'Hidalgo', '67890123F', 'ana.hidalgo@example.com', '605678901', 'Calle de la Paz 77, Málaga', '2025-01-06', 1, 5);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Luis', 'Ramírez', '78901234G', 'luis.ramirez@example.com', '606789012', 'Avenida Libertad 33, Bilbao', '2025-01-07', 1, 2);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Elena', 'Sánchez', '89012345H', 'elena.sanchez@example.com', '607890123', 'Calle del Rio 56, León', '2025-01-08', 1, 0);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Raúl', 'García', '90123456I', 'raul.garcia@example.com', '608901234', 'Calle de la Montaña 87, Toledo', '2025-01-09', 1, 4);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Sofía', 'Torres', '01234567J', 'sofia.torres@example.com', '609012345', 'Calle del Viento 21, Granada', '2025-01-10', 1, 3);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Diego', 'Molina', '12345678K', 'diego.molina@example.com', '610123456', 'Calle del Mar 34, Almería', '2025-01-11', 1, 1);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Nuria', 'Fuentes', '23456789L', 'nuria.fuentes@example.com', '611234567', 'Calle de la Luz 76, Burgos', '2025-01-12', 1, 2);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Ana', 'García', '23456765B', 'ana.garcia@example.com', '623456789', 'Avenida Siempre Viva 456, Sevilla', '2025-01-02', 1, 1);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Luis', 'Martínez', '34567000C', 'luis.martinez@example.com', '634567890', 'Calle Tormenta 789, Barcelona', '2025-01-03', 1, 2);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Rocio', 'Lopez', '45678801D', 'maria.lopez@example.com', '645678901', 'Plaza Mayor 101, Valencia', '2025-01-04', 1, 5);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('José', 'Hernández', '56789002E', 'jose.hernandez@example.com', '656789012', 'Calle del Río 202, Bilbao', '2025-01-05', 1, 3);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Laura', 'Martín', '67770123F', 'laura.martin@example.com', '667890123', 'Avenida Marítima 303, Málaga', '2025-01-06', 1, 4);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Javier', 'Gómez', '78901288G', 'javier.gomez@example.com', '678901234', 'Calle Nueva 404, Zaragoza', '2025-01-07', 1, 0);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Carmen', 'Jiménez', '89992345H', 'carmen.jimenez@example.com', '689012345', 'Calle Sol 505, Murcia', '2025-01-08', 1, 2);
INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES ('Felipe', 'Sánchez', '90123488I', 'felipe.sanchez@example.com', '612345679', 'Avenida de Europa 606, Granada', '2025-01-09', 1, 1);

INSERT INTO ventas (fechaVenta, usuario_id, valorTotal) VALUES
('2025-01-15', 1, 29.99),
('2025-01-16', 2, 19.99),
('2025-01-17', 3, 39.99),
('2025-01-18', 4, 24.99),
('2025-01-19', 5, 15.99),
('2025-01-20', 6, 22.50),
('2025-01-21', 7, 45.00),
('2025-01-22', 8, 34.95),
('2025-01-23', 9, 55.50),
('2025-01-24',  10, 16.75),
('2025-01-25',  11, 29.99),
('2025-01-26',  12, 49.99),
('2025-01-27',  13, 19.50),
('2025-01-28',  14, 39.95),
('2025-01-29',  15, 25.00),
('2025-01-30',  16, 37.80),
('2025-01-31',  17, 28.00),
('2025-02-01',  18, 30.99),
('2025-02-02',  19, 42.20),
('2025-02-03',  20, 32.45);

INSERT INTO ventas_detalle (venta_id, venta_item, libro_id, precioVentaLibro) VALUES
(1, 1, 1, 29.99), 
(2, 1, 2, 9.99),
(3, 1, 3, 39.99);
(3, 2, 2, 39.99), 
(3, 3, 1, 39.99); 
(4, 1, 4, 24.99),
(5, 1, 5, 15.99), 
(6, 1, 6, 22.50), 
(7, 1, 7, 45.00), 
(8, 1, 8, 34.95), 
(9, 1, 9, 55.50),
(10,1, 10,16.75),
(11,1, 11,29.99),
(12,1, 12,49.99),
(13,1, 13,19.50),
(14,1, 14,39.95),
(15,1, 15,25.00),
(16,1, 16,37.80),
(17,1, 2,28.00),
(18,1, 18,30.99),
(19,1, 19,42.20),
(20,2, 20,32.45);


select * from usuario;

-- pruebas de libro
INSERT INTO libro (titulo, autor_id, isbn, disponible, genero) VALUES ('El incorrecto', 16, '999-9999999999', 1, 'Fantasía');
UPDATE libro set titulo = 'El incorrecto2', autor_id = 17, isbn = '888-9999999999', disponible = 1, genero = 'Fantasía' where libro_id = 21;
-- DELETE from libro where libro_id = 17;
select * from libro;

DELETE from Autor where autor_id = 20;
select * from Autor where upper(nombreAutor) = 'GABRIEL';

select * from ventas;

select v.venta_id, v.fechaVenta, v.usuario_id, v.valorTotal, venta_item, libro_id, precioVentaLibro
from ventas v
join ventas_detalle vd on v.venta_id = vd.venta_id
where v.venta_id = 3;
