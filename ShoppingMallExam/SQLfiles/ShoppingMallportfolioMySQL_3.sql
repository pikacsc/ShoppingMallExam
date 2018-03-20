--샘플데이터 입력

insert into worker values('admin','admin','홍관리','010-5555-5555');
insert into worker values('ccc11203','ccc11203','최성찬','010-3145-5255');

insert into member (id, pwd, name, zip_num, address, phone) values('one', '1111', '김나리', '133-110', 
'서울시성동구성수동1가 1번지21호','010-7584-1313');

insert into member (id, pwd, name, zip_num, address, phone) values('two', '2222', '이백함', '130-120', 
'서울시송파구잠실2동 리센츠 아파트 201동 505호','011-1334-4213');






insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
default, '크로그다일부츠', '2', '40000', '50000', '10000', '오지니랄 크로그다일부츠 입니다.', 'w2.jpg');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
default, '롱부츠', '2', 40000, 50000, 10000,'따뜻한 롱부츠 입니다.', 'w-28.jpg', 'n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) values( 
default, '힐', '1', '10000', '12000', '2000', '여성용전용 힐', 'w-26.jpg', 'n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) values(
default, '슬리퍼', '4', '5000', '5500', '500', '편안한 슬리퍼입니다.', 'w-25.jpg', 'y');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) values(
default, '회색힐', '1', '10000', '12000', '2000', '여성용전용 힐', 'w9.jpg', 'n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image) values(
default, '여성부츠', '2', '12000', '18000', '6000', '여성용 부츠', 'w4.jpg');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) values(
default,  '핑크샌달', '3', '5000', '5500', '500', '사계절용 샌달입니다.', 'w-10.jpg', 'y');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) values(
default, '슬리퍼', '3', '5000', '5500', '500', '편안한 슬리퍼입니다.', 'w11.jpg', 'y');
insert into product(pseq,  name, kind, price1, price2, price3, content, image) values(
default,  '스니커즈', '4', '15000', '20000', '5000', '활동성이 좋은 스니커즈입니다.', 'w1.jpg');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) values(
default,  '샌달', '3', '5000', '5500', '500', '사계절용 샌달입니다.', 'w-09.jpg','n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) values(
default,  '스니커즈', '5', '15000', '20000', '5000', '활동성이 좋은 스니커즈입니다.', 'w-05.jpg','n');



insert into cart(cseq,id,pseq,quantity) values(default,'one',1,1);



insert into orders(oseq, id) values(default, 'one');
insert into orders(oseq, id) values(default, 'one');
insert into orders(oseq, id) values(default, 'two');



insert into order_detail(obseq, oseq, pseq, quantity)
values(default,1,1,1);


insert into order_detail(obseq, oseq, pseq, quantity)
values(default,1,2,5);


insert into order_detail(obseq, oseq, pseq, quantity)
values(default,2,4,3);

insert into order_detail(obseq, oseq, pseq, quantity)
values(default,3,3,1);



insert into order_detail(obseq, oseq, pseq, quantity)
values(default,3,2,1);


insert into order_detail(obseq, oseq, pseq, quantity)
values(default,3,6,2);


insert into order_detail(obseq, oseq, pseq, quantity)
values(default,3,1,2);





insert into qna (qseq, subject, content, id)
values(default, '테스트', '질문내용1', 'one');
update qna SET reply='답변내용', rep='2';

insert into qna (qseq, subject, content, id)
values(default, '테스트2', '질문내용2', 'one');
commit;




-- select * from order_detail;
-- select * from product;
-- select * from qna;

--뷰 생성
create or replace view cart_view
as 
select o.cseq, o.id, o.pseq, m.name mname, p.name pname,
o.quantity,o.indate,p.price2, o.result
from cart o, member m, product p
where o.id = m.id and o.pseq = p.pseq
and result = '1';



create or replace view order_view
as 
select d.obseq, o.oseq, o.id, o.indate, d.pseq, d.quantity, m.name mname,
m.zip_num, m.address, m.phone, p.name pname, p.price2, d.result
from orders o, order_detail d, member m, product p
where o.oseq=d.oseq and o.id = m.id and d.pseq = p.pseq;





commit;











