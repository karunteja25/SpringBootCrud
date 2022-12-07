package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user_entity")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_entity_id_seq")
    @SequenceGenerator(name = "user_entity_id_seq", sequenceName = "user_entity_id_seq", allocationSize =1 )
	private Integer id;
	private String username;
	private Integer age;
	private String address;

}
