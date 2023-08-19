package com.nalla.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.nalla.model.Customer;
import com.nalla.util.DatabaseUtil;
import com.nalla.util.QueryUtil;

public class DatabaseService {
	static DatabaseUtil d = new DatabaseUtil();
	static Connection c;
	static PreparedStatement ps;
	static Statement st;
	static Scanner s;

	public static void insert_Customer_Details(Customer cs) throws SQLException {

		c = d.getConnection();
		ps = c.prepareStatement(QueryUtil.insertCustomerQuery());

		ps.setInt(1, cs.getC_Id());
		ps.setString(2, cs.getC_Name());
		ps.setInt(3, cs.getC_Accno());
		ps.setString(4, cs.getC_accType());
		ps.setInt(5, cs.getC_Balance());
		int i = ps.executeUpdate();
		if (i > 0) {
			System.out.println("Recored inserted successfully.......!!!!!!!!!");

		} else {
			System.out.println(" Record not inserted try once again...");
		}

	}

	public static void view_CustomerList() throws SQLException {
		c = d.getConnection();
		st = c.createStatement();
		ResultSet resultSet = st.executeQuery(QueryUtil.view_CustomerQuery());
		while (resultSet.next()) {

			System.out.println("Customer ID: " + resultSet.getInt(1));
			System.out.println("Customer Name: " + resultSet.getString(2));
			System.out.println("Customer AccountNo: " + resultSet.getInt(3));
			System.out.println("Customer AccType: " + resultSet.getString(4));
			System.out.println("Customer Balance: " + resultSet.getInt(5));
			System.out.println("---------------Next Customer------------------");

		}
	}

	public static boolean getCustomerByID(int id) throws SQLException {
		boolean isFound = false;
		c = d.getConnection();
		st = c.createStatement();
		ResultSet rs = st.executeQuery(QueryUtil.getByID_CustomerQuery(id));
		while (rs.next()) {
			isFound = true;
			System.out.println("Customer ID: " + rs.getInt(1));
			System.out.println("Customer Name: " + rs.getString(2));
			System.out.println("Customer AccountNo: " + rs.getInt(3));
			System.out.println("Customer AccType: " + rs.getString(4));
			System.out.println("Customer Balance: " + rs.getInt(5));
			System.out.println("---------------Next Customer------------------");
		}

		return true;

	}

	public static void deleteCustomerByID(int id) throws SQLException {
		c = d.getConnection();
		st = c.createStatement();
		int delete = st.executeUpdate(QueryUtil.delete_CustomerQuery(id));

		if (delete > 0) {
			System.out.println("Recored is deleted successfully");
		} else {
			System.out.println("Recored not deleted ");
		}

	}

	public static void updateCustomerDeatils(Customer cus) throws SQLException {

		c = d.getConnection();

		String updatequery = "update customer set c_Name = ?, c_AccType = ? where c_ID = "
				+ cus.getC_Id();
		ps = c.prepareStatement(updatequery);

		ps.setString(1, cus.getC_Name());

		ps.setString(2, cus.getC_accType());

		

		int i = ps.executeUpdate();
		if (i == 1) {
			System.out.println("Recored updated successfully.......!!!!!!!!!");

		} else {
			System.out.println(" Record not updated try once again...");
		}

	}
	public static void transferAmount(int faccno,int taccno,int amt) throws SQLException {
		c = d.getConnection();
		 st = c.createStatement();
		
		
		ResultSet rs = st.executeQuery(QueryUtil.view_CustomerQuery());
		int bal1 = 0,bal2=0;
		while(rs.next()) {
			
			if(rs.getInt(3)==faccno) 
				bal1 = rs.getInt(5);

			if(rs.getInt(3)==taccno) 
				 bal2 = rs.getInt(5);
			
		}
//		System.out.println(faccno  +"===>"+bal1);
//		System.out.println(taccno  +"===>"+bal2);
//		

		int i;
		 i = st.executeUpdate(QueryUtil.transferFrom(faccno, amt, bal1));
		i = st.executeUpdate(QueryUtil.transferTo(taccno, amt, bal2));
		c.commit();
		if(i==1) {
			System.out.println("Amount transfered successfully.........!!");

		}else {
			System.out.println("Transfer Failed");

		}
		if(c !=null) {
			c.close();
	}
			}
}
