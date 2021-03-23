package org.isamm.demoSpring.Repository;

import org.isamm.demoSpring.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmailIgnoreCase(String username);

}
