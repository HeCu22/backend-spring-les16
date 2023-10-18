package nl.novi.les16jwt.repository;

import nl.novi.les16jwt.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, String> {
    List<Role> findAllBy();
}
