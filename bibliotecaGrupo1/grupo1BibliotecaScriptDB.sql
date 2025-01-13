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
*/


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