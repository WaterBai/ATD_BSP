create database atd;

use atd;

DROP TABLE IF EXISTS 'user';  
  
CREATE TABLE user (  
  id int(11) NOT NULL AUTO_INCREMENT,  
  username varchar(40) NOT NULL,  
  password varchar(255) NOT NULL,  
  age int(4) NOT NULL,  
  PRIMARY KEY (id)  
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into user(id,username,password,age) values (1,'测试','sfasgfaf',24);  