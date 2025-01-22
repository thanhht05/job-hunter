package vn.thanh.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.thanh.jobhunter.domain.User;
import vn.thanh.jobhunter.responsitory.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {

            return user.get();
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public List<User> fetchAllUser() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public User handleUpdateUser(User user) {
        User currentUser = this.fetchUserById(user.getId());

        if (currentUser != null) {
            currentUser.setEmail(user.getEmail());
            currentUser.setName(user.getName());
            currentUser.setPassword(user.getPassword());

            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }
}
