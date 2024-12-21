# Learning Spring Data JPA

> **Objective:** Learn Spring JPA implementation and related concepts using simple Student-Course-Review service exmaple.
 
## Topics to Cover

* Single & Multiple-DB connections
* Connection-pool using Hikari
* RDBMS & NoSQL DB implementation
* Entities, Column Definitions, Constraints
* One-to-One, One-to-Many, Many-to-One, Optionality
* Cascading, Joins, Fetching Types
* Embbedable, AttributeOverrides
* Paginated Result, Resutl Sorting
* Native Query, Named Parameter, Named Query
* JPA-Auditing (Created, Modified User & Date)
* CustomColumnOrdering, Hibernate-Properties Overrride

## ERD, Examples & Features

* Here, I have taken the premise of an online institution and how it can manage student & course relationship
* Additionally, there is a feedback module attached to the course, each student can share feedback for 'n' courses they're enrolled into.
* `Student` & `Course` details are maintained in **Relational-DB** while maintaining `Feedback` in the **NoSQL DB**

### User Entities

* **Student-Profile**
  * Combination of Student Details & Student Qualification
  * Student Details consists basic details of the student
  * Student Qualification consists detials of their marks/distinctions in given STEM subjects
  * Student Details <-- Student Qualification are in One-to-One relationship
* **Course-Profile**
  * Combination of Course Details & Course Review
  * Course Details consists basic details of the course like name, duration, eligibility, etc.
  * Course Review consists of detials like course rating, review message, etc.
  * Course Details <-- Course Review are in One-to-Many relationship
* Student Details <-- Course Details themselves are related to each other in One-to-Many relationship