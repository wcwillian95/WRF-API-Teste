create database wrcfilmes

use wrcfilmes

create table filme(
id int primary key auto_increment,
original_title varchar(255),
title  varchar(255),
original_language varchar(5),
overview  varchar(255),
poster_path varchar(255),
release_date date,
vote_average double,
media_type varchar(25)
)