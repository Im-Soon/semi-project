create table reserve(
 res_num number,
 mem_num number,
 res_date varchar2(10) not null,
 res_time varchar2(8) not null,
 res_count varchar2(8) not null
 room_num varchar2(30) not null,
 reg_date date default sysdate not null,
 modify_date date,
 constraint reserve_pk primary key(res_num),
 constraint zmember_detail_fk foreign key(mem_num) references zmember (room_num)
);

create sequence reserve_seq;