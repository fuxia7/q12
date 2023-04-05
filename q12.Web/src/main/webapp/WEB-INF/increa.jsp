<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.js"></script>
<script src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">



</script>
</head>
<body>

           <form:form action="${pageContext.request.contextPath }/users"  method="POST"   modelAttribute="user" enctype="multipart/form-data">
           
           
        
		  
		   <c:if test="${user.id!=0 }">
           <form:hidden path="id"  />
             <fmt:message key="user.namee"></fmt:message>:&nbsp;&nbsp;&nbsp; <form:select path="tid" items="${zhi}" itemLabel="namee" itemValue="t_id"></form:select><br>
           <input type="hidden" name=_method value="PUT"> 
           </c:if>
           
            <c:if test="${user.id==0}">
			 <fmt:message key="user.name"></fmt:message>:<form:input path="name"/><font color="red"><form:errors path="name"></form:errors></font><br>
			   <fmt:message key="user.namee"></fmt:message>:&nbsp;&nbsp;&nbsp; <form:select path="userfu.t_id" items="${zhi}" itemLabel="namee" itemValue="t_id"></form:select><br>
		  </c:if> 
		  <fmt:message key="user.price"></fmt:message>:<form:input path="price"/><font color="red"><form:errors path="price"></form:errors></font><br>
        
          
        
         
         <fmt:message key="user.password"></fmt:message>:<form:input path="password"/><font color="red"><form:errors path="password"></form:errors></font><br>
         <fmt:message key="user.sex"></fmt:message>:<form:radiobuttons path="sex" items="${xing}" /><br>
         <fmt:message key="user.birth"></fmt:message>:<form:input path="birth" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/><font color="red"><form:errors path="birth"></form:errors></font><br>
         链接:<input type="file" name="filelink"><br> 
      
        
         
           <input type="submit"   value=<fmt:message key="user.submit" ></fmt:message> >
           
          
           </form:form>
</body>
</html>