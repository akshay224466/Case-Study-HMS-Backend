package com.Inventary.Service;


import java.util.List;
import java.util.Optional;

import com.Inventary.Models.Inventary;




public interface Inventaryservice {

	Inventary addInventary(Inventary inv);



	Optional<Inventary> getInventary(long parseLong);



	String deleteInventary(long parseLong);



	List<Inventary> getAllInventary();



	Inventary updateInventary(Inventary inv, long id);

	



	

	

	

}
