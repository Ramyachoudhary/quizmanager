<%-- 
    Document   : professorhome
    Created on : Feb 4, 2018, 12:25:36 AM
    Author     : Ramya
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
    <head>



        <title>Quiz Manager</title>


        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--  <link rel="stylesheet" href="/resources/styles.css">  -->



        <style>
            .navbar {
                color: #FFFFFF;
                background-color: #6593D1;
            }
            .navbar-inverse .navbar-nav>li>a {
                color: #000000;
            }
            .navbar-brand{
                color: #000000;
            }
            .container-fluid{
                width:100%;
                padding:20px 50px;
            }

            .right-button{
                float:right;
                color: #FFFFFF;

            }

        </style>



    </head>
    <body>


        <nav class="navbar navbar-inverse navbar-fixed-top navbar-custom">

            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#" ><font color="white" style="font-style:oblique ">Quiz Manager</font></a>
                </div>
                <ul class="nav navbar-nav">
                    <li ><a href="shome">DashBoard</a></li>
                    <!--      <li><a href="addq">Add Questions</a></li>
                          <li><a href="createqz">Create Quiz</a></li>
                          <li><a href="#">Page 3</a></li>-->
                </ul>
                <!--      <a href="#" class="right-button">logout</a>-->
           

<p  class="right-button">${User.userName} &nbsp;&nbsp;
                    <a href="home"> <button type="button" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-user"></span> logout
                        </button></a>
                </p>
            </div>
        </nav>

    </body>
</html>
<br/><br/>