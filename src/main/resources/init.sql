-- Crear base de datos y tablas
CREATE DATABASE prueba_tecnica;

-- Usar la base de datos
\c prueba_tecnica;

-- Crear tabla de usuarios con contraseña
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

-- Crear tabla de pedidos
CREATE TABLE orders (
     id SERIAL PRIMARY KEY,
        description VARCHAR(255),
        user_id INT,
        FOREIGN KEY (user_id) REFERENCES user_id(id)
);

-- Insertar algunos datos iniciales
INSERT INTO users (name, email, password) VALUES ('Juan Pérez', 'juan@correo.com', 'password123');
INSERT INTO users (name, email, password) VALUES ('Ana García', 'ana@correo.com', 'password456');

INSERT INTO orders (description, user_id) VALUES ('Pedido de zapatos', 1);
INSERT INTO orders (description, user_id) VALUES ('Pedido de computadora', 2);
