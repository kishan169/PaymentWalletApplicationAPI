package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.masai.model.LogIn;

public interface LogInDAO extends JpaRepository<LogIn, Integer>{

}
