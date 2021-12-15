package com.woo.bo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woo.bo.UserEntity.WooUser;
import com.woo.bo.data.entity.repo.WooUserRepo;
import com.woo.bo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
@Autowired
private WooUserRepo wooUserRepo;
	@Override
	public WooUser saveUser(WooUser wooUser) {
		
		return wooUserRepo.save(wooUser);
	}

}
