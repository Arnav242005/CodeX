🎓 Academic & IT Project Marketplace

A full-stack web-based marketplace enabling students, developers, and organizations to buy, sell, and request academic/IT projects. The platform integrates mentorship, affiliate registration, and documentation support, providing a structured and secure environment for collaboration.

🚀 Features

🔐 User Authentication & Security

Secure login and registration using JBCrypt password hashing

Servlet filters to protect routes and restrict unauthorized access

🏗 N-Tier Architecture

Controller → Service → DAO → Database

Hibernate ORM for database abstraction and efficient query handling

📂 Marketplace Functionality

Dynamic project filtering and search

Replica payment system for project purchases

Developer-client communication modules

✅ Testing & Reliability

Unit and integration testing with JUnit

Achieved 90%+ test case pass rate

🛠️ Tech Stack

Frontend: HTML, CSS, JavaScript, Bootstrap, Tailwind CSS
Backend: Enterprise Java (Servlets, JSP), Hibernate, JBCrypt, Maven
Database: MySQL
Tools: Eclipse EE, Figma, StarUML, JUnit

📐 Architecture

The project follows a secure N-tier architecture:

Client (Browser)  
   ↓  
Controller Layer (Servlets)  
   ↓  
Service Layer (Business Logic)  
   ↓  
DAO Layer (Data Access Objects via Hibernate)  
   ↓  
Database (MySQL)  

📷 Screenshots / Mockups

(Add screenshots or Figma designs here if available)

⚡ Getting Started
Prerequisites

Java JDK 8+

Maven

MySQL

Eclipse EE / IntelliJ IDEA

Installation & Setup

Clone the repository:

git clone https://github.com/your-username/academic-it-marketplace.git


Import into Eclipse EE as a Maven project.

Configure hibernate.cfg.xml with your MySQL credentials.

Run the SQL scripts from /database to set up schema and seed data.

Deploy on Apache Tomcat server.

🧪 Testing

Run JUnit tests located in /src/test/java.

Achieved 90%+ test coverage across unit, integration, and beta testing.

📌 Future Enhancements

Integrate real payment gateways (Razorpay/Stripe/PayPal)

Add role-based dashboards for students, developers, and admins

Implement REST APIs for external integrations

Deploy on cloud platforms (AWS, Azure, or Heroku)

👨‍💻 Author

Arnav Jadhav

Full-Stack Developer | Java & React Enthusiast

LinkedIn | GitHub

Do you want me to also create a short version of this README (just project intro + features + tech stack + setup) so it’s lightweight for GitHub, and you can keep the detailed one in your documentation?
