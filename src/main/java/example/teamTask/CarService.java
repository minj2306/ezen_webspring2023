package example.teamTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired CarEntityRepository carEntityRepository;

    @Transactional
    public boolean doPost( CarDto carDto){

        System.out.println( "Service-doPost : "+ carDto );

        LocalDateTime ctime = LocalDateTime.now();

        System.out.println( "Service-ctime : "+ ctime );


        carDto.setCtime(ctime);

        System.out.println( "Service-carDto.addCtime : "+ carDto );

        carEntityRepository.save( carDto.toEntity() );

        return true;

    }

    @Transactional
    public List<CarDto> doGet(){

        List<CarEntity> entitys  = carEntityRepository.findAll();

        List<CarDto> carDtos = new ArrayList<>();

        entitys.forEach( e -> {
            carDtos.add( e.toDto() );
        });

        System.out.println("Service-doGet : "+ carDtos );

        return carDtos;

    }

    @Transactional
    public boolean doPut( CarDto carDto ){

        System.out.println( "Service-doPut : "+ carDto );

        Optional<CarEntity> optionalCarEntity =
                carEntityRepository.findById( carDto.getCno() );

        if( optionalCarEntity.isPresent() ){

            CarEntity carEntity = optionalCarEntity.get();

            carEntity.setCtype( carDto.getCtype() );
            carEntity.setCnumber( carDto.getCnumber() );

        }

        return true;

    }

    @Transactional
    public boolean doDelete( int cno ){

        System.out.println( "Service-doDelete : "+ cno );


        carEntityRepository.deleteById( cno );
        return true;

    }

    /*
    @id(pk)
	int cno
	Sting cnumber
	String ctype
	LocalDateTime ctime 서비스에서 LocalDateTime.now() set하기
    * */


}
