create table book(
    bookId serial primary key,
    bookName varchar (100),
    pageNumber int ,
    topic topic [] ,
    realiseDate date
);



insert into book (bookName , pageNumber , topic.topic_name ,realiseDate) values ('dinitra' , 150 ,array['romance','comedy'] ,'1998-05-12'),
 ('lova' , 200 ,array['comedy','comedy'], '1995-04-02'), 
 ('romeo et julliette' , 200 ,array['other'], '2000-05-01');