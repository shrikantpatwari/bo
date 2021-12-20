package com.woo.bo.service.api;

import java.util.List;

import com.woo.bo.data.entity.WooUser;

public interface UserService {

	long save(WooUser wooUser);

	List<WooUser> getAllUsers();

	WooUser updateWooUserById(Long id, WooUser emp);

	WooUser getUserById(Long id);
}