desc board;
select * from board;
drop table board;
create table board(
num number(5) primary key,
pass VARCHAR2(30),
name VARCHAR2(30),
email VARCHAR2(30),
title VARCHAR2(50),
content VARCHAR2(1000),
readcount number(4) default 0,
writedate date      default sysdate);
drop sequence board_seq;
create sequence board_seq start with 1 increment by 1;

insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '¼ºÀ±Á¤','pinksung@naver.com','1234','Ã¹¹æ¹®','¹İ°©½À´Ï´Ù.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '¼ºÀ±Á¤','pinksung@naver.com','1234','±è¹ä','¸ÀÀÖ¾î¿ä.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, 'Àü¼öºó','raccon@naver.com','3333','°íµî¾î Á¤½Ä','ÀÏ½ÄÀÔ´Ï´Ù.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, 'Àü¿øÁÖ','one@naver.com','1111','°¹°ñ¸¶À»','µÅÁö»ï°ã»ìÀÌ ¸ÀÀÖ½À´Ï´Ù.');

commit;
