create table cart(
	cart_num number not null,
	mem_num number not null,
	pro_num number not null,
	cart_count number(5) not null,
	constraint cart_pk primary key (cart_num),
	constraint cart_fk1 foreign key (mem_num)
							references member (mem_num),
	constraint cart_fk2 foreign key (pro_num)
							references product (pro_num)
);

create sequence cart_seq;