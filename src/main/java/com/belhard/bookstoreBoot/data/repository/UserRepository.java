package com.belhard.bookstoreBoot.data.repository;

import com.belhard.bookstoreBoot.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
