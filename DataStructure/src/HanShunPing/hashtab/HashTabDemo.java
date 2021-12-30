package HanShunPing.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("exit：退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    // 创建 雇员
                    Employee emp = new Employee(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}


//创建HashTab 管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //?留一个坑,这是不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Employee emp) {
        //根据员工id，决定应该添加到那条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有的链表,遍历哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id，查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Employee emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {// 找到
            System.out.printf("在第%d条链表中找到 店员 id = %d\n", (empLinkedListNo + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该店员~");
        }
    }


    //编写一个散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;

    }
}

//表示一个雇员
class Employee {
    public int id;
    public String name;
    public Employee next;//next default=null

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//EmpLinkedList,链表
class EmpLinkedList {
    //头指针，执行第一个Emp，因此我们这个链表的head，是直接指向第一个Emp
    private Employee head;//default null

    //add
    //1. 假定，当添加雇员时，id自增
    //因此，直接将该雇员直接加到本链表最后
    public void add(Employee emp) {
        //first
        if (head == null) {
            head = emp;
            return;
        }
        //if not first, use a cursor to help locate
        Employee curEmp = head;
        while (true) {
            if (curEmp.next == null) {//the last one
                break;
            }
            curEmp = curEmp.next;
        }
        //add emp to the last one when return
        curEmp.next = emp;
    }

    //list遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {//null
            System.out.println("第 " + (no + 1) + " 条链表为空");
            return;
        }
        System.out.println("第 " + (no + 1) + " 条链表信息为");
        Employee curEmp = head;//辅助指针
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {//说明已经到了最后结点
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //根据id查找雇员
    public Employee findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) {//找到
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;//找到最后也没找到，返回null
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return curEmp;
    }
}
