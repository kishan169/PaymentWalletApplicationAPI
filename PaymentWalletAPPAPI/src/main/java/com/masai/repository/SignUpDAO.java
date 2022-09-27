package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.SignUp;

@Repository
public interface SignUpDAO extends JpaRepository<SignUp, Integer>{
	
	public Optional<SignUp> findByUserName(String userName);
}
