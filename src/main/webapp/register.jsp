<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - EduTrack</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
    <a href="index.html" class="back-btn">← Back to Home</a>
    
    <div class="container">
        <div class="header">
            <div class="logo"></div>
            <h1>Create Account</h1>
            <p class="subtitle">Join EduTrack today</p>
        </div>
        
        <form action="register" method="post" autocomplete="off">
            <div class="form-group">
                <label for="name">Full Name</label>
                <input type="text" id="name" name="name">
            </div>
            
            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="role">Role</label>
                <select id="role" name="role" required>
                    <option value="">Select Role</option>
                    <option value="student">Student</option>
                    <option value="admin">Admin</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit" class="btn">Create Account</button>
        </form>
        
        <div class="login-link">
            Already have an account? <a href="login.jsp">Sign in</a>
        </div>
    </div>
    
    <%
    	
    String error = (String) session.getAttribute("error");
    String error1 = (String) session.getAttribute("error1");
    String unexpected = (String) session.getAttribute("unexpected");
    String duplicate = (String) session.getAttribute("duplicate");
                		
    if(error!=null) {
    	
    	%>
    	<h3><%= error %></h3>
    	<%
    	
    	session.removeAttribute("error");
    }
    
    if(duplicate!=null) {
	    
	    %>
	    <h3><%= duplicate %></h3>
	    <%
	    	
	    session.removeAttribute("duplicate");	
	}
    
    if(error1!=null) {
    	
    	%>
    	<h3><%= error1 %></h3>
    	<%
    	
    	session.removeAttribute("error1");
	}
    
    if(unexpected!=null) {
    	
    	%>
    	<h3><%= unexpected %></h3>
    	<%
    	
    	session.removeAttribute("unexpected");
	}
    
    %>
    
</body>
</html>