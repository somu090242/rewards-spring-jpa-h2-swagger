package com.test.rewards.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long userId;
		@NotBlank
		private String userName;
		
		@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdTimestamp;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedTimestamp;
}
