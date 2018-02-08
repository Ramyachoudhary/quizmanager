<%-- 
    Document   : takeqz
    Created on : Feb 5, 2018, 9:49:03 AM
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
            <form action ="submittakenquiz">
            <br/><br/><br/><br/>
            <h3>quiz :${quizname}</h3>
            <input type="hidden" name="sid" value="student1"/>
             <input type="hidden" name="qid" value="${qzid}"/>
              <input type="hidden" name="quizname" value="${quizname}"/>
            <ol type="1">
                
                <c:forEach items="${questionsList}" var="question">
                    <input type="hidden" name="questions" value="${question.question_id}"/>
                    <li>
                        <div id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="card">
                                <div class="card-header" role="tab" id="headingOne">
                                    <h5 class="mb-0"> <h2>
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne${question.question_id}" aria-expanded="true" aria-controls="collapseOne${question.question_id}">
                                                ${question.question_title}
                                            </a></h2>
                                    </h5>
                                </div>

                                <div id="collapseOne${question.question_id}" class="collapse" role="tabpanel" aria-labelledby="headingOne">
                                    <div class="card-block">
                                        <ol type="A">
                                            <li> <input type="checkbox" name="${question.question_id}" value="${question.option_one}"/> ${question.option_one}</li>
                                            <li><input type="checkbox" name="${question.question_id}" value="${question.option_two}"/> ${question.option_two}</li>
                                            <li><input type="checkbox" name="${question.question_id}" value="${question.option_three}"/> ${question.option_three}</li>
                                            <li><input type="checkbox" name="${question.question_id}" value="${question.option_four}"/> ${question.option_four}</li>
                                            <li><input type="checkbox" name="${question.question_id}" value="${question.option_five}"/> ${question.option_five}</li>

                                        </ol>

                                    </div>
                                </div>
                            </div>
                    </li>
                </c:forEach>
            </ol>
             
             <input type="submit" value="submit quiz"/>
        </form>
        </div>

    </body>
</html>
