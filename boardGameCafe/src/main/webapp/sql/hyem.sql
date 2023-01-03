create table notice(
	noti_num number,
	noti_title varchar2(20) not null,
	noti_content clob not null,
	noti_file varchar2(50),
	noti_hit number(5) default 0 not null,
	noti_reg_date date default sysdate not null,
	constraint notice_pk primary key (noti_num)
);

create sequence notice_seq;

create table inquiry(
	inqu_num number,
	mem_num number not null,
	inqu_title varchar2(20) not null,
	inqu_content clob not null,
	inqu_file varchar2(50),
	/* 0 : 공개, 1 : 비공개 */
	inqu_hit number(5) default 0 not null,
	inqu_check number(1) default 0 not null,
	inqu_reg_date date default sysdate not null,
	constraint inquiry_pk primary key (inqu_num),
	constraint inquiry_fk foreign key (mem_num) references member(mem_num)
);

create sequence inquiry_seq;

create table inquiry_rpl(
	inqu_rpl_num number,
	inqu_num number not null,
	inqu_rpl_content clob not null,
	inqu_rpl_reg_date date default sysdate not null,
	constraint inqu_rpl_pk primary key (inpu_rpl_num),
	constraint inqu_rpl_fk foreign key (inpu_num) references inquiry(inqu_num)
);

create sequence inqu_rpl_seq;