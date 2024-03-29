drop table product;
drop sequence product_seq;
CREATE TABLE product(
code NUMBER(4),
name VARCHAR2(100),
price NUMBER(8),
pictureurl VARCHAR2(50),
description VARCHAR2(1000),
PRIMARY KEY (code));

create sequence product_seq start with 1 increment by 1;

INSERT INTO product VALUES( product_seq.nextval,
'개념을 콕콕 잡아주는 데이터베이스',27000,'db.jpg',
'데이터베이스에 관한 모든 것을 쉽고 재미있게 정리한 교재');
INSERT INTO product VALUES( product_seq.nextval,
'HTML5프로그래밍 입문',26000,'html5.jpg',
'웹 프로그래밍을 처음 배우는 독자를 위한 입문서');
INSERT INTO product VALUES( product_seq.nextval,
'Oracle 11g 프로그래밍',23000,'oracle.jpg',
'데이터베이스에 대한 전반적인 개념과 함께 SQL을 처음 공부하는 초보자를 대상으로 구성한 책');

INSERT INTO product VALUES( product_seq.nextval,
'java의 정석',27000,'java.jpg',
'자바 프로그래머로써 반드시 알아야하는 것을 모두 담은책.
저자는 자바를 소개하는데 그치지 않고 프로그래머로써 꼭 알아야하는 내용들을 체계적으로 정리');

INSERT INTO product VALUES( product_seq.nextval,
'웹 디자이너를 위한 jQuery',22500,'jquery.jpg',
'프로그래밍에 약한 디자이너가 jQuery를 잘 쓸 수 있도록 도와주는 책');

COMMIT;
select * from product;