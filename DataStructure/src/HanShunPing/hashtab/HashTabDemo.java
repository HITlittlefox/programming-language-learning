package HanShunPing.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        //������ϣ��
        HashTab hashTab = new HashTab(7);
        //дһ���򵥵Ĳ˵�
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:��ӹ�Ա");
            System.out.println("list����ʾ��Ա");
            System.out.println("exit���˳�ϵͳ");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("����id");
                    int id = scanner.nextInt();
                    System.out.println("��������");
                    String name = scanner.next();
                    // ���� ��Ա
                    Employee emp = new Employee(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("������Ҫ���ҵ�id");
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


//����HashTab �����������
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //������
    public HashTab(int size) {
        this.size = size;
        //��ʼ��empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //?��һ����,���ǲ�Ҫ���˷ֱ��ʼ��ÿ������
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //��ӹ�Ա
    public void add(Employee emp) {
        //����Ա��id������Ӧ����ӵ���������
        int empLinkedListNo = hashFun(emp.id);
        //��emp��ӵ���Ӧ��������
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //�������е�����,������ϣ��
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //���������id�����ҹ�Ա
    public void findEmpById(int id) {
        //ʹ��ɢ�к���ȷ���������������
        int empLinkedListNo = hashFun(id);
        Employee emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {// �ҵ�
            System.out.printf("�ڵ�%d���������ҵ� ��Ա id = %d\n", (empLinkedListNo + 1), id);
        } else {
            System.out.println("�ڹ�ϣ���У�û���ҵ��õ�Ա~");
        }
    }


    //��дһ��ɢ�к�����ʹ��һ���򵥵�ȡģ��
    public int hashFun(int id) {
        return id % size;

    }
}

//��ʾһ����Ա
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

//EmpLinkedList,����
class EmpLinkedList {
    //ͷָ�룬ִ�е�һ��Emp�����������������head����ֱ��ָ���һ��Emp
    private Employee head;//default null

    //add
    //1. �ٶ�������ӹ�Աʱ��id����
    //��ˣ�ֱ�ӽ��ù�Աֱ�Ӽӵ����������
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

    //list��������Ĺ�Ա��Ϣ
    public void list(int no) {
        if (head == null) {//null
            System.out.println("�� " + (no + 1) + " ������Ϊ��");
            return;
        }
        System.out.println("�� " + (no + 1) + " ��������ϢΪ");
        Employee curEmp = head;//����ָ��
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {//˵���Ѿ����������
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //����id���ҹ�Ա
    public Employee findEmpById(int id) {
        //�ж������Ƿ�Ϊ��
        if (head == null) {
            System.out.println("����Ϊ��");
            return null;
        }
        //����ָ��
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) {//�ҵ�
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;//�ҵ����Ҳû�ҵ�������null
                break;
            }
            curEmp = curEmp.next;//����
        }
        return curEmp;
    }
}
