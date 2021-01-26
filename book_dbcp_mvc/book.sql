create table bookTBL(
	code number(4) PRIMARY key,
	title nvarchar2(50) not null,
	writer nvarchar2(20) not null,
	price number(8) not null
);
select * from bookTBL;
drop table bookTBL;

insert into bookTBL values(1001,'이것이 자바다','신용균',28000);
insert into bookTBL values(1002,'자바의 신','강신용',29000);
insert into bookTBL values(1003,'자바 1000제','김용만',27000);
insert into bookTBL values(1004,'오라클로 배우는 데이터베이스 입문','김진수',32000);