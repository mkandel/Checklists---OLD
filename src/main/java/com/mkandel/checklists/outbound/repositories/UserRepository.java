/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.outbound.repositories;

import com.mkandel.checklists.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUsername(String username);
}
