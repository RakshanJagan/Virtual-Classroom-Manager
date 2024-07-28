import java.util.*;

public class VirtualClassroomManager {
    private Map<String, Classroom> classrooms;

    public VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            System.out.println("Classroom already exists.");
            return;
        }
        classrooms.put(name, new Classroom(name));
        System.out.println("Classroom " + name + " has been created.");
        CustomLogger.logInfo("Created classroom: " + name);
    }

    public void removeClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            System.out.println("Classroom not found.");
            return;
        }
        classrooms.remove(name);
        System.out.println("Classroom " + name + " has been removed.");
        CustomLogger.logInfo("Removed classroom: " + name);
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
            return;
        }
        System.out.println("Classrooms:");
        for (String classroomName : classrooms.keySet()) {
            System.out.println("- " + classroomName);
        }
    }

    public void addStudent(int id, String name, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        classroom.addStudent(new Student(id, name));
        System.out.println("Student " + id + " has been enrolled in " + className + ".");
        CustomLogger.logInfo("Added student " + id + " to classroom " + className);
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        List<Student> students = classroom.getStudents();
        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + className + ".");
            return;
        }
        System.out.println("Students in " + className + ":");
        for (Student student : students) {
            System.out.println("- " + student.getId() + ": " + student.getName());
        }
    }

    public void scheduleAssignment(String className, String details) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        Assignment assignment = new Assignment(details);
        classroom.addAssignment(assignment);
        System.out.println("Assignment for " + className + " has been scheduled.");
        CustomLogger.logInfo("Scheduled assignment for classroom " + className);
    }

    public void submitAssignment(int studentId, String className, String details) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        Student student = classroom.findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        Assignment assignment = findAssignmentByDetails(classroom, details);
        if (assignment == null) {
            System.out.println("Assignment not found.");
            return;
        }
        student.submitAssignment(assignment);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        CustomLogger.logInfo("Submitted assignment by Student " + studentId + " in " + className);
    }

    public void displayAssignmentStatus(String className, String details) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        Assignment assignment = findAssignmentByDetails(classroom, details);
        if (assignment == null) {
            System.out.println("Assignment not found.");
            return;
        }
        System.out.println("Assignment status for " + details + " in " + className + ":");
        for (Student student : classroom.getStudents()) {
            Boolean status = student.getAssignmentStatus().getOrDefault(assignment, false);
            System.out.println("- " + student.getId() + ": " + student.getName() + " - "
                    + (status ? "COMPLETED" : "NOT COMPLETED"));
        }
    }

    private Assignment findAssignmentByDetails(Classroom classroom, String details) {
        for (Assignment assignment : classroom.getAssignments()) {
            if (assignment.getDetails().equals(details)) {
                return assignment;
            }
        }
        return null;
    }
}
