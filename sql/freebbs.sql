--bbs 테이블 삭제
drop table freebbs;
--bbs_id 시퀀스 삭제
drop sequence freebbs_post_id_seq;

--bbs 테이블 생성
CREATE TABLE freebbs (
    post_id number(10) primary key,
    writer varchar2(30) not null,
    title varchar2(100) not null,
    contents clob not null,
    cdate timestamp default systimestamp,
    udate timestamp,
    views number default 0
);

create or replace trigger update_udate      //create 혹은 replace 트리거 : udate를 업데이트 하라
before update on freebbs
for each row                                //업데이트 되는 각 행에 대해 트리거가 실행됨
begin
    :NEW.udate := systimestamp;             //업데이트 되는 행의 udate필드를 현재 시간으로 설정
end;
/
--시퀀스 생성
create sequence freebbs_post_id_seq;

insert into freebbs (post_id,writer,title,contents,cdate, udate, views)
            values(freebbs_post_id_seq.nextval,'작성자1','제목1','내용1',sysdate, null, 0);
insert into freebbs (post_id,writer,title,contents,cdate, udate, views)
            values(freebbs_post_id_seq.nextval,'작성자2','제목2','내용2',sysdate, null, 0);
insert into freebbs (post_id,writer,title,contents,cdate, udate, views)
            values(freebbs_post_id_seq.nextval,'작성자3','제목3','내용3',sysdate, null, 0);
insert into freebbs (post_id,writer,title,contents,cdate, udate, views)
            values(freebbs_post_id_seq.nextval,'작성자4','제목4','내용4',sysdate, null, 0);
insert into freebbs (post_id,writer,title,contents,cdate, udate, views)
            values(freebbs_post_id_seq.nextval,'작성자5','제목5','내용5',sysdate, null, 0);

commit;