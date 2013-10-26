package br.com.trsystems.base.sorters;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.trsystems.base.entity.EntityObject;

public class LazySorter<T extends EntityObject> implements Comparator<T> {
	private String sortField;

	private SortOrder sortOrder;

	public LazySorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	public int compare(T obj1, T obj2) {
		try {
			
			Object value1 = obj1.getClass().getField(this.sortField).get(obj1);
			Object value2 = obj2.getClass().getField(this.sortField).get(obj2);

			@SuppressWarnings("unchecked")
			int value = ((Comparable<T>) value1).compareTo((T) value2);

			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
