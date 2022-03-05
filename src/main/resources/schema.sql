CREATE TABLE `rb_user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
);


CREATE TABLE `employee_master` (
  `emp_aadhar` varchar(20) NOT NULL,
  `emp_first_name` varchar(45) NOT NULL,
  `emp_midldle_name` varchar(45) DEFAULT NULL,
  `emp_last_name` varchar(45) DEFAULT NULL,
  `emp_address` varchar(250) DEFAULT NULL,
  `emp_phone` varchar(15) DEFAULT NULL,
  `emp_alternate_phone` varchar(15) DEFAULT NULL,
  `emp_age` varchar(15) DEFAULT NULL,
  `emp_sex` varchar(10) DEFAULT NULL,
  `emp_marital_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`emp_aadhar`)
);
