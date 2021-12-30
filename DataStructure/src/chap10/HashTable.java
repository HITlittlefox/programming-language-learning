//package chap10;
//public class HashTable{
//	HashItem[] ht;
//	int tableSize;
//	int currentSize;
//
//	HashTable(int m){
//		tableSize = m;
//		ht = new HashItem[tableSize];
//		currentSize = 0;
//	}
//
//	public boolean isIn(int x){
//		int i = find(x);
//		if(i >= 0)
//			return true;
//		else
//			return false;
//	}
//
//	public int getValue(int i){
//		return ht[i].data;
//	}
//
//	public int find(int x){
//		int i = x % tableSize;
//		int j = i;
//
//		if(ht[j] == null) ht[j] = new HashItem(0);
//		while(ht[j].info == 1 && ht[j].data != x){
//			j = (j + 1) % tableSize;
//			if(j == i) return - tableSize;
//		}
//		if(ht[j].info == 1)
//			return j;
//		else
//			return - j;
//	}
//
//	public int insert(int x){
//		int i = find(x);
//
//		if(i > 0) return 0;
//		else if(i != -tableSize){
//			ht[-i] = new HashItem(x , 1);
//			currentSize ++;
//			return 1;
//		}
//		else return 0;
//	}
//
//	public int delete(int x){
//		int i = find(x);
//
//		if(i >= 0){
//			ht[i].info = - 1;
//			currentSize --;
//			return 1;
//		}
//		else return 0;
//	}
//}
//
//class HashItem{
//	int data;
//	int info;
//
//	HashItem(int i){
//		info = i;
//	}
//
//	HashItem(int d, int i){
//		data = d;
//		info = i;
//	}
//}
