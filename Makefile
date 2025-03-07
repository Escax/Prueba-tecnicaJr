# Nombre del contenedor para evitar duplicados
CONTAINER_NAME=prueba_tecnica

# Construir los contenedores
build:
	docker-compose build

# Levantar los contenedores en segundo plano
up:
	docker-compose up -d

# Ver logs de la API
logs:
	docker-compose logs -f api

# Detener y eliminar los contenedores
down:
	docker-compose down

# Reiniciar los contenedores
restart: down up

# Ejecutar pruebas dentro del contenedor de la API
test:
	docker exec -it $(CONTAINER_NAME) mvn test

# Ejecutar la aplicación sin usar Docker (útil para debugging local)
run-local:
	mvn clean spring-boot:run

# Acceder a la base de datos dentro del contenedor
db-shell:
	docker exec -it $(CONTAINER_NAME) psql -U postgres -d prueba_tecnica
