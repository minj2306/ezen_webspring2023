package example.day06;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
public interface NoteEntityRepository extends JpaRepository< NoteEntity , Integer > {




}
