package com.lovo.hibernate.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity //��hibernate����
@Table(name="t_user")//ӳ�����
public class UserEntity {
	@Id   
	@Column(name="uid",length=32)  //ӳ������
	@GenericGenerator(name="useruuid",strategy="uuid")//�Զ���ID���ɲ���
	@GeneratedValue(generator="useruuid")//�����ɲ���
	private String userId;
	@Column(length=32)
	private String userName;
	@OneToMany(mappedBy="userEntity")
	private List<UserRole> userRole;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
}
