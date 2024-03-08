DROP table boards;

create table boards (
    bno             number          primary key,
    btitle          varchar2(100)   not null,
    bcontent        clob            not null,
    bwriter         varchar2(50)    not null,
    bdate           date            default sysdate,
    bfilename       varchar2(50)    null,
    bfiledata		blob			null
);
CREATE SEQUENCE SEQ_BNO NOCACHE;
INSERT INTO boards VALUES
(SEQ_BNO.NEXTVAL,'눈오는 날','함박눈이 내려요','winter',sysdate,'snow.jpg','');

--create table users (
--    userid         varchar2(50)    null,
--    username       varchar2(50)    null,
--    userpassword   number          null,
--    userage        varchar2(50)    null,
--    useremail      varchar2(50)    null
--);
--CREATE SEQUENCE 

select sum(comm) from emp;
select avg(sal) from emp;
select max(sal), min(sal) from emp;
select max(sal) from emp;
select ename, sal from emp where sal=(select max(sal)from emp);
select max(hiredate)"최근입사일",min(hiredate)"최초입사일" from emp;

select count(*), count(comm) from emp;
select count(comm) "사원수" from emp where deptno = 30;
select * from dept;

select count(job) "업무수" from emp;
select count(distinct job) "업무수" from emp;

select distinct deptno from emp;
select deptno from emp group by deptno;
select deptno, avg(sal) from emp group by deptno;

select deptno, max(sal), min(sal) from emp group by deptno;
select deptno, count(*), count(comm) from emp group by deptno;

select deptno, avg(sal) from emp group by deptno having avg(sal) >= 2000;
select deptno, max(sal), min(sal) from emp group by deptno having max(sal) > 2900;

select max(sal) "Maximum", min(sal)"Minimum",sum(sal)"Sum",Round(avg(sal))"Average" from emp;
select job"Job", max(sal) "Maximum", min(sal)"Minimum",sum(sal)"Sum",Round(avg(sal))"Average" from emp group by job;
select count(*), job from emp group by job;
select count(*) "COUNT(MANAGER)", job from emp group by job;
select max(sal)-min(sal) "DIFFERENCE" from emp;

select job, min(sal) from emp group by job having min(sal) > 2000;
select job, min(sal) from emp where mgr is not null group by job having not min(sal) < 2000 order by min(sal) desc;

select deptno "DNO", count(*)"Number of People", Round(avg(sal),2)"Salary" from emp group by deptno;

