  CREATE  TABLE user (
  user_id int NOT NULL AUTO_INCREMENT,
  create_date DATE NULL,
  userName VARCHAR(80) NOT NULL,
  password VARCHAR(80) NOT NULL,
  displayName VARCHAR(120) NULL,
  PRIMARY KEY (user_id));
  