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
VALUES (board_seq.nextval, '성윤정','pinksung@naver.com','1234','첫방문','반갑습니다.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '성윤정','pinksung@naver.com','1234','김밥','맛있어요.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '전수빈','raccon@naver.com','3333','고등어 정식','일식입니다.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '전원주','one@naver.com','1111','갯골마을','돼지삼겹살이 맛있습니다.');

commit;
