CREATE TABLE "ORDER_MAIN" (
	"ORDER_MAIN_NUM"	NUMBER		NOT NULL,
	"MEM_NUM"	NUMBER		NOT NULL,
	"ORDER_MAIN_NAME"	VARCHAR2(600)		NOT NULL,
	"ORDER_MAIN_TOTAL"	NUMBER(7)		NOT NULL,
	"PAYMENT"	NUMBER(1)		NOT NULL,
	"ORDER_MAIN_DATE"	DATE		NOT NULL,
	"MEM_ZIPCODE"	VARCHAR2(5)		NOT NULL,
	"MEM_ADDRESS1"	VARCHAR2(50)		NOT NULL,
	"MEM_ADDRESS2"	VARCHAR2(50)		NOT NULL,
	"MEM_PHONE"	VARCHAR2(15)		NOT NULL,
	CONSTRAINT ORDER_MAIN_PK PRIMARY KEY (ORDER_MAIN_NUM),
	CONSTRAINT ORDER_MAIN_FK FOREIGN KEY (MEM_NUM) REFERENCES MEMBER_DETAIL (MEM_NUM)
);

CREATE TABLE "ORDER_DETAIL" (
	"ORDER_DETAIL_NUM"	NUMBER		NOT NULL,
	"ORDER_MAIN_NUM"	NUMBER		NOT NULL,
	"PRO_NAME"	VARCHAR2(50)		NOT NULL,
	"PRO_PRICE"	NUMBER(8)		NOT NULL,
	"PRO_TOTAL"	NUMBER(8)		NOT NULL,
	"PRO_COUNT"	NUMBER(7)		NOT NULL,
	"STATUS"	NUMBER(1)	DEFAULT 0	NOT NULL,
	CONSTRAINT ORDER_DETAIL_PK PRIMARY KEY (ORDER_DETAIL_NUM),
	CONSTRAINT ORDER_DETAIL_FK FOREIGN KEY (ORDER_MAIN_NUM) REFERENCES ORDER_MAIN (ORDER_MAIN_NUM)
);

CREATE SEQUENCE ORDER_MAIN_SEQ;
CREATE SEQUENCE ORDER_DETAIL_SEQ;