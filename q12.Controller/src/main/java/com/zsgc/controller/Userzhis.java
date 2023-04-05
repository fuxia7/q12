package com.zsgc.controller;

import com.zsgc.service.Uservrices;
import com.zsgc.yg.Userfu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class Userzhis {

	@Autowired
	private Uservrices uservrices;

//	@Autowired
//	private Userfudao userfudao;

	@Autowired
	private ResourceBundleMessageSource sour;

	@RequestMapping("/queryuserfu")
	public String queryuserfu(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {

		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);
		if(pageno==null&&pagesize==null){
			pageno="0";
			pagesize="2";


		}


		map.put("accumulation",pageno);
			map.put("userfu", uservrices.query(Integer.valueOf(pageno), Integer.valueOf(pagesize)));
		map.put("sum",uservrices.count());

		map.put("pagesize",Integer.valueOf(pagesize));
		map.put("bu",uservrices.pd());

		System.out.println(pageno);
		System.out.println(pagesize);

		return "lists";



	}
	@RequestMapping("/queryuserrfu")
	public String queryuserrfu(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {

		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);
//		if(pageno==null&&pagesize==null){
//			pageno="1";
//			pagesize="2";
//
//		}




					map.put("userfu",uservrices.query(Integer.valueOf(pageno)+1,Integer.valueOf(pagesize)));
					map.put("accumulation",Integer.valueOf(pageno)+1);
					map.put("sum",uservrices.count());
					map.put("pagesize",Integer.valueOf(pagesize));
		            map.put("bu",uservrices.pd());


		System.out.println(pageno);
		System.out.println(pagesize);


		return "lists";



	}

	@RequestMapping("/queryuserrrfu")
	public String queryuserrrfu(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {

		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);


			map.put("accumulation",Integer.valueOf(pageno)-1);
			map.put("userfu",uservrices.query(Integer.valueOf(pageno)-1,Integer.valueOf(pagesize)));
		    map.put("sum",uservrices.count());
		    map.put("pagesize",Integer.valueOf(pagesize));
		    map.put("bu",uservrices.pd());

		System.out.println(pageno);
		System.out.println(pagesize);

		return "lists";



	}
	@RequestMapping("/queryuserrrrfu")
	public String queryuserrrrfu(Map<String,Object> map,Locale locale,String pageno,String pagesize) throws ServletException, IOException {

		map.put("fo",locale.toString());
		//System.out.println(sour.getMessage("user.name", new Object[]{"李宁玉","破译天才"}, null));
		//Integer.valueOf(pageno);


		map.put("accumulation",Integer.valueOf(pageno));
		map.put("userfu",uservrices.query(Integer.valueOf(pageno),Integer.valueOf(pagesize)));

		map.put("sum",uservrices.count());
		map.put("pagesize",Integer.valueOf(pagesize));
		map.put("bu",uservrices.pd());
		System.out.println(pageno);
		System.out.println(pagesize);

		return "lists";



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






	@RequestMapping(value="/userfu/{t_id}",method=RequestMethod.DELETE)
	public String delete(Map<String,Object> map,@PathVariable("t_id") int t_id,String pageno,String pagesize){
		System.out.println("删除");
         List list=  uservrices.pd();
		for (Object o : list) {
			System.out.println(o.toString());
		}
         map.put("bu",list);



        System.out.println("^^^^^^^^^^^^^^^^^^^^^");
		uservrices.delete(t_id);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^");

		Integer size = Integer.valueOf(pagesize);
		Integer eno = Integer.valueOf(pageno);

		return "redirect:/queryuserfu"+"?pageno="+eno+"&pagesize="+size ;
	}
	@RequestMapping(value="/usersfu",produces ="text/html;charset=utf-8",method=RequestMethod.GET)
	public String increase(Map<String,Object> map,Locale locale) {
		System.out.println("后翼弃兵");



		map.put("userfu",new Userfu());

		return "increas";
	}
	@RequestMapping(value="/usersfu",produces ="text/html;charset=utf-8",method=RequestMethod.POST)
	public String increaseuser(@Validated Userfu userfu,BindingResult bindingResult,Map <String,Object> map,Locale locale) throws IOException {

		if(bindingResult.getErrorCount()>0) {
			List<FieldError> list =   bindingResult.getFieldErrors();
			for (FieldError fieldError : list) {
				System.out.println(fieldError.getDefaultMessage());
			}


			return "increas";
		}


		uservrices.increase(userfu);


		return "redirect:/queryuserfu";

	}





	@RequestMapping(value="/userfu/{t_id}",method=RequestMethod.GET)
	public String update(@PathVariable("t_id") int t_id,Map<String,Object> map,Locale locale){

	     Userfu userfu=uservrices.queryid(t_id);
	    // System.out.println(user);

	     map.put("userfu", userfu);


		return "increas";
	}


	@ModelAttribute
	public void getuserfu(@RequestParam(value="t_id",required=false) Integer t_id,Map<String, Object> map) {

		if(t_id != null) {
			map.put("userfu",uservrices.queryid(t_id));
		}


	}






	@RequestMapping(value="/usersfu",produces ="text/html;charset=utf-8",method=RequestMethod.PUT)
	public String updateuser(@Validated Userfu userfu,BindingResult bindingResult,Map<String,Object> map,Locale locale) throws IOException {


		if(bindingResult.getErrorCount()>0) {
			List<FieldError> list =   bindingResult.getFieldErrors();
			for (FieldError fieldError : list) {
				System.out.println(fieldError.getDefaultMessage());
			}


			return "increas";
		}

			uservrices.modify(userfu);

		return "redirect:/queryuserfu";

	}






}
