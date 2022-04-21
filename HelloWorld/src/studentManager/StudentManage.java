package studentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        while (true) {
            System.out.println("----------欢迎来到学生管理系统-----------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            Scanner input = new Scanner(System.in);
            String op = input.nextLine();
            switch (op) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    deleteStuent(array);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
//                    System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);
            }
        }
    }
    public static void addStudent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        String sid;
        System.out.println("请输入学生学号：");
        while (true) {
            sid = input.nextLine();
            if (isUsed(array,sid)) {
                System.out.println("该学号已被使用，请重新输入：");
                continue;
            }
            break;
        }
        System.out.println("请输入学生姓名：");
        String name = input.nextLine();
        System.out.println("请输入学生年龄：");
        String age = input.nextLine();
        System.out.println("请输入学居住地：");
        String address = input.nextLine();
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加成功！");
    }
    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size()==0) {
            System.out.println("暂无学生！");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t居住地");
        for (int i=0;i<array.size();i++) {
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t"+ s.getAddress());
        }
    }
    public static void deleteStuent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除学生的学号：");
        String sid = input.nextLine();
        int idx = -1;
        for (int i=0;i<array.size();i++) {
            Student s = array.get(i);
            if (sid.equals(s.getSid())) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println("无信息！");
        }
        else {
            array.remove(idx);
            System.out.println("删除成功！");
        }
    }
    public static void updateStudent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号：");
        String sid = input.nextLine();
        Student s = new Student();
        System.out.println("请输入学生新姓名：");
        String name = input.nextLine();
        System.out.println("请输入学生新年龄：");
        String age = input.nextLine();
        System.out.println("请输入学生新居住地：");
        String address = input.nextLine();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        for (int i=0;i<array.size();i++) {
            Student student = array.get(i);
            if (sid.equals(student.getSid())) {
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改成功！");
    }
    public static boolean isUsed(ArrayList<Student> array,String sid) {
        for (int i=0;i<array.size();i++) {
            Student s = array.get(i);
            if (sid.equals(s.getSid())) {
                return true;
            }
        }
        System.out.println("1");
        return false;
    }
}
