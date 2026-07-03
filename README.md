# Employee-ProjectDay3

# 🧑‍💼 Employee Management System – Spring Boot App

A **full-stack employee management application** built with **Spring Boot**, **Thymeleaf**, **H2 Database**, and front-end technologies like **HTML, CSS**.  
This project demonstrates a complete CRUD web application with authentication, validation, exception handling, and a modern coral‑red UI.

---

## 🚀 Project Purpose

The **Employee Management System** is designed to help HR or managers handle employee records easily. It provides a simple web interface to:

- ✅ **Create** new employees (with auto‑assigned salaries based on role)
- 📋 **Display** all employees in a clean table
- 💰 **Raise** salaries by percentage
- 🔐 **Login** securely (with database‑backed credentials)
- 🚪 **Exit** with a friendly "Thank You" message
- - 🗄️ **Persist** data in H2 database
- 🧪 **Test** REST APIs via Postman


---

## 🛠️ Technology Stack

| Technology | Purpose |
|------------|---------|
| **Spring Boot 3.2.x** | Core framework (MVC, REST, DI) |
| **Spring Data JPA (Hibernate)** | ORM for database operations |
| **HTML5** | Structuring the web pages |
| **CSS3** | Styling and responsive design (coral‑red theme) |
| **H2 Database** | Embedded file‑based database (data persists) |
| **Thymeleaf** | Server‑side HTML template engine |
| **Maven** | Dependency management and build tool |
| **Java 17+** | Programming language |
| **H2 Console** | In‑browser SQL viewer |

---

## 🔐 Login System – How It Works

The login page  is the first screen users see when they open the application.  
It validates credentials against the **H2 database** using Spring Data JPA.

### 🔑 How the flow works:

| Step | Action | Description |
|------|--------|-------------|
| 1 | **Navigate to** `/login` | User sees a login form (username + password). |
| 2 | **Enter credentials** | The app looks up the `User` entity by username. |
| 3 | **Password check** | Compares the entered password with the stored password. |
| 4 | **Redirect** | On success → `welcome.html`; On failure → back to `login.html` with an error message. |
| 5 | **Logout** | Click "Logout" → session clears → return to login page. |

### 🔐 Current Login Credentials

| Field | Value |
|-------|-------|
| **Username** | Any valid username from the `users` table |
| **Password** | `admin123` (for all users) |


### Database Schema

sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
); 
└── raise.html 

--------------------------------------------------------------------------------------------------------------------------------------------------
After successful login, the Employee Management System home page is displayed at http://localhost:8090/.

Login rules:
 Registration Form
Field	Validation Rules
Name	• Only letters (A-Z, a-z)
• Maximum 2 spaces allowed
• No numbers or special characters
Age	• Minimum: 18
• Maximum: 60
Designation	• Only 3 allowed:
- trainer
- tester
- programmer


H2 Database Console
Open H2 Console: http://localhost:8090/h2-console

Enter login details:

Field	Value
JDBC URL	jdbc:h2:file:./data/employee_db
Username	sa
Password	(leave blank)

Verify the employee list matches the web UI display.

-------------------------------------------------------------------------
REST API Testing with Postman
All REST endpoints are prefixed with /api/employees.

Action	Method	URL	Body / Params
Create Employee	POST	/api/employees	JSON body
Get All Employees	GET	/api/employees	None
Get Employee by ID	GET	/api/employees/{id}	None
Raise Salary	PUT	/api/employees/{id}/salary?percentage=10	Query param
Delete Employee	DELETE	/api/employees/{id}	None
