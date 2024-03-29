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
VALUES (board_seq.nextval, '������','pinksung@naver.com','1234','ù�湮','�ݰ����ϴ�.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '������','pinksung@naver.com','1234','���','���־��.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '������','raccon@naver.com','3333','���� ����','�Ͻ��Դϴ�.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '������','one@naver.com','1111','������','���������� ���ֽ��ϴ�.');

commit;
