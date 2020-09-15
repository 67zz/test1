package com.lovo.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_rolePowe")
public class RolePowe {
	@Id
	@GenericGenerator(name="suuid",strategy="uuid")
	@GeneratedValue(generator="suuid")
	@Column(length=32)
	private String rpId;
	@ManyToOne
	@JoinColumn(name="f_role_id")
	private Role role;
	@ManyToOne
	@JoinColumn(name="f_powe_id")
	private Powe powe;
	public String getRpId() {
		return rpId;
	}
	public void setRpId(String rpId) {
		this.rpId = rpId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Powe getPowe() {
		return powe;
	}
	public void setPowe(Powe powe) {
		this.powe = powe;
	}
}
