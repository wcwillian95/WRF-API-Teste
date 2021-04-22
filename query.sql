create database wrcfilmes

use wrcfilmes;

create table recomendados(
id varchar(255) primary key,
original_language varchar(255),
original_title varchar(255),
overview text,
poster_path varchar(255),
release_date varchar(255),
vote_average double,
media_type varchar(255),
original_name varchar(255)
)
select * from recomendados

create table filme(
varcode varchar(255) primary key ,
varrank varchar(255),
title  varchar(255),
fullTitle varchar(255),
varyear  varchar(255),
image varchar(255),
crew varchar(255),
imDbRating varchar(255),
imDbRatingCount varchar(255)
)
 select * from filme