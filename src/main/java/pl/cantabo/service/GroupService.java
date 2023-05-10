package pl.cantabo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.GroupRepository;
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
        return log.traceExit(groupRepository.save(group));
    }

    public void delete(UUID id){
        log.debug("Deleting group", id);
        groupRepository.deleteById(id);
    }

    public List<GroupDAO> getAll(){
        log.debug("Getting all groups");
        return log.traceExit(groupRepository.findAll());
    }
}
