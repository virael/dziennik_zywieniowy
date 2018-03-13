package pl.lukasz.janusz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukasz.janusz.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
