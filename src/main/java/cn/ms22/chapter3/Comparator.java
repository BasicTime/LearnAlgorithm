package cn.ms22.chapter3;

import cn.ms22.utils.CommonUtil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 比较中，lis和tl的年龄在第二次排序时候保证了稳定性
 *
 */
public class Comparator {
    public static void main(String[] args) {
        //利用比较器
        Student zs = Student.builder().setAge(15).setName("张三").setSex("nv").setHeight(170).build();
        Student lis = Student.builder().setAge(14).setName("李四").setSex("nan").setHeight(163).build();
        Student ww = Student.builder().setAge(12).setName("王五").setSex("nv").setHeight(183).build();
        Student tl = Student.builder().setAge(14).setName("唐六").setSex("nan").setHeight(170).build();
        Student[] students = new Student[]{zs, lis, ww, tl};
        CommonUtil.print(students);
        Arrays.sort(students, java.util.Comparator.comparingInt(o -> o.age));
        CommonUtil.print(students, "按照年龄排序之后");
        Arrays.sort(students, java.util.Comparator.comparingInt(o -> o.height));
        CommonUtil.print(students, "按照身高排序之后");

        //利用优先队列堆结构
        PriorityQueue<Student> students1 = new PriorityQueue<>(java.util.Comparator.comparingInt(o -> o.height));
        students1.add(zs);
        students1.add(lis);
        students1.add(ww);
        students1.add(tl);
        System.out.println("优先队列，堆结构按照student.Height排序。");
        while(!students1.isEmpty()){
            System.out.println(students1.poll());
        }
        PriorityQueue<Student> students2 = new PriorityQueue<>(java.util.Comparator.comparingInt(o -> o.age));
        students2.add(zs);
        students2.add(lis);
        students2.add(ww);
        students2.add(tl);
        System.out.println("优先队列，堆结构按照student.age排序。");
        while(!students2.isEmpty()){
            System.out.println(students2.poll());
        }
        //利用treeSet树结构排序
        //TODO 树结构打印还有待处理
        TreeSet<Student> treeSet1= new TreeSet<>(java.util.Comparator.comparingInt(o -> o.age));
        treeSet1.add(zs);
        treeSet1.add(lis);
        treeSet1.add(ww);
        treeSet1.add(tl);

        System.out.println("treeSet，按照student.age排序。");
        while(!treeSet1.isEmpty()){
            System.out.println(treeSet1.pollFirst());
        }

        TreeSet<Student> treeSet2= new TreeSet<>(java.util.Comparator.comparingInt(o -> o.height));
        treeSet2.add(zs);
        treeSet2.add(lis);
        treeSet2.add(ww);
        treeSet2.add(tl);
        System.out.println("treeSet，按照student.height排序。");
        while(!treeSet2.isEmpty()){
            System.out.println(treeSet2.pollFirst());
        }
    }

    static class Student {
        private String name;
        private String sex;
        private int age;
        private int height;

        public Student() {
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    '}';
        }

        public static StudentBuilder builder() {
            return new StudentBuilder();
        }

        static class StudentBuilder {
            private Student student;

            public StudentBuilder() {
                this.student = new Student();
            }

            public StudentBuilder setName(String name) {
                this.student.name = name;
                return this;
            }

            public StudentBuilder setAge(int age) {
                this.student.age = age;
                return this;
            }

            public StudentBuilder setSex(String sex) {
                this.student.sex = sex;
                return this;
            }

            public StudentBuilder setHeight(int height) {
                this.student.height = height;
                return this;
            }

            public Student build() {
                return this.student;
            }
        }
    }
}
