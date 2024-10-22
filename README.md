# Online Exam Portal Project
## Overview
* The Online Exam Portal is a backend application built using Java Spring Boot, designed to facilitate both administrators and users in conducting and taking exams. The application provides a structured way for admins to create and manage exams, while users can register, take exams, and view their results.

## Features
### Admin Panel
1. Create Exams: Admins can create exams based on different categories.
2. Each exam can have: Multiple questions
3. Defined answers
4. Marks allocation per question
5. A timer for each exam
6. Question Randomization: Admins can add a set of questions, and the system will randomly select a specific number of questions from this set for each user. This ensures that each user receives a unique set of questions.
7. Exam Scheduling: Admins can schedule exams, making them available only during specified times or dates.
8. Manage Questions: Admins can add, update, and delete questions for any exam.
9. Exam Retake Management: Admins can set retake rules, allowing users to retake an exam after a specified period or number of attempts.
Results Tracking: Admins can view the results of all exams taken by users.
10. Exam Control: Admins can enable or disable specific exams or entire categories as needed.

### User Panel
1. User Registration: Users can sign up and create a personalized profile.
2. Take Exams: After registering, users can view and take any available exam from the list based on categories.
3. View Results: Users can view their results immediately after completing an exam.
4. Track Exam History: Users can track their past exam attempts and monitor their progress over time.
## Technologies Used
* Backend: Java Spring Boot
* Database: PostgreSQL
* ORM: Hibernate
* Security: Spring Security
  #
## Build (for developer)
The project requires JDK 11.
1. Build:
    ```
    $ mvn clean install 
    ```

## Future Features
* Feedback System: Allow users to provide feedback on specific questions or exams, helping admins review and update questions based on user feedback.
* Leaderboards: Display leaderboards for top performers on exams. Admins can set this up to show either globally or for specific categories.
* Notification: Send email or in-app notifications to users for new exams, upcoming deadlines, or exam results. You could integrate it with a notification service like Twilio or SendGrid.
* Certificate Generation: Automatically generate certificates for users who pass an exam, including their name, exam score, and date.


### Contribution
* If you'd like to contribute to this project, feel free to submit a pull request or open an issue for suggestions or bug reports.
