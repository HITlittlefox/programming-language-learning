package HomeWorkDS;

public class LinStack implements Stack {
	Node head;										//��ջͷ
	int size;										//������

	public void LinStack(){							//���캯��
		head = null;
		size = 0;
	}

	public void push(Object obj){					//��ջ
		head = new Node(obj, head);					//�½����Ϊ��ջ��
		size ++;
	}

	public Object pop() throws Exception{			//��ջ
		if(size == 0){
			throw new Exception("��ջ�ѿգ�");
		}
		Object obj = head.data;					//ԭջ������Ԫ��
		head = head.next;							//ԭջ���������
		size --;
		return obj;
	}

	public boolean notEmpty(){						//�ǿշ�
		return head != null;
	}

	public Object getTop(){
		return head.data;
	}
}
