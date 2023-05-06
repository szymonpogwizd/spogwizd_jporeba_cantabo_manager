package pl.cantabo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.GroupRepository;
import pl.cantabo.database.user.UserDAO;
import pl.cantabo.database.user.UserRepository;
import pl.cantabo.database.user.UserType;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class CantaboApplication {

	public static void main(String[] args) {

//		TESTOWE WSTAWIANIE DANYCH DO BAZY
//		ConfigurableApplicationContext context = SpringApplication.run(CantaboApplication.class, args);
//
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		GroupRepository groupRepository = context.getBean(GroupRepository.class);
//
//		List<UserDAO> users = Arrays.asList(
//				new UserDAO(UUID.randomUUID(), "Mor Admin", UserType.ADMINISTRATOR, "mor@example.com", "passwordQWE223!@#", true, UUID.randomUUID().toString(), ZonedDateTime.now().plusDays(1), null, null),
//				new UserDAO(UUID.randomUUID(), "Wor SuperAdmin", UserType.SUPERADMINISTRATOR, "wor@example.com", "passwordQWE123!@#", true, UUID.randomUUID().toString(), ZonedDateTime.now().plusDays(1), null, null)
//		);
//
//		List<GroupDAO> groups = Arrays.asList(
//				new GroupDAO(UUID.randomUUID(), "Mor Group", true, null, null, null, null, null, null, null),
//				new GroupDAO(UUID.randomUUID(), "Wor Group", true, null, null, null, null, null, null, null)
//		);
//
//		userRepository.saveAllAndFlush(users);
//		groupRepository.saveAllAndFlush(groups);

		SpringApplication.run(CantaboApplication.class, args);
	}

}
