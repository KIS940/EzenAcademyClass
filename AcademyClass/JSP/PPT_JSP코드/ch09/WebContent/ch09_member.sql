DROP TABLE member;

CREATE TABLE member(
name VARCHAR2 (30),
userid varchar2(30),
pwd VARCHAR2(20),
email VARCHAR2(30),
phone CHAR(13),
admin NUMBER(1) default 0,
primary key(userid));

insert into member values('ÀÌ¼ø½Å','sslee','1234','sslee@naver.com','010-2362-5157',0);
insert into member values('À±ºÀ±æ','bkyoon','1234','bkyoon@naver.com','010-1234-1234',0);
insert into member values('°­°¨Âù','kckang','1234','kckang@naver.com','010-4321-4321',0);

COMMIT;
select * from member;