package com.nalla.util;

public class QueryUtil {
	public static String insertCustomerQuery() {
		return "insert into customer values(?,?,?,?,?)";
	}
	public static String view_CustomerQuery() {
		return "select * from customer";
	}
	
	public static String getByID_CustomerQuery(int customerID) {
		return "select * from customer where c_ID = " + customerID;
	}
	public static String delete_CustomerQuery(int customerID) {
		return "delete from customer where c_ID = " + customerID;
	}
	public static String transferFrom(int faccno,int amt,int bal1) {
		return "update customer set c_balance="+ (bal1-amt) +"where c_AccNo = " + faccno;
	}
	public static String transferTo(int taccno,int amt,int bal2) {
		return "update customer set c_balance="+ (bal2+amt) +"where c_AccNo = " + taccno;
	}
}
