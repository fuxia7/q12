package com.zsgc.dao;

import com.zsgc.yg.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Userdao {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
//	@PersistenceContext
//	private EntityManager en;

	/*private Session session;
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}*/

	@Autowired
	private UserMapper userMapper;
	
	public List<User> query(int pageno, int pagesize) {
//		String sql = "select * from book as bo,boo as b where bo.tid=b.t_id order by id asc";
//		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//		List<User> list1 = jdbcTemplate.query(sql,rowMapper);
		//System.out.println(list1.toString());
		int start= pageno*pagesize;
		System.out.println(start);
	/*	session=getSession();
	List<User> list1=	session.createQuery("from User").setFirstResult(start).setMaxResults(pagesize).list();*/

		List<User> list1=userMapper.query(start,pagesize);

		for (User user : list1) {
			//System.out.println(user.toString());
		}



		return list1;
		
	}
	public int count(){
		/*session=getSession();
		Object	count=session.createQuery("select count(*)  from User").uniqueResult();*/
		Object	count=	userMapper.count();

		int sum= Integer.parseInt(count.toString());

//		if(sum%pagesize==0) {
//			return sum/pagesize;
//		}
//		else {
//			return (sum/pagesize)+1;
//		}

		return sum;

	}
	public List<User> queryy() {
		List<User>	list3=userMapper.queryy();

		return  list3;
	}
	
	
	
	public void delete(int id) {
//		String sql="delete from book where id=?";
//		
//		jdbcTemplate.update(sql,id);
		
		//en.createQuery("delete from User where id=?").setParameter(1, id).executeUpdate();
		/*session=getSession();
	//User user = session.get(User.class,id);
		User user=new User();
		user.setId(id);
	  session.delete(user);*/

		userMapper.delete(id);
		
	}
	
	
	public void increase(User user) {
		//String sql="insert into book(name,price,password,sex,tid,birth,link) value(?,?,?,?,?,?,?)";
		
		//jdbcTemplate.update(sql, user.getName(),user.getPrice(),user.getPassword(),user.getSex(),user.getUserfu().getT_id(),user.getBirth(),user.getLink());
		
		//en.createQuery("insert into User(name,price,password,sex,tid,birth,link) value(?,?,?,?,?,?,?)").setParameter(1, user.getName()).setParameter(2, user.getPrice()).setParameter(3, user.getPassword())
		//.setParameter(4, user.getSex()).setParameter(5,user.getUserfu().getT_id() ).setParameter(6, user.getBirth()).setParameter(7, user.getLink()).executeUpdate();
		
		/*User u=new User();
		u.setName(user.getName());
		u.setPrice(user.getPrice());
		u.setPassword(user.getPassword());
		u.setSex(user.getSex());

		u.setTid(user.getUserfu().getT_id());


		//u.setTid(user.getUserfu().getT_id());
		u.setBirth(user.getBirth());
		u.setLink(user.getLink());

		session=getSession();
	    session.persist(u);*/

		userMapper.increase(user);
		
		
		
	}
	
	
	public void increas(List<User> list) {
//		String sql="insert into book(name,price,password,sex,tid,birth,link) value(?,?,?,?,?,?,?)";
//		for (User user : list) {
//			jdbcTemplate.update(sql, user.getName(),user.getPrice(),user.getPassword(),user.getSex(),user.getUserfu().getT_id(),user.getBirth(),user.getLink());
//		}
		/*User u=new User();
		session=getSession();
		for (User user : list) {
			session.persist(user);
		}*/

		for (User user : list) {
			userMapper.increas(user);
		}

	}
	
	
	

	
	
	public void modify(User user) {
		//String sql="update book set name=?,price=?,password=?,sex=?,tid=?,birth=?,link=? where id=?";
		
		//jdbcTemplate.update(sql, user.getName(),user.getPrice(),user.getPassword(),user.getSex(),user.getTid(),user.getBirth(),user.getLink(),user.getId());
		//update Order set ordername=? where oid=?
		//en.createQuery("update User set name=?,price=?,password=?,sex=?,tid=?,birth=?,link=? where id=?").setParameter(1, user.getName()).setParameter(2, user.getPrice()).setParameter(3, user.getPassword())
		//.setParameter(4, user.getSex()).setParameter(5,user.getId() ).setParameter(6, user.getBirth()).setParameter(7, user.getLink()).setParameter(8,user.getId()).executeUpdate();
	/*	session=getSession();
	User uu = session.get(User.class, user.getId());
	
	uu.setName(user.getName());
	uu.setPrice(user.getPrice());
	uu.setPassword(user.getPassword());
	uu.setSex(user.getSex());
	uu.setTid(user.getTid());
	uu.setBirth(user.getBirth());
	uu.setLink(user.getLink());
	
	
  System.out.println(user.toString());*/

		userMapper.modify(user);
		
	}
	
	
	public User queryid(int id) {
//		 RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//		 String sql="select * from book where id=?";
//			User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
		
	//User user=	(User) en.createQuery("select u from User u where id=?").setParameter(1,id).getSingleResult();
	/*	session=getSession();
	User user = session.get(User.class, id);*/
		User user=userMapper.queryid(id);
		
			return user;
			
		
	}
	
	public boolean isMergedRegion(Sheet sheet,int row,int column) {
		int sheetMergeCount =sheet.getNumMergedRegions();
		for(int i=0; i<sheetMergeCount;i++) {
		CellRangeAddress range = sheet.getMergedRegion(i);
		int firstColumn = range.getFirstColumn();
		int lastColumn = range.getLastColumn();
		int firstRow = range.getFirstRow();
		int lastRow = range.getLastRow();
		if (row >= firstRow && row <= lastRow) {
			if (column >= firstColumn && column <= lastColumn) {
				return true;
			}
		}
	}
		
		
		return false;
		
	}
	public String getMergedRegionValue(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();

		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();

			if (row >= firstRow && row <= lastRow) {

				if (column >= firstColumn && column <= lastColumn) {
					Row fRow = sheet.getRow(firstRow);
					Cell fCell = fRow.getCell(firstColumn);
					return getCellValue(fCell);
				}
			}
		}

		return null;
	}
	public String getCellValue(Cell cell) {

		if (cell == null)
			return "";

		if (cell.getCellTypeEnum() == CellType.STRING) {

			return cell.getStringCellValue();

		} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {

			return String.valueOf(cell.getBooleanCellValue());

		} else if (cell.getCellTypeEnum() == CellType.FORMULA) {

			return cell.getCellFormula();

		} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {

			return String.valueOf(cell.getNumericCellValue());

		}
		return "";
	}
	

}
