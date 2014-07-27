#!/bin/bash

# Variables
DBPASSWD=toor

echo -e "\n[INFO] Starting installation\n"

echo -e "\n[INFO] Updating packages\n"
apt-get -qq update

echo -e "\n[INFO] Installing base packages\n"
apt-get -y install vim curl build-essential > /dev/null 2>&1

echo -e "\n[INFO] Installing MySQL packages\n"
echo "mysql-server mysql-server/root_password password $DBPASSWD" | debconf-set-selections
echo "mysql-server mysql-server/root_password_again password $DBPASSWD" | debconf-set-selections
apt-get -y install mysql-server-5.5 > /dev/null 2>&1
sed "s/\$DBPASSWD/$DBPASSWD/g" /vagrant/mysql_bootstrap.sql > /tmp/mysql_bootstrap.sql
mysql --user=root --password=$DBPASSWD --host=localhost --port=3306 < /tmp/mysql_bootstrap.sql
rm /tmp/mysql_bootstrap.sql
sudo mv /etc/mysql/my.cnf /etc/mysql/my.cnf_backup
sudo sed 's/bind-address/#bind-address/g' /etc/mysql/my.cnf_backup | sed 's/skip-external-locking/#skip-external-locking/g' > /etc/mysql/my.cnf
sudo service mysql restart

echo -e "\n[INFO] Done!\n"
