package com.stanrnd.jimdb;

import java.util.List;

import com.stanrnd.jimdb.IndexConfig;
import com.stanrnd.jimdb.Table;
import com.stanrnd.jimdb.select.Filter;
import com.stanrnd.jimdb.select.LogOp;
import com.stanrnd.jimdb.select.Op;

public class OnlyUpdatePostWrite {
	/*
	 * Validates that table data ONLY changes after an insert statement
	 * 1. Asserts that data has changed after a write
	 * 2. Asserts that data has NOT changed after various non-write statements
	 */
		
    public static void main(String[] args) 
    		throws NoSuchFieldException, 
    		SecurityException, 
    		IllegalArgumentException, 
    		IllegalAccessException {
    	Table<Employee> table = new Table<Employee>(100, new IndexConfig());

    	Object[] data_prior = table.data.clone();
		table.insert(new Employee("eid02", "Alan", "male", 20000, "HR", "Bangalore", "alan@gmail.com"));
		table.insert(new Employee("eid06", "Jacklin", "female", 10000, "QA", "Bangalore", "jacklin@gmail.com"));		
    	assert !data_prior.equals(table.data);
    	Object[] data_post_write = table.data.clone();
		table.find(new Filter(
					new Filter(
						new Filter("department", Op.EQ, "IT"), LogOp.OR, new Filter("department", Op.EQ, "QA")
						),
					LogOp.AND, new Filter("address", Op.EQ, "Bangalore")
				)
			);
		table.find(new Filter(
				new Filter(
					new Filter("department", Op.EQ, "IT"), LogOp.OR, new Filter("department", Op.EQ, "QA")
					),
				LogOp.AND, new Filter("address", Op.EQ, "Bangalore")
			)
		);
    	Object[] data_post_read = table.data.clone();
    	assert !data_post_write.equals(data_post_read);
    }
}
