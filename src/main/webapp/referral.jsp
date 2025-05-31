<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Referral</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background: #ffffff;
        padding: 40px;
        border-radius: 16px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        text-align: center;
        width: 350px;
    }

    .referral-code {
        font-size: 1.5rem;
        color: #333;
        margin-bottom: 20px;
        font-weight: bold;
        word-break: break-all;
    }

    .btn-home {
        background-color: #4facfe;
        border: none;
        color: white;
        padding: 12px 25px;
        text-align: center;
        text-decoration: none;
        font-size: 16px;
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .btn-home:hover {
        background-color: #00c3ff;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="referral-code">
            <% String code = (String) request.getAttribute("referralcode"); %>
            <%= code %>
        </div>
        <a href="index.html"><button class="btn-home">Go to Home</button></a>
    </div>
</body>
</html>
