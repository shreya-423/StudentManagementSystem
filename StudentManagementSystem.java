import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static class Student {
        private int id;
        private String name;
        private int age;
        private String course;

        public Student(int id, String name, int age, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        @Override
        public String toString() {
            return "ID: " + id +
                    ", Name: " + name +
                    ", Age: " + age +
                    ", Course: " + course;
        }
    }

    static class StudentService {
        private ArrayList<Student> students = new ArrayList<>();

        public void addStudent(Student student) {
            students.add(student);
            System.out.println("Student added successfully!");
        }

        public void viewStudents() {
            if (students.isEmpty()) {
                System.out.println("No student records found.");
                return;
            }
            for (Student s : students) {
                System.out.println(s);
            }
        }

        public void updateStudent(int id, String name, int age, String course) {
            for (Student s : students) {
                if (s.getId() == id) {
                    s.setName(name);
                    s.setAge(age);
                    s.setCourse(course);
                    System.out.println("Student updated successfully!");
                    return;
                }
            }
            System.out.println("Student not found!");
        }

        public void deleteStudent(int id) {
            for (Student s : students) {
                if (s.getId() == id) {
                    students.remove(s);
                    System.out.println("Student deleted successfully!");
                    return;
                }
            }
            System.out.println("Student not found!");
        }

        public void searchStudent(int id) {
            for (Student s : students) {
                if (s.getId() == id) {
                    System.out.println(s);
                    return;
                }
            }
            System.out.println("Student not found!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            System.out.println("\n Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    service.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    service.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();
                    service.searchStudent(searchId);
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
        sc.close();
    }
}
