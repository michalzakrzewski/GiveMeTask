package com.zakrzewski.givemetask.repositories;

import com.zakrzewski.givemetask.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserModel, Long> {
}
