CREATE TABLE productTBL(

	num NUMBER(8),
	
	category VARCHAR2(20) NOT NULL,
	name VARCHAR2(50) NOT NULL,
	content VARCHAR2(3000) NOT NULL,
	psize VARCHAR2(10) NOT NULL,
	color VARCHAR2(20) NOT NULL,
	
	amount NUMBER(8) NOT NULL,
	price NUMBER(8) NOT NULL,
	
	uploadDate DATE DEFAULT sysdate
	
	);
	
	ALTER TABLE productTBL ADD CONSTRAINT pk_productTBL PRIMARY KEY(num);
	
	CREATE SEQUENCE prod_seq;
	
	select * from productTBL;
	
	insert into productTBL(num, category, name, content, psize, color, amount, price, uploadDate) values(1, '아웃도어', '테스', '확인', 'L', '검정', 2, 3000, sysdate);