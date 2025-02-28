# Usar la imagen oficial de MySQL
FROM mysql:8.0

# Exponer el puerto que deseas usar (en este caso 3307 en lugar de 3306)
EXPOSE 3307

# Copiar algún archivo de configuración si es necesario (opcional)
# COPY my.cnf /etc/mysql/my.cnf

# Ejecutar el servicio MySQL
CMD ["mysqld"]
