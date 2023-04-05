package com.zsgc.yg;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name="book")
public class User {
  private int id;
 
  @NotEmpty
 @Length(max=5)
  private String name;
  
  @NumberFormat(pattern = "###,###.##")
  private Float price;
  @NotEmpty
  private String password;
  private String sex;
  private int tid;
  
  @Past
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
 /* @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
  private Date birth;
  private String link;
  
 private Userfu userfu;
 

 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}


public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}


public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}


public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}

@JoinColumn(name ="tid",insertable = false,updatable = false)
@ManyToOne
public Userfu getUserfu() {
	return userfu;
}
public void setUserfu(Userfu userfu) {
	this.userfu = userfu;
}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", tid=" + tid +
				", birth=" + birth +
				", link='" + link + '\'' +
				", userfu=" + userfu +
				'}';
	}
}
