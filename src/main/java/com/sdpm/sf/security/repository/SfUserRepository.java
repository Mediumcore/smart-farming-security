package com.sdpm.sf.security.repository;

import com.sdpm.sf.security.entity.SfUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shirukai
 */
public interface SfUserRepository extends JpaRepository<SfUser, Long> {
    SfUser findSfUserByUsername(String username);
}
