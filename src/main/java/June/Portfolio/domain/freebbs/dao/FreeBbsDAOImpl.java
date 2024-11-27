package June.Portfolio.domain.freebbs.dao;

import June.Portfolio.domain.entity.FreeBbs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository                  // Spring의 컴포넌트 스캔에 의해 자동으로 Bean으로 등록, 데이터베이스와 상호작용을 처리 하는 역할을 함
@RequiredArgsConstructor     // final 필드를 매개값으로 갖는 생성자를 자동 생성해준다.
public class FreeBbsDAOImpl implements FreeBbsDAO{

  //sql 쿼리를 작성할때 이름기반의 파라미터를 사용할수 있게 해줌
  //sql 인젝션에 대한 방어 밎 sql 쿼리를 보다 가독성 있게 작성할수 있도록 해줌
  private final NamedParameterJdbcTemplate template;
  @Override
  public Long save(FreeBbs freeBbs) {

    StringBuffer sql = new StringBuffer();
    sql.append("insert into freebbs (post_id,writer,title,contents,cdate, udate, views) " );
    sql.append("values(freebbs_post_id_seq.nextval, :writer, :title, :contents, sysdate, null, 0) " );


    // BeanPropertySqlParameterSource : 주어진 객체의 필드 이름과 SQL 쿼리에서 사용하는 파라미터 이름이 일치하면, 해당 필드의 값을 SQL 쿼리의 파라미터로 자동으로 설정합니다.
    SqlParameterSource param = new BeanPropertySqlParameterSource(freeBbs);

    //KeyHolder는 데이터베이스에 삽입된 레코드의 키(주로 기본 키)를 저장하는 객체입니다. GeneratedKeyHolder는 자동 생성된 키를 저장하는 데 사용됩니다.
    KeyHolder keyholder = new GeneratedKeyHolder();

//  template.update 메서드는 SQL 쿼리를 실행하고, param을 사용하여 파라미터를 설정합니다.
//  keyholder를 통해 삽입된 레코드의 키를 가져올 수 있습니다.
//  new String[]{"post_id"}는 생성된 키의 이름을 지정합니다. 이 경우, post_id가 자동 생성된 키입니다.
    long rows = template.update(sql.toString(), param, keyholder,new String[]{"post_id"});
//    keyholder.getKeys().get("post_id")를 통해 삽입된 레코드의 post_id 값을 가져옵니다.
    Number pidNumber = (Number)keyholder.getKeys().get("post_id");
    long pid = pidNumber.longValue();
    return pid;
  }

  @Override
  public List<FreeBbs> getAllPost() {
    return List.of();
  }

  @Override
  public Optional<FreeBbs> findById(Long postId) {
    return Optional.empty();
  }

  @Override
  public int updateById(Long postId, FreeBbs freeBbs) {
    return 0;
  }

  @Override
  public int deleteById(Long postId) {
    return 0;
  }

  @Override
  public int deleteByIds(List<Long> postIds) {
    return 0;
  }

  @Override
  public int getTotalRecords() {
    return 0;
  }
}
