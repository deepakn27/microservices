package com.springsecurity.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.dao.AppDataRepository;
import com.springsecurity.entity.Model;

@Service
public class ApplicationDataService {

	@Autowired
	AppDataRepository appdatarepo;
	
	public String getApplicationData()
	{
		Iterable<Model> modelItr =  appdatarepo.findAll();
		Iterator<Model> iter = modelItr.iterator();
		while(iter.hasNext()){
			 return iter.next().getTenant();
		}
		return null;
	}
	
}
