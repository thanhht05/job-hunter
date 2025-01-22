package vn.thanh.jobhunter.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.thanh.jobhunter.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
