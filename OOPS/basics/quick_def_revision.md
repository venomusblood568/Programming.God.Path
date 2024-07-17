# Object-Oriented Programming (OOP) Concepts

## 1. Encapsulation
- **Definition:** Bundling data (attributes) and methods (functions) that operate on the data into a single unit (class).
- **Purpose:** Encapsulation helps in hiding the internal state of objects and restricting access to it, promoting modularity and reusability.

## 2. Abstraction
- **Definition:** Process of hiding complex implementation details and showing only essential features of the object.
- **Purpose:** Abstraction allows focusing on what an object does rather than how it does it, simplifying the complexity of the system.

## 3. Inheritance
- **Definition:** Mechanism where a new class (derived or subclass) inherits properties (attributes and methods) from an existing class (base or superclass).
- **Purpose:** Inheritance facilitates code reuse, promotes hierarchical relationships between classes, and supports polymorphism.

## 4. Polymorphism
- **Definition:** Ability of an object to take on different forms or behaviors depending on the context.
- **Types:**
  - **Compile-time (Method Overloading):** Multiple methods with the same name but different parameters in the same class.
  - **Runtime (Method Overriding):** Child class providing a specific implementation of a method defined in its superclass.
- **Purpose:** Polymorphism enables flexibility and dynamic behavior in the program, enhancing code extensibility and maintainability.

## 5. Classes and Objects
- **Classes:** Blueprint or template for creating objects. It defines attributes (data fields) and behaviors (methods) common to all objects of that type.
- **Objects:** Instance of a class, which has its own state (attributes) and behavior (methods) defined by the class.
- **Purpose:** Classes and objects form the basic building blocks of OOP, facilitating modular and organized software development.

## 6. Encapsulation vs Abstraction
- **Encapsulation:** Combines data (attributes) and methods (functions) into a single unit, hiding internal state from outside interference.
- **Abstraction:** Hides complex implementation details and provides a simplified view of the object, focusing on essential features.

## 7. Key Principles
- **DRY (Don't Repeat Yourself):** Avoid duplicating code by promoting code reuse through inheritance and composition.
- **SOLID Principles:** Guiding principles for software design:
  - **Single Responsibility Principle (SRP):** A class should have only one reason to change.
  - **Open/Closed Principle (OCP):** Software entities should be open for extension but closed for modification.
  - **Liskov Substitution Principle (LSP):** Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.
  - **Interface Segregation Principle (ISP):** Clients should not be forced to depend on interfaces they do not use.
  - **Dependency Inversion Principle (DIP):** High-level modules should not depend on low-level modules; both should depend on abstractions.

