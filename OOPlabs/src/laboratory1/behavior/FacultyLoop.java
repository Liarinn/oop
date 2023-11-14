package laboratory1.behavior;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import laboratory1.models.Faculty;
import laboratory1.models.Student;
import static laboratory1.behavior.UniversityLoop.faculties;


public class FacultyLoop {

    public void createAndAssignStudent(String input) {
        String[] parts = input.split("/");
        if (parts.length == 8) {
            String facultyAbbreviation = parts[1];
            String firstName = parts[2];
            String lastName = parts[3];
            String email = parts[4];
            String dateOfBirthStr = parts[5] + "/" + parts[6] + "/" + parts[7];

            LocalDate enrollmentDate = LocalDate.now();
            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                    Student student = new Student(firstName, lastName, email, dateOfBirthStr, enrollmentDate, false);
                    faculty.addStudent(student);
                    System.out.println("Student succesfuly assigned to: " + facultyAbbreviation + ".\n");
            } else {
                System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.\n");}
        } else {
            System.out.println("Invalid command format. \n" +
                    "You should use: ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year>\n");
        }
    }

    private static Student findStudentByEmail(String email) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    return student;
                }}}
        return null;
    }
    public void graduateStudents(String input) {
        String[] parts = input.split("/");

        if (parts.length == 2) {
            String studentEmail = parts[1];
            Student student = findStudentByEmail(studentEmail);

            if (student != null) {
                student.setGraduated(true);
                System.out.println("Student with email " + studentEmail + " has been graduated.\n");
            } else {
                System.out.println("Student with email " + studentEmail + " not found.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: gs/<email>\n");
        }
    }

    public void displayEnrolledStudents(String input) {
        String[] parts = input.split("/");

        if (parts.length == 2) {
            String facultyAbbreviation = parts[1];
            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                List<Student> students = faculty.getStudents();
                boolean enrolledStudentsFound = false;

                System.out.println("Currently Enrolled Students in Faculty " + facultyAbbreviation + ":");
                for (Student student : students) {
                    if (!student.isGraduated()) {
                        System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
                        System.out.println("Student Email: " + student.getEmail());
                        System.out.println("Date of birth: " + student.getDateOfBirth());
                        System.out.println("Enrollment Date: " + student.getEnrollmentDate() + "\n");
                        enrolledStudentsFound = true;
                    }
                }

                if (!enrolledStudentsFound) {
                    System.out.println("No enrolled students in this Faculty " + facultyAbbreviation + ".\n");}
            } else {
                System.out.println("Faculty:" + facultyAbbreviation + " not found.\n");}
        } else {
            System.out.println("Invalid command format. \n Please use: ds/<faculty abbreviation>\n");
        }
    }

    private static Faculty findFacultyByAbbreviation(String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }

    static void displayGraduates(String input) {
        String[] parts = input.split("/");

        if (parts.length == 2) {
            String facultyAbbreviation = parts[1];

            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                List<Student> students = faculty.getStudents();

                if (!students.isEmpty()) {
                    System.out.println("Graduated Students in Faculty " + facultyAbbreviation + ":");
                    for (Student student : students) {
                        if (student.isGraduated()) {
                            System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
                            System.out.println("Student Email: " + student.getEmail());
                            System.out.println("Date of birth: " + student.getDateOfBirth());
                            System.out.println("Enrollment Date: " + student.getEnrollmentDate() +"\n");
                        }
                    }

                    boolean noGraduatesFound = students.stream().noneMatch(Student::isGraduated);
                    if (noGraduatesFound) {
                        System.out.println("No graduated students in Faculty " + facultyAbbreviation + ".\n");
                    }
                } else {
                    System.out.println("No students in Faculty " + facultyAbbreviation + ".\n");
                }
            } else {
                System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: dg/<faculty abbreviation>\n");
        }
    }

    static void checkStudentFaculty(String input) {
        String[] parts = input.split("/");

        if (parts.length == 3) {
            String facultyAbbreviation = parts[1];
            String studentEmail = parts[2];

            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                boolean belongsToFaculty = studentBelongsToFaculty(studentEmail, faculty);

                if (belongsToFaculty) {
                    System.out.println("Student with email " + studentEmail + " belongs to Faculty " + facultyAbbreviation + ".\n");
                } else {
                    System.out.println("Student with email " + studentEmail + " does not belong to Faculty " + facultyAbbreviation + ".\n");
                }
            } else {
                System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: bf/<faculty abbreviation>/<email>\n");
        }
    }

    private static boolean studentBelongsToFaculty(String studentEmail, Faculty faculty) {
        List<Student> students = faculty.getStudents();
        for (Student student : students) {
            if (student.getEmail().equals(studentEmail)) {
                return true;
            }
        }
        return false;
    }

    public void facultyLoop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    
                    Faculty Operations:
                    What do you want to do?
                    
                    ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student
                    gs/<email> - (g)raduate (s)tudent
                    ds/<faculty abbreviation> - (d)isplay enrolled students
                    dg/<faculty abbreviation> - (d)isplay (g)raduated students
                    bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty
                    
                    b - Back
                    q - Quit Program
                    """);

            System.out.print("your input> ");
            String choiceFaculty = scanner.nextLine().trim();

            if (choiceFaculty.startsWith("ns/")) {
                createAndAssignStudent(choiceFaculty);
            } else if (choiceFaculty.startsWith("gs/")) {
                graduateStudents(choiceFaculty);
            } else if (choiceFaculty.startsWith("ds/")) {
                displayEnrolledStudents(choiceFaculty);
            } else if (choiceFaculty.startsWith("dg/")) {
                displayGraduates(choiceFaculty);
            } else if (choiceFaculty.startsWith("bf/")) {
                checkStudentFaculty(choiceFaculty);
            } else if (choiceFaculty.equals("b")) {
                return;
            } else if (choiceFaculty.equals("q")) {
                System.exit(0);
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}