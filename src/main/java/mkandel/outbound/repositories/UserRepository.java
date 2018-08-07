/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.outbound.repositories;

import java.util.List;
import mkandel.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUsername(String username);
}
