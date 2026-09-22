import java.util.ArrayList;
import java.util.Vector;

public class CourseRegistrationSystem {
    private Vector<Course> availableCourses;
    private ArrayList<Course> registeredCourses;

    public CourseRegistrationSystem() {
        availableCourses = new Vector<>();
        registeredCourses = new ArrayList<>();
    }

    // Add a course to the available courses catalogue
    public void addAvailableCourse(Course course) {
        availableCourses.add(course);
    }

    // Remove a course from the available courses catalogue
    public boolean removeAvailableCourse(String courseCode) {
        for (int i = 0; i < availableCourses.size(); i++) {
            if (availableCourses.get(i).getCourseCode().equals(courseCode)) {
                availableCourses.remove(i);
                return true;
            }
        }
        return false;
    }

    // Search for a course in the available courses catalogue
    public Course searchAvailableCourse(String courseCode) {
        for (Course course : availableCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    // Register a course for the student (if available and not already registered)
    public boolean registerCourse(String courseCode) {
        // First, check if the course is available
        Course course = searchAvailableCourse(courseCode);
        if (course == null) {
            System.out.println("Course with code " + courseCode + " is not available.");
            return false;
        }

        // Check if the course is already registered
        if (isCourseRegistered(courseCode)) {
            System.out.println("Course with code " + courseCode + " is already registered.");
            return false;
        }

        // Add to registered courses
        registeredCourses.add(course);
        System.out.println("Course " + courseCode + " registered successfully.");
        return true;
    }

    // Drop a course from the student's registered courses
    public boolean dropCourse(String courseCode) {
        for (int i = 0; i < registeredCourses.size(); i++) {
            if (registeredCourses.get(i).getCourseCode().equals(courseCode)) {
                registeredCourses.remove(i);
                System.out.println("Course " + courseCode + " dropped successfully.");
                return true;
            }
        }
        System.out.println("Course with code " + courseCode + " is not registered.");
        return false;
    }

    // Search for a course in the student's registered courses
    public Course searchRegisteredCourse(String courseCode) {
        for (Course course : registeredCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    // Helper method to check if a course is already registered
    private boolean isCourseRegistered(String courseCode) {
        for (Course course : registeredCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    // Generate a registration summary using StringBuffer
    public String generateRegistrationSummary() {
        StringBuffer summary = new StringBuffer();
        summary.append("=== Registration Summary ===\n");
        summary.append("Registered Courses:\n");

        if (registeredCourses.isEmpty()) {
            summary.append("No courses registered.\n");
        } else {
            for (Course course : registeredCourses) {
                summary.append("- ").append(course.getCourseCode())
                        .append(": ").append(course.getCourseName())
                        .append(" (").append(course.getCredits()).append(" credits)\n");
            }
        }

        summary.append("\nTotal Credits: ").append(calculateTotalCredits());
        summary.append("\n============================");

        return summary.toString();
    }

    // Calculate total registered credits
    public int calculateTotalCredits() {
        int total = 0;
        for (Course course : registeredCourses) {
            total += course.getCredits();
        }
        return total;
    }

    // Getter for available courses (for demonstration)
    public Vector<Course> getAvailableCourses() {
        return availableCourses;
    }

    // Getter for registered courses (for demonstration)
    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Add some sample courses to the available catalogue
        system.addAvailableCourse(new Course("CS101", "Introduction to Computer Science", 3));
        system.addAvailableCourse(new Course("MATH205", "Calculus II", 4));
        system.addAvailableCourse(new Course("PHYS101", "Physics I", 4));
        system.addAvailableCourse(new Course("ENG101", "English Composition", 3));
        system.addAvailableCourse(new Course("HIST101", "World History", 3));

        System.out.println("Available Courses:");
        for (Course course : system.getAvailableCourses()) {
            System.out.println("- " + course.getCourseCode() + ": " + course.getCourseName() + " (" + course.getCredits() + " credits)");
        }
        System.out.println();

        // Register some courses
        system.registerCourse("CS101");
        system.registerCourse("MATH205");
        system.registerCourse("ENG101");

        // Try to register a duplicate
        system.registerCourse("CS101");

        // Try to register a non-existent course
        system.registerCourse("ART101");

        // Show registration summary
        System.out.println(system.generateRegistrationSummary());
        System.out.println();

        // Drop a course
        system.dropCourse("MATH205");

        // Show updated registration summary
        System.out.println("After dropping MATH205:");
        System.out.println(system.generateRegistrationSummary());
    }
}