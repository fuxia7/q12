package com.zsgc.dao;

import com.zsgc.yg.Userfu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Userfudao {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
//	@PersistenceContext
//	private EntityManager en;

	/*private Session session;
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	*/

	@Autowired
	private UserfuMapper userfuMapper;
	public List<Userfu> query1() {
//		String sql = "select * from boo";
//		RowMapper<Userfu> rowMapper = new BeanPropertyRowMapper<>(Userfu.class);
//		List<Userfu> list1 = jdbcTemplate.query(sql,rowMapper);
		/*session=getSession();
		List<Userfu> list1=	session.createQuery("from Userfu").list();*/

		List<Userfu> list1=userfuMapper.query1();
		
		return list1;
		
	}
	
//	public Userfu queryid(int id) {
//		 RowMapper<Userfu> rowMapper = new BeanPropertyRowMapper<>(Userfu.class);
//		 String sql="select * from boo where id=?";
//		 Userfu userfu= jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
//			return userfu;
//		
//	}
}
