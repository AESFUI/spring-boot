package ml.sadriev.springboot.repository;

import ml.sadriev.springboot.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {

    Users findUserByNickName(String nickName);


}
