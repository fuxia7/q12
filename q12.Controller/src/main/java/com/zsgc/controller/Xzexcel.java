package com.zsgc.controller;

import com.zsgc.service.Uservrice;
import com.zsgc.yg.User;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Component("xz")
public class Xzexcel extends AbstractXlsxView{

    @Autowired
    private Uservrice uservrice;


	@Override
	protected void buildExcelDocument(Map<String, Object> arg0, Workbook arg1, HttpServletRequest arg2,
			HttpServletResponse response) throws Exception {

		 String fileName = "fuu.xlsx";
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/ms-excel");// 文件下载
	        response.setHeader("Content-Disposition", "inline; filename=" + new String(fileName.getBytes(), "iso8859-1"));
	        OutputStream outputStream = response.getOutputStream();


	        Sheet sheet = arg1.createSheet("李宁玉");

	       Row r1 = sheet.createRow(0);
	        XSSFCell t1 = (XSSFCell) r1.createCell(0);
			   XSSFCell t2 = (XSSFCell)r1.createCell(1);
			   XSSFCell t3 =(XSSFCell) r1.createCell(2);
			   XSSFCell t4 = (XSSFCell)r1.createCell(3);
			   XSSFCell t5 = (XSSFCell)r1.createCell(4);
			   XSSFCell t6 = (XSSFCell)r1.createCell(5);
			   XSSFCell t7 =(XSSFCell) r1.createCell(6);
			   XSSFCell t8 =(XSSFCell) r1.createCell(7);
			   XSSFCell t9 = (XSSFCell)r1.createCell(8);

			     t1.setCellValue("id");
			     t2.setCellValue("名字");
			     t3.setCellValue("值");
			     t4.setCellValue("密码");
			     t5.setCellValue("性别");
			     t6.setCellValue("tid");
			     t7.setCellValue("生日");
			    // t8.setCellValue("t_id");
			     //t9.setCellValue("namee");

	       List<User> list = uservrice.queryy();
	       System.out.println(list.toString());
			for(int f=0;f<list.size();f++) {

				Row  r3= sheet.createRow(f+1);


					     XSSFCell t11 =  (XSSFCell) r3.createCell(0);
						   XSSFCell t22 =  (XSSFCell) r3.createCell(1);
						   XSSFCell t33 =  (XSSFCell)r3.createCell(2);
						   XSSFCell t44=  (XSSFCell)r3.createCell(3);
						   XSSFCell t55 = (XSSFCell) r3.createCell(4);
						   XSSFCell t66 = (XSSFCell) r3.createCell(5);
						   XSSFCell t77 = (XSSFCell) r3.createCell(6);
						   XSSFCell t88 = (XSSFCell) r3.createCell(7);
						   XSSFCell t99 = (XSSFCell) r3.createCell(8);


								   User a0=  list.get(f);

								  // System.out.println(f);
								//System.out.println(a0);
									   t11.setCellValue(a0.getId());
									     t22.setCellValue(a0.getName());
									     t33.setCellValue(a0.getPrice());
									     t44.setCellValue(a0.getPassword());
									     t55.setCellValue(a0.getSex());
									     t66.setCellValue(a0.getTid());
									     t77.setCellValue(a0.getBirth());
									    // t88.setCellValue(a0.getUserfu().getT_id());
									    // t99.setCellValue(a0.getUserfu().getNamee());



			}



	        arg1.write(outputStream);
	        outputStream.flush();
	        outputStream.close();




	}




}
