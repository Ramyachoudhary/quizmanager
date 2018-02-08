<%-- 
    Document   : addquestions
    Created on : Feb 4, 2018, 1:41:41 AM
    Author     : Ramya
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script>
            
            function myFunction(){
               
                
                
                var q1=document.getElementById("questiontext").value ;
                var o1=document.getElementById("option_one").value;
                var o2=document.getElementById("option_two").value;
                var o3=document.getElementById("option_three").value;
                var o4=document.getElementById("option_four").value;
                var o5=document.getElementById("option_five").value;
                
                if(q1==""){
                    alert("please enter question title");
                     
                return false;
                }else if(o1==""){
                    alert("please enter option one");
                     
                return false;
                }else
                if(o2==""){
                    alert("please enter option two");
                     
                return false;
                }else
                     if(o3==""){
                    alert("please enter option three");
                     
                return false;
                }else
                if(o4==""){
                    alert("please enter option four");
                     
                return false;
                }else
                if(o5==""){
                    alert("please enter option five");
                     
                return false;
                }else
                if(o1.charAt(0)!="+"&&o1.charAt(0)!="-"){
                    alert("option 1, first charecter should be (+) or (-)");
                     
                return false;
                }else
                  if(o2.charAt(0)!="+"&&o2.charAt(0)!="-"){
                    alert("option 2, first charecter should be (+) or (-)");
                     
                return false;
                }else
                  if(o3.charAt(0)!="+"&&o3.charAt(0)!="-"){
                    alert("option 3, first charecter should be (+) or (-)");
                     
                return false;
                }else
                      if(o4.charAt(0)!="+"&&o4.charAt(0)!="-"){
                    alert("option 4, first charecter should be (+) or (-)");
                     
                return false;
                }else
                        if(o5.charAt(0)!="+"&&o5.charAt(0)!="-"){
                    alert("option 5, first charecter should be (+) or (-)");
                                    return false;
                }else{
                 return true;
                }
                
                
               
            }
            
            
            </script>
        
        
        
        <title>JSP Page</title>
        <style>
            
        label {
    color: #6593D1;
    font-style: bold;
}
</style>
           <%@include file="headerp.jsp" %>
    </head>
    <body>
     
      
        

<div class="container">
  <h2>Add Question</h2>
  <form:form action="submitquestion"  onsubmit="return myFunction()"  modelAttribute="question" name="Login_Form" class="form-signin">
    <div class="form-group">
      <label for="questiontext">Question Text</label>
      <form:input path="question_title" type="text" class="form-control" id="questiontext" placeholder="Question text" name="questiontext"/>
    </div>
      <br/><br/>
      <font color="red">* first letter should be +(plus) for positive options -(minus) for negative options </font>
    <div class="form-group">
      <label for="option_one">Option 1.</label>
      <form:input path="option_one"  class="form-control" id="option_one" placeholder="option one" name="option_one"/>
    </div>
      
      
         <div class="form-group">
      <label for="option_two">Option 2.</label>
      <form:input path="option_two" class="form-control" id="option_two" placeholder="option two" name="option_two"/>
    </div>
      
         <div class="form-group">
      <label for="option_three">Option 3.</label>
      <form:input path="option_three" class="form-control" id="option_three" placeholder="option three" name="option_three"/>
    </div>
         <div class="form-group">
      <label for="option_four">Option 4.</label>
      <form:input path="option_four" class="form-control" id="option_four" placeholder="option four" name="option_four"/>
    </div>
         <div class="form-group">
      <label for="pwd">Option 5.</label>
      <form:input path="option_five"  class="form-control" id="option_five" placeholder="option five" name="option_five"/>
    </div>
      
      
      
      
<!--    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>-->
<center>  <button type="submit" class="btn btn-primary">Submit</button></center>
  </form:form>
</div>

        
    </body>
</html>
