package vn.thanh.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.thanh.jobhunter.domain.User;
import vn.thanh.jobhunter.service.UserService;
import vn.thanh.jobhunter.service.exception.IdInvalidException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("users/create")
    @PostMapping("users")
    public ResponseEntity<User> createNewUser(@RequestBody User userTHanh) {

        // User user = new User();
        // user.setEmail("thanh@gmail.com");
        // user.setName("huu thanh");
        // user.setPassword("123456");
        this.userService.saveUser(userTHanh);
        return ResponseEntity.status(HttpStatus.CREATED).body(userTHanh);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws IdInvalidException {

        if (id > 999) {
            throw new IdInvalidException("id lon hon 999");
        }
        this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("userThanh");
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = this.userService.fetchUserById(id);

        // return ResponseEntity.status(HttpStatus.OK).body(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = this.userService.fetchAllUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("users")
    public ResponseEntity<String> handleUpdateUser(@RequestBody User thanh) {

        this.userService.saveUser(thanh);

        return ResponseEntity.ok("userThanh");
    }

}
