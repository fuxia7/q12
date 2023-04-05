package com.zsgc.dao;

import com.zsgc.yg.Userfu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserfuMapper {

    public List<Userfu> query1();

    public List<Userfu> query(@Param("pageno")int pageno, @Param("pagesize")int pagesize);

    public int count();

    public void delete(int t_id);

    public void increase(Userfu userfu);

    public void modify(Userfu userfu);

    public Userfu queryid(int t_id);

    public List pd();



}
