CREATE TABLE `USER_TABLE` (
  `UserId` bigint(20) AUTO_INCREMENT NOT NULL COMMENT 'user ID',
  `UserName` varchar(100) NOT NULL COMMENT 'user name',     
  `PassWord` varchar(200) NOT NULL COMMENT 'passwd', 
  `Sex` varchar(2) NOT NULL DEFAULT '' COMMENT 'sex',
  `Location` varchar(100) COMMENT 'current location', 
  `UserImage` varchar(1024) COMMENT 'imge header',
  `Label` varchar(200) NOT NULL DEFAULT '0' COMMENT 'status',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user table';

CREATE TABLE `PICTURE_TABLE` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'picture ID',
  `Category` varchar(20) NOT NULL DEFAULT '0' COMMENT 'picture Category',
  `Location` varchar(100) COMMENT 'upload location', 
  `BeginDateTime` date COMMENT 'upload time',
  `SubmmitPeopleId` bigint(20) NOT NULL DEFAULT '0' COMMENT 'user ID',
  `Details` varchar(1024) COMMENT 'picture details',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='picture table';