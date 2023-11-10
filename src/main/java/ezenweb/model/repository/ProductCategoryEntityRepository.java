package ezenweb.model.repository;

import ezenweb.model.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryEntityRepository extends JpaRepository<ProductCategoryEntity, Integer > {
}
