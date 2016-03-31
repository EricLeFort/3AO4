CREATE TABLE Rock(
	`RockID` INT,
	`Name` VARCHAR(255),
	`Value` NUMERIC(15, 6) DEFAULT `UNKNOWN`,
	`Hardness` VARCHAR(255) DEFAULT `UNKNOWN`,
	`Colour` VARCHAR(255) DEFAULT `UNKNOWN`,
	`Texture` VARCHAR(255) DEFAULT `UNKNOWN`,
	`Size` VARCHAR(255) DEFAULT `UNKNOWN`,
	`Latitude` NUMERIC(15,2) DEFAULT `UNKNOWN`,
	`Longitude` NUMERIC(15,2) DEFAULT `UNKNOWN`,
	`Radius` NUMERIC(15,2) DEFAULT `UNKNOWN`,

	PRIMARY KEY `RockID`
);

CREATE TABLE User(
	`Password` VARCHAR(255) NOT NULL,
	`HistoryID` INT,

	PRIMARY KEY `Password`
);

CREATE TABLE History(
	`HistoryID` INT,
	`RockID` INT NOT NULL,
	`Date` DATE DEFAULT GETDATE() NOT NULL,

	FOREIGN KEY(`RockID`) REFERENCES Rock(`RockID`) ON DELETE CASCADE,		#Should delete all history items referencing the deleted rock.
	PRIMARY KEY('HistoryID')
);

CREATE TABLE Location(
	`Lat` INT,
	`Lon` INT,

	PRIMARY KEY (`Lat`, `Lon`)
);

#INSERT all rock data here.
#INSERT INTO Rock VALUES(0,'UNKNOWN');

#TODO ensure validity of this method, it is new to me.
delimiter $$					#Temporarily updates the delimiter to '$$' so I can use ';' within the trigger.

CREATE TRIGGER updateHistory
BEFORE UPDATE ON History
FOR EACH ROW 
BEGIN
	SET NEW.Date = OLD.Date;	#Forces all dates to remain unchanged.
END$$

delimiter;						#Restores the delimiter.