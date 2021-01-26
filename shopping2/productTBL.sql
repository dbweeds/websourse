create table productTBL(
	num number(8),
	category varchar2(20) not null,
	name varchar2(50) not null,
	content varchar2(3000) not null,
	psize varchar2(10) not null,
	color varchar2(20) not null,
	amount number(10) not null,
	price number(10) not null,
	regdate date default sysdate);


alter table productTBL add constraint pk_productTBL PRIMARY key(num);

create SEQUENCE prod_seq;

insert into productTBL values(prod_seq.nextval,'아웃도어','바람막이','생각보다좋음','큼','블루',50,50000,sysdate);

select * from productTBL;