package com.Manager.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Manager.Models.ManagerInformation;
import com.Manager.Repository.ManagerRepository;
@Service
public class ManagerService implements UserDetailsService{
	
	@Autowired
	private ManagerRepository managerRepo;

	/*
	 * //for creating/adding washer[ public Washer addWasher(Washer washer) { return
	 * washerRepository.save(washer); }
	 */
//
	public List<ManagerInformation> getmanagerInfos() {
// TODO Auto-generated method stub
		List<ManagerInformation> managerInfos = managerRepo.findAll();
		System.out.println("Getting Manager from DB" + managerInfos);
		return managerInfos;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ManagerInformation foundedManager = managerRepo.findByEmail(username);
		if (foundedManager == null)
			return null;
		String Email = foundedManager.getEmail();
		String Password = foundedManager.getPassword();
		return new User(Email, Password, new ArrayList<>());
	}

}



