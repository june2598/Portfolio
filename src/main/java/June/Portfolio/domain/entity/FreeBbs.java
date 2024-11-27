package June.Portfolio.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FreeBbs {
  private Long postId;                //POST_ID	NUMBER(10,0)
  private String writer;              //WRITER	VARCHAR2(30 BYTE)
  private String title;               //TITLE	VARCHAR2(100 BYTE)
  private String contents;            //CONTENTS	CLOB
  private LocalDateTime cdate;        //CDATE	TIMESTAMP(6)
  private LocalDateTime udate;        //UDATE	TIMESTAMP(6)
  private Long views;                 //VIEWS	NUMBER
}
