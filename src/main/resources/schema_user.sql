CREATE TABLE IF NOT EXISTS `sf_user`
(
    id            BIGINT not null auto_increment primary key,
    description   varchar(255) null,
    password      varchar(255) null,
    role          varchar(255) null,
    url           varchar(255) null,
    username      varchar(255) null,
    base_password varchar(255) null
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;
