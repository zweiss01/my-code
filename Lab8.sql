--  Zach Weiss
--  11/11/2020
--  Lab 8
--  Prof. Labouseur

DROP TABLE IF EXISTS ActorMovies;
DROP TABLE IF EXISTS DirectorMovies;
DROP TABLE IF EXISTS Actors;
DROP TABLE IF EXISTS Directors;
DROP TABLE IF EXISTS People;
DROP TABLE IF EXISTS Zipcode;
DROP TABLE IF EXISTS Movies; -- makes sure we do not try to repeat tables

-- Zipcode --
CREATE TABLE Zipcode (
   zip     text not null,
   city    text,
   state   text,
   country text,
 primary key(zip)
); -- the zipcode table makes sure we are in BCNF by avoiding multiple key dependencies

-- People --
CREATE TABLE People (
   pid                int not null,
   firstName          text,
   lastName           text,
   addr1              text,
   addr2              text,
   zip                text ,
   spouseName         text,
   guildAnniversary   date,
 primary key(pid)
);

-- Actors --
CREATE TABLE Actors (
   pid          int not null references People(pid),
   hairColor    text,
   eyeColor     text,
   height       numeric(4, 2),
   weight       numeric(5, 2),
   DOB          date,
   favColor     text,
 primary key(pid)
);

-- Directors --
CREATE TABLE Directors (
   pid            int not null references People(pid),
   filmSchool     text,
   favLensMaker   text,
 primary key(pid)
);

-- Movies --
CREATE TABLE Movies (
  movId              int not null,
  name               text,
  yearReleased       text,
  mpaaNumber         int,
  boxOfficeDomestic  numeric(11,2),
  foreignBoxOffice   numeric(11,2),
  DVD_BluRaySales    numeric(11,2),
 primary key(movId)
);

-- ActorMovies --
CREATE TABLE ActorMovies (
   actorId    int not null references People(pid),
   movieId    int not null references Movies(movId),
 primary key(actorId, movieId)
); 

-- this associative entity avoids many to many relationships, as does DirectorMovies

-- DirectorMovies --
CREATE TABLE DirectorMovies (
   directorId   int not null references People(pid),
   movieId      int not null references Movies(movId),
 primary key(directorId, movieId)
);


-- SQL statements for loading example data

-- People --
INSERT INTO People (pid, firstName, lastName, addr1, 
					addr2, zip, spouseName, guildAnniversary)
VALUES
 (001, 'Andrew', 'McLaglen', '67 A4200',        '', 'WC1B 4BA', 'Sheila Greene',      '1994-06-01'),
 (002, 'Ewan',  'McGregor', '39 Victoria St',   '', 'PH1 5EH',  '',                   '1993-09-12'),
 (003, 'Roger', 'Moore',    '37 Viceroy Rd',    '', 'SW8 2HA',  'Kristina Tholstrup', '1945-02-13'),
 (004, 'Lewis', 'Gilbert',  '38 Pembury Rd',    '', 'N17 8LY',  'Hylda Tafler',       '1925-06-10')
;

-- Actors --
INSERT INTO Actors (pid, hairColor, eyeColor, height, weight, DOB, favColor)
VALUES
 (002, 'brown', 'blue', 70.12, 175.00, '1971-03-31', 'blue'),
 (003, 'brown', 'blue', 73.00, 175.00, '1927-10-14', 'red')
;

-- Directors --
INSERT INTO Directors (pid, filmSchool, favLensMaker)
VALUES
 (001, 'Cates School',  'Nikon'),
 (004, '',              'Sony')
;

-- Products --
INSERT INTO Movies(movId, name, yearReleased, mpaaNumber, boxOfficeDomestic, 
				   foreignBoxOffice, DVD_BluRaySales)
VALUES
(001, 'The Spy Who Loved Me', 1977,  24822, 46800000.00, 138600000, 900000),
(002, 'North Sea Hijack',     1980,  25789, 805000.00, 0, 0)
;

-- ActorMovies --
INSERT INTO ActorMovies(actorId, movieId)
VALUES
(003, 001),
(003, 002)
;

-- DirectorMovies --
INSERT INTO DirectorMovies(directorId, movieId)
VALUES
(001, 002),
(004, 001)
;

-- Zipcode --
INSERT INTO Zipcode(zip, city, state, country)
VALUES
('WC1B 4BA', 'Southampton Row', '', 'England'),
('PH1 5EH',  'Perth',           '', 'Scotland'),
('SW8 2HA',  'Viceroy Road',    '', 'England'),
('N17 8LY',  'Pembury Road',    '', 'England')
;

-- SQL statement for all directors with whom Roger Moore has worked 

select firstName, lastName
from People -- gets first and last name of director from people
where pid in (select pid
			   from Directors -- gets director data for use
			  where pid in (select directorId
						     from DirectorMovies -- checks for directors who have directed a movie
						    where movieId in (select movieId
											   from ActorMovies -- checks for the movies where the actor and director
											                    --    were a part of the same movie
											  where actorId = 003)));
