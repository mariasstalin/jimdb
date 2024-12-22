package com.stanrnd.jimdb.select;

import com.stanrnd.jimdb.select.operation.AndOperation;
import com.stanrnd.jimdb.select.operation.EqualOperation;
import com.stanrnd.jimdb.select.operation.OrOperation;

public class OperationFactory {
	
	private OperationParam operationParam;
	
	public OperationFactory(OperationParam operationParam) {
		this.operationParam = operationParam;
	}
	
	public Operation getOperation(Op operator) {
		Operation operation = null;
		switch (operator) {
		case EQ: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case NEQ: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case LT: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case LTE: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case GT: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case GTE: {
			operation = new EqualOperation(operationParam);
			break;
			
		}
		case CONTAINS: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case EMPTY: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case END_WITH: {
			operation = new EqualOperation(operationParam);
			break;
		}
		case START_WITH: {
			operation = new EqualOperation(operationParam);
			break;
		}
		}
		return new EqualOperation(operationParam);
	}

	public Operation getOperation(LogOp operator) {
		Operation operation = null;
		switch (operator) {
		case AND: {
			operation = new AndOperation(operationParam);
			break;
		}
		case OR: {
			operation = new OrOperation(operationParam);
			break;
		}
		case NOT: {
			operation = new OrOperation(operationParam);
			break;
		}
		}
		return new AndOperation(operationParam);
	}
	
}
