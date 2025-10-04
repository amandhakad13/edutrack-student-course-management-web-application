<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - EduTrack	</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <a href="index.html" class="back-btn">← Back to Home</a>
    
    <div class="container">
        <div class="header">
            <div class="logo"></div>
            <h1>Welcome Back</h1>
            <p class="subtitle">Login to your account</p>
        </div>
        
        <form action="loginServlet" method="post" autocomplete="off">
            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
                <div class="forgot-password">
                    <a href="#">Forgot Password?</a>
                </div>
            </div>
            
            <button type="submit" class="btn">Login</button>
        </form>
        
        <div class="register-link">
            Don't have an account? <a href="register.jsp">Create one</a>
        </div>
    </div>
    
    <%
    	
    	String success = (String) session.getAttribute("success");
        
        if(success!=null) {
        	%>
        	<h3><%= success %></h3>
        	<% 
        	
        	session.removeAttribute("success");
        }
    
    %>
</body>
</html>