package nl.novi.les16jwt.controller;

import nl.novi.les16jwt.dto.UserDto;
import nl.novi.les16jwt.model.Role;
import nl.novi.les16jwt.model.User;
import nl.novi.les16jwt.repository.RoleRepository;
import nl.novi.les16jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepos;
    private final RoleRepository roleRepos;
    private final PasswordEncoder encoder;

    public UserController(UserRepository userRepos, RoleRepository roleRepos, PasswordEncoder encoder) {
        this.userRepos = userRepos;
        this.roleRepos = roleRepos;
        this.encoder = encoder;
    }
    @GetMapping("/overview")
    public ResponseEntity<List<User>> getUsers() {
         List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepos.findAll();
        for (User user : list) {
            var dto = new UserDto();
            dto.username = user.getUsername();
            dto.password = user.getPassword();
            // dto.roles = user.getRoles();
            collection.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.username);
        newUser.setPassword(encoder.encode(userDto.password));

        List<Role> userRoles = new ArrayList<>();
        for (String rolename : userDto.roles) {
            Optional<Role> or = roleRepos.findById(rolename);

            userRoles.add(or.get());
        }
        newUser.setRoles(userRoles);

        userRepos.save(newUser);

        return "Done";
    }
}
