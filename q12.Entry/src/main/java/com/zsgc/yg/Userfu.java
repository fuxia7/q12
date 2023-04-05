package com.zsgc.yg;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="boo")
public class Userfu {
	private int t_id;
	  private String namee;
	  
	  private Set<User> users=new  HashSet<>(); 
	  
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getNamee() {
		return namee;
	}
	public void setNamee(String namee) {
		this.namee = namee;
	}
	
	
	
	@OneToMany(mappedBy = "userfu",fetch=FetchType.LAZY)
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Userfu{" +
				"t_id=" + t_id +
				", namee='" + namee + '\'' +
				'}';
	}
}
