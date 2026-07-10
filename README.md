# 🛒 Java Spring Boot Full Stack — eCommerce Project Masterclass

Repository for tracking my progress through the Udemy course **[Java Spring Boot Full Stack: eCommerce Project Masterclass](https://www.udemy.com/course/spring-boot-using-intellij-build-a-real-world-project/)** by Faisal Memon (EmbarkX) — building a production-grade eCommerce application from scratch using **Spring Boot 4 / Spring Framework 7** on the backend and **React** on the frontend.

> 📌 This repo contains my personal implementation, notes, and code-alongs as I go through the course. Code may diverge from the instructor's version as I experiment and add my own touches.

---

## 📖 About the Course

- **Instructor:** Faisal Memon (EmbarkX)
- **Duration:** 90+ hours | 57 sections | 581+ lectures
- **Platform:** Udemy
- **Focus:** Build a complete, real-world eCommerce REST API with Spring Boot, secure it with Spring Security + JWT, connect a React frontend, and deploy to AWS.

---

## 🧰 Tech Stack

### Backend
- **Java 21**
- **Spring Framework 7 / Spring Boot 4**
- **Spring Data JPA / Hibernate**
- **Spring Security + JWT** (Authentication & Authorization)
- **PostgreSQL / MySQL**
- **Lombok**
- **Spring AI** (Generative AI integration)

### Frontend
- **React**
- **Tailwind CSS**
- **Redux**
- **React Router**

### Tooling & Deployment
- **IntelliJ IDEA**
- **Postman**
- **AWS** (Deployment)
- **Spring Boot Profiles**

---

## 🗺️ Course Roadmap / Sections Covered

- [ ] Introduction and Setup
- [ ] Basics of Web Development & Internet
- [ ] Spring Framework — The Basics
- [ ] Spring Framework — Working with Annotations
- [ ] Spring Boot 101 — Building the First REST API
- [ ] eCommerce App: Category Module
- [ ] Databases and Persistence Fundamentals
- [ ] Getting Started with JPA
- [ ] Reducing Boilerplate — Lombok
- [ ] Validations in Spring Boot API
- [ ] Pagination and Sorting
- [ ] Multiple Entities & JPA Relationships
- [ ] Working with PostgreSQL / MySQL
- [ ] Managing Products
- [ ] Spring Security — Securing the Application
- [ ] Spring Security — JWT
- [ ] Managing User Profiles & Roles
- [ ] Custom Authentication in eCommerce App
- [ ] Implementing Shopping Cart
- [ ] Managing User Address for Shipping
- [ ] Orders and Payments
- [ ] Revisiting Security
- [ ] Deploying API on AWS
- [ ] Spring Boot Profiles
- [ ] Advanced AWS Deployment
- [ ] Spring AI Integration
- [ ] React Fundamentals (JSX, Components, Props)
- [ ] React Hooks (useEffect, useRef, useContext, Custom Hooks)
- [ ] React + API Integration
- [ ] React Hook Forms
- [ ] React with Tailwind CSS
- [ ] React Routing
- [ ] Redux

> Update the checkboxes as you complete each section 👆

---

## 🚀 Project Features (planned)

- User registration/login with JWT-based auth
- Role-based access (Admin / Customer)
- Product & category management (CRUD)
- Pagination, sorting, and filtering
- Shopping cart functionality
- Address management for shipping
- Order placement and payment flow
- Deployment-ready configuration (Spring Profiles + AWS)
- AI-powered features via Spring AI

---

## ⚙️ Getting Started

### Prerequisites
- Java 21
- Maven
- PostgreSQL / MySQL running locally
- Node.js & npm (for the React frontend)

### Backend Setup
```bash
git clone https://github.com/sandip9938/<repo-name>.git
cd <repo-name>/backend
mvn clean install
mvn spring-boot:run
```

### Frontend Setup
```bash
cd <repo-name>/frontend
npm install
npm start
```

### Environment Variables
Create an `application.properties` (or `application.yml`) with:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
jwt.secret=your_jwt_secret
```

---

## 📂 Project Structure
```
├── backend/
│   ├── src/main/java/...
│   ├── src/main/resources/
│   └── pom.xml
├── frontend/
│   ├── src/
│   └── package.json
└── README.md
```

---

## 🙋 About Me

Built by **Sandip Panda** — Junior Web Developer transitioning to Java Backend Development.
- GitHub: [github.com/sandip9938](https://github.com/sandip9938)
- Portfolio: [sandip-panda.netlify.app](https://sandip-panda.netlify.app)

---

## 📝 License

This project is for learning purposes as part of the course mentioned above. All course content rights belong to the instructor.
