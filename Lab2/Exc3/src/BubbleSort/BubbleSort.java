package BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Sortable {
	
	private List<Integer> sortedList;
	
	@Override
	public void sort(List<Integer> list) {	
		if(list == null) {
			throw new NullPointerException();
		} else if (list.size() == 1) {
			setSortedList(new ArrayList<Integer>(list));
		} else if (list.size() == 0) {
			setSortedList(new ArrayList<Integer>());
		} else {
			int size = list.size()-1;
			for(int i=0; i<size; i++) {
				for(int j=0; j<size-i; j++) {
					if (list.get(j) > list.get(j+1)) {
						int temp = list.get(j);
						list.remove(j);
						list.add(j, list.get(j));
						list.remove(j+1);
						list.add(j+1, temp);
					}
				}
			}
			setSortedList(new ArrayList<Integer>(list));
		}
	}

	public List<Integer> getSortedList() {
		return sortedList;
	}

	public void setSortedList(List<Integer> sortedList) {
		this.sortedList = sortedList;
	}
}
