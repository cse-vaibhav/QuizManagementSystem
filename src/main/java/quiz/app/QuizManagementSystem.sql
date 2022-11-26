
CREATE DATABASE `QuizManagementSystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
use QuizManagementSystem;
-- QuizManagementSystem.Questions definition

CREATE TABLE `Questions` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Question` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Question` (`Question`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- QuizManagementSystem.Users definition

CREATE TABLE `Users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Organisation` varchar(100) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `Email` varchar(100) NOT NULL,
  `FName` varchar(100) NOT NULL,
  `LName` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Codes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Code` varchar(100) NOT NULL,
  `createdBy` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Code` (`Code`),
  KEY `Codes_FK` (`createdBy`),
  CONSTRAINT `Codes_FK` FOREIGN KEY (`createdBy`) REFERENCES `Users` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Quiz Codes';

-- QuizManagementSystem.`Options` definition

CREATE TABLE `Options` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `option` varchar(100) NOT NULL,
  `QuestionID` int NOT NULL,
  `QuizCode` int NOT NULL,
  `isCorrect` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Options_FK` (`QuestionID`),
  KEY `Options_FK_1` (`QuizCode`),
  CONSTRAINT `Options_FK` FOREIGN KEY (`QuestionID`) REFERENCES `Questions` (`ID`),
  CONSTRAINT `Options_FK_1` FOREIGN KEY (`QuizCode`) REFERENCES `Codes` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

