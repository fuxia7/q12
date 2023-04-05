<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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



                if( (sum%pagesize)==1 &&pageno!=0 ){


                    var pagen=parseInt(pageno)-1;
                    //alert(pagen+"***");

                    var hre=href+"?pageno="+pagen+"&pagesize="+pagesize;
                    $(".formm").attr("action",hre).submit();
                }

                else{
                    //alert("关九?");

                    var hreff=href+"?pageno="+pageno+"&pagesize="+pagesize;
                    $(".formm").attr("action",hreff).submit();


                }








                /*alert("表示有员工关联，公司不能删除");*/
                return false;
            });

            $("#fo").change(function(){
                window.location.href="queryuser?locale="+$(this).val();
            });

            $("#firstpage").click(function(){
                var pageno="0";
                var pagesize=$("#pagesize").val();


                window.location.href="queryuser?pageno="+pageno+"&pagesize="+pagesize;
            });
            $("#toppage").click(function(){
                var pageno=$("#pageno").val();
                var pagesize=$("#pagesize").val();


                window.location.href="queryuserrr?pageno="+pageno+"&pagesize="+pagesize;

            });
            $("#nextpage").click(function(){
                var pageno=$("#pageno").val();

                var pagesize=$("#pagesize").val();





                window.location.href="queryuserr?pageno="+pageno+"&pagesize="+pagesize;
            });

            $("#endpage").click(function(){


                var pagesize=$("#pagesize").val();
                var sum='${sum}';

                if(sum%pagesize==0) {
                    var pagecount=(sum/pagesize)-1;

                    window.location.href="queryuserrrr?pageno="+ pagecount+"&pagesize="+pagesize;
                }
                else {
                    var pagecount=(sum/pagesize)-1;
                    pagecount=Math.ceil(pagecount);

                    window.location.href="queryuserrrr?pageno="+ pagecount+"&pagesize="+pagesize;
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
                    window.location.href="queryuser?pageno="+pageno+"&pagesize="+pagesize;
                }else{
                    window.location.href="queryuser?pageno="+0+"&pagesize="+pagesize;
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

<form action="usersce" method="POST">
    <input type="text" name="user" />

    <input type="submit" value=<fmt:message key="user.submit"></fmt:message>>
</form>

<table border="1" id="usertable">

    <tr>
        <td><fmt:message key="user.id">
        </fmt:message></td>
        <td><fmt:message key="user.name"></fmt:message></td>
        <td><fmt:message key="user.price"></fmt:message></td>
        <td><fmt:message key="user.password"></fmt:message></td>
        <td><fmt:message key="user.sex"></fmt:message></td>
        <td><fmt:message key="user.tid"></fmt:message></td>
        <td><fmt:message key="user.birth"></fmt:message></td>
        <td>链接</td>
        <%-- <td><fmt:message key="user.t_id"></fmt:message></td>--%>
        <td><fmt:message key="user.namee"></fmt:message></td>

        <td><fmt:message key="user.delete"></fmt:message></td>
        <td><fmt:message key="user.modify"></fmt:message></td>
    </tr>
    <c:forEach items="${requestScope.user}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.price}</td>
            <td>${user.password}</td>
            <td>${user.sex}</td>
            <td>${user.tid}</td>
            <td><fmt:formatDate value="${user.birth}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>

                <c:set  var="chh" scope="request" value="${user.link}">
                </c:set>
                    <%-- <%=request.getAttribute("chh") %>  --%>
                <img alt="" src="zp?str=<%=java.net.URLEncoder.encode(request.getAttribute("chh") == null? "":String.valueOf(request.getAttribute("chh")))%>" width="55" height="85">

                    <%--  ${user.link}  --%>

            </td>
            <td>${user.userfu.namee}</td>


                <%--  <td>${user.userfu.t_id}</td>
                 <td>${user.userfu.namee}</td>  --%>

            <td><a class="delete"  href="user/${user.id}"><fmt:message key="user.delete"></fmt:message></a></td>
            <td><a href="user/${user.id}"><fmt:message key="user.modify"></fmt:message></a></td>
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
<a href="users"><fmt:message key="user.add"></fmt:message></a>
<br><br>
<form action="downloadexcel" method="post">
    <input type="submit" value=<fmt:message key="user.download"></fmt:message>>
</form>
<br>
<form action="zp" method="GET">
    <input type="text" name="str">
    <input type="submit" value=<fmt:message key="user.clickDownload"></fmt:message>>
</form>
<br>


<a href="${pageContext.request.contextPath }/zp?str=<%=java.net.URLEncoder.encode("C:\\Users\\86159\\Desktop\\fj.jpg")%>" ><fmt:message key="user.downloadHyperlink"></fmt:message></a>
<br><br>
<form action="daoru" method="post">
    <input type="submit" style="color:red" value="导入数据">
</form>

<br>
<form action="dao" method="post" enctype="multipart/form-data">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="file" name="shuju"><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="导入数据">
</form>

<br><br>
<a href="queryuserfu">操作部门</a>

</body>
</html>