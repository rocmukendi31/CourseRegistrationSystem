# University Course Registration System

A simple Java implementation of a university course registration system that demonstrates the use of core Java collections: `Vector`, `ArrayList`, and `StringBuffer`.

## Features

- **Course Class**: Represents a course with course code, course name, and credits
- **Available Courses Catalog**: Uses `Vector<Course>` to store available courses
- **Student Registration**: Uses `ArrayList<Course>` to track registered courses
- **Registration Summary**: Generated using `StringBuffer` for efficient string manipulation
- **Core Functionality**:
  - Add/remove courses from available catalog
  - Register/drop courses for students
  - Prevent duplicate registrations
  - Search for courses in both catalog and registration
  - Calculate total registered credits
  - Generate formatted registration summary

## Files

- `Course.java`: Defines the Course class with getters, setters, equals(), hashCode(), and toString()
- `CourseRegistrationSystem.java`: Main implementation with:
  - Vector for available course catalogue
  - ArrayList for student's registered courses
  - Methods for add, remove, search operations
  - Duplicate registration prevention
  - StringBuffer-based summary generation
  - Credit calculation
  - Demonstration main method

## How to Run

1. **Prerequisites**: Java Development Kit (JDK) installed
2. **Compile**: 
   ```bash
   javac Course.java CourseRegistrationSystem.java
   ```
3. **Run**:
   ```bash
   java CourseRegistrationSystem
   ```

## Sample Output

```
Available Courses:
- CS101: Introduction to Computer Science (3 credits)
- MATH205: Calculus II (4 credits)
- PHYS101: Physics I (4 credits)
- ENG101: English Composition (3 credits)
- HIST101: World History (3 credits)

Course CS101 registered successfully.
Course MATH205 registered successfully.
Course ENG101 registered successfully.
Course with code CS101 is already registered.
Course with code ART101 is not available.
=== Registration Summary ===
Registered Courses:
- CS101: Introduction to Computer Science (3 credits)
- MATH205: Calculus II (4 credits)
- ENG101: English Composition (3 credits)

Total Credits: 10
============================

Course MATH205 dropped successfully.
After dropping MATH205:
=== Registration Summary ===
Registered Courses:
- CS101: Introduction to Computer Science (3 credits)
- ENG101: English Composition (3 credits)

Total Credits: 6
============================
```

## Key Concepts Demonstrated

- **Vector**: Legacy synchronized list used for available course catalogue
- **ArrayList**: Standard list implementation used for student's registered courses
- **StringBuffer**: Mutable string sequence used for building registration summary
- **Collection Operations**: Adding, removing, searching elements
- **Duplicate Prevention**: Checking before registration
- **Data Encapsulation**: Course class with private fields and public accessors

## Learning Objectives

This implementation demonstrates:
- When to use Vector vs ArrayList (though in modern Java, ArrayList is generally preferred unless thread-specific synchronization is needed)
- String manipulation efficiency with StringBuffer vs String concatenation
- Basic collection operations in Java
- Encapsulation and object-oriented design principles
- Prevention of business rule violations (duplicate registration)

## License

This project is open source and available under the MIT License.