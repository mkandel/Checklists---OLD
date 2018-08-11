/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.outbound.repositories;

import com.mkandel.checklists.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByUsername(String username);

    @Transactional
    void deleteById(String id);
}
