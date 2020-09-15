package com.lovo.hibernate.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity //��hibernate����
@Table(name="t_role")//ӳ�����
public class Role {
	@Id   
	@Column(name="rid",length=32)  //ӳ������
	@GenericGenerator(name="useruuid",strategy="uuid")//�Զ���ID���ɲ���
	@GeneratedValue(generator="useruuid")//�����ɲ���
	private String roleId;
	@Column(length=32)
	private String roleName;
	@OneToMany(mappedBy="role")
	private List<UserRole> userRole;
	@OneToMany(mappedBy="powe")
	private List<RolePowe> rolePowe;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
	public List<RolePowe> getRolePowe() {
		return rolePowe;
	}
	public void setRolePowe(List<RolePowe> rolePowe) {
		this.rolePowe = rolePowe;
	}
}
