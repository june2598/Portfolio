package June.Portfolio.domain.freebbs.dao;

import June.Portfolio.domain.entity.FreeBbs;

import java.util.List;
import java.util.Optional;

public interface FreeBbsDAO {

  //게시글 등록
  Long save(FreeBbs freeBbs);

  //게시글 전체 목록
  List<FreeBbs> getAllPost();

  //게시글 목록(페이징 구현)

  //게시글 조회
  //Optional 클래스 : null 안정성을 높임 (게시글 조회시 null일수도있기때문)
  Optional<FreeBbs> findById(Long postId);


  //게시글 수정
  //게시글 수정하려면 게시글 아이디, 실제 수정할내용은 FreeBbs 객체
  int updateById(Long postId, FreeBbs freeBbs);

  //게시글 단건 삭제
  int deleteById(Long postId);

  //게시글 여러건 삭제
  int deleteByIds(List<Long> postIds);

  //게시글 총 숫자 조회
  int getTotalRecords();
}
