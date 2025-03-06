
# Comando para construir y levantar los contenedores
run:
	docker-compose up --build

# Comando para detener y eliminar los contenedores
down:
	docker-compose down

# Comando para limpiar (eliminar imágenes y volúmenes no utilizados)
clean:
	docker-compose down --volumes --rmi all

# Comando para ver los logs de los contenedores
logs:
	docker-compose logs -f