CREATE TABLE USER_TABLE(
    userid bigint(20) auto_increment not null comment 'user id', 
    username varchar(100) not null comment 'user name',
    age bigint(3) auto_increment not null comment 'user age',     
    PassWord varchar(200) NOT NULL COMMENT 'passwd', 
    Sex varchar(2) NOT NULL DEFAULT '' COMMENT 'sex',
    followerID bigint(20) auto_increment not null comment 'follower id',
    followingID bigint(20) auto_increment not null comment 'following id',
    Location varchar(100) COMMENT 'current location', 
    UserImage varchar(1024) COMMENT 'imge header',
    Label varchar(200) NOT NULL DEFAULT '0' COMMENT 'status',
    PRIMARY KEY (UserId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user table';

CREATE TABLE PICTURE_TABLE(
    id bigint(20) not null auto_increment comment 'picture id',
    Category varchar(20) NOT NULL DEFAULT '0' COMMENT 'picture Category',
    Location varchar(100) COMMENT 'upload location', 
    BeginDateTime date COMMENT 'upload time',
    SubmmitPeopleId bigint(20) NOT NULL DEFAULT '0' COMMENT 'user ID',
    Details varchar(1024) COMMENT 'picture details',
    PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='picture table';
