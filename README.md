# BackLink-Sorting
Backlink Sorting is a tool that organizes and ranks backlinks using SEO metrics like authority, relevance, and spam score. It helps identify high-quality links and improve backlink management efficiently.

# BackLink-Sorting

BackLink-Sorting is a web-based SEO tool that helps organize, analyze, and rank backlinks using important SEO metrics such as domain authority, page authority, relevance, traffic, and spam score. It helps users identify high-quality backlinks and improve link-building strategies efficiently.

## Features

- Sort backlinks based on SEO metrics
- Detect low-quality or spam backlinks
- Rank backlinks by authority and relevance
- User-friendly frontend interface
- Fast backend processing
- Helps improve SEO decision-making

## Tech Stack

### Frontend
- HTML
- CSS
- JavaScript
- React.js (if used)

### Backend
- Java Spring Boot
- JSP (JavaServer Pages)
- Spring MVC
- Spring Data JPA
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Test
- Spring Boot Starter Tomcat
- Spring Boot DevTools
- Spring Boot DTO
- Restful API
- Hibernate
- MySQL 

### Project Workflow

- Frontend server runs on **http://localhost:5173**
- The UI sends requests to the backend server running on **http://localhost:8080**
- Requests are received by **JSP** and forwarded to the **Controller**
- The Controller passes the request to the **Service Layer**, where business logic and API methods are handled
- The Service Layer uses **Servlets/Repository Layer** to process the request and access the database
- The Repository Layer fetches data from the database and returns the result
- The response flows back from **Repository → Service → Controller**
- Finally, the response is sent back to the client UI

## Project Structure

BackLink-Sorting/
│── BackLink-Validator/frontend  
│── Backlink-Backend/Backlink-Backend  
│── README.md

## Screenshot
Project Screenshot

   BackLink-Video.mp4
   
## Installation

### Clone Repository

```bash
git clone https://github.com/ShrabanaPal/BackLink-Sorting.git
cd BackLink-Sorting
npm install
npm run dev