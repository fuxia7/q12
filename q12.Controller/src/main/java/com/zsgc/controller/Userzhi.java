package com.zsgc.controller;

import com.zsgc.service.Uservrice;
import com.zsgc.yg.Userfu;
import com.zsgc.yg.User;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.ParseException;
import java.util.*;

@Controller
public class Userzhi {
	
	@Autowired
	private Uservrice uservrice;
	
//	@Autowired
//	private Userfudao userfudao;
	
	@Autowired
	private ResourceBundleMessageSource sour;
	
	@RequestMapping("/queryuser")
	public String queryuser(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {
		System.out.println("查询sc");
		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);
		if(pageno==null&&pagesize==null){
			pageno="0";
			pagesize="2";


		}


		map.put("accumulation",pageno);
			map.put("user", uservrice.query(Integer.valueOf(pageno), Integer.valueOf(pagesize)));
		map.put("sum",uservrice.count());

		map.put("pagesize",Integer.valueOf(pagesize));

		System.out.println(pageno);
		System.out.println(pagesize);

		return "list"; 
		
		
		
	}
	@RequestMapping("/queryuserr")
	public String queryuserr(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {

		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);
//		if(pageno==null&&pagesize==null){
//			pageno="1";
//			pagesize="2";
//
//		}




					map.put("user",uservrice.query(Integer.valueOf(pageno)+1,Integer.valueOf(pagesize)));
					map.put("accumulation",Integer.valueOf(pageno)+1);
					map.put("sum",uservrice.count());
					map.put("pagesize",Integer.valueOf(pagesize));



		System.out.println(pageno);
		System.out.println(pagesize);


		return "list";



	}

	@RequestMapping("/queryuserrr")
	public String queryuserrr(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {

		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);


			map.put("accumulation",Integer.valueOf(pageno)-1);
			map.put("user",uservrice.query(Integer.valueOf(pageno)-1,Integer.valueOf(pagesize)));
		    map.put("sum",uservrice.count());
		    map.put("pagesize",Integer.valueOf(pagesize));

		System.out.println(pageno);
		System.out.println(pagesize);

		return "list";



	}
	@RequestMapping("/queryuserrrr")
	public String queryuserrrr(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {

		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);


		map.put("accumulation",Integer.valueOf(pageno));
		map.put("user",uservrice.query(Integer.valueOf(pageno),Integer.valueOf(pagesize)));

		map.put("sum",uservrice.count());
		map.put("pagesize",Integer.valueOf(pagesize));

		System.out.println(pageno);
		System.out.println(pagesize);

		return "list";



	}



//	@RequestMapping("/locale")
//	public String qie(Locale locale,Map<String,Object> map) {
//		System.out.println(locale);
//		map.put("fo",locale.toString());
//		return "forward:queryuser";
//	}
	
	
	
//	@RequestMapping("/queryuserr")
//	@ResponseBody
//	public List<User> queryuserr() {
//
//		return uservrice.query();
//	}
	
