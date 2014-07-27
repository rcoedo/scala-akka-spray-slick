## MySQL 5.5 on Ubuntu 14.04 x64 using Vagrant

## Requirements

* Have Vagrant installed.
* Port 3306 available

## How to install

1. Download the project

        git clone https://github.com/rcoedo/vagrant-ubuntu-mysql

2. Run `vagrant up` inside the project directory. This will download the image and install everything.

3. Enjoy :)

## How to connect

Run the following command: 

        mysql -u root --host=127.0.0.1 -p
        Enter password: toor
        
