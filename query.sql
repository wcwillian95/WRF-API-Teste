create database wrcfilmes

use wrcfilmes;

create table filme(
id varchar(255) primary key ,
varrank varchar(255),
title  varchar(255),
fullTitle varchar(5),
varyear  varchar(255),
image varchar(255),
crew varchar(25),
imDbRating varchar(25),
imDbRatingCount varchar(25)
)
