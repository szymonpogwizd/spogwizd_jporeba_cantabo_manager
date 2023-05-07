package pl.cantabo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.GroupRepository;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongRepository;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;
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

//		populateDatabase();

		SpringApplication.run(CantaboApplication.class, args);
	}

//	static void populateDatabase() {
		//		TESTOWE WSTAWIANIE DANYCH DO BAZY
//		ConfigurableApplicationContext context = SpringApplication.run(CantaboApplication.class, args);
//
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		GroupRepository groupRepository = context.getBean(GroupRepository.class);
//		SongRepository songRepository = context.getBean(SongRepository.class);
//		SongCategoryRepository songCategoryRepository = context.getBean(SongCategoryRepository.class);
//
//		List<UserDAO> users = Arrays.asList(
//				new UserDAO(UUID.randomUUID(), "User 1", UserType.USER, "user1@example.com", "passwordQWEq223!@#", true, UUID.randomUUID().toString(), ZonedDateTime.now().plusDays(1), null, null),
//				new UserDAO(UUID.randomUUID(), "User 2", UserType.USER, "user2@example.com", "passwordQWE2a23!@#", true, UUID.randomUUID().toString(), ZonedDateTime.now().plusDays(1), null, null),
//				new UserDAO(UUID.randomUUID(), "Mor Admin", UserType.ADMINISTRATOR, "mor@example.com", "passwordQWE223!@#", true, UUID.randomUUID().toString(), ZonedDateTime.now().plusDays(1), null, null),
//				new UserDAO(UUID.randomUUID(), "Wor SuperAdmin", UserType.SUPERADMINISTRATOR, "wor@example.com", "passwordQWE123!@#", true, UUID.randomUUID().toString(), ZonedDateTime.now().plusDays(1), null, null)
//		);
//
////		List<GroupDAO> groups = Arrays.asList(
////				new GroupDAO(UUID.randomUUID(), "Mor Group", true, null, null, null, null, null, null, null),
////				new GroupDAO(UUID.randomUUID(), "Wor Group", true, null, null, null, null, null, null, null)
////		);
//
//		List<SongDAO> songs = Arrays.asList(
//			new SongDAO(UUID.randomUUID(), "Song 1", "Artist 1", "Words 1", 0L, true, null, null, null, null, null),
//			new SongDAO(UUID.randomUUID(), "Song 2", "Artist 2", "Words 2", 0L, true, null, null, null, null, null),
//			new SongDAO(UUID.randomUUID(), "Song 3", "Artist 3", "Words 3", 0L, true, null, null, null, null, null),
//			new SongDAO(UUID.randomUUID(), "Song 4", "Artist 4", "Words 4", 0L, true, null, null, null, null, null),
//			new SongDAO(UUID.randomUUID(), "Song 5", "Artist 5", "Words 5", 0L, true, null, null, null, null, null)
//		);
//
//		List<SongCategoryDAO> songCategories = Arrays.asList(
//				new SongCategoryDAO(UUID.randomUUID(), "Category 1", true, null, null),
//				new SongCategoryDAO(UUID.randomUUID(), "Category 2", true, null, null),
//				new SongCategoryDAO(UUID.randomUUID(), "Category 3", true, null, null),
//				new SongCategoryDAO(UUID.randomUUID(), "Category 4", true, null, null)
//		);
//
//		userRepository.saveAllAndFlush(users);
////		groupRepository.saveAllAndFlush(groups);
//		songRepository.saveAllAndFlush(songs);
//		songCategoryRepository.saveAllAndFlush(songCategories);
//	}
}
