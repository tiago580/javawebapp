package br.com.trsystems.base.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.trsystems.base.entity.EntityObject;
import br.com.trsystems.base.service.Service;
import br.com.trsystems.base.sorters.LazySorter;

public class EntityObjectLazyList<T extends EntityObject> extends
		LazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityObjectLazyList(Service<T> service) {
		this.service = service;
	}

	private Service<T> service = null;

	private List<T> records = null;

	@Override
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		records = service.find(first, pageSize);
		 List<T> data = new ArrayList<T>();
		for(T obj : records){
			boolean match = true;
			
			for(Iterator<String> it = filters.keySet().iterator();it.hasNext();){
				try {
					String filterProperty = it.next();  
                    String filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(obj.getClass().getField(filterProperty).get(obj));  
  
                    if(filterValue == null || fieldValue.startsWith(filterValue)) {  
                        match = true;  
                    }  
                    else {  
                        match = false;  
                        break;  
                    }  
				} catch (Exception e) {
					match = false;
				}
			}
			
			if(match){
				data.add(obj);
			}
			
		}
		
		 //sort  
        if(sortField != null) {  
            Collections.sort(data, new LazySorter<T>(sortField, sortOrder));  
        }
        
		if (getRowCount() <= 0) {
			setRowCount(service.countRecordsTotal());
		}
		setPageSize(pageSize);
		return records;
	}

	public Object getRowKey(T object) {
		Method method = null;
		Object result = null;
		try {
			method = object.getClass().getMethod("getId");
			result = method.invoke(object);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	};

	@Override
	public T getRowData(String rowKey) {
		Integer id = Integer.valueOf(rowKey);
		for (T object : records) {
			if (id.equals(getRowKey(object))) {
				return object;
			}

		}
		return null;
	}

}
