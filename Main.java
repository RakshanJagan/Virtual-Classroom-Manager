import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Virtual Classroom Manager");
        System.out.println(
                "Commands: add_classroom, remove_classroom, list_classrooms, add_student, list_students, schedule_assignment, submit_assignment, display_assignment_status, exit");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ", 2);

            if (parts[0].equals("exit")) {
                break;
            }

            try {
                switch (parts[0]) {
                    case "add_classroom":
                        manager.addClassroom(parts[1]);
                        break;
                    case "remove_classroom":
                        manager.removeClassroom(parts[1]);
                        break;
                    case "list_classrooms":
                        manager.listClassrooms();
                        break;
                    case "add_student":
                        String[] studentParts = parts[1].split(" ", 3);
                        int studentId = Integer.parseInt(studentParts[0]);
                        String studentName = studentParts[1];
                        String className = studentParts[2];
                        manager.addStudent(studentId, studentName, className);
                        break;
                    case "list_students":
                        manager.listStudents(parts[1]);
                        break;
                    case "schedule_assignment":
                        String[] assignmentParts = parts[1].split(" ", 2);
                        String assignmentClassName = assignmentParts[0];
                        String assignmentDetails = assignmentParts[1];
                        manager.scheduleAssignment(assignmentClassName, assignmentDetails);
                        break;
                    case "submit_assignment":
                        String[] submissionParts = parts[1].split(" ", 3);
                        int submitStudentId = Integer.parseInt(submissionParts[0]);
                        String submitClassName = submissionParts[1];
                        String submitAssignmentDetails = submissionParts[2];
                        manager.submitAssignment(submitStudentId, submitClassName, submitAssignmentDetails);
                        break;
                    case "display_assignment_status":
                        String[] statusParts = parts[1].split(" ", 2);
                        String statusClassName = statusParts[0];
                        String statusAssignmentDetails = statusParts[1];
                        manager.displayAssignmentStatus(statusClassName, statusAssignmentDetails);
                        break;
                    default:
                        System.out.println("Unknown command.");
                        break;
                }
            } catch (Exception e) {
                CustomLogger.logError("An error occurred while processing command: " + command, e);
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
