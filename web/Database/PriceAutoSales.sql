CREATE DATABASE PriceAutoSalesCentral;
USE PriceAutoSalesCentral;

/*DROP TABLE Cars;*/

CREATE TABLE Cars (
    carId int NOT NULL AUTO_INCREMENT,
    brand varchar(50),
    model varchar(100),
    type int,
    fuelType int,
    transmission int,
    cubicCapacity varchar(50),
    userId int,
    created datetime,
	PRIMARY KEY (carId)
);

INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created) 
VALUES ('Toyota', 'Land Cruiser Prado', 7, 2, 2, '4000', LOCALTIME());
INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created)
VALUES ('Honda', 'Civic', 1, 1, 1, '1700', LOCALTIME());
INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created)
VALUES ('Suzuki', 'Vitara', 1, 1, 1, '1900', LOCALTIME());
INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created)
VALUES ('Suzuki', 'Alto', 8, 1, 1, '1000', LOCALTIME());

UPDATE Cars SET userId = 1 WHERE carId = 3;
DELETE FROM Cars WHERE carId = 7;

SELECT * FROM Cars WHERE carId = 4;

CREATE TABLE Transmission (
    id int NOT NULL AUTO_INCREMENT,
    description varchar(50),
    PRIMARY KEY (id)
);

INSERT INTO Transmission (description)
VALUES ('Manual');
INSERT INTO Transmission (description)
VALUES ('Shiftronic');
INSERT INTO Transmission (description)
VALUES ('Dual Automatic');

SELECT * FROM Transmission;

CREATE TABLE FuelType (
    id int NOT NULL AUTO_INCREMENT,
    description varchar(50),
    PRIMARY KEY (id)
);

INSERT INTO FuelType (description)
VALUES ('Gasoline');
INSERT INTO FuelType (description)
VALUES ('Diesel');
INSERT INTO FuelType (description)
VALUES ('Hibrid');
INSERT INTO FuelType (description)
VALUES ('Electric');

SELECT * FROM FuelType;

CREATE TABLE CarType (
    id int NOT NULL AUTO_INCREMENT,
    description varchar(50),
    PRIMARY KEY (id)
);

INSERT INTO CarType (description)
VALUES ('Sedan');
INSERT INTO CarType (description)
VALUES ('Pick Up 4x4');
INSERT INTO CarType (description)
VALUES ('PickUp 4x2');
INSERT INTO CarType (description)
VALUES ('SUV 4x4');
INSERT INTO CarType (description)
VALUES ('SUV 4x2');
INSERT INTO CarType (description)
VALUES ('Hatchback');
INSERT INTO CarType (description)
VALUES ('Station Wagon');

SELECT * FROM CarType;

CREATE TABLE Users (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50),
    last_name varchar(50),
    email varchar(50),
    password varchar(50),
    type varchar(50),
    PRIMARY KEY (id)
);

INSERT INTO Users (name, last_name, email, password, type)
VALUES ('Braulio', 'Sandi', 'bsandim@castrocarazo.ac.cr', 'Admin$1234', 'root');
INSERT INTO Users (name, last_name, email, password, type)
VALUES ('Ernesto', 'Valverde', 'evalverde@castrocarazo.ac.cr', 'Admin$1234', 'sales');

SELECT * FROM Users WHERE email = 'bsandim@castrocarazo.ac.cr' AND password = 'Admin$1234';

SELECT 
	cars.brand, 
	cars.model, 
    cars.cubicCapacity,
	cartype.description,
    concat(users.name,' ', users.last_name) owner
FROM cars	
	INNER JOIN cartype 
    ON cars.type = cartype.id
    LEFT JOIN users 
    ON cars.userid = users.id;

