package com.jp.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author Rob Winch
 * @since 5.0
 */
public interface UserRepository extends CrudRepository<User, Long> {
//	Mono<User> findByEmail(String email);
	User findByEmail(String email);
}
