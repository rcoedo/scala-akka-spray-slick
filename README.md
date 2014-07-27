## Integration project: Scala, Akka, Spray and Slick

## About the project

This project is my first contact with the scala world. It can be improved in many ways. If you have any suggestion please don't hesitate to contact me.

## Mysql database

In order to avoid complex setups, a Vagrant box with the necessary provisioning to run this project is provided in the mysqldb folder.
Note that this is completely optional and you can also use your own database.

The requirements to run the box are as follows:

* Have Vagrant installed
* Port 3306 available

## How to run

1. Download the project

        git clone https://github.com/rcoedo/scala-akka-spray-slick

2. Go to the mysqldb folder and run `vagrant up` inside the project directory. This will download the image and install everything.

3. go to the root folder and run `sbt run`

## How to see the result 

Open `http://localhost:8080/api/messages` and `http://localhost:8080/api/message/1` in your browser

## TODO List

* Tests
* Logging
