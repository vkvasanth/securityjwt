package com.example.securitydemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securitydemo.models.UserDetails;


@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Integer> {

	UserDetails saveUserDetails(UserDetails userdetails);

	

}
