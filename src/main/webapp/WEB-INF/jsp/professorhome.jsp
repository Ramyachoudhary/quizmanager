<%-- 
    Document   : professorhome
    Created on : Feb 4, 2018, 12:25:36 AM
    Author     : Ramya
--%>

<html>
<head>
    
    
    
	<title>Quiz Manager</title>
	


</head>
<%@include file="headerp.jsp" %>
    <body>
        <br/><br/><br/> <br/><br/>
        <div class="container">
            <h2> Quiz report  </h2>
            <table class="table table-striped">
                <tr><th>Quiz name </th><th> student name </th><th> score </th></tr>
            <c:forEach items="${resultarray}" var="result">
                
                <tr><td>${result.quiz_name}</td><td> ${result.user_id} </td> <td> ${result.correct_answers}/ ${result.total_answered}</td></tr> 
                
                
            </c:forEach>
            </table>
            
        </div>
    </body>
</html>
