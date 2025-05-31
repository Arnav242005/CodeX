<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Control Panel</title>
<link rel="stylesheet" href="adminControl.css">
</head>
<body>
	<div class="main-container">
		<h2>Welcome, Admin!</h2>
	<p>Here’s a quick overview of your platform:</p>
	</div>
		<div class="buttons">
			<button onclick="goToUsers()">Manage Users</button>
			<button onclick="goToProjects()">Manage Projects</button>
			<button onclick="goToMentors()">Manage Mentors</button>
			<button onclick="goToAffiliate()">Affiliate Partners</button>
		</div>
			
	<div class="dashboard-stats">
	    <div class="stat-card">
	        <h3>Total Users</h3>
	        <p><%= request.getAttribute("userCount").toString() %></p>
	    </div>
	    <div class="stat-card">
	        <h3>Mentors</h3>
	        <p><%= request.getAttribute("mentorCount").toString() %></p>
	    </div>
	    <div class="stat-card">
	        <h3>Total Projects</h3>
	        <p><%= request.getAttribute("projectCount").toString() %></p>
	    </div>
	    <div class="stat-card">
	        <h3>Purchased Projects</h3>
	        <p><%= request.getAttribute("purchasedCount").toString() %></p>
	    </div>
	    <div class="stat-card">
	        <h3>New Messages</h3>
	        <p><%= request.getAttribute("messageCount").toString() %></p>
	    </div>
	    <div class="stat-card">
	        <h3>Total Affiliate Partners</h3>
	        <p><%= request.getAttribute("affiliateCount").toString() %></p>
	    </div>
	</div>
<script src="adminControl.js"></script>
</body>
</html>