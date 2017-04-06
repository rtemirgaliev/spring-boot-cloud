package com.rinat.sbcloud.auth.repository;

import com.rinat.sbcloud.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
}
