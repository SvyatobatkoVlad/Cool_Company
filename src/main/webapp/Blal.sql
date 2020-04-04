CREATE SCHEMA cool_company DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

use cool_company;

CREATE TABLE role(
ID_role int NOT NULL AUTO_INCREMENT,
Role_user varchar(255) NOT NULL,
 CONSTRAINT PK_Role PRIMARY KEY (ID_role)
);

CREATE TABLE user (
    ID_user int NOT NULL AUTO_INCREMENT ,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Date_of_Birth int,
    Address varchar(255),
    Login varchar(255),
    Password varchar(255),
    Telephone int,
    ID_role  int NOT NULL,
	CONSTRAINT FK_role FOREIGN KEY (ID_role) REFERENCES role (ID_role) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT PK_Person PRIMARY KEY (ID_user)
    
);


CREATE TABLE Countries (
ID_Countries int NOT NULL AUTO_INCREMENT,
Countri_name varchar(255) NOT NULL,
CONSTRAINT PK_Countries PRIMARY KEY (ID_Countries)
);

CREATE TABLE Cities (
ID_Cities int NOT NULL AUTO_INCREMENT,
Cities_name varchar(255) NOT NULL,
ID_Countries int NOT NULL,
CONSTRAINT FK_Countries FOREIGN KEY (ID_Countries) REFERENCES Countries (ID_Countries) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT PK_Cities PRIMARY KEY (ID_Cities)
);

CREATE TABLE Type_of_tour (
ID_Type_of_tour int NOT NULL AUTO_INCREMENT,
Type_tour varchar(255) NOT NULL,
CONSTRAINT PK_Type_of_tour PRIMARY KEY (ID_Type_of_tour)
);

CREATE TABLE Type_of_allocation (
ID_Type_of_allocation int NOT NULL AUTO_INCREMENT,
Type_of_allocation varchar(255) NOT NULL,
CONSTRAINT PK_allocation PRIMARY KEY (ID_Type_of_allocation)
);


CREATE TABLE Hotels (
ID_Hotels int NOT NULL AUTO_INCREMENT,
Hotels_name varchar(255) NOT NULL,
Stars  int NOT NULL,
ID_Cities int NOT NULL,
ID_Type_of_allocation int NOT NULL,
CONSTRAINT FK_Cities FOREIGN KEY (ID_Cities) REFERENCES Cities (ID_Cities) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_Type_of_allocation FOREIGN KEY (ID_Type_of_allocation) REFERENCES Type_of_allocation (ID_Type_of_allocation) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT PK_Hotels PRIMARY KEY (ID_Hotels)
);

CREATE TABLE tour(
ID_tour int NOT NULL AUTO_INCREMENT,
start_data varchar(255) NOT NULL,
End_date varchar(255) NOT NULL,
ID_Type_of_tour int NOT NULL,
ID_Hotels int NOT NULL,
CONSTRAINT FK_Type_of_tours FOREIGN KEY (ID_Type_of_tour) REFERENCES Type_of_tour (ID_Type_of_tour) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_Hotels FOREIGN KEY (ID_Hotels) REFERENCES Hotels (ID_Hotels) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT PK_tour PRIMARY KEY (ID_tour)
);

CREATE TABLE Orders (
 ID_orders int NOT NULL AUTO_INCREMENT,
 Datas varchar(255) NOT NULL,
 price decimal(10,2) NOT NULL,
 ID_user int NOT NULL,
 ID_tour int NOT NULL,
 CONSTRAINT FK_user FOREIGN KEY (ID_user) REFERENCES user (ID_user) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT FK_tour FOREIGN KEY (ID_tour) REFERENCES tour (ID_tour) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT PK_Orders PRIMARY KEY (ID_orders)
);

