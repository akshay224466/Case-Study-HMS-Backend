package com.Inventary.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventary.Models.Inventary;
import com.Inventary.Repository.InventaryRepo;


@Service
public class InventaryserviceImpl implements Inventaryservice {
	
	@Autowired
	InventaryRepo inventaryRepo;

	@Override
	public Inventary addInventary(Inventary inv) {
		// TODO Auto-generated method stub
		return inventaryRepo.insert(inv);
	}

	@Override
	public List<Inventary> getAllInventary() {
		// TODO Auto-generated method stub
		return inventaryRepo.findAll();
	}

	@Override
	public Optional<Inventary> getInventary(long parseLong) {
		// TODO Auto-generated method stub
		return inventaryRepo.findById( parseLong);
	}

	@Override
	public Inventary updateInventary(Inventary inv) {
		// TODO Auto-generated method stub
		return inventaryRepo.save(inv);
	}

	@Override
	public String deleteInventary(long parseLong) {
		inventaryRepo.deleteById(parseLong);
		return "Deleted employee with ID :" + parseLong;
	}

	
}
