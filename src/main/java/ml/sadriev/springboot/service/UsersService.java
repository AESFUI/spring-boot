package ml.sadriev.springboot.service;

import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import lombok.AllArgsConstructor;
import ml.sadriev.springboot.enums.RoleType;
import ml.sadriev.springboot.model.Role;
import ml.sadriev.springboot.model.Users;
import ml.sadriev.springboot.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsersService {

    @Resource
    private final UsersRepository usersRepository;

/*    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    public Users findUserByNickName(String nickName) throws Exception {
        return usersRepository.findUserByNickName(nickName);
    }

    public List<Users> findAll() throws Exception {
        return (List<Users>) usersRepository.findAll();
    }

    @Transactional
    public void createUser(final String nickName, final String password, final RoleType roleType) {
        Users user = new Users();
        user.setNickName(nickName);
//        user.setPasswordHash(passwordEncoder.encode(password));
        user.setPasswordHash("passworHash");

        Role role = new Role();
        role.setRoleEnum(roleType);
        role.setUser(user);
        user.setRoles(Collections.singletonList(role));

        usersRepository.save(user);
    }
}
