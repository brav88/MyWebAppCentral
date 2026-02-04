CREATE DATABASE PriceAutoSales;
USE PriceAutoSales;

/*DROP TABLE Cars;*/

CREATE TABLE Cars (
    carId int NOT NULL AUTO_INCREMENT,
    brand varchar(50),
    model varchar(100),
    type int,
    fuelType int,
    transmission int,
    cubicCapacity varchar(50),
    created datetime,
	PRIMARY KEY (carId)
);

INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created)
VALUES ('Toyota', 'Land Cruiser Prado', 7, 2, 2, '4000cc', LOCALTIME());
INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created)
VALUES ('Honda', 'Civic', 1, 1, 1, '1700cc', LOCALTIME());
INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created)
VALUES ('Suzuki', 'Vitara', 1, 1, 1, '1900cc', LOCALTIME());

UPDATE Cars SET brand = 'Suzuki' WHERE carId = 3;
SELECT * FROM Cars;

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


