package devmalik90.dukaan.repository;

import devmalik90.dukaan.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>
{

}
