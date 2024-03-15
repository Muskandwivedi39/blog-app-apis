
# Blog Application 

This repository contains the code for a RESTful API for a blog application with user, post, category, and comment features. The API is designed using Spring Boot framework with Hibernate JPA for efficient database operations, and it utilizes an H2 in-memory database for seamless functionality. Additionally, the API includes exception handling and validation features to ensure data integrity and robustness. API testing can be performed using Postman.

## Features

- **User Management**: Create, retrieve, update, and delete users.
- **Post Management**: Create, retrieve, update, and delete blog posts.
- **Category Management**: Create, retrieve, update, and delete categories for posts.
- **Comment Management**: Create, retrieve, update, and delete comments on posts.
- **Exception Handling**: Handle various types of exceptions gracefully to provide meaningful error responses.
- **Validation**: Validate incoming requests to ensure data consistency and integrity.

## Technologies Used

- Spring Boot
- Hibernate JPA
- H2 Database
- Postman (for API testing)
- Maven

. The API will be accessible at `http://localhost:9091`.

## API Endpoints

Below are the available endpoints for the blog API:

- **Users:**
  - GET /api/users
  - GET /api/users/{id}
  - POST /api/users
  - PUT /api/users/{id}
  - DELETE /api/users/{id}
    
- **Categories:**
  - GET /api/categories
  - GET /api/categories/{id}
  - POST /api/categories
  - PUT /api/categories/{id}
  - DELETE /api/categories/{id}

 - **Posts:**
  - GET /api/posts
  - GET /api/posts/{id}
  - POST /api/posts
  - PUT /api/posts/{id}
  - DELETE /api/posts/{id}

- **Comments:**
  - GET /api/posts/{post_id}/comments
  - GET /api/comments/{id}
  - POST /api/posts/{post_id}/comments
  - PUT /api/comments/{id}
  - DELETE /api/comments/{id}
  - ## API Testing by Postman
  - ![Screenshot 2024-03-15 152326](https://github.com/Muskandwivedi39/blog-app-apis/assets/114982533/8480e7ac-7c21-4464-bbdf-b9fe4eec097c)
  - ## Data Strored
  - ![Screenshot 2024-03-15 160026](https://github.com/Muskandwivedi39/blog-app-apis/assets/114982533/5360c299-8222-4217-aba7-d8b70853c817)





