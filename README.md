# Prueba Tecnica Jr

# Proyecto CRUD con Spring Boot y PostgreSQL

Este es un proyecto CRUD desarrollado con Spring Boot, PostgreSQL y Docker, siguiendo buenas prácticas como DTOs, MapStruct, validaciones y pruebas.

## 🏗️ Estructura del Proyecto

El proyecto está compuesto por los siguientes servicios:

- **API Spring Boot** - Una aplicación Java que implementa la lógica del CRUD para gestionar los datos.
- **Base de Datos PostgreSQL** - Un contenedor Docker que aloja una base de datos PostgreSQL que la API utiliza para almacenar los datos.

## 🚀 Tecnologías utilizadas
- Java 21

- Spring Boot 3.4.3

- PostgreSQL

- Docker y Docker Compose

- Swagger para documentación

- MapStruct para mapeo de entidades

## 🔧 Instalación y ejecución

1️⃣ Clonar el repositorio:

https://github.com/Escax/Prueba-tecnicaJr.git

2️⃣ Levantar el proyecto con Docker:

- make build         # Construir las imágenes de Docker
- make up            # Levantar los contenedores

Si make no está disponible, usa:

- docker-compose up --build -d

3️⃣ Verificar los contenedores:

- docker ps

4️⃣ Acceder a Swagger para probar la API:

http://localhost:8080/swagger-ui.html


## 🛑 Detener y Eliminar Contenedores

make down   # Detener y eliminar contenedores

- Sin make:
  
docker-compose down -v


# 📌 Autor

**Esneider** - 




