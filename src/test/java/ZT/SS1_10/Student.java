package ZT.SS1_10;

public class Student {

    int studentId;
    String name;
    String surName;
    int course;

    double mathAverageGrade;
    double economicAverageGrade;
    double foreignLanguageAverageGrade;

}

class StudentTest{

    static double arithmeticMean(Student st){
        return (st.mathAverageGrade + st.economicAverageGrade + st.foreignLanguageAverageGrade)/3;
    }

    public static void main(String[] args) {
        Student st1 = new Student();
        st1.studentId = 1;
        st1.name = "John";
        st1.surName = "Doe";
        st1.course = 3;
        st1.mathAverageGrade = 7.8;
        st1.economicAverageGrade = 9.1;
        st1.foreignLanguageAverageGrade = 8.9;
        System.out.println(arithmeticMean(st1));

        Student st2 = new Student();
        st2.studentId = 2;
        st2.name = "Gianis";
        st2.surName = "Papaspirou";
        st2.course = 1;
        st2.mathAverageGrade = 8.2;
        st2.economicAverageGrade = 9.3;
        st2.foreignLanguageAverageGrade = 7.9;
        System.out.println(arithmeticMean(st2));

        Student st3 = new Student();
        st3.studentId = 3;
        st3.name = "Sotiris";
        st3.surName = "Samaras";
        st3.course = 2;
        st3.mathAverageGrade = 7.5;
        st3.economicAverageGrade = 7.8;
        st3.foreignLanguageAverageGrade = 7.7;
        System.out.println(arithmeticMean(st3));

    }




}
