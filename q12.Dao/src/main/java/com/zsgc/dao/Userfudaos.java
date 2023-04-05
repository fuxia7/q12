package com.zsgc.dao;


import com.zsgc.yg.Userfu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Userfudaos {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

//	@PersistenceContext
//	private EntityManager en;

/*	private Session session;
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}*/
@Autowired
private UserfuMapper userfuMapper;

	public List<Userfu> query(int pageno, int pagesize) {
//		String sql = "select * from book as bo,boo as b where bo.tid=b.t_id order by id asc";
//		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//		List<User> list1 = jdbcTemplate.query(sql,rowMapper);
		//System.out.println(list1.toString());
		int start= pageno*pagesize;
	/*	System.out.println(start);
		session=getSession();
	List<Userfu> list1=	session.createQuery("from Userfu").setFirstResult(start).setMaxResults(pagesize).list();*/
//
//		for (User user : list1) {
//			System.out.println(user.toString());
//		}
		List<Userfu> list1=userfuMapper.query(start,pagesize);


		return list1;

	}
	public int count(){
		/*session=getSession();
		Object	count=session.createQuery("select count(*)  from Userfu").uniqueResult();*/
		Object	count= userfuMapper.count();
		int sum= Integer.parseInt(count.toString());

//		if(sum%pagesize==0) {
//			return sum/pagesize;
//		}
//		else {
//			return (sum/pagesize)+1;
//		}

		return sum;

	}



	public void delete(int t_id) {
//		String sql="delete from book where id=?";
//
//		jdbcTemplate.update(sql,id);

		//en.createQuery("delete from User where id=?").setParameter(1, id).executeUpdate();
		/*session=getSession();
	//User user = session.get(User.class,id);
		Userfu userfu=new Userfu();
		userfu.setT_id(t_id);
	  session.delete(userfu);*/

		userfuMapper.delete(t_id);

	}


	public void increase(Userfu userfu) {
		//String sql="insert into book(name,price,password,sex,tid,birth,link) value(?,?,?,?,?,?,?)";

		//jdbcTemplate.update(sql, user.getName(),user.getPrice(),user.getPassword(),user.getSex(),user.getUserfu().getT_id(),user.getBirth(),user.getLink());

		//en.createQuery("insert into User(name,price,password,sex,tid,birth,link) value(?,?,?,?,?,?,?)").setParameter(1, user.getName()).setParameter(2, user.getPrice()).setParameter(3, user.getPassword())
		//.setParameter(4, user.getSex()).setParameter(5,user.getUserfu().getT_id() ).setParameter(6, user.getBirth()).setParameter(7, user.getLink()).executeUpdate();

		/*Userfu u=new Userfu();
		u.setNamee(userfu.getNamee());


		session=getSession();
	session.persist(u);*/
		userfuMapper.increase(userfu);



	}









	public void modify(Userfu userfu) {
		//String sql="update book set name=?,price=?,password=?,sex=?,tid=?,birth=?,link=? where id=?";

		//jdbcTemplate.update(sql, user.getName(),user.getPrice(),user.getPassword(),user.getSex(),user.getTid(),user.getBirth(),user.getLink(),user.getId());
		//update Order set ordername=? where oid=?
		//en.createQuery("update User set name=?,price=?,password=?,sex=?,tid=?,birth=?,link=? where id=?").setParameter(1, user.getName()).setParameter(2, user.getPrice()).setParameter(3, user.getPassword())
		//.setParameter(4, user.getSex()).setParameter(5,user.getId() ).setParameter(6, user.getBirth()).setParameter(7, user.getLink()).setParameter(8,user.getId()).executeUpdate();
	/*	session=getSession();
	Userfu uu = session.get(Userfu.class, userfu.getT_id());

	uu.setNamee(userfu.getNamee());*/

		userfuMapper.modify(userfu);



	}


	public Userfu queryid(int t_id) {
//		 RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//		 String sql="select * from book where id=?";
//			User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);

	//User user=	(User) en.createQuery("select u from User u where id=?").setParameter(1,id).getSingleResult();
		/*session=getSession();
	Userfu userfu = session.get(Userfu.class, t_id);*/
		Userfu userfu = 	userfuMapper.queryid(t_id);

			return userfu;


	}


     public List pd(){
     /* session=getSession();
		// select distinct c from Customer c left join fetch c.orders
		 List fgt = session.createQuery("select distinct u.tid from User u").list();
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
		 for (Object o : fgt) {
			 //System.out.println(o.toString());
		 }
		 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");*/

		 List fgt = userfuMapper.pd();
		 for (Object o : fgt) {
			 System.out.println(o.toString());
		 }
		 return fgt;
	 }



}
