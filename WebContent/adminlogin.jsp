<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
        /* Basics */
        html, body
        {
            padding: 0;
            margin: 0;
            width: 100%;
            height: 100%;
            font-family: "Helvetica Neue" , Helvetica, sans-serif;
            background-image: url(C:\\Users\\admin\\eclipse-workspace\\StudentInfoManage\\web-design-2906159_1920.jpg);
        }
        .logincontent
        {
            position: fixed;
            width: 350px;
            height: 300px;
            top: 50%;
            left: 50%;
            margin-top: -150px;
            margin-left: -175px;
            background-color: Transparent;
            padding-top: 10px;
        }
        .loginheading
        {
            border-bottom: solid 1px #ECF2F5;
            padding-left: 18px;
            padding-bottom: 10px;
            color: #ffffff;
            font-size: 20px;
            font-weight: bold;
            font-family: sans-serif;
        }
        label
        {
            color: #ffffff;
            display: inline-block;
            margin-left: 18px;
            padding-top: 10px;
            font-size: 15px;
        }
        input[type=text], input[type=password]
        {
            background-color: Transparent;
            font-size: 14px;
            padding-left: 10px;
            margin: 10px;
            margin-top: 12px;
            margin-left: 18px;
            width: 300px;
            height: 35px;
            border: 1px solid #ccc;
            border-radius: 2px;
            box-shadow: inset 0 1.5px 3px rgba(190, 190, 190, .4), 0 0 0 5px #f5f5f5;
            font-size: 14px;
        }
        
       input[type=submit]{
       background-color: Transparent;
    overflow:hidden;
    border: 3px solid;;
    color: white;
    text-align: center;
    display: inline-block;
    font-size: 16px;
    margin-left:80px;
   position:relative;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
         width: 150px;
            height: 30px;
       }
       
       
       .button{
    background-color: Transparent;
    overflow:hidden;
    border: 3px solid;;
    color: white;
    padding-top:10px;
    padding-bottom:10px;
    padding-left:10px;
    text-align: center;
    display: inline-block;
    font-size: 16px;
   margin-top:50px;
   margin-left:80%;
   position:relative;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="login.jsp"><button class="button button5">BACK TO HOME</button></a>
<div class="logincontent">
        <div class="loginheading">
          !!!! WELCOME ADMIN !!!!
        </div>
        <form name='frm' action="adminlogin">
        <label for="txtUserName">
            Username:</label>
        <input type="text" id="txtUserName" name="username" />
        <label for="txtPassword">
            Password:</label>
        <input type="password" id="txtPassword" name="password" />
        <br><br>
            <input type="submit" class="login" value="Login" id="btnSubmit" />
       </form>
    </div>
</body>
</html>