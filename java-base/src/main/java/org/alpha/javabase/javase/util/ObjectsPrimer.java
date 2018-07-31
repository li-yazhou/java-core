package org.alpha.javabase.javase.util;

import org.alpha.javabase.javase.util.bean.Student;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author liyazhou1
 * @date 2018/7/31
 */
public class ObjectsPrimer {


    @Test
    public void compare() {
        Student s1 = new Student("001", "zz", LocalDate.now(), 1);
        Student s2 = new Student("002", "yz", LocalDate.now().minusYears(5), 1);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        Comparator<Student> cmp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        };

        Comparator<Student> comparator = (student1, student2) -> student1.getBirthday().compareTo(student2.getBirthday());

        Comparator<Student> studentComparator = Comparator.comparing(student -> student.getBirthday());

        Comparator<Student> studentComparator1 = Comparator.comparing(Student::getBirthday);

        int bigger = Objects.compare(s1, s2, cmp);
        System.out.println("bigger = " + bigger);

        bigger = Objects.compare(s1, s2, comparator);
        System.out.println("bigger = " + bigger);


        bigger = Objects.compare(s1, s2, studentComparator);
        System.out.println("bigger = " + bigger);

        bigger = Objects.compare(s1, s2, studentComparator1);
        System.out.println("bigger = " + bigger);
    }


    /*
        Returns true if the arguments are deeply equal to each other and false otherwise. Two null values are deeply equal.
        If both arguments are arrays, the algorithm in Arrays.deepEquals is used to determine equality.
        Otherwise, equality is determined by using the equals method of the first argument.
     */
    @Test
    public void deepEquals() {
        Student s1 = new Student("001", "zz", LocalDate.now(), 1);
        Student s2 = new Student("001", "zz", LocalDate.now(), 1);
        Student s3 = new Student("001", "zz", LocalDate.now(), 1);
        Student s4 = new Student("001", "zz", LocalDate.now(), 1);

        Student[] students1 = {s1, s2};
        Student[] students2 = {s3, s4};

        System.out.println("== " + (s1 == s2));
        System.out.println("equals = " + s1.equals(s2));

        boolean deepEquals = Objects.deepEquals(s1, s2);
        System.out.println("deepEquals = " + deepEquals);

        deepEquals = Objects.deepEquals(students1, students2);
        System.out.println("deepEquals = " + deepEquals);
    }


    /*
        与 deepEquals的区别是
            Objects.equals(o1, o2) 相当于 o1.equals(o2)
     */
    @Test
    public void equals() {
        Student s1 = new Student("001", "zz", LocalDate.now(), 1);
        Student s2 = new Student("001", "zz", LocalDate.now(), 1);
        Student s3 = new Student("001", "zz", LocalDate.now(), 1);
        Student s4 = new Student("001", "zz", LocalDate.now(), 1);

        Student[] students1 = {s1, s2};
        Student[] students2 = {s3, s4};

        boolean equals = Objects.equals(students1, students2);
        System.out.println("equals = " + equals);

        boolean arrayEquals = Arrays.equals(students1, students2);
        System.out.println("arrayEquals = " + arrayEquals);
    }

    @Test
    public void hash() {
        Student s1 = new Student("001", "zz", LocalDate.now(), 1);
        Student s2 = new Student("001", "zz", LocalDate.now(), 1);
        Student s3 = new Student("001", "zz", LocalDate.now(), 1);
        Student s4 = new Student("001", "zz", LocalDate.now(), 1);

        Student[] students1 = {s1, s2};
        Student[] students2 = {s3, s4};

        int hashResult1 = Objects.hash(students1);
        int hashResult2 = Objects.hash(students2);
        System.out.println("hashResult1 = " + hashResult1);
        System.out.println("hashResult2 = " + hashResult2);

        /*
            hashResult1 = -1879658015
            hashResult2 = -1879658015
         */
    }

    @Test
    public void testHashCode() {
        Student s1 = new Student("001", "zz", LocalDate.now(), 1);
        System.out.println("Objects.hashCode(s1) = " + Objects.hashCode(s1));
        System.out.println("hashCode = " + s1.hashCode());
        /*
            Objects.hashCode(s1) = 1551873393
            hashCode = 1551873393
         */
    }


    /*
        requireNonNull
        public static <T> T requireNonNull(T obj)
            Checks that the specified object reference is not null. This method is designed primarily for doing parameter validation in methods and constructors, as demonstrated below:

             public Foo(Bar bar) {
                 this.bar = Objects.requireNonNull(bar);
             }

        Type Parameters:
            T - the type of the reference
        Parameters:
            obj - the object reference to check for nullity
        Returns:
            obj if not null
        Throws:
            NullPointerException - if obj is null
     */
    @Test
    public void requireNonNull() {
        Student student = new Student("001", "zz", LocalDate.now(), 1);
        System.out.println("student = " + student);
        student = Objects.requireNonNull(student);
        System.out.println("student = " + student);

        student = null;
        student = Objects.requireNonNull(student);
        System.out.println("student = " + student);
    }


    /*
        异常提示
     */
    @Test
    public void requireNonNullWithMsg() {
        Student student = null;
        System.out.println("student = " + student);
        student = Objects.requireNonNull(student, "null value");
        System.out.println("student = " + student);
    }


    @Test
    public void testToString() {
        Student student = new Student("001", "zz", LocalDate.now(), 1);
        System.out.println("student = " + student);
        System.out.println("Objects.toString(student) = " + Objects.toString(student));

        student = null;
        System.out.println("student = " + student);
        System.out.println("Objects.toString(student) = " + Objects.toString(student));
        System.out.println("Objects.toString(student, \"null object\") = "
                + Objects.toString(student, "null object"));

    }

}
