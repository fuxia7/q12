<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.js"></script>
<script type="text/javascript">


$(function(){

	$(".delete").click(function(){
		var href = $(this).attr("href");
        var pageno=$("#pageno").val();
        var pagesize=$("#pagesize").val();
        var pagecount=$("#zonggong").text();
        var sum='${sum}';

        var bc=$(this).attr("bc");

        if( (sum%pagesize)==1 &&pageno!=0 ){
          /*  var mulength = '${fn:length(bu)}';

            var i=0;
            for (;i<mulength;i++)
            {
                const rrr = [${bu}[i]],
                    ttt = [parseInt(bc)];

                let intersection = $(rrr).filter(ttt).toArray();
                console.log(intersection);

                if(intersection.length!=0){
                    alert("有员工关联,不能删除!");

                }

                else{
                    var pagen=parseInt(pageno)-1;
                    //alert(pagen+"***");

                    var hre=href+"?pageno="+pagen+"&pagesize="+pagesize;
                    $(".formm").attr("action",hre).submit();
                }
            }
*/
            var rrr =${bu};
            rrr=rrr.toString();
                //alert(rrr);
              var  ttt = bc;
            ttt=ttt.toString();
            //alert(ttt);

          var uuu=  rrr.indexOf(ttt);
            //alert(uuu);
            if(uuu!=-1){
                alert("有员工关联,不能删除!");

            }

            else{
                var pagen=parseInt(pageno)-1;
                //alert(pagen+"***");

                var hre=href+"?pageno="+pagen+"&pagesize="+pagesize;
                $(".formm").attr("action",hre).submit();
            }

        }

        else{
            //alert("关九?");

            var rrr = ${bu};
        rrr= rrr.toString();
           // alert(rrr);
             var   ttt =bc;
     ttt=ttt.toString();
           // alert(ttt);


            var uuu=  rrr.indexOf(ttt);
           // alert(uuu);

            if(uuu!=-1){
                alert("有员工关联,不能删除");
            }

            else{
                var hreff=href+"?pageno="+pageno+"&pagesize="+pagesize;
                $(".formm").attr("action",hreff).submit();
            }


        }

		/*alert("表示有员工关联，公司不能删除");*/
		return false;
	});

	 $("#fo").change(function(){
		window.location.href="queryuserfu?locale="+$(this).val();
	});

    $("#firstpage").click(function(){
        var pageno="0";
        var pagesize=$("#pagesize").val();


        window.location.href="queryuserfu?pageno="+pageno+"&pagesize="+pagesize;
    });
    $("#toppage").click(function(){
        var pageno=$("#pageno").val();
        var pagesize=$("#pagesize").val();


        window.location.href="queryuserrrfu?pageno="+pageno+"&pagesize="+pagesize;

    });
    $("#nextpage").click(function(){
        var pageno=$("#pageno").val();

        var pagesize=$("#pagesize").val();





        window.location.href="queryuserrfu?pageno="+pageno+"&pagesize="+pagesize;
    });

    $("#endpage").click(function(){


        var pagesize=$("#pagesize").val();
        var sum='${sum}';

        if(sum%pagesize==0) {
            var pagecount=(sum/pagesize)-1;

            window.location.href="queryuserrrrfu?pageno="+ pagecount+"&pagesize="+pagesize;
		}
		else {
            var pagecount=(sum/pagesize)-1;
            pagecount=Math.ceil(pagecount);

            window.location.href="queryuserrrrfu?pageno="+ pagecount+"&pagesize="+pagesize;
		}


    });

    $("#kexuan").change(function(){
        var pagesize=$(this).val();
        $("#pagesize").val(pagesize);

        var pageno=$("#pageno").val();
        var pagesize=$("#pagesize").val();
        var pagecount=$("#zonggong").text();


         var a=pagecount/pagesize;
          a=Math.ceil(a);
        if(a>=parseInt(pageno)){
            window.location.href="queryuserfu?pageno="+pageno+"&pagesize="+pagesize;
        }else{
            window.location.href="queryuserfu?pageno="+0+"&pagesize="+pagesize;
        }
    });




    function zong(){
        var pageno= $("#pageno").val();
        var pagen =parseInt(pageno)+1;

        $("#dangqian").text(parseInt(pagen));

        var sum='${sum}';
        var pagesize=$("#pagesize").val();
        var pagecount=sum/pagesize;
        pagecount=Math.ceil(pagecount);
        $("#zonggong").text(pagecount);



        if(pagen == pagecount){

            $("#nextpage").hide();

        }
        else{
            $("#nextpage").show();
        }

        if(pagen==1){
            $("#toppage").hide();
        }
        else{
            $("#toppage").show();
        }

        var pagesize=$("#pagesize").val();
        $(".fu").text(parseInt(pagesize));


    }
    zong();




})


</script>
</head>
<body>

   <select id="fo" >
     <option value="zh_CN" <c:if test="${fo=='zh_CN'}">selected</c:if>>中文</option>
     <option value="en_US" <c:if test="${fo=='en_US'}">selected</c:if> >english</option>
   </select>

  <br> <br>

 <form action="" method="POST" class="formm" id="sc">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	


<table border="1" id="usertable">

    <tr>
     <td><fmt:message key="user.id">
</fmt:message></td>

     <td><fmt:message key="user.namee"></fmt:message></td>
     
     <td><fmt:message key="user.delete"></fmt:message></td>
     <td><fmt:message key="user.modify"></fmt:message></td>
    </tr>
   <c:forEach items="${requestScope.userfu}" var="userfu">
   <tr>
       <td>${userfu.t_id}</td>
      <td>${userfu.namee}</td>


         
        <td><a class="delete"  href="userfu/${userfu.t_id}" bc="${userfu.t_id}"><fmt:message key="user.delete"></fmt:message></a></td>
        <td><a href="userfu/${userfu.t_id}"><fmt:message key="user.modify"></fmt:message></a></td>
         </tr>
   </c:forEach>
</table>
   <br>
   <c:set var="accumulatio" scope="request" value="${requestScope.accumulation}"></c:set>
   <c:set var="pagesiz" scope="request" value="${requestScope.pagesize}"></c:set>
   <input type="hidden" name="pageno" id="pageno" value="${accumulatio}">
   <input type="hidden" name="pagesize" id="pagesize" value="${pagesiz}">
   <input type="hidden" name="sum" id="sum">
   <input type="hidden" name="pagecount" id="pagecount">
   当前是<font color="red"  id="dangqian" ></font>页，&nbsp;&nbsp;
   总共<font color="red" id="zonggong" ></font>页.&nbsp;&nbsp;



   <select id="kexuan">
       <option value="" class="fu"></option>
       <option value="2">2</option>
       <option value="3">3</option>
       <option value="4">4</option>
       <option value="5">5</option>
   </select>
   <br>
   <a href="#" id="firstpage">首页</a>&nbsp;&nbsp;
   <a href="#" id="toppage">上一页</a>&nbsp;&nbsp;
   <a href="#" id=nextpage>下一页</a>&nbsp;&nbsp;
   <a href="#" id="endpage">尾页</a>&nbsp;&nbsp;
  
   <br><br>
   <a href="usersfu"><fmt:message key="user.add"></fmt:message></a>
    <br><br>

   <a href="queryuser">操作员工</a>
   
    

    



   <br><br>

    
</body>
</html>