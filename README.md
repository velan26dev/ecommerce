# 🛒 E-Commerce Web Application

### 🚀 Full Stack Java \| Spring Boot \| React \| JWT \| MySQL

------------------------------------------------------------------------

## 📌 Project Overview

A full-stack **E-Commerce Web Application** built using **Spring Boot
(Backend)** and **React.js (Frontend)** with secure authentication using
**JWT**.

This project simulates a real-world online shopping platform with secure
REST APIs, role-based authorization, cart management, and admin product
control.

------------------------------------------------------------------------

## 🏗 System Architecture

React Frontend → Axios → Spring Boot REST API → Service Layer →
JPA/Hibernate → MySQL Database

✔ Layered Architecture\
✔ RESTful API Design\
✔ JWT-Based Authentication\
✔ Role-Based Access Control

------------------------------------------------------------------------

## 🛠 Tech Stack

### 🔹 Backend

-   Java 21+
-   Spring Boot
-   Spring Security
-   JWT Authentication
-   Hibernate / JPA
-   MySQL
-   Maven

### 🔹 Frontend

-   React.js
-   React Router
-   Axios (Interceptor for JWT)
-   Context API / State Management
-   CSS

### 🔹 Tools

-   Git & GitHub
-   Postman
-   Eclipse / VS Code

------------------------------------------------------------------------

## ✨ Core Features

### 👤 User Module

-   User Registration & Login
-   Secure JWT Authentication
-   Browse Products
-   Add to Cart
-   Remove from Cart
-   Update Cart Quantity

### 🛠 Admin Module

-   Add Products
-   Update Products
-   Delete Products
-   Manage Inventory

### 🔐 Security

-   BCrypt Password Encryption
-   JWT Token Generation & Validation
-   Role-Based Authorization
-   Protected REST APIs

------------------------------------------------------------------------

## 📂 REST API Endpoints

### Authentication

POST /auth/register\
POST /auth/login

### Product

GET /api/product\
POST /api/product\
PUT /api/product/{id}\
DELETE /api/product/{id}

### Cart

POST /api/cart/{productId}/{quantity}\
DELETE /api/cart/{productId}\
GET /api/cart

------------------------------------------------------------------------

## 🗄 Database Tables

-   User
-   Product
-   Cart
-   Order

------------------------------------------------------------------------

## ⚙ Installation & Setup

### 1️⃣ Clone Repository

git clone https://github.com/velan26dev/ecommerce.git

### 2️⃣ Backend Setup

Configure MySQL in application.properties and run: mvn spring-boot:run

Backend runs at: http://localhost:8080

### 3️⃣ Frontend Setup

npm install\
npm run dev

Frontend runs at: http://localhost:5173

------------------------------------------------------------------------

## 🧠 Key Learning Outcomes

-   Implemented JWT authentication with Spring Security
-   Designed scalable REST APIs
-   Integrated frontend and backend using Axios
-   Handled cart synchronization issues
-   Applied layered architecture principles

------------------------------------------------------------------------

## 🚀 Future Enhancements

-   Payment Gateway Integration
-   Order History Module
-   Cloud Image Storage
-   Docker Deployment
-   CI/CD Pipeline

------------------------------------------------------------------------

## 👨‍💻 Developer

**Velan K**\
Java Full Stack Developer

LinkedIn: www.linkedin.com/in/velan-k \
GitHub: https://github.com/velan26dev

------------------------------------------------------------------------

⭐ If you like this project, give it a star on GitHub!
