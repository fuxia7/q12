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

           <form:form action="${pageContext.request.contextPath }/usersfu"  method="POST"   modelAttribute="userfu" enctype="multipart/form-data">
           
           
        
		  
		   <c:if test="${userfu.t_id!=0}">
           <form:hidden path="t_id"  />

           <input type="hidden" name=_method value="PUT"> 
           </c:if>
           
            <c:if test="${userfu.t_id==0}">

		  </c:if>

               <fmt:message key="user.name"></fmt:message>:<form:input path="namee"/><br>

        
          
        
         

      
        
         
           <input type="submit"   value=<fmt:message key="user.submit" ></fmt:message> >
           
          
           </form:form>
</body>
</html>