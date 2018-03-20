use mydb;

create table worker(
    id varchar(20) primary key,
    pwd varchar(20),
    name varchar(40),
    phone varchar(20)
);



select * from worker;


alter table member drop primary key cascade;
drop table member;


create table member(
    id varchar(20) primary key,
    pwd varchar(20),
    name varchar(40),
    email varchar(40),
    zip_num varchar(7),
    address varchar(100),
    phone varchar(20),
    useyn char(1) default 'y',
    indate datetime default CURRENT_TIMESTAMP
);


alter table product drop primary key cascade;
drop table product;
create table product(
    pseq int(5) primary key auto_increment,
    name varchar(100),
    kind char(1),
    price1 int(7) default '0',
    price2 int(7) default '0',
    price3 int(7) default '0',
    content varchar(1000),
    image varchar(50) default 'default.jpg',
    useyn char(1) default 'y',
    bestyn char(1) default 'n',
    indate datetime default current_timestamp
);











alter table cart drop primary key cascade;
drop table cart;
create table cart(

);




create table cart(
	cseq int(10) primary key auto_increment, -- 장바구니번호
    id varchar(16) REFERENCES `member` (`id`), -- 주문자 아이디(FK : member.id)
    pseq int(5) REFERENCES `product` (`pseq`), -- 주문 상품번호(FK : product.pseq)
    quantity int(5) default '1', -- 주문 수량 
    result char(1) default '1', -- 1:미처리 , 2:처리
    indate datetime default current_timestamp -- 주문일
); 



alter table orders drop primary key cascade;
drop table orders;
create table orders(
    oseq int(10) primary key auto_increment, -- 주문번호
    id varchar(16) references member(id), -- 주문자아이디
    indate datetime default current_timestamp -- 주문일
);



alter table order_detail drop primary key cascade;
drop table order_detail;
create table order_detail(
    obseq int(10) primary key, -- 주문상세번호
    oseq int(10) references orders(oseq), -- 주문번호
    pseq int(5) references product(pseq), -- 상품번호
    quantity int(5) default 1, -- 주문수량
    result char(1) default '1' -- 1:미처리 2:처리
);






-- Q&A 게시판은 고객이 쇼핑몰에서 제품의 문의사항 또는 배송문의와 같은 제반적인 사항에 대해서 질문을 하고자 할때 사용한다. 
alter table qna drop primary key cascade;
drop table qna;
create table qna(
    qseq int(5) primary key auto_increment, -- 글번호
    subject varchar(300), -- 제목
    content varchar(1000), -- 문의내용
    reply varchar(1000), -- 답변내용
    id varchar(20), -- 작성자 (FK: member.id)
    rep char(1) default '1', -- 1:답변 무 , 2:답변 유
    indate datetime default current_timestamp -- 작성일
);




commit;













