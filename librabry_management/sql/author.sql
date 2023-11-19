create table author (
    authorId serial primary key,
    authorName varchar (200),
    sex char check (sex = 'M ' or sex = 'F')
);

insert into author (authorName , sex) values ('rado','m'), ('shakespear' , 'm') , ('jj rabearivelo' , 'm');