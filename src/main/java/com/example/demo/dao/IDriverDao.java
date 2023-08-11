package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Driver;

@Repository
public interface IDriverDao extends JpaRepository<Driver, Integer>{
	
}
