package com.woo.bo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woo.bo.data.entity.WooUser;
import com.woo.bo.data.repository.WooUserRepo;
import com.woo.bo.service.api.UserService;


@Service
public class UserServiceImpl implements UserService {

@Autowired
private WooUserRepo wooUserRepo;

	@Override
	public long save(WooUser wooUser) {
		return wooUserRepo.save(wooUser).getUserId();
	}
}
