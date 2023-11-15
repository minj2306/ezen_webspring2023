package ezenweb.model.repository;

import ezenweb.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity , String> {

    // 1. 제품별 재고 수
    @Query(value = "select pname , pstock from product" , nativeQuery = true)
    List< Map<Object , Object> > findByBarChart();

    // 2. 카테고리별 제품 수
    @Query(value = "select pc.pcname , count(*) from product p" +
            " inner join productcategory pc" +
            " on p.pcno = pc.pcno" + // on절 : pk , fk 교/합 집합 위한 조인 조건절
            " group by pc.pcname" // group by
            , nativeQuery = true)
    List< Map<Object , Object> > findByPieChart();

    /*
        DTO , Entity 아닌 타입이 전해져 있지 않는 MAP <Object , Object> 사용
            { key , value } : entry 라고 부름

            - : 여러개 entry 모이면 MAP ( *** 레코드 1줄 )
            MAP = { key , value } , { key , value } , { key , value }
                    필드명   값         필드명   값        필드명   값

            - : 여러개 MAP 저장하기 위해서 LIST ( *** 여러 레코드 )
            LIST = [ MAP , MAP , MAP ,MAP ]
    */

}
