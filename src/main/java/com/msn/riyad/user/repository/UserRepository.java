/**
 *
 */
package com.msn.riyad.user.repository;

import com.msn.riyad.user.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Riyad
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    
}
