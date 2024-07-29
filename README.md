EI
---
This repository contains two exercise EX1-Design Patterns and EX2- Console application.

Path to Ex1- https://github.com/AnuTechie/Virtual-Classroom-Management-system/tree/d9e8a5afbd4842a5da12eeb7d8324f9151a4f985/ex%201%20Design%20patterns

Path to Ex2-https://github.com/AnuTechie/Virtual-Classroom-Management-system/tree/main/src/virtual/classroom/management/system

EX1- Design Patterns
------------------
Behavioral Pattern
----------------
Java file- ObserverPattern.java

Use Case: Player Health Notification System

I chose the "Player Health Notification System" use case for the Observer Pattern to effectively manage and demonstrate the dynamic relationship between a player's health status and various game elements that respond to it. The Player class can notify multiple observers, such as HealthBar, SoundEffects, and Achievements, whenever there is a change in health. This use case illustrates how the Observer Pattern allows these observers to react independently and appropriately, ensuring a flexible, scalable, and maintainable system where new observers can be added or removed with minimal impact on existing code.

Java file- StrategyPattern.java

Use Case Name: Payment Processing in an Online Shopping System

The Strategy Pattern is well-suited for the "Payment Processing in an Online Shopping System" use case because it effectively separates the payment method logic from the shopping cart functionality. By defining a family of payment algorithms as separate classes implementing the PaymentStrategy interface, the system allows for easy addition or modification of payment methods without altering the core shopping cart code. This pattern promotes flexibility and maintainability, as the shopping cart can dynamically switch between different payment methods through a simple interface. Additionally, it adheres to the Open/Closed Principle, ensuring that the system is open for extension with new payment methods but closed for modification of existing code. This separation of concerns simplifies both development and future enhancements.

Creational Pattern
====
Java file : AbstractFactoryPattern.java

Use Case Name: Theming in a Cross-Platform GUI Application

The "Theming in a Cross-Platform GUI Application" use case justifies the use of the Abstract Factory Pattern due to its ability to handle the creation of families of related objects (in this case, UI components) without specifying their concrete classes. The Abstract Factory Pattern is ideal for this scenario because it allows the application to easily switch between different themes (light and dark) while maintaining consistency within each theme. By defining abstract product interfaces (Button and Checkbox) and concrete factories (LightThemeFactory and DarkThemeFactory), the pattern ensures that the creation of UI components is decoupled from their specific implementations. This approach simplifies the addition of new themes or changes to existing ones, as new factories and product implementations can be introduced without altering the client code. The use of the Abstract Factory Pattern enhances flexibility, maintainability, and scalability in the GUI application's design.

Java file: BuilderPattern.java

Use Case Name: Robotics Manufacturing Process

The Builder Pattern is well-suited for the "Robotics Manufacturing Process" use case because it provides a flexible and controlled approach to constructing complex objects, such as robots, with various configurations. This pattern is particularly useful when the construction process involves multiple steps and the final product needs to be assembled from different components. By defining abstract builder interfaces (RobotBuilder) and concrete implementations (HumanoidRobotBuilder and IndustrialRobotBuilder), the pattern allows for the systematic creation of different types of robots, ensuring that each robot is assembled with the appropriate parts (head, body, arms, legs) according to its specific type. The RobotDirector class manages the construction process, guiding the builder through each step and resulting in a fully constructed robot. This approach simplifies the creation of complex objects, enhances code maintainability, and facilitates the addition of new robot types by introducing new builders, all without changing the existing client code.

Structural Pattern
-------------

Java file : AdapterPattern.java

Use Case Name: Legacy Game Controller Integration

The Adapter Pattern is well-suited for the "Legacy Game Controller Integration" use case because it facilitates compatibility between an existing legacy system (retro game controller) and a new system interface (modern console). This pattern enables the integration of old hardware with newer technology by adapting the interface of the legacy controller to match the requirements of the modern console. In this scenario, the RetroToModernAdapter acts as a bridge, converting the legacy controller's methods (pressButtonA and pressButtonB) to the modern console's methods (pressButtonX and pressButtonY). This approach allows the modern console to interact with the old game controller without altering either the existing hardware or the new system, thus preserving functionality while ensuring compatibility. The Adapter Pattern simplifies the integration process, avoids the need for extensive modifications, and promotes reusability of existing components.

Java file: CompositePattern.java

Use Case Name: Art Exhibit Management System

The Composite Pattern is highly effective for the "Art Exhibit Management System" due to its ability to handle complex hierarchical structures with ease. Firstly, it allows both individual art pieces (ArtPiece) and groups of art pieces (ExhibitComposite) to be treated uniformly through a common Exhibit interface, simplifying the management and display processes. Secondly, it provides flexibility to create and manage nested exhibits, enabling both single items and collections to be combined in various ways. Thirdly, the pattern supports dynamic composition, allowing exhibits to be assembled, modified, or displayed without affecting the underlying components. Fourthly, it promotes scalability by allowing new types of exhibits to be added without changing the existing code. Fifthly, it enhances maintainability by isolating changes within individual components or composites rather than altering the entire system. Lastly, the Composite Pattern improves code clarity by eliminating the need for conditional logic to handle different types of exhibits, resulting in a cleaner and more intuitive design.


EX2- Console application on Virtual Classroom Manager
----------------------------------

![Class Diagram](https://github.com/user-attachments/assets/cd32c876-fdb2-4579-92dd-6a8b52170d2b)

Overview:
--------
The Virtual Classroom Management System is an innovative console-based application designed to streamline classroom activities for both teachers and students.

This system provides a comprehensive platform for managing assignments, tracking grades, and facilitating communication.

Key Features:
-----------------

1.Classroom Management:
-------------------
Teachers can manage multiple classrooms, each with a unique group of students.

2.Assignment Handling:
---------------------
Teachers can assign homework, track submissions, and grade assignments efficiently.

3.Student Interaction:
----------------------
Students can submit assignments and view grades directly within the system.

4.Attendance Tracking:
---------------------
Ensures that marking a student as absent in one classroom does not affect their attendance in other classrooms.

Technical Highlights
--------------------

1.Object-Oriented Design: 
--------------------------
The system is built using Java with a focus on clean, maintainable code.

2.Class Hierarchy: 
---------------------
Key classes include Classroom, Teacher, Student, and Assignment, each with essential attributes and methods.

3.Scalability: 
----------------
The design supports the addition of more functionalities, ensuring long-term usability.



Key technical details include:
------------

Language: Java

IDE: Compatible with any Java IDE (e.g., IntelliJ IDEA, Eclipse)

Version Control: Managed using Git, hosted on GitHub

Database: Uses a simple file-based storage for persistence (can be extended to use relational databases like MySQL)

Dependencies: Java Standard Library

