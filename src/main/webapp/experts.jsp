<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CodeX</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="experts.css">
    <script defer src="script.js"></script>
</head>
<body>
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
                    <li class="nav-item"><a href="experts.jsp" class="nav-link">Mentorship</a></li>                    
                    <li class="nav-item"><a href="login.jsp" class="nav-link">Login</a></li>
                    <li class="nav-item"><a href="signup.jsp" class="nav-link">Signup</a></li>
                    
                       <button class="btn free-consultation" onclick="location.href='#inquiry'">Free Consultation</button>
                       
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div class="card-container">
    <!-- Card 1 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Aryan Sharma</h2>
      <div class="role">Java Developer</div>
      <div class="location">📍 Mumbai, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ Java</div>
        <div class="tag">Spring Boot</div>
        <div class="tag">Backend</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>

    <!-- Card 2 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Neha Verma</h2>
      <div class="role">Python Developer</div>
      <div class="location">📍 Delhi, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ Python</div>
        <div class="tag">Flask</div>
        <div class="tag">Data Science</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>

    <!-- Card 3 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Ravi Mehta</h2>
      <div class="role">C Developer</div>
      <div class="location">📍 Hyderabad, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ C</div>
        <div class="tag">Embedded Systems</div>
        <div class="tag">Low Level</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>

    <!-- Card 4 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Sneha Kapoor</h2>
      <div class="role">C++ Developer</div>
      <div class="location">📍 Bangalore, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ C++</div>
        <div class="tag">Game Dev</div>
        <div class="tag">DSA</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>

    <!-- Card 5 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Ankit Reddy</h2>
      <div class="role">IoT Specialist</div>
      <div class="location">📍 Pune, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ IoT</div>
        <div class="tag">Arduino</div>
        <div class="tag">ESP8266</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>

    <!-- Card 6 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Kajal Singh</h2>
      <div class="role">MERN Stack Dev</div>
      <div class="location">📍 Jaipur, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ MERN</div>
        <div class="tag">MongoDB</div>
        <div class="tag">React</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>

    <!-- Card 7 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Vikram Rao</h2>
      <div class="role">Cloud Engineer</div>
      <div class="location">📍 Chennai, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ Cloud</div>
        <div class="tag">AWS</div>
        <div class="tag">DevOps</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>

    <!-- Card 8 -->
    <div class="card">
      <img src="https://via.placeholder.com/100" alt="Mentor Photo" />
      <h2>Divya Raj</h2>
      <div class="role">Tech Mentor</div>
      <div class="location">📍 Kolkata, India</div>
      <div class="tags">
        <div class="tag highlight">⭐ Mentoring</div>
        <div class="tag">Soft Skills</div>
        <div class="tag">Project Guidance</div>
      </div>
      <button class="quote-btn">Get a Quote</button>
    </div>
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
                <li><a href="delete.jsp">Delete Account</a></li>
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


</body>
</html>