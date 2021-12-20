package com.woo.bo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.woo.bo.data.entity.WooUser;
import com.woo.bo.data.repository.WooUserRepo;
import com.woo.bo.dto.UserViewDto;
import com.woo.bo.exceptions.*;
import com.woo.bo.service.api.UserService;

@Service
public class UserServiceImpl implements UserService {

@Autowired
private WooUserRepo wooUserRepo;

	@Override
	public long save(WooUser wooUser) 
	{
		UserViewDto userViewDto=new UserViewDto();
		userViewDto.setUserName(wooUser.getUserName());
		WooUser wooUserName=wooUserRepo.findByUserName(wooUser.getUserName());
		if(StringUtils.isEmpty(wooUserName) || wooUserName==null ) {
			return wooUserRepo.save(wooUser).getUserId();
		}else{
			throw new UserAlreadyPresentException(wooUser.getUserName(),"", wooUser.getUserId());
		}
	
	}

	@Override
	public List<WooUser> getAllUsers() {		
		return wooUserRepo.findAll();
	}

	@Override
	public WooUser updateWooUserById(Long id, WooUser wooUser) {
		
		  WooUser existingWooUser=wooUserRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("wooUser", "Id", "id"));
		  existingWooUser.setUserName(wooUser.getUserName());
		  existingWooUser.setMobilePhone(wooUser.getMobilePhone());
		  existingWooUser.setWalletAddress(wooUser.getWalletAddress());
		  existingWooUser.setEmail(wooUser.getWalletAddress());		 
		  wooUserRepo.save(existingWooUser); 
		 return null;
		 
	}

	@Override
	public WooUser getUserById(Long id) {
		
		Optional<WooUser> wooUserById=wooUserRepo.findById(id);
		if(wooUserById.isPresent()) {
			return wooUserById.get();
		}
		else
		{
			throw new ResourceNotFoundException("WooUser", "Id", "id");
		}
	}

	

}