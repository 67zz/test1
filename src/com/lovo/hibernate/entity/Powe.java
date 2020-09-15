package com.lovo.hibernate.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity //被hibernate管理
@Table(name="t_powe")//映射表名
public class Powe {
	@Id
	@GenericGenerator(name="suuid",strategy="uuid")
	@GeneratedValue(generator="suuid")
	@Column(length=32)
	private String powdId;
	@Column(length=32)
	private String poweName;
	@OneToMany(mappedBy="powe")
	private List<RolePowe> rolePowe;
	public String getPowdId() {
		return powdId;
	}
	public void setPowdId(String powdId) {
		this.powdId = powdId;
	}
	public String getPoweName() {
		return poweName;
	}
	public void setPoweName(String poweName) {
		this.poweName = poweName;
	}
	public List<RolePowe> getRolePowe() {
		return rolePowe;
	}
	public void setRolePowe(List<RolePowe> rolePowe) {
		this.rolePowe = rolePowe;
	}
}
