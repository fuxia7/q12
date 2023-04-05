package com.zsgc.service;

import com.zsgc.dao.Userdao;
import com.zsgc.dao.Userfudao;
import com.zsgc.yg.Userfu;
import com.zsgc.yg.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Uservrice {
	@Autowired
	private Userdao userdao;
	
	@Autowired
	private Userfudao userfudao;
	
	public List<User> query(int pageno, int pagesize) {
		return userdao.query(pageno,pagesize);

	}
	public int count(){

		return userdao.count();
	}
	public List<User> queryy(){
		return userdao.queryy();
	}
	

	public void delete(int id) {
		userdao.delete(id);
	}
	

	public void increase(User user) {
		userdao.increase(user);
	}
	

	public void increas(List<User> list) {
		userdao.increas(list);
	}
	

	public void modify(User user) {
		userdao.modify(user);
	}
	
	public User queryid(int id) {
		return userdao.queryid(id);
	}
	
	public boolean isMergedRegion(Sheet sheet,int row,int column) {
		return userdao.isMergedRegion(sheet, row, column);
	}
	public String getMergedRegionValue(Sheet sheet, int row, int column) {
		return userdao.getMergedRegionValue(sheet, row, column);
	}
	public String getCellValue(Cell cell) {
		return userdao.getCellValue(cell);
	}
	
	public List<Userfu> query1() {
		return userfudao.query1();
		
	}
	
	

}
