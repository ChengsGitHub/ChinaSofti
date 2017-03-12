/*
SQLyog Ultimate v10.51 
MySQL - 5.5.20 : Database - scott
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`scott` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `scott`;

/*Table structure for table `countries` */

DROP TABLE IF EXISTS `countries`;

CREATE TABLE `countries` (
  `COUNTRY_ID` varchar(255) NOT NULL,
  `COUNTRY_NAME` varchar(255) DEFAULT NULL,
  `REGION_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COUNTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `countries` */

insert  into `countries`(`COUNTRY_ID`,`COUNTRY_NAME`,`REGION_ID`) values ('CA','Canada','2'),('DE','Germany','1'),('UK','United Kingdom','1'),('US','United States of America','2');

/*Table structure for table `departments` */

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `DEPARTMENT_ID` int(11) NOT NULL,
  `DEPARTMENT_NAME` varchar(255) DEFAULT NULL,
  `MANAGER_ID` int(11) DEFAULT NULL,
  `LOCATION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `departments` */

insert  into `departments`(`DEPARTMENT_ID`,`DEPARTMENT_NAME`,`MANAGER_ID`,`LOCATION_ID`) values (10,'Administration',200,1700),(20,'Marketing',201,1800),(50,'Shipping',124,1500),(60,'IT',103,1400),(80,'Sales',149,2500),(90,'Executive',100,1700),(110,'Accounting',205,1700),(190,'Contracting',NULL,1700);

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `HIRE_DATE` date DEFAULT NULL,
  `JOB_ID` varchar(255) DEFAULT NULL,
  `SALARY` int(11) DEFAULT NULL,
  `COMMISSION_PCT` double DEFAULT NULL,
  `MANAGER_ID` int(11) DEFAULT NULL,
  `DEPARTMENT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  KEY `FK_EMP_JOB` (`JOB_ID`),
  KEY `FK_EMP_DEPT` (`DEPARTMENT_ID`),
  CONSTRAINT `FK_EMP_DEPT` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `departments` (`DEPARTMENT_ID`) ON DELETE SET NULL,
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`JOB_ID`) REFERENCES `jobs` (`JOB_ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8;

/*Data for the table `employees` */

insert  into `employees`(`EMPLOYEE_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`PHONE_NUMBER`,`HIRE_DATE`,`JOB_ID`,`SALARY`,`COMMISSION_PCT`,`MANAGER_ID`,`DEPARTMENT_ID`) values (100,'Steven','King','SKING','515.123.4567','1987-06-17','AD_PRES',24000,NULL,NULL,90),(101,'Neena','Kochhar','NKOCHHAR','515.123.4568','1989-09-21','AD_VP',17000,NULL,100,90),(102,'Lex','De Haan','LDEHAAN','515.123.4569','1993-01-13','AD_VP',17000,NULL,100,90),(103,'Alexander','Hunold','AHUNOLD','590.423.4567','1990-01-03','IT_PROG',9000,NULL,102,60),(104,'Bruce','Ernst','BERNST','590.423.4568','1991-05-21','IT_PROG',6000,NULL,103,60),(107,'Diana','Lorentz','DLORENTZ','590.423.5567','1999-02-07','IT_PROG',4200,NULL,103,60),(124,'Kevin','Mourgos','KMOURGOS','650.123.5234','1999-11-16','ST_MAN',5800,NULL,100,50),(141,'Trenna','Rajs','TRAJS','650.121.8009','1995-10-17','ST_CLERK',3500,NULL,124,50),(142,'Curtis','Davies','CDAVIES','650.121.2994','1997-01-29','ST_CLERK',3100,NULL,124,50),(143,'Randall','Matos','RMATOS','650.121.2874','1998-03-15','ST_CLERK',2600,NULL,124,50),(144,'Peter','Vargas','PVARGAS','650.121.2004','1998-07-09','ST_CLERK',2500,NULL,124,50),(149,'Eleni','Zlotkey','EZLOTKEY','011.44.1344.429018','2000-01-29','SA_MAN',10500,0.2,100,80),(174,'Ellen','Abel','EABEL','011.44.1644.429267','1996-05-11','SA_REP',11000,0.3,149,80),(176,'Jonathon','Taylor','JTAYLOR','011.44.1644.429265','1998-03-24','SA_REP',8600,0.2,149,80),(178,'Kimberely','Grant','KGRANT','011.44.1644.429263','1999-05-24','SA_REP',7000,0.15,149,NULL),(200,'Jennifer','Whalen%','JWHALEN','515.123.4444','1987-09-17','AD_ASST',4400,NULL,101,10),(201,'Michael','Hartstein','MHARTSTE','515.123.5555','1996-02-17','MK_MAN',13000,NULL,100,20),(202,'Pat','Fay\\%','PFAY','603.123.6666','1997-08-17','MK_REP',6000,NULL,201,20),(205,'Shelley','Higgins','SHIGGINS','515.123.8080','1994-06-07','AC_MGR',12000,NULL,101,110),(206,'William','Gietz/','WGIETZ','515.123.8181','1994-06-07','AC_ACCOUNT',8300,NULL,205,110);

/*Table structure for table `job_grades` */

DROP TABLE IF EXISTS `job_grades`;

CREATE TABLE `job_grades` (
  `GRADE_LEVEL` varchar(255) NOT NULL,
  `LOWEST_SAL` int(11) DEFAULT NULL,
  `HIGHEST_SAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`GRADE_LEVEL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `job_grades` */

insert  into `job_grades`(`GRADE_LEVEL`,`LOWEST_SAL`,`HIGHEST_SAL`) values ('A',1000,2999),('B',3000,5999),('C',6000,9999),('D',10000,14999),('E',15000,24999),('F',25000,40000);

/*Table structure for table `job_history` */

DROP TABLE IF EXISTS `job_history`;

CREATE TABLE `job_history` (
  `EMPLOYEE_ID` int(11) NOT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `JOB_ID` varchar(255) DEFAULT NULL,
  `DEPARTMENT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `job_history` */

insert  into `job_history`(`EMPLOYEE_ID`,`START_DATE`,`END_DATE`,`JOB_ID`,`DEPARTMENT_ID`) values (102,'1993-01-13','1998-07-24','IT_PROG',60),(101,'1989-09-21','1993-10-27','AC_ACCOUNT',110),(101,'1993-10-28','1997-03-15','AC_MGR',110),(201,'1996-02-17','1999-12-19','MK_REP',20),(114,'1998-03-24','1999-12-31','ST_CLERK',50),(122,'1999-01-01','1999-12-31','ST_CLERK',50),(200,'1987-09-17','1993-06-17','AD_ASST',90),(176,'1998-03-24','1998-12-31','SA_REP',80),(176,'1999-01-01','1999-12-31','SA_MAN',80),(200,'1994-07-01','1998-12-31','AC_ACCOUNT',90);

/*Table structure for table `jobs` */

DROP TABLE IF EXISTS `jobs`;

CREATE TABLE `jobs` (
  `JOB_ID` varchar(255) NOT NULL,
  `JOB_TITLE` varchar(255) DEFAULT NULL,
  `MIN_SALARY` int(255) DEFAULT NULL,
  `MAX_SALARY` int(255) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jobs` */

insert  into `jobs`(`JOB_ID`,`JOB_TITLE`,`MIN_SALARY`,`MAX_SALARY`) values ('AC_ACCOUNT','Public Accountant',4200,9000),('AC_MGR','Accounting Manager',8200,16000),('AD_ASST','Administration Assistant',3000,6000),('AD_PRES','President',20000,40000),('AD_VP','Administration Vice President',15000,30000),('IT_PROG','Programmer',4000,10000),('MK_MAN','Marketing Manager',9000,15000),('MK_REP','Marketing Representative',4000,9000),('SA_MAN','Sales Manager',10000,20000),('SA_REP','Sales Representative',6000,12000),('ST_CLERK','Stock Clerk',2000,5000),('ST_MAN','Stock Manager',5500,8500);

/*Table structure for table `locations` */

DROP TABLE IF EXISTS `locations`;

CREATE TABLE `locations` (
  `LOCATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STREET_ADDRESS` varchar(255) DEFAULT NULL,
  `POSTAL_CODE` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `STATE_PROVINCE` varchar(255) DEFAULT NULL,
  `COUNTRY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LOCATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2501 DEFAULT CHARSET=utf8;

/*Data for the table `locations` */

insert  into `locations`(`LOCATION_ID`,`STREET_ADDRESS`,`POSTAL_CODE`,`CITY`,`STATE_PROVINCE`,`COUNTRY_ID`) values (1400,'2014 Jabberwocky Rd','26192','Southlake','Texas',0),(1500,'2011 Interiors Blvd','99236','South San Francisco','California',0),(1700,'2004 Charade Rd','98199','Seattle','Washington',0),(1800,'460 Bloor St. W.','ON M5S 1X8','Toronto','Ontario',0),(2500,'Magdalen Centre, The Oxford Science Park','OX9 9ZB','Oxford','Oxford',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
