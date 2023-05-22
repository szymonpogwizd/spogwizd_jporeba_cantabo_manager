package pl.cantabo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.GroupRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    @Transactional
    public GroupDAO create(GroupDAO group){
        log.debug("Creating group{}", group);
        validateGroup(group, false);
        return log.traceExit(groupRepository.save(group));
    }

    @Transactional
    public GroupDAO update(UUID id, GroupDAO group){
        log.debug("Updating group {}: {}", id, group);
        boolean isSameGroup = checkIfSameGroup(id, group);
        validateGroup(group, isSameGroup);
        GroupDAO toUpdate = groupRepository.findById(id).orElseThrow(() -> new ValidationException("Grupa o podanym id nie istnieje"));
        toUpdate.setName(group.getName());
        return log.traceExit(groupRepository.save(toUpdate));
    }

    private boolean checkIfSameGroup(UUID id, GroupDAO group) {
        Optional<GroupDAO> foundGroup = groupRepository.findByName(group.getName());
        return foundGroup.isPresent() && foundGroup.get().getId().equals(id);
    }

    private void validateGroup(GroupDAO group, boolean isSameGroup) {
        List<String> validationErrors = new ArrayList<>();

        if (group.getName() == null || group.getName().isEmpty()) {
            validationErrors.add("Nazwa grupy nie może być pusta\n");
        }

        if (!isSameGroup) {
            if (groupRepository.findByName(group.getName()).isPresent()) {
                validationErrors.add("Grupa o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }

    public void delete(UUID id){
        log.debug("Deleting group{}", id);
        groupRepository.deleteById(id);
    }

    public List<GroupDAO> getAll(){
        log.debug("Getting all groups");
        return log.traceExit(groupRepository.findAll());
    }
}
