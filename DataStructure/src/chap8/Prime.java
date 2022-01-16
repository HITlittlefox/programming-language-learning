//package chap8;
//
//public class Prim{
//	public static void prim(AdjMWGraph g, MinSpanTree[] closeVertex) throws Exception{
//		int n = g.getNumOfVertices();
//		int minCost;
//		int[] lowCost = new int[n];
//		int k = 0;
//
//		for(int i = 1; i < n; i ++)
//			lowCost[i] = g.getWeight(0, i);
//		MinSpanTree temp = new MinSpanTree();
//		temp.vertex = g.getValue(0);
//		closeVertex[0] = temp;
//		lowCost[0] = - 1;
//
//		for(int i = 1; i < n; i ++){
//			minCost = maxWeight;
//			for(int j = 1; j < n; j ++){
//				if(lowCost[j] < minCost && lowCost[j] > 0){
//					minCost = lowCost[j];
//					k = j;
//				}
//			}
//
//			MinSpanTree curr = new MinSpanTree();
//			curr.vertex = g.getValue(k);
//			curr.weight = minCost;
//			closeVertex[i] = curr;
//			lowCost[k] = -1;
//
//			for(int j = 1; j < n; j ++){
//				if(g.getWeight(k, j) < lowCost[j])
//					lowCost[j] = g.getWeight(k, j);
//			}
//		}
//	}
//}
