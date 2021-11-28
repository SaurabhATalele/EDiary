# EDiary

This is a diary project that deals with keeping records of the cutomers with reaspect to their payments.

The database used in thois project is the MySQL and use the following commands to create the same

# Database
CREATE DATABASE ebill;

# First table
CREATE TABLE `customers` (
  `ID` int NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
)

# Second Table
CREATE TABLE `payments` (
  `id` int NOT NULL,
  `amount` int DEFAULT NULL,
  `balance` int DEFAULT NULL,
  `dt` date DEFAULT NULL,
 tid int default 1,
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customers` (`ID`));

