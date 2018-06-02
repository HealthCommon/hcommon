package com.hc.data.repositories;


import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hc.data.models.User;

@Repository
public interface IUserRepository extends CrudRepository<User, UUID> {
	@Query("SELECT * FROM hc_users WHERE mobile = ?0 and password = ?1 ALLOW FILTERING")
	User findByMobileAndPassword(String mobile, String password);
	@Query("SELECT * FROM hc_users WHERE mobile = ?0 and otp = ?1 ALLOW FILTERING")
	User findByMobileAndOtp(String mobile, String otp);
}
