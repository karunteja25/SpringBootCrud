package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	@Query("SELECT user FROM UserEntity user  WHERE username = ?1")
	public UserEntity findUserByName(String userName);
	@Modifying
	@Transactional
	@Query("UPDATE UserEntity u set u.username=:userName where u.id=:id")
	public void updateUserNameById(@Param("userName") String userName,@Param("id")Integer id);
	

}
