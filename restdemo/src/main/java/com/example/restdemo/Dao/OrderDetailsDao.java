package com.example.restdemo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restdemo.models.OrderDetails;
@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

}
