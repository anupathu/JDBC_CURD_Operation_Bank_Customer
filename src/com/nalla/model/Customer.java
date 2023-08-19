package com.nalla.model;

public class Customer {
private int c_Id;
private String c_Name;
private int c_Accno;
private String c_accType;
private int c_Balance;
public int getC_Id() {
	return c_Id;
}
public void setC_Id(int c_Id) {
	this.c_Id = c_Id;
}
public String getC_Name() {
	return c_Name;
}
public void setC_Name(String c_Name) {
	this.c_Name = c_Name;
}
public int getC_Accno() {
	return c_Accno;
}
public void setC_Accno(int c_Accno) {
	this.c_Accno = c_Accno;
}
public String getC_accType() {
	return c_accType;
}
public void setC_accType(String c_accType) {
	this.c_accType = c_accType;
}
public int getC_Balance() {
	return c_Balance;
}
public void setC_Balance(int c_Balance) {
	this.c_Balance = c_Balance;
}
public Customer(int c_Id, String c_Name, int c_Accno, String c_accType, int c_Balance) {
	
	this.c_Id = c_Id;
	this.c_Name = c_Name;
	this.c_Accno = c_Accno;
	this.c_accType = c_accType;
	this.c_Balance = c_Balance;
}
public Customer (int c_Id,String c_Name,String c_accType) {
	this.c_Id = c_Id;
	this.c_Name = c_Name;
	
	this.c_accType = c_accType;
	
}




}
