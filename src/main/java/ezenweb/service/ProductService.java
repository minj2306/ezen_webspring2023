package ezenweb.service;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.entity.ProductCategoryEntity;
import ezenweb.model.entity.ProductEntity;
import ezenweb.model.repository.ProductCategoryEntityRepository;
import ezenweb.model.repository.ProductEntityRepository;
import ezenweb.model.repository.ProductImgEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductCategoryEntityRepository productCategoryEntityRepository;
    @Autowired
    ProductEntityRepository productEntityRepository;
    @Autowired
    ProductImgEntityRepository productImgEntityRepository;
    @Autowired
    FileService fileService;

    // 1. 카테고리 등록
    @Transactional
    public boolean addCategory(@RequestBody ProductCategoryDto productCategoryDto){

        // 1. DTO --> 엔티티
        // 2. 리포지토리 이용한 엔티티 세이브
        // 3. 성공시 true 실패시 false

        return productCategoryEntityRepository.save(
                ProductCategoryEntity.builder().
                        pcname(productCategoryDto.getPcname())
                        .build()
        ).getPcno()>= 1 ? true : false;
    }
    
    // 2. 카테고리 출력
    @Transactional
    public List<ProductCategoryDto> printCategory(){

        // 1. 모든 엔티티 호출 // 2. 모든 엔티티 리스트 -> dto 리스트 변환 // 3. dto 리스트 반환

        return productCategoryEntityRepository.findAll().stream().map(
                e ->{ return ProductCategoryDto.builder()
                        .pcno( e.getPcno() )
                        .pcname( e.getPcname() )
                        .build(); }
                ).collect(Collectors.toList());

    }
    
    // 3. 카테고리 수정
    @Transactional
    public boolean updateCategory(ProductCategoryDto productCategoryDto ){

        // 1. 수정할 엔티티 찾는다[ pcno ] // 2. 찾은 엔티티가 존재하면 수정 o 아니면 수정x // 3. 성공시 true 실패시 false

        ProductCategoryEntity productCategoryEntity =
                toEntity(productCategoryDto.getPcno());
        if(productCategoryEntity != null){
            productCategoryEntity.setPcname( productCategoryDto.getPcname() );
            return true;
        }

        return false;
    }
    
    // 4. 카테고리 삭제
    @Transactional
    public boolean deleteCategory( int pcno ){
        // 1. 삭제할 엔티티 찾는다[pcno] // 2. 찾은 엔티티가 존재하면 삭제o 아니면 삭제x // 3. 성공시true 실패시 false
        ProductCategoryEntity productCategoryEntity = toEntity( pcno );
        if( productCategoryEntity != null ){ productCategoryEntityRepository.delete(productCategoryEntity); return  true; }
        return false;
    }

    // 5. 부가적인 엔티티 검색용 함수
    public ProductCategoryEntity toEntity (int pcno ){

        Optional<ProductCategoryEntity> productCategoryEntityOptional =
                productCategoryEntityRepository.findById( pcno );
        return productCategoryEntityOptional.isPresent() ? productCategoryEntityOptional.get() : null ;

    }


}