	@RequestMapping(value="queryuse",method=RequestMethod.GET)
	@ResponseBody
	public User queryuse(@RequestBody User user) {
		
		System.out.println(user);
		return user;
		
		
	}
	
	
	@RequestMapping(value="zp",method=RequestMethod.GET)
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session,@RequestParam String str) throws IOException{
//		System.out.println(str);
//		String strr = java.net.URLDecoder.decode(str);
//		System.out.println(strr);
		if(str!=null &&str!="") {
		byte [] body = null;
		File file=new File(str);
		InputStream in = new FileInputStream(str);
		body = new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename="+file.getName());
		
		HttpStatus statusCode = HttpStatus.OK;
		
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
		
		}
		return null;
	}
	
	private Object decodeURIComponent(String str) {
		return str;
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id,String pageno,String pagesize){
		System.out.println("删除");

		uservrice.delete(id);

		Integer size = Integer.valueOf(pagesize);
		Integer eno = Integer.valueOf(pageno);

		return "redirect:/queryuser"+"?pageno="+eno+"&pagesize="+size ;
	}
	@RequestMapping(value="/users",produces ="text/html;charset=utf-8",method=RequestMethod.GET)
	public String increase(Map<String,Object> map,Locale locale) {
		System.out.println("后翼弃兵");
		Map<String,String> m=new HashMap<String, String>();
		m.put("女",sour.getMessage("sex.female", null, locale));
		m.put("男",sour.getMessage("sex.male", null, locale));
		
		  List<Userfu> lis = uservrice.query1();




			map.put("zhi", lis);



		
		map.put("xing",m);
		map.put("user",new User());
		
		return "increa";
	}
	@RequestMapping(value="/users",produces ="text/html;charset=utf-8",method=RequestMethod.POST)
	public String increaseuser(@Validated User user,BindingResult bindingResult,@RequestParam("filelink") MultipartFile multipartFile,Map <String,Object> map,Locale locale) throws IOException {
		
		if(bindingResult.getErrorCount()>0) {
			List<FieldError> list =   bindingResult.getFieldErrors();
			for (FieldError fieldError : list) {
				System.out.println(fieldError.getDefaultMessage());
			}
			Map<String,String> m=new HashMap<String, String>();
			m.put("女",sour.getMessage("sex.female", null, locale));
			m.put("男",sour.getMessage("sex.male", null, locale));
			
			  List<Userfu> lis = uservrice.query1();

		 
			map.put("zhi", lis);
			
			map.put("xing",m);
			return "increa";
		}
	
	String namefile=multipartFile.getOriginalFilename();
	
	String namefil[]=  namefile.split("\\.");
	String type=namefil[namefil.length-1];
	
	String path="C:\\Users\\86159\\Desktop\\java\\"+getname(type);
	FileOutputStream in = new FileOutputStream(path);
	       
	InputStream in1 = multipartFile.getInputStream();
    
     //读取文件 生成一个字节数组
     byte[] a =new byte[1024]; 
    
    
     //写文件
     int b=0;
     while((b=in1.read(a))!= -1)
     {
    	 in.write(a,0,b);
     }
     in.close();  
     in1.close(); 

		
		user.setLink(path);
		uservrice.increase(user);
		
		
		return "redirect:/queryuser";
		
	}
	
	public synchronized String getname(String type) {
		return System.currentTimeMillis()+"."+type;
	}
	
	
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String update(@PathVariable("id") int id,Map<String,Object> map,Locale locale){
		 
	     User user=uservrice.queryid(id);
	    // System.out.println(user);
	    
	     map.put("user", user);
	     Map<String,String> m=new HashMap<String, String>();
			m.put("女",sour.getMessage("sex.female", null, locale));
			m.put("男",sour.getMessage("sex.male", null, locale));
			
			 List<Userfu> lis = uservrice.query1();


		
		
			map.put("zhi", lis);
			
			
			map.put("xing",m);
		
		return "increa";
	}
	
	
	@ModelAttribute
	public void getuser(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map) {
		
		if(id != null) {
			map.put("user",uservrice.queryid(id));
		}
		

	}
	
	
	
	
	
	
	@RequestMapping(value="/users",produces ="text/html;charset=utf-8",method=RequestMethod.PUT)
	public String updateuser(@Validated User user,BindingResult bindingResult,@RequestParam("filelink") MultipartFile multipartFile,Map<String,Object> map,Locale locale) throws IOException {
		  System.out.println("词不达意");
		  System.out.println("关九大大");
		
		if(bindingResult.getErrorCount()>0) {
			List<FieldError> list =   bindingResult.getFieldErrors();
			for (FieldError fieldError : list) {
				System.out.println(fieldError.getDefaultMessage());
			}
			Map<String,String> m=new HashMap<String, String>();
			m.put("女",sour.getMessage("sex.female", null, locale));
			m.put("男",sour.getMessage("sex.male", null, locale));
			
			  List<Userfu> lis = uservrice.query1();

		 
			map.put("zhi", lis);
			
			map.put("xing",m);
			
			return "increa";
		}
		String namefile=multipartFile.getOriginalFilename();
		
		String namefil[]=  namefile.split("\\.");
		String type=namefil[namefil.length-1];
		
		String path="C:\\Users\\86159\\Desktop\\java\\"+getname(type);
		FileOutputStream in = new FileOutputStream(path);
		       
		InputStream in1 = multipartFile.getInputStream();
	    
	     //读取文件 生成一个字节数组
	     byte[] a =new byte[1024]; 
	    
	    
	     //写文件
	     int b=0;
	     while((b=in1.read(a))!= -1)
	     {
	    	 in.write(a,0,b);
	     }
	     in.close();  
	     in1.close(); 

			
			user.setLink(path);
		
			uservrice.modify(user);
		
		return "redirect:/queryuser";
		
	}
	
	@RequestMapping(value="/usersce",produces ="text/html;charset=utf-8",method=RequestMethod.POST)
	public String ceshi(User user) {
		
		System.out.println(user.toString());
		return "redirect:/queryuser";
		
	}
	
	@RequestMapping(value="/downloadexcel",produces ="text/html;charset=utf-8",method=RequestMethod.POST)
	public String biao()  {
//		XSSFWorkbook x=new XSSFWorkbook();
//		XSSFSheet sheet = x.createSheet("t1");
//		
//		 XSSFRow r1 = sheet.createRow(0);
//		 XSSFCell t1 = r1.createCell(0);
//		   XSSFCell t2 = r1.createCell(1);
//		   XSSFCell t3 = r1.createCell(2);
//		   XSSFCell t4 = r1.createCell(3);
//		   XSSFCell t5 = r1.createCell(4);
//		   XSSFCell t6 = r1.createCell(5);
//		   XSSFCell t7 = r1.createCell(6);
//		   XSSFCell t8 = r1.createCell(7);
//		   XSSFCell t9 = r1.createCell(8);
//		   
//		     t1.setCellValue("id");
//		     t2.setCellValue("名字");
//		     t3.setCellValue("值");
//		     t4.setCellValue("密码");
//		     t5.setCellValue("性别");
//		     t6.setCellValue("tid");
//		     t7.setCellValue("生日");
//		     t8.setCellValue("t_id");
//		     t9.setCellValue("namee");
//		     List<User> list = userdao.query();
//		for(int f=0;f<list.size();f++) {
//			
//			 XSSFRow  r3= sheet.createRow(f+1);
//			
//
//				     XSSFCell t11 =  r3.createCell(0);
//					   XSSFCell t22 =  r3.createCell(1);
//					   XSSFCell t33 =  r3.createCell(2);
//					   XSSFCell t44=  r3.createCell(3);
//					   XSSFCell t55 =  r3.createCell(4);
//					   XSSFCell t66 =  r3.createCell(5);
//					   XSSFCell t77 =  r3.createCell(6);
//					   XSSFCell t88 =  r3.createCell(7);
//					   XSSFCell t99 =  r3.createCell(8);
//					  
//							  
//							   User a0=  list.get(f);
//							   
//							  // System.out.println(f);
//							//System.out.println(a0);
//								   t11.setCellValue(a0.getId());
//								     t22.setCellValue(a0.getName());
//								     t33.setCellValue(a0.getPrice());
//								     t44.setCellValue(a0.getPassword());
//								     t55.setCellValue(a0.getSex());
//								     t66.setCellValue(a0.getTid());
//								     t77.setCellValue(a0.getBirth());
//								     t88.setCellValue(a0.getT_id());
//								     t99.setCellValue(a0.getNamee());	
//			  
//		}
//		
//			
//		
//		 FileOutputStream in = new FileOutputStream("C:\\Users\\86159\\Desktop\\fu.xlsx");
//		    x.write(in);
//		    in.close();
//		    
//		    String rtt="C:\\Users\\86159\\Desktop\\fu.xlsx";
//		    
//		  
//	        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("fu.xlsx","UTF-8"));
//	        
//	        InputStream in1 = new FileInputStream(rtt);
//	       
//	        //读取文件 生成一个字节数组
//	        byte[] a =new byte[1024]; 
//	        OutputStream out = response.getOutputStream();
//	       
//	        //写文件
//	        int b=0;
//	        while((b=in1.read(a))!= -1)
//	        {
//	            out.write(a,0,b);
//	        }
//	        in1.close();  
//	        out.close(); 

	return "xz";
		
	}
	
	@RequestMapping(value="/daoru",produces ="text/html;charset=utf-8",method=RequestMethod.POST)
	public String daoru() throws IOException, ParseException  {
		
		String path="C:\\Users\\86159\\Desktop\\fu.xlsx";
		// 读到文件得到流
				InputStream in=new FileInputStream(path);
				// 把流转换成office对象进行处理
				XSSFWorkbook xss=new XSSFWorkbook(in);
				// 得到工作页的数量
				int sheets = xss.getNumberOfSheets();
				 List<User> list = new ArrayList<User>();
				for(int i=0;i<sheets;i++) {
					// 得到具体的工作页
				XSSFSheet xssf = xss.getSheetAt(i);
				if(xssf!=null) {
					// 得到最后一行的下标
					int xssfw = xssf.getLastRowNum();
					
					for(int j=0;j<=xssfw; j++) {
						
					XSSFRow row=	xssf.getRow(j);
					
					if(row!=null) {
					
					XSSFCell cell = row.getCell(0);
					XSSFCell cell1 = row.getCell(1);
					XSSFCell cell2 = row.getCell(2);
					XSSFCell cell3 = row.getCell(3);
					XSSFCell cell4= row.getCell(4);
					XSSFCell cell5 = row.getCell(5);
					XSSFCell cell6 = row.getCell(6);
					XSSFCell cell7 = row.getCell(7);
					XSSFCell cell8 = row.getCell(8);
					
					
					 User user =new User();
					 Userfu us=new Userfu();
		             user.setName(uservrice.getCellValue(cell));
		             user.setPrice(Float.valueOf(uservrice.getCellValue(cell1)));
		             user.setPassword(uservrice.getCellValue(cell2));
		             user.setSex(uservrice.getCellValue(cell3));
		             user.setTid(Integer.valueOf(uservrice.getCellValue(cell4)));
		            
		             Date setupTime = HSSFDateUtil.getJavaDate(Double.parseDouble(uservrice.getCellValue(cell5)));
		            
		             
		             user.setBirth(setupTime);
		             user.setLink(uservrice.getCellValue(cell6));
		             us.setT_id(Integer.valueOf(uservrice.getCellValue(cell7)));
		             
                     us.setNamee(uservrice.getCellValue(cell8));
		            
		             user.setUserfu(us);
		             
		             list.add(user);
					

					}
					}
				
				}
				}
				System.out.println(list);

				uservrice.increas(list);	
		
		return "redirect:/queryuser";
	}
	@RequestMapping(value="/dao",produces ="text/html;charset=utf-8",method=RequestMethod.POST)
	public String dao(@RequestParam("shuju") MultipartFile multipartFile) throws IOException, ParseException  {
		
      String namefile=multipartFile.getOriginalFilename();
		
		String namefil[]=  namefile.split("\\.");
		String type=namefil[namefil.length-1];
		
		String path="C:\\Users\\86159\\Desktop\\java\\"+getname(type);
		
		FileOutputStream in2 = new FileOutputStream(path);
	       
		InputStream in1 = multipartFile.getInputStream();
	    
	     //读取文件 生成一个字节数组
	     byte[] a =new byte[1024]; 
	    
	    
	     //写文件
	     int b=0;
	     while((b=in1.read(a))!= -1)
	     {
	    	 in2.write(a,0,b);
	     }
	     in2.close();  
	     in1.close(); 
		// 读到文件得到流
				InputStream in=new FileInputStream(path);
				// 把流转换成office对象进行处理
				XSSFWorkbook xss=new XSSFWorkbook(in);
				// 得到工作页的数量
				int sheets = xss.getNumberOfSheets();
				 List<User> list = new ArrayList<User>();
				for(int i=0;i<sheets;i++) {
					// 得到具体的工作页
				XSSFSheet xssf = xss.getSheetAt(i);
				if(xssf!=null) {
					// 得到最后一行的下标
					int xssfw = xssf.getLastRowNum();
					
					for(int j=0;j<=xssfw; j++) {
						
					XSSFRow row=	xssf.getRow(j);
					
					if(row!=null) {
					
					XSSFCell cell = row.getCell(0);
					XSSFCell cell1 = row.getCell(1);
					XSSFCell cell2 = row.getCell(2);
					XSSFCell cell3 = row.getCell(3);
					XSSFCell cell4= row.getCell(4);
					XSSFCell cell5 = row.getCell(5);
					XSSFCell cell6 = row.getCell(6);
					XSSFCell cell7 = row.getCell(7);
					XSSFCell cell8 = row.getCell(8);
					
					
					 User user =new User();
					 Userfu us=new Userfu();
		             user.setName(uservrice.getCellValue(cell));
		             user.setPrice(Float.valueOf(uservrice.getCellValue(cell1)));
		             user.setPassword(uservrice.getCellValue(cell2));
		             user.setSex(uservrice.getCellValue(cell3));
		             user.setTid(Integer.valueOf(uservrice.getCellValue(cell4)));
		            
		             Date setupTime = HSSFDateUtil.getJavaDate(Double.parseDouble(uservrice.getCellValue(cell5)));
		            
		             
		             user.setBirth(setupTime);
		             user.setLink(uservrice.getCellValue(cell6));
		             us.setT_id(Integer.valueOf(uservrice.getCellValue(cell7)));
                     us.setNamee(uservrice.getCellValue(cell8));
		             
		             user.setUserfu(us);
		             
		             list.add(user);
					

					}
					}
				
				}
				}
				System.out.println(list);

				uservrice.increas(list);	
		
		return "redirect:/queryuser";
	}
	
	@InitBinder
    public void ht(WebDataBinder webDataBinder) {
		//System.out.println("记忆一寸寸攀附黑夜而生长");
//		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		 webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sim, true));
		 
		 //webDataBinder.setDisallowedFields("price"); 
		 
    }
	
//	@ExceptionHandler(value =Exception.class)
//	public ModelAndView chuwu(Exception ce) {
//		System.out.println("发光体"+ce);
//		ModelAndView mod=new ModelAndView("cg");
//		mod.addObject("fu",ce.getMessage());
//		return mod;
//	}
//	@ExceptionHandler(value =ArithmeticException.class)
//	public String chuwu1() {
//		System.out.println("硝烟四起");
//		return "cg";
//	}
	
	
	@RequestMapping(value ="chu",method =RequestMethod.GET)
	public String chu() {
//		if(6==6) {
//		throw new Ceex();	
//		}
		int i=1/0;
		return "list";
	}
	
}
