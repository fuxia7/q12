package com.zsgc.service;

import com.zsgc.dao.Userfudaos;
import com.zsgc.yg.Userfu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Uservrices {
	@Autowired
	private Userfudaos userfudaos;



	public List<Userfu> query(int pageno, int pagesize) {
		return userfudaos.query(pageno,pagesize);

	}
	public int count(){

		return userfudaos.count();
	}


	public void delete(int t_id) {

		userfudaos.delete(t_id);
	}


	public void increase(Userfu userfu) {

		userfudaos.increase(userfu);
	}





	public void modify(Userfu userfu) {
		userfudaos.modify(userfu);
	}

	public Userfu queryid(int t_id) {
		return userfudaos.queryid(t_id);
	}


	public List pd(){

		return userfudaos.pd();
	}




}
