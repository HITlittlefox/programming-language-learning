//package chap10;
//public class Exam10_4{
//	public static void main(String[] args){
//		HashTable myHashTable = new HashTable(13);
//		int[] a = {180,750,600,430,541,900,460};
//		int i, j, n = 7, item;
//
//		for(i = 0; i < n; i++)
//			myHashTable.insert(a[i]);
//
//		for(i = 0; i < n; i++){
//			j = myHashTable.find(a[i]);
//			if(j > 0){
//				item = myHashTable.getValue(j);
//				System.out.println("j = " + j + "  ht[] = " + item);
//			}
//		}
//
//		if(myHashTable.isIn(430)) System.out.println("����Ԫ��430�ڹ�ϣ����");
//		else System.out.println("����Ԫ��430���ڹ�ϣ����");
//
//		myHashTable.delete(430);
//		if(myHashTable.isIn(430)) System.out.println("����Ԫ��430�ڹ�ϣ����");
//		else System.out.println("����Ԫ��430���ڹ�ϣ����");
//	}
//}
