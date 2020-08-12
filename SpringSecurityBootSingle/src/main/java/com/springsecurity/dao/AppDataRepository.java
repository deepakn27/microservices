package com.springsecurity.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Model;

@Repository
public interface AppDataRepository extends CrudRepository<Model, Long> {

	Iterable<Model> findAll();
}
