package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.profile.ProfileDAO;
import pl.cantabo.database.profile.ProfileRepository;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDAO create(ProfileDAO profile) {
        log.debug("Creating profile {}", profile);
        validateProfile(profile);
        return log.traceExit(profileRepository.save(profile));
    }

    public ProfileDAO update(UUID id, ProfileDAO profile) {
        log.debug("Updating profile {}: {}", id, profile);
        validateProfile(profile);
        ProfileDAO toUpdate = profileRepository.findById(id).orElseThrow(() -> new ValidationException("Profil o podanym id nie istnieje"));
        toUpdate.setName(profile.getName());
        toUpdate.setActive(profile.isActive());
        toUpdate.setSortByUsed(profile.isSortByUsed());
        toUpdate.setBgColor(profile.getBgColor());
        toUpdate.setTxColor(profile.getTxColor());
        toUpdate.setStopColor(profile.getStopColor());
        toUpdate.setFontStyle(profile.getFontStyle());
        toUpdate.setMargin(profile.getMargin());
        toUpdate.setMaxFont(profile.getMaxFont());
        toUpdate.setMaxMin(profile.getMaxMin());
        toUpdate.setAlign(profile.getAlign());
        toUpdate.setAlgorithmRange(profile.getAlgorithmRange());
        toUpdate.setShowTitle(profile.isShowTitle());
        toUpdate.setAllBig(profile.isAllBig());
        toUpdate.setShowEmptySlide(profile.isShowEmptySlide());
        toUpdate.setInvertColors(profile.isInvertColors());
        toUpdate.setExpandedList(profile.isExpandedList());
        return log.traceExit(profileRepository.save(toUpdate));
    }

    private void validateProfile(ProfileDAO profileDAO) {
        List<String> validationErrors = new ArrayList<>();

        if (profileDAO.getName() == null || profileDAO.getName().isEmpty()) {
            validationErrors.add("Nazwa profilu nie może być pusta\n");
        }

        if (profileRepository.findByName(profileDAO.getName()).isPresent()) {
            validationErrors.add("Profil o podanej nazwie już istnieje\n");
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
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
