drop table IF exists TBL_SHOWTIME;
drop table IF exists TBL_SHOWTIME_MOVIE;



CREATE TABLE TBL_SHOWTIME (id IDENTITY PRIMARY KEY NOT NULL,
   date_at TIMESTAMP);

CREATE TABLE TBL_SHOWTIME_MOVIE (id IDENTITY PRIMARY KEY NOT NULL,
   SHOWTIME_ID INT,
   movie_id INT);

insert into TBL_SHOWTIME(id,date_at) values (1,'2021-09-05');
insert into TBL_SHOWTIME(id,date_at) values (2,'2021-09-05');
insert into TBL_SHOWTIME(id,date_at) values (3,'2021-09-05');
insert into TBL_SHOWTIME(id,date_at) values (4,'2021-09-05');

insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (5,1,1);
insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (6,1,3);

insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (7,2,2);
insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (8,2,3);
insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (9,2,4);

insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (10,3,5);
insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (11,3,6);
insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (12,3,7);

insert into TBL_SHOWTIME_MOVIE(id,SHOWTIME_ID,movie_id) values (13,4,5);