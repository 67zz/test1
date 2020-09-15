package com.lovo.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_userRole")
public class UserRole {
	@Id
	@GenericGenerator(name="suuid",strategy="uuid")
	@GeneratedValue(generator="suuid")
	@Column(length=32)
	private String urId;
	@ManyToOne
	@JoinColumn(name="f_user_id")
	private UserEntity  userEntity;
	@ManyToOne
	@JoinColumn(name="f_role_id")
	private Role role;
	public String getUrId() {
		return urId;
	}
	public void setUrId(String urId) {
		this.urId = urId;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
