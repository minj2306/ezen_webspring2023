package example.과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneEntityRepository phoneEntityRepository;

    @Transactional
    public boolean doPost(PhoneDto phoneDto){

        PhoneEntity phoneEntity = PhoneEntity.builder()
                                            .pname(phoneDto.getPname())
                                            .pnumber(phoneDto.getPnumber())
                                            .build();

        phoneEntityRepository.save(phoneEntity);

        return false;
    }

    @Transactional
    public List<PhoneDto> doGet(){

        List<PhoneEntity> phoneEntities =
                phoneEntityRepository.findAll(Sort.by(Sort.Order.asc("pname")));

        List<PhoneDto> list = new ArrayList<>();

        phoneEntities.forEach((entity)->{

            PhoneDto phoneDto = PhoneDto.builder()
                    .pno(entity.getPno())
                    .pname(entity.getPname())
                    .pnumber(entity.getPnumber())
                    .build();
            list.add(phoneDto);
        });

        return list;
    }

    @Transactional
    public boolean doPut( PhoneDto phoneDto){

        Optional<PhoneEntity> phoneEntity =
                 phoneEntityRepository.findById(phoneDto.getPno());

        if( phoneEntity.isPresent()){

            PhoneEntity updateEntity = phoneEntity.get();

            updateEntity.setPname(phoneDto.getPname());
            updateEntity.setPnumber(phoneDto.getPnumber());
        }

        return false;
    }

    @Transactional
    public boolean doDelete( int pno ){

        phoneEntityRepository.deleteById(pno);

        return false;
    }
}
