<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CodeX</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
    <script defer src="script.js"></script>
    <style>
    .delete-form-container {
      max-width: 400px;
      margin: 60px auto;
      padding: 30px;
      background-color: #f1f1f1;
      border-radius: 12px;
      box-shadow: 0 6px 12px rgba(0,0,0,0.1);
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .delete-form-container h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #333;
    }

    .delete-form-container label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
      color: #555;
    }

    .delete-form-container input[type="email"],
    .delete-form-container input[type="password"] {
      width: 100%;
      padding: 10px 12px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 14px;
    }

    .delete-form-container input[type="submit"] {
      width: 100%;
      padding: 12px;
      background-color: #dc3545;
      border: none;
      color: white;
      font-size: 16px;
      font-weight: bold;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .delete-form-container input[type="submit"]:hover {
      background-color: #c82333;
    }
  </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container-fluid">
            <div class="d-flex align-items-center">
                <a href="index.html">
    <img src="components/codeX.png" alt="Logo" class="logo">
</a>
                <img src="components/searchpng.png" alt="Search" class="search-icon" id="searchIcon">
                <input type="text" placeholder="Search..." class="search-bar" id="searchBar">
            </div>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a href="#popular-box" class="nav-link">Buy</a></li>
                    <li class="nav-item"><a href="Sales.jsp" class="nav-link">Sell</a></li>
                    <li class="nav-item"><a href="request.jsp" class="nav-link">Request</a></li>
                    
                    <li class="nav-item"><a href="login.jsp" class="nav-link">Login</a></li>
                    <li class="nav-item"><a href="signup.jsp" class="nav-link">Signup</a></li>
                    
                       <button class="btn free-consultation" onclick="location.href='index.html#inquiry'">Free Consultation</button>
                       
                       
                    </li>
                </ul>
            </div>
        </div>
    </nav>
 <div class="delete-form-container">
  <h2>Delete Individual</h2>
  <form action="deleteIndividualServlet" method="post">
    <label for="email">Email</label>
    <input type="email" name="email" id="email" required>

    <label for="password">Password</label>
    <input type="password" name="password" id="password" required>

    <input type="submit" value="Delete">
  </form>
</div>
<div style="height: 80px;"></div>

  <footer class="footer">
    <div class="footer-container">
        <div class="footer-column">
            <h3>By Category</h3>
            <ul>
                <li><a href="#">Web Source Codes</a></li>
                <li><a href="#">iOS</a></li>
                <li><a href="#">Android Apps</a></li>
                <li><a href="#">PHP Scripts</a></li>
            </ul>
        </div>
        <div class="footer-column">
            <h3>Media</h3>
            <ul>
                <li><a href="#">Articles</a></li>
                <li><a href="#">Blog</a></li>
            </ul>
        </div>
        <div class="footer-column">
            <h3>License</h3>
            <ul>
                <li><a href="#">License</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Refund Policy</a></li>
                <li><a href="#">Management</a></li>
                <li><a href="#">Support</a></li>
            </ul>
        </div>
        <div class="footer-column">
            <h3>Terms of Service</h3>
            <ul>
                <li><a href="#">Terms of Service</a></li>
            </ul>
        </div>
        <div class="footer-column">
            <h3>About CodeX</h3>
            <ul>
                <li><a href="#">Become an Affiliate</a></li>
                <li><a href="#">Become a Sales Partner</a></li>
                <li><a href="#">How it Works</a></li>
                <li><a href="#">FAQs</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">Partners</a></li>
            </ul>
        </div>
    </div>

    <div class="footer-bottom">
        <img src="components/codeX.png" alt="CodeX Logo" class="footer-logo"> 
        <div class="social-icons">
            <a href="#"><img src="components/facebook.svg" alt="Facebook"></a>
            <a href="#"><img src="components/twitterX.webp" alt="Twitter"></a>
            <a href="#"><img src="components/instagram.svg" alt="Instagram"></a>
            <a href="#"><img src="components/linkedin.svg" alt="LinkedIn"></a>
            <a href="#"><img src="components/youtube.svg" alt="YouTube"></a>
        </div>
    </div>
</footer>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>