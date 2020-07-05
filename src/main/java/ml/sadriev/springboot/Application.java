package ml.sadriev.springboot;

import javax.annotation.Resource;
import ml.sadriev.springboot.enums.RoleType;
import ml.sadriev.springboot.model.Users;
import ml.sadriev.springboot.service.UsersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

	@Resource
	private UsersService usersService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods() throws Exception {
		init();

		usersService.findAll().forEach(System.out::println);

/*		usersService.findAll().forEach(it-> System.out.println(it));

		usersService.findAllByName("Smith").forEach(it-> System.out.println(it));

		usersService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));*/
	}

	private void initUser(final String nickName, final String password, final RoleType roleType) throws Exception {
		final Users user = usersService.findUserByNickName(nickName);
		if (user != null) {
			return;
		}
		usersService.createUser(nickName, password, roleType);
	}

	private void init() throws Exception {
		initUser("admin", "admin", RoleType.ADMIN);
		initUser("user", "user", RoleType.USER);
		initUser("user2", "user2", RoleType.USER);
		initUser("user3", "user3", RoleType.USER);
	}

}
