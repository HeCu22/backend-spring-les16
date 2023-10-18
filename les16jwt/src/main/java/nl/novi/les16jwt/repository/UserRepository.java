package nl.novi.les16jwt.repository;

import nl.novi.les16jwt.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();
}
