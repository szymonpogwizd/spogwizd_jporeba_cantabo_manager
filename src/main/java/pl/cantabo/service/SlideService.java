package pl.cantabo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.slide.SlideDAO;
import pl.cantabo.database.slide.SlideRepository;
import java.util.List;
import java.util.UUID;
@Service
@Log4j2
@RequiredArgsConstructor
public class SlideService {
    private final SlideRepository slideRepository;

    @Transactional
    public SlideDAO create(SlideDAO slide){
        log.debug("Creating slide{}", slide);
        return log.traceExit(slideRepository.save(slide));
    }

    public void delete(UUID id){
        log.debug("Deleting slide", id);
        slideRepository.deleteById(id);
    }

    public List<SlideDAO> getAll(){
        log.debug("Getting all slides");
        return  log.traceExit(slideRepository.findAll());
    }
}
