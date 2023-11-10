package ezenweb.model.repository;

import ezenweb.model.entity.ProductImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgEntityRepository extends JpaRepository<ProductImgEntity, String> {
}
