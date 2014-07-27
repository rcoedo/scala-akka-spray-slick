GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '$DBPASSWD' WITH GRANT OPTION;
CREATE USER sassuser IDENTIFIED BY 'sasspw';
CREATE USER testsassuser IDENTIFIED BY 'sasspw';
CREATE DATABASE sassrest;
CREATE DATABASE testsassrest;
GRANT ALL PRIVILEGES ON sassrest.* TO sassuser@'%' IDENTIFIED BY 'sasspw';
GRANT ALL PRIVILEGES ON testsassrest.* TO testsassuser@'%' IDENTIFIED BY 'sasspw';
