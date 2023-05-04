create schema if not exists `javase2_bedu_pw`;

CREATE USER if not exists 'pwadmin'@'localhost' identified by 'ADMIN_PW_PWD';
grant all on javase2_bedu_pw.* to 'pwadmin'@'localhost' ;


flush privileges;
