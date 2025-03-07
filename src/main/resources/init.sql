-- Crear tabla de usuarios (si no existe)
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Crear tabla de pedidos (si no existe)
CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insertar usuarios iniciales
INSERT INTO users (name, email, password) VALUES
('Juan Pérez', 'juan.perez@email.com', 'password123'),
('María García', 'maria.garcia@email.com', 'securepass'),
('Carlos López', 'carlos.lopez@email.com', 'mypassword');

-- Insertar pedidos iniciales
INSERT INTO orders (description, user_id) VALUES
('Pedido de prueba 1', 1),
('Pedido de prueba 2', 2),
('Pedido de prueba 3', 3);
