CREATE TABLE "ROOM" (
	"ROOM_NUM"	NUMBER		NOT NULL,
	"ROOM_SIZE"	NUMBER(2)		NOT NULL,
	"ROOM_DETAIL"	VARCHAR2(150)		NOT NULL,
	"ROOM_NAME"	VARCHAR2(30)		NOT NULL,
	CONSTRAINT ROOM_PK PRIMARY KEY (ROOM_NUM)
);

CREATE TABLE "RESERVE" (
	"RES_NUM"	NUMBER		NOT NULL,
	"MEM_NUM"	NUMBER		NOT NULL,
	"RES_DATE"	VARCHAR2(10)		NOT NULL,
	"RES_TIME"	VARCHAR2(8)		NOT NULL,
	"RES_COUNT"	NUMBER(2)		NOT NULL,
	"ROOM_NUM"	NUMBER		NOT NULL,
	CONSTRAINT RESERVE_PK PRIMARY KEY (RES_NUM),
	CONSTRAINT RESERVE_FK1 FOREIGN KEY (MEM_NUM) REFERENCES MEMBER_DETAIL (MEM_NUM),
	CONSTRAINT RESERVE_FK2 FOREIGN KEY (ROOM_NUM) REFERENCES ROOM (ROOM_NUM)
);