INSERT INTO role (ID_role, Role_user) VALUES ('1', 'ADMIN');
INSERT INTO role (ID_role, Role_user) VALUES ('2', 'CLIENT');
INSERT INTO role (ID_role, Role_user) VALUES ('3', 'CONTENT_MANAGER');



    
INSERT INTO user (ID_user, LastName, FirstName, Date_of_Birth, Address, Login, Password,  Telephone, ID_role) VALUES ('1', 'Svyatobatko', 'Vlad', '10091999', 'Kharkov', 'Svyatobatko@gmail.com', 'sv40631400sv', '09545622', '1');
INSERT INTO user (ID_user, LastName, FirstName, Date_of_Birth, Address, Login, Password,  Telephone, ID_role) VALUES ('2', 'Baranova', 'Sveta', '12101987', 'Kharkov', 'Sveta@gmail.com', 'az40631400az',  '098213513', '2');

INSERT INTO countries (ID_Countries, Countri_name) VALUES ('1', 'Ukraine');
INSERT INTO countries (ID_Countries, Countri_name) VALUES ('2', 'Italy');
INSERT INTO countries (ID_Countries, Countri_name) VALUES ('3', 'France');



INSERT INTO cities (ID_Cities, Cities_name, ID_Countries) VALUES ('1', 'Kharkiv', '1');
INSERT INTO cities (ID_Cities, Cities_name, ID_Countries) VALUES ('2', 'Milan', '2');
INSERT INTO cities (ID_Cities, Cities_name, ID_Countries) VALUES ('3', 'Paris', '3');

INSERT INTO type_of_allocation (ID_Type_of_allocation, `Type_of_allocation`) VALUES ('1', 'Suite_Room');
INSERT INTO type_of_allocation (ID_Type_of_allocation, `Type_of_allocation`) VALUES ('2', 'Single_Room');
INSERT INTO type_of_allocation (ID_Type_of_allocation, `Type_of_allocation`) VALUES ('3', 'Double_Room');

INSERT INTO hotels (ID_Hotels, Hotels_name, Stars, ID_Cities, ID_Type_of_allocation) VALUES ('1', 'Viva_Hotel', '4', '1', '1');
INSERT INTO hotels (ID_Hotels, Hotels_name, Stars, ID_Cities, ID_Type_of_allocation) VALUES ('2', 'Grand_Hotel', '5', '2', '2');
INSERT INTO hotels (ID_Hotels, Hotels_name, Stars, ID_Cities, ID_Type_of_allocation) VALUES ('3', 'Motel_One_Paris', '3', '3', '3');

INSERT INTO type_of_tour (ID_Type_of_tour, Type_tour) VALUES ('1', 'Wedding_tour');
INSERT INTO type_of_tour (ID_Type_of_tour, Type_tour) VALUES ('2', 'Extreme tour');
INSERT INTO type_of_tour (ID_Type_of_tour, Type_tour) VALUES ('3', 'Individua_tours');

INSERT INTO tour (ID_tour, start_data, End_date, ID_Type_of_tour, ID_Hotels) VALUES ('1', '10.10.2020', '17.10.2020', '1', '1');
INSERT INTO tour (ID_tour, start_data, End_date, ID_Type_of_tour, ID_Hotels) VALUES ('2', '12.10.2020', '19.10.2020', '2', '2');
INSERT INTO tour (ID_tour, start_data, End_date, ID_Type_of_tour, ID_Hotels) VALUES ('3', '13.10.2020', '20.10.2020', '3', '3');

INSERT INTO orders (ID_orders, Datas, price, ID_user, ID_tour) VALUES ('1', '10.10.2020', '735.48', '1', '1');
INSERT INTO orders (ID_orders, Datas, price, ID_user, ID_tour) VALUES ('2', '11.10.2020', '888.55', '1', '2');
INSERT INTO orders (ID_orders, Datas, price, ID_user, ID_tour) VALUES ('3', '12.10.2020', '333.16', '1', '3');


SELECT * FROM orders WHERE ID_user = 1;














  