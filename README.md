#  AP Quiz Application

A desktop-based Quiz Management System developed using **Core Java** and **Java Swing GUI**.
The application provides an interactive quiz environment with features like Admin Panel, Leaderboard, Timer, 50-50 Lifeline, Score Tracking, and File Handling.


#  Project Overview

AP Quiz Application is a Java Swing-based desktop application designed to conduct multiple-choice quizzes in an interactive and user-friendly manner. The project includes both **User** and **Admin** functionalities.

The user can attempt quizzes, view scores, and check the leaderboard, while the admin can manage quiz questions through a dedicated admin panel.


#   Features

#   User Features

* User Login
* Interactive Quiz Interface
* Multiple Choice Questions
* Timer for Each Question
* 50-50 Lifeline
* Instant Score Calculation
* Final Result & Percentage
* Leaderboard System
* Attractive GUI Design


#    Admin Features

* Secure Admin Login
* Add Questions
* Edit Questions
* Delete Questions
* Start Quiz from Admin Panel
* Manage Quiz Database


#   Technologies Used

| Technology           | Purpose                 |
| -------------------- | ----------------------- |
| Core Java            | Application Logic       |
| Java Swing           | GUI Development         |
| AWT                  | Event Handling          |
| File Handling        | Data Storage            |
| Object Serialization | Leaderboard & Questions |
| NetBeans IDE         | Development Environment |


#   Project Structure

AP-Quiz-Application/
│
├── src/
│   ├── quiz/application/
│   │   ├── Splash.java
│   │   ├── Login.java
│   │   ├── Rules.java
│   │   ├── Quiz.java
│   │   ├── Score.java
│   │   ├── Leaderboard.java
│   │   ├── AdminLogin.java
│   │   ├── AdminPanel.java
│   │   └── QuizData.java
│
├── icons/
│   ├── quiz.jpg
│   ├── login.jpeg
│   ├── score.png
│   └── icon.png
│
├── questions.dat
├── leaderboard.dat
├── build.xml
└── README.md


#   Application Screens

#     Splash Screen

Displays the welcome screen of the application.

#      Login Page

Allows users and admin to log in to the system.

#      Rules Page

Displays quiz instructions and quiz guidelines.

#      Quiz Interface

Shows quiz questions with options, timer, and lifeline.

#      Score Page

Displays final score, percentage, and performance message.

#      Leaderboard

Shows top player scores.

#      Admin Panel

Allows admin to manage quiz questions.


#   Functional Modules

## 1. Login Module

Handles user name input and admin authentication.

## 2. Quiz Module

Conducts the quiz and manages question navigation.

## 3. Timer Module

Limits answering time for each question.

## 4. Lifeline Module

Implements 50-50 functionality.

## 5. Score Module

Calculates marks and percentage.

## 6. Leaderboard Module

Stores and displays top scores.

## 7. Admin Module

Manages question database operations.


#   Data Storage

The application uses file handling for storing:

* Quiz Questions (`questions.dat`)
* Leaderboard Scores (`leaderboard.dat`)


#    How to Run

## Step 1

Clone the repository:

git clone https://github.com/your-username/ap-quiz-application.git


## Step 2

Open the project in **Apache NetBeans** or any Java IDE.

## Step 3

Run the `Splash.java` file.


#   Admin Credentials

Username: Ashu
Password: 9117

(You can modify credentials in the source code.)


#   Future Enhancements

* Database Integration (MySQL)
* Online Multiplayer Quiz
* User Registration System
* Category-wise Quiz
* Cloud storage support
* Android Application Version 
* Web-Based Deployment 
* AI-Based Question Generation 
* Advanced Analytics Dashboard 


#   Advantages

* Easy to Use
* Attractive User Interface
* Lightweight Application
* Fast Performance



#  Developed By

**Ashu Kumar**


#  GitHub Repository

If you like this project, please give it a ⭐ on GitHub.
