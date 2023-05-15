package pl.cantabo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.cantabo.database.profile.ProfileDAO;
import pl.cantabo.database.profile.ProfileRepository;
import pl.cantabo.database.song.SongRepository;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class CantaboApplication {

	public static void main(String[] args) {

//		populateDatabase(args);

		SpringApplication.run(CantaboApplication.class, args);
	}

	static void populateDatabase(String[] args) {
		//		TESTOWE WSTAWIANIE DANYCH DO BAZY
		ConfigurableApplicationContext context = SpringApplication.run(CantaboApplication.class, args);
//
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		GroupRepository groupRepository = context.getBean(GroupRepository.class);
//		SongRepository songRepository = context.getBean(SongRepository.class);
//		SongCategoryRepository songCategoryRepository = context.getBean(SongCategoryRepository.class);
//		ProfileRepository profileRepository = context.getBean(ProfileRepository.class);
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

//		List<ProfileDAO> profiles = Arrays.asList(
//				new ProfileDAO(UUID.randomUUID(), "Profile 1", false, false, 0, 0, 0, "Arial", 0.0f, 0.0f, 0.0f, "center", "50", false, false, false, false, false, false, null),
//				new ProfileDAO(UUID.randomUUID(), "Profile 2", false, false, 0, 0, 0, "Arial", 0.0f, 0.0f, 0.0f, "center", "50", false, false, false, false, false, false, null),
//				new ProfileDAO(UUID.randomUUID(), "Profile 3", false, false, 0, 0, 0, "Arial", 0.0f, 0.0f, 0.0f, "center", "50", false, false, false, false, false, false, null),
//				new ProfileDAO(UUID.randomUUID(), "Profile 4", false, false, 0, 0, 0, "Arial", 0.0f, 0.0f, 0.0f, "center", "50", false, false, false, false, false, false, null)
//		);
//
//		userRepository.saveAllAndFlush(users);
////		groupRepository.saveAllAndFlush(groups);
//		songRepository.saveAllAndFlush(songs);
//		songCategoryRepository.saveAllAndFlush(songCategories);
//		profileRepository.saveAllAndFlush(profiles);
	}
}
