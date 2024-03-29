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
'������ ���� ����ִ� �����ͺ��̽�',27000,'db.jpg',
'�����ͺ��̽��� ���� ��� ���� ���� ����ְ� ������ ����');
INSERT INTO product VALUES( product_seq.nextval,
'HTML5���α׷��� �Թ�',26000,'html5.jpg',
'�� ���α׷����� ó�� ���� ���ڸ� ���� �Թ���');
INSERT INTO product VALUES( product_seq.nextval,
'Oracle 11g ���α׷���',23000,'oracle.jpg',
'�����ͺ��̽��� ���� �������� ����� �Բ� SQL�� ó�� �����ϴ� �ʺ��ڸ� ������� ������ å');

INSERT INTO product VALUES( product_seq.nextval,
'java�� ����',27000,'java.jpg',
'�ڹ� ���α׷��ӷν� �ݵ�� �˾ƾ��ϴ� ���� ��� ����å.
���ڴ� �ڹٸ� �Ұ��ϴµ� ��ġ�� �ʰ� ���α׷��ӷν� �� �˾ƾ��ϴ� ������� ü�������� ����');

INSERT INTO product VALUES( product_seq.nextval,
'�� �����̳ʸ� ���� jQuery',22500,'jquery.jpg',
'���α׷��ֿ� ���� �����̳ʰ� jQuery�� �� �� �� �ֵ��� �����ִ� å');

COMMIT;
select * from product;