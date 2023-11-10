package ezenweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.UUID;

@Service
public class FileService {
    /*파일관련 메소드 정의*/

    // 0.파일경로
    private String fileRootPath = "c:\\java\\";

    // 1. 업로드
    public String fileUpload(MultipartFile multipartFile){
        // 0. 유효성검사
        if(multipartFile.isEmpty() ){// 파일이 비어있으면
            return null;
        }
        // 1. 파일명 [ 파일명은 식별자가 될수 없다. 같은 이름으로 올릴 수 있기 때문에 ]
            // 1. UUID 조합 , 2. 날짜 / 시간 조합 3. 상위 컨텐츠PK 등등
        String fileName =
                UUID.randomUUID().toString() +"_"+ // UUID 이용한 파일 식별자 만들기
                multipartFile.getOriginalFilename().replaceAll("_" , "-"); // 식별을 위해 _ 를 - 로 변경
        // 2. 파일 경로
        File file = new File(fileRootPath + fileName);

        // 3. 업로드
        try{
            multipartFile.transferTo( file );
            return fileName; // 성공시 파일명 리턴  [ db에 저장하려고 ]
        }catch ( Exception e ){
            System.out.println("업로드 실패 : " + e);
            return null; // 실패시 null 리턴
        }
    }

    @Autowired
    private HttpServletResponse response;
    // 2. 다운로드
    public  void fileDownload(String uuidFile){

        // 다운로드할 파일명 찾기
        String downloadFilePath = fileRootPath + uuidFile;
        // 2. uuid 제거된 순순 파일명 [ 다운로드시 출력되는 파일명 이니까 uuid 제거 ]
        String filename = uuidFile.split("_")[1]; // 기분으로 쪼갠후 뒷자리 파일명만 호출
        try{
            // 3. 다운로드 형식 구성
            response.setHeader( "Content-Disposition" ,
                    "attachment;filename="+ URLEncoder.encode( filename , "UTF-8") );
            // 4. 다운로드
            //--------------------------서버가 해당 파일 읽어오기-------------------------
                // 1. 서버가 해당 파일 읽어오기
                File file = new File( downloadFilePath );
                // 2. 버퍼스트림 이용한 바이트로 파일 읽어오기;
            BufferedInputStream fin = new BufferedInputStream( new FileInputStream( file ) );
                // 3. 파일의 용량[바이트] 만큼 바이트 배열 선언
            byte[] bytes = new byte[ (int)file.length() ];
                // 4. 버퍼스트림이 읽어온 바이트들을 바이트배열에 저장
            fin.read( bytes );

            //----------------------------------서버가 읽어온 파일을 클라이언트에게 응답하기
            // 1. 버퍼스트림 이용한 response 으로 응답하기
            BufferedOutputStream fout = new BufferedOutputStream( response.getOutputStream() );
            // 2. 읽어온 바이트[파일] 내보내기
            fout.write( bytes );
            // 3. 안전하게 스트림 닫기
            fout.flush(); fout.close(); fin.close();
        }catch (Exception e){
            System.out.println( "fileDownload : " + e );
        }
    }


}
