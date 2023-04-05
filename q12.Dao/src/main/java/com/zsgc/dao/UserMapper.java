package com.zsgc.dao;
import com.zsgc.yg.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {

    public List<User> query(@Param("pageno")int pageno,@Param("pagesize")int pagesize);

    public List<User> queryy();

    public int count();

    public void delete(int id);

    public void increase(User user);

    public void modify(User user);

    public User queryid(int id);

    public void increas(User user);






}
