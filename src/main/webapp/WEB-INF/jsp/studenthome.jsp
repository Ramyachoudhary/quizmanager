<%-- 
    Document   : studenthome
    Created on : Feb 4, 2018, 9:17:43 PM
    Author     : Ramya
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <%@include file="headers.jsp" %>
    <body>
         <div class="container">
             <h1>Quiz</h1>
             <h2>please select quiz</h2>
             <ul>
             <c:forEach items="${quizlist}" var="qz">
                 <li>
                 <h3> <a href="takeqz?qzid=${qz.quizid}&qzname=${qz.quizname}">${qz.quizname}</a></h3>
                 </li>
             </c:forEach>
             </ul>
         </div>
    </body>
</html>
