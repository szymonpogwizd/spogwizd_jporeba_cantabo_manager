package pl.cantabo.database.profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDAO create(ProfileDAO profile) {
        log.debug("Creating profile {}", profile);
        return log.traceExit(profileRepository.save(profile));
    }

    public void delete(UUID id) {
        log.debug("Deleting profile {}", id);
        profileRepository.deleteById(id);
    }

    public List<ProfileDAO> getAll() {
        log.debug("Getting all profiles");
        return log.traceExit(profileRepository.findAll());
    }
}
