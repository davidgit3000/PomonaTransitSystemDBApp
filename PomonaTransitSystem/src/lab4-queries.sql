CREATE TABLE `lab4`.`trip` (
  `TripNumber` INT NOT NULL,
  `StartLocationName` VARCHAR(100) NULL,
  `DestinationName` VARCHAR(100) NULL,
  PRIMARY KEY (`TripNumber`));
  
  CREATE TABLE `lab4`.`tripoffering` (
  `TripNumber` INT,
  `Date` DATE,
  `ScheduledStartTime` VARCHAR(10),
  `ScheduledArrivalTime` VARCHAR(10),
  `DriverName` VARCHAR(100) NULL,
  `BusID` VARCHAR(10) NULL,
  PRIMARY KEY (`TripNumber`, `Date`, `ScheduledStartTime`),
 FOREIGN KEY (`TripNumber`) REFERENCES Trip (`TripNumber`),
 FOREIGN KEY (`DriverName`) REFERENCES Driver (`DriverName`),
 FOREIGN KEY (`BusID`) REFERENCES Bus (`BusID`)
);

CREATE TABLE `lab4`.`bus` (
  `BusID` VARCHAR(10) NOT NULL,
  `Model` VARCHAR(100) NULL,
  `Year` VARCHAR(4) NULL,
  PRIMARY KEY (`BusID`));

CREATE TABLE `lab4`.`driver` (
  `DriverName` VARCHAR(100) NOT NULL,
  `DriverTelephoneNumber` VARCHAR(20) NULL,
  PRIMARY KEY (`DriverName`));
  
  CREATE TABLE `lab4`.`stop` (
  `StopNumber` INT NOT NULL,
  `StopAddress` VARCHAR(100) NULL,
  PRIMARY KEY (`StopNumber`));
  
  CREATE TABLE `lab4`.`actualtripstopinfo` (
  `TripNumber` INT NOT NULL,
  `Date` DATE NOT NULL,
  `ScheduledStartTime` VARCHAR(10) NOT NULL,
  `StopNumber` INT NOT NULL,
  `ScheduledArrivalTime` VARCHAR(10) NULL,
  `ActualStartTime` VARCHAR(10) NULL,
  `ActualArrivalTime` VARCHAR(10) NULL,
  `NumberOfPassengerIn` INT NULL,
  `NumberOfPassengerOut` INT NULL,
  PRIMARY KEY (`TripNumber`, `Date`, `ScheduledStartTime`, `StopNumber`),
 FOREIGN KEY (`TripNumber`, `Date`, `ScheduledStartTime`) 
          REFERENCES TripOffering (`TripNumber`, `Date`, `ScheduledStartTime`),
FOREIGN KEY (`StopNumber`)
          REFERENCES `lab4`.`stop` (`StopNumber`)
);

CREATE TABLE `lab4`.`tripstopinfo` (
  `TripNumber` INT NOT NULL,
  `StopNumber` INT NOT NULL,
  `SequenceNumber` INT NULL,
  `DrivingTime` VARCHAR(5) NULL,
  PRIMARY KEY (`TripNumber`, `StopNumber`));

INSERT INTO `lab4`.`trip` (`TripNumber`, `StartLocationName`, `DestinationName`) VALUES ('1', 'Los Angeles', 'West Covina');
INSERT INTO `lab4`.`trip` (`TripNumber`, `StartLocationName`, `DestinationName`) VALUES ('2', 'Westminster', 'Garden Grove');
INSERT INTO `lab4`.`trip` (`TripNumber`, `StartLocationName`, `DestinationName`) VALUES ('3', 'La Puente', 'El Monte');

INSERT INTO `lab4`.`driver` (`DriverName`, `DriverTelephoneNumber`) VALUES ('David', '111-111-1111');
INSERT INTO `lab4`.`driver` (`DriverName`, `DriverTelephoneNumber`) VALUES ('Thanh', '222-222-2222');
INSERT INTO `lab4`.`driver` (`DriverName`, `DriverTelephoneNumber`) VALUES ('Nhat', '333-333-3333');

INSERT INTO `lab4`.`bus` (`BusID`, `Model`, `Year`) VALUES ('B10', 'model1', '2020');
INSERT INTO `lab4`.`bus` (`BusID`, `Model`, `Year`) VALUES ('B11', 'model2', '2020');
INSERT INTO `lab4`.`bus` (`BusID`, `Model`, `Year`) VALUES ('B12', 'model3', '2021');
INSERT INTO `lab4`.`bus` (`BusID`, `Model`, `Year`) VALUES ('B14', 'model4', '2022');
INSERT INTO `lab4`.`bus` (`BusID`, `Model`, `Year`) VALUES ('B23', 'model5', '2023');

INSERT INTO `lab4`.`tripoffering` (`TripNumber`, `Date`, `ScheduledStartTime`, `ScheduledArrivalTime`, `DriverName`, `BusID`) VALUES ('1', '2024-02-02', '08:00am', '09:00am', 'David', 'B10');
INSERT INTO `lab4`.`tripoffering` (`TripNumber`, `Date`, `ScheduledStartTime`, `ScheduledArrivalTime`, `DriverName`, `BusID`) VALUES ('1', '2024-02-02', '09:00am', '10:00am', 'David', 'B12');
INSERT INTO `lab4`.`tripoffering` (`TripNumber`, `Date`, `ScheduledStartTime`, `ScheduledArrivalTime`, `DriverName`, `BusID`) VALUES ('1', '2024-03-02', '08:30am', '09:30am', 'Thanh', 'B11');
INSERT INTO `lab4`.`tripoffering` (`TripNumber`, `Date`, `ScheduledStartTime`, `ScheduledArrivalTime`, `DriverName`, `BusID`) VALUES ('2', '2023-10-02', '10:00am', '11:00am', 'David', 'B12');
INSERT INTO `lab4`.`tripoffering` (`TripNumber`, `Date`, `ScheduledStartTime`, `ScheduledArrivalTime`, `DriverName`, `BusID`) VALUES ('2', '2023-12-03', '11:00am', '12:00pm', 'Nhat', 'B14');
INSERT INTO `lab4`.`tripoffering` (`TripNumber`, `Date`, `ScheduledStartTime`, `ScheduledArrivalTime`, `DriverName`, `BusID`) VALUES ('3', '2024-10-02', '03:00pm', '04:00pm', 'Thanh', 'B23');

-- SELECT T1.ScheduledStartTime, T1.ScheduledArrivalTime, T1.DriverName, T1.BusID
-- FROM tripoffering AS T1
-- JOIN trip AS T2 ON T1.TripNumber = T2.TripNumber
-- WHERE T2.StartLocationName = 'Los Angeles' AND T2.DestinationName = 'West Covina' AND T1.Date = '2024-02-02';