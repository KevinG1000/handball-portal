# Everything Handball Portal

A full-stack web application designed to connect handball players, share tournament information, and grow the handball community. This platform provides tournament updates, court locations, game rules, and social features for handball enthusiasts.

## 🔗 Project Repositories

- Backend: [handball-portal](https://github.com/KevinG1000/handball-portal)
- Frontend: [frontend-handball-portal](https://github.com/KevinG1000/frontend-handball-portal)

## 🚀 Features

### User Authentication
- Secure user registration and login system
- Password encryption using BCrypt
- Protected routes for authenticated users

### What is Handball
- Comprehensive guide to handball rules
- Different game formats explained
- Essential information for newcomers

### Where to Play
- List of popular handball courts
- Direct Google Maps navigation links
- Detailed court information and facilities

### Tournaments
- Upcoming tournament listings
- Online registration system
- User comments and discussion
- Player matchmaking functionality

### Tournament Videos
- Recent tournament highlights
- Live tournament coverage
- Short-form content section (similar to YouTube Shorts)
- Community engagement through video content

## 🛠 Technology Stack

### Backend
- Java Spring Boot
- MySQL Database
- Hibernate ORM
- Spring Security
- BCrypt Password Encryption
- RESTful API Architecture

### Frontend
- React.js
- React Router
- CSS3
- Axios for API calls

## 📋 Prerequisites

- Java JDK 17 or higher
- Node.js 14.x or higher
- MySQL 8.x
- Maven

## 🔧 Installation

1. Clone both repositories:
  git clone https://github.com/KevinG1000/handball-portal
  git clone https://github.com/KevinG1000/frontend-handball-portal


2. Backend Setup:
  bash
  cd handball-portal
  mvn clean install
  mvn spring-boot:run

3. Frontend Setup:
  bash
  cd frontend-handball-portal
  npm install
  npm start


4. Configure MySQL:
- Create a database named 'handball_db'
- Update application.properties with your database credentials

## 🏗 Project Structure

### Backend Structure
handball-portal/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── controllers/
│ │ │ ├── models/
│ │ │ ├── repositories/
│ │ │ └── services/
│ │ └── resources/
│ └── test/
└── pom.xml


### Frontend Structure
frontend-handball-portal/
├── src/
│ ├── components/
│ ├── services/
│ ├── styles/
│ └── App.js
└── package.json


## 🔐 Environment Variables

Create a .env file in the backend directory:
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/handball_db
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password


## Database Relationships

### Key Relationships:
1. Users to Comments: One-to-Many
   - One user can create many comments
   - Each comment belongs to only one user
   - Relationship established through the user's username

2. Tournaments to Comments: One-to-Many
   - One tournament can have many comments
   - Each comment belongs to only one tournament
   - Relationship established through tournamentId

3. Users to Tournaments: Many-to-Many (through comments)
   - Users can comment on multiple tournaments
   - Tournaments can receive comments from multiple users
   - Comments table acts as a junction table connecting users and tournaments

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License

This project is licensed under the MIT License - see the LICENSE.md file for details.

## 👥 Contact

Kevin G - [GitHub](https://github.com/KevinG1000)

Project Links: 
- [Backend Repository](https://github.com/KevinG1000/handball-portal)
- [Frontend Repository](https://github.com/KevinG1000/frontend-handball-portal)
   
