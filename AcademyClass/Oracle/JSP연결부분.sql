desc member

create table member(
  name VARCHAR2(10),
  userid VARCHAR2(10),
  pwd VARCHAR2(10),
  email VARCHAR2(20),
  phone char(13),
  admin NUMBER(1) default 0, --0:����� 1:������
  primary key(userid));

insert into member 
values('ȫ�浿','hong','1234','hong@naver.com',
        '010-5555-3333',0);
insert into member 
values('�̼���','lee','1234','lee@gmail.com',
        '010-2222-3333',0);
insert into member 
values('������','you','1234','you@yahoo.com',
        '010-7777-3333',1);
insert into member 
values('������','kang','1234','kang@daum.net',
        '010-3333-1234',1);        
SELECT   *
FROM member;

commit;

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
VALUES (board_seq.nextval, '������','raccon@naver.com','3333','����� ����','�Ͻ��Դϴ�.');
insert into board(num, name, email, pass, title, content)
VALUES (board_seq.nextval, '������','one@naver.com','1111','������','���������� ���ֽ��ϴ�.');

commit;