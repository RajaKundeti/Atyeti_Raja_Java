package poc3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Concepts Covered:
    -------------------------------
    Object arrays and collections
    Variable initialization and manipulation in loops
    Data aggregation using variables
    Scope inside methods and loops
    Clean code with reusable functions

 */


public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter No of Students: ");
        int n = sc.nextByte();

        //  STORING N NO OF STUDENTS DATA INTO A LIST
        List<Student> studentList = new ArrayList<>();
        for(int i=0; i<n; i++){
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            name = sc.nextLine();
            System.out.print("Enter Student Marks: ");
            double marks = sc.nextDouble();
            studentList.add(new Student(name,marks));
        }

        //  CALCULATING AVERAGE
        double averageMarks = getAverageMarks(studentList);
        System.out.println("Average Marks: "+averageMarks);

        //  CALCULATING MIN MARKS
        double minMarks = getMinimumMarks(studentList);
        System.out.println("Minimum Marks: "+minMarks);

        //  CALCULATING MAX MARKS
        double maxMarks = getMaximumMarks(studentList);
        System.out.println("Maximum Marks: "+maxMarks);

        //  GETTING NAME OF HIGHEST SCORER
        String highestScorer = getHighestScorer(studentList);
        System.out.println("Highest Scorer: "+highestScorer);

        //  GETTING NAME OF LOWEST SCORER
        String lowestScorer = getLowestScorer(studentList);
        System.out.println("Lowest Scorer: "+lowestScorer);

    }

    private static double getAverageMarks(List<Student> studentList) {
        double average = 0;
        double sum = 0;
        int count = 0;
        for(Student s: studentList){
            count++;
            sum += s.getMarks();
            average = sum/count;
        }
        return average;
    }

    private static String getLowestScorer(List<Student> studentList) {
        Student s = getStudentByMinMarks(studentList);
        return s.getName();
    }

    private static String getHighestScorer(List<Student> studentList) {
        Student s = getStudentByMaxMarks(studentList);
        return s.getName();
    }

    private static double getMaximumMarks(List<Student> studentList) {
        Student s = getStudentByMaxMarks(studentList);
        return s.getMarks();
    }

    private static double getMinimumMarks(List<Student> studentList) {
        Student s = getStudentByMinMarks(studentList);
        return s.getMarks();
    }

    private static Student getStudentByMinMarks(List<Student> studentList) {
        double min = Double.MAX_VALUE;
        Student minStudent = null;
        for(Student s : studentList){
            if(s.getMarks()<min){
                min = s.getMarks();
                minStudent = s;
            }
        }
        return minStudent;
    }

    private static Student getStudentByMaxMarks(List<Student> studentList) {
        double max = Double.MIN_VALUE;
        Student maxStudent = null;
        for(Student s : studentList){
            if(s.getMarks()>max){
                max = s.getMarks();
                maxStudent = s;
            }
        }
        return maxStudent;
    }


}
