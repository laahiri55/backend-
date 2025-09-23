# Hotel Management System - Backend

This is the Spring Boot backend for the Hotel Management System.

## Features

- User authentication with JWT tokens
- Role-based access control (Admin/User)
- Room management (CRUD operations)
- Booking system with validation
- RESTful API endpoints
- MySQL database integration
- Security with Spring Security

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

## Setup Instructions

1. **Database Setup**
   ```sql
   CREATE DATABASE hotel_management;
   ```

2. **Configure Database**
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication
- `POST /api/auth/signin` - User login
- `POST /api/auth/signup` - User registration

### Rooms
- `GET /api/rooms` - Get all rooms
- `GET /api/rooms/available` - Get available rooms
- `GET /api/rooms/{id}` - Get room by ID

### Bookings (Authenticated)
- `GET /api/bookings/user` - Get user bookings
- `POST /api/bookings` - Create booking
- `PUT /api/bookings/{id}/cancel` - Cancel booking

### Admin Only
- `POST /api/admin/rooms` - Create room
- `PUT /api/admin/rooms/{id}` - Update room
- `DELETE /api/admin/rooms/{id}` - Delete room
- `GET /api/admin/bookings` - Get all bookings
- `PUT /api/admin/bookings/{id}/cancel` - Cancel any booking
- `DELETE /api/admin/bookings/{id}` - Delete booking

## Default Users

- **Admin**: admin@hotel.com / admin123
- **User**: user@hotel.com / user123

## Technologies Used

- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- MySQL
- JWT Authentication
- Maven