select decode (deptno, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS')"dname", 
       decode (deptno, 10,'NEW YORK', 20,'DALLAS',30,'CHICAGO',40,'BOSTON')"Location",
       count(*)"Number of People",avg(sal)"Salary" from emp group by deptno;
       
select job,
       sum(decode(deptno, 10, sal))"부서 10",
       sum(decode(deptno, 20, sal))"부서 20",
       sum(decode(deptno, 30, sal))"부서 30",
       sum(sal)"총액"
       from emp group by job;
       
select deptno from emp where ename = 'SCOTT';
select * from dept where deptno = 20;
select * from emp,dept;
select * from emp,dept where emp.deptno = dept.deptno;
select ename, dname from emp, dept where emp.deptno = dept.deptno and ename = 'SCOTT';
select ename, dname deptno from emp,dept where emp.deptno = dept.deptno and ename ='SCOTT';
select emp.ename, dept.dname, emp.deptno from emp,dept where emp.deptno = dept.deptno and ename ='SCOTT';

select ename, sal from emp e,dept d where e.deptno = d.deptno and loc='NEW YORK';
select ename, hiredate from emp e, dept d where e.deptno = d.deptno and dname = 'ACCOUNTING';
select ename, dname from emp e, dept d where e.deptno = d.deptno and job = 'MANAGER';

select * from salgrade;
select ename, sal, grade from emp, salgrade where sal between losal and hisal;

select ename, mgr from emp where ename='SMITH';
select e2.empno, e2.ename from emp e1, emp e2 where e1.mgr = e2.empno and e1.ename= 'SMITH';

select e1.ename, e1.job from emp e1, emp e2 where e1.mgr = e2.empno and e2.ename = 'KING';
select e1.ename, e2.ename from emp e1, emp e2 where e1.deptno = e2.deptno and e1.ename = 'SCOTT';

select e1.ename, e2.empno as"관리자사번", e2.ename as "관리자이름" from emp e1, emp e2 where e1.mgr = e2.empno(+);

select employee.ename || '의 매니저는' || manager.ename || '입니다' from emp employee, emp manager where employee.mgr = manager.empno(+);

select * from emp;
select * from dept;
select e.ename, d.deptno, d.dname from emp e, dept d where e.deptno(+) = d.deptno;

select * from emp cross join dept;

select ename, dname from emp inner join dept on emp.deptno = dept.deptno where ename = 'SCOTT';
select ename, dname from emp inner join dept using(deptno);
select ename, dname from emp natural join dept;


CREATE TABLE dept01 (
    deptno NUMBER(2),
    dname VARCHAR2(14)
);
INSERT INTO dept01 VALUES (10, 'ACCOUNTING');
INSERT INTO dept01 VALUES (20, 'RESEARCH');

CREATE TABLE dept02 (
    deptno NUMBER(2),
    dname VARCHAR2(14)
);
INSERT INTO dept02 VALUES (10, 'ACCOUNTING');
INSERT INTO dept02 VALUES (30, 'SALES');

select * from dept01 left outer join dept02 using(deptno);
select * from dept01 right outer join dept02 using(deptno);
select * from dept01 full outer join dept02 using(deptno);

desc users
create table users (
	userid          varchar2(50)	primary key, 
	username		varchar2(50)	not null,
	userpassword	varchar2(50)	not null,
	userage			number(3)	    not null,
	useremail		varchar2(50)	not null
);

select ename, sal from emp where sal>(select avg(sal) from emp);

select ename, sal, job from emp where sal >= any(select sal from emp where job = 'SALESMAN') and job <> 'SALESMAN';

select dname from dept where deptno = (select deptno from emp where ename ='SCOTT');
select ename, sal from emp where sal > (select avg(sal) from emp);

select e2.ename, e2.job from emp e1, emp e2 where e1.empno = 7788 and e1.job = e2.job and e2.empno != 7788;

select ename, job from emp where job = (select job from emp where empno = 7788) and empno != 7788;
select ename, job from emp where sal > (select sal from emp where empno = 7499) and empno != 7499;
select ename, job, sal from emp where sal = (select min(sal) from emp);
select job, avg(sal) as average_salary from emp group by job having avg(sal) = (select min(avg_sal) from(select avg(sal) as avg_sal from emp group by job));
select e.ename, e.sal, e.deptno from emp e join(select deptno, min(sal) as min_salary from emp group by deptno) min_sal_emp on e.deptno = min_sal_emp.deptno and e.sal = min_sal_emp.min_salary;
select empno, ename, job from emp where sal < (select min(sal) from emp where job = 'ANALYST') and job != 'SALESMAN';
select ename from emp where mgr is null;
select distinct mgr from emp where mgr is not null;
select ename, hiredate from emp where deptno = (select deptno from emp where ename = 'BLAKE') and ename != 'BLAKE';
select empno, ename from emp where sal > (select avg(sal) from emp) order by sal asc;
select empno, ename, deptno from emp where deptno in (select deptno from emp where ename like'%K%');
select ename, deptno, job from emp where deptno in (select deptno from dept where loc='DALLAS');
select ename,job from emp where empno in(select mgr from emp where mgr is not null) and job <>'MANAGER';

select * from emp;
select rowid, empno, ename from emp;
insert into emp values(8000, 'MICHALE', 'ARTIST',7839, TO_DATE('90-01-01','YY-MM-DD'),4000,600,40);


drop table sam02;
create table sam02(
    year01 interval year(4) to month);
desc sam02
insert into sam02 
    values(interval '48' month(4));
select * from sam02;
select year01, sysdate, sysdate+year01 from sam02;

create table sam03(
    day01 interval day(3) to second);
insert into sam03
values(interval '100' day(3));
select * from sam03;
select day01, sysdate, sysdate+day01 from sam03;

create table emp01(
empno number(4),
ename varchar2(20),
sal number(7,2));
drop table dept01;
create table dept01(
deptno number(2),
dname varchar2(14),
loc varchar2(13));

create table emp02
as
select * from emp;
desc emp02

create table emp03
as
select empno, ename from emp;
desc emp03
create table emp04
as
select empno, ename from emp where 1=0; 
select * from emp04;
desc emp04

create table emp05
as 
select * from emp
where deptno =10;

create table dept20
as
select empno, ename, sal*12 annsal
from emp
where deptno=20;

drop table dept02;
create table dept02
as
select deptno, dname, loc 
from dept
where 1=0;
desc dept02
desc emp01

alter table emp01
add(job varchar(9));

alter table dept02
add(dngr number(4));

alter table emp01
modify(job varchar2(30));

alter table dept02
modify(dngr varchar2(15));
select * from dept02;
insert into dept02
values(10, 'reserch','paris','kim');
alter table dept02
modify(dngr number(4));
delete from dept02;
desc dept02

alter table dept02
drop column dngr;

alter table emp01
drop column job;

alter table emp02
set unused(job);
alter table emp02
drop unused columns;
drop table emp01;
select * from emp02;
delete from emp02 where deptno =20;
truncate table emp02;
desc emp02

drop table test;
rename emp02 to test;

desc user_tables;
show user
desc all_tables;
select table_name from all_tables
order by owner desc;