package chap2.SingleList;

import java.util.Comparator;

public class MyComparator implements Comparator {
	public int compare(Object o1, Object o2) {

		if ((o1 instanceof Integer) && (o2 instanceof Integer)) {
			Integer co1 = (Integer) o1;
			Integer co2 = (Integer) o2;
			int i1 = co1.intValue();
			int i2 = co2.intValue();
			if (i1 <= i2)
				return 1;
			else
				return -1;

		} else {
			return 0;
		}

	}

	public boolean equals(Object obj) {
		return false;
	}

}