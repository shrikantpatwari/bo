/**
 * 
 */
package com.woo.bo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woo.bo.data.entity.WooUser;

/**
 * @author PAVILION
 *
 */

@Repository
public interface WooUserRepo extends JpaRepository<WooUser, Long> {
	WooUser findByUserName(String userName);

//	WooUser findBySponserName(String sponserName);

}