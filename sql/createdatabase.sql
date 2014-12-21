CREATE DATABASE sample CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE sample_test CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'sample_u'@'%' IDENTIFIED by 'sample_p';
GRANT ALL PRIVILEGES ON sample.* TO 'sample_u'@'%' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON sample_test.* TO 'sample_u'@'%' WITH GRANT OPTION;
CREATE USER 'sample_u'@'localhost' IDENTIFIED by 'sample_p';
GRANT ALL PRIVILEGES ON sample.* TO 'sample_u'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON sample_test.* TO 'sample_u'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;