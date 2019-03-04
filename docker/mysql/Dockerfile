FROM mysql:latest
EXPOSE 3306
ENV MYSQL_ROOT_PASSWORD=ontap
ENV MYSQL_USER=netapp
ENV MYSQL_PASSWORD=ontap
ENV MYSQL_DATABASE=sakila
ENV TZ=Asia/Tokyo
COPY init/* /docker-entrypoint-initdb.d/
