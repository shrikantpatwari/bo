/**
 * 
 */
package com.woo.bo.data.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woo.bo.UserEntity.WooUser;

/**
 * @author PAVILION
 *
 */

@Repository
public interface WooUserRepo extends JpaRepository<WooUser, Long> {

}