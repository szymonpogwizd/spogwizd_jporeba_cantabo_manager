package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.profile.ProfileInfoDTO;
import pl.cantabo.database.profile.ProfileMapper;
import pl.cantabo.service.ProfileService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/profiles")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @GetMapping
    public List<ProfileInfoDTO> getAll() {
        log.debug("Getting all profiles");
        return log.traceExit(
                profileService.getAll()
                        .stream()
                        .map(profileMapper::profileDAO2ProfileInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("{id}")
    public void deleteProfile(@PathVariable UUID id) {
        log.debug("Deleting profile {}", id);
        profileService.delete(id);
    }
}
