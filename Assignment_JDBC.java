package com.JDBCPrograms.codegnan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment_JDBC {
	static final String jdbc_Url = "jdbc:mysql://localhost:3306/jfs30_JDBC";
	static final String userName = "root";
	static final String password = "@Rmkec2043";

	public static void main(String[] args) {
		// DELETE SINGLE RECOED WITHOUT SCANNER CLASS
		try (Connection connection = DriverManager.getConnection(jdbc_Url,userName,password); 
				Statement statement = connection.createStatement()) {
					String sql = "DELETE FROM EMPLOYEE WHERE ENO = 333";
					statement.executeUpdate(sql);
					System.out.println("Row IS DELECTED Successfully");
				}catch (SQLException e) {
					e.printStackTrace();
				}

		// DELETE SINGLE RECORD INPUT FROM END USER
		try(Connection connection = DriverManager.getConnection(jdbc_Url,userName,password);
				Statement statement = connection.createStatement()){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Number: ");
			int ENO = sc.nextInt();

			String deleteSql = "DELETE FROM EMPLOYEE WHERE ENO = " + ENO; 
			int rowsAffected = statement.executeUpdate(deleteSql);
			if(rowsAffected == 1) {
				System.out.println("Records deleted Successfully");
			}else {
				System.out.println("Failed To delete Records In DataBase" + ENO);
			}
			sc.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}


		
		// DELERE MULTI-RECODS FROM END USER INPUT
		try (Connection connection = DriverManager.getConnection(jdbc_Url, userName, password);
				Statement statement = connection.createStatement()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter No Of Records To Delete: ");
			int NoOfRecords = sc.nextInt();
			for (int i = 0; i < NoOfRecords; i++) {
				System.out.println("Enter Details For records: " + (i+1));
				System.out.println("Enter Employee Number: ");
				int ENO = sc.nextInt();
				String deleteSql = "DELETE FROM EMPLOYEE WHERE ENO = " + ENO;
				int rowsAffected = statement.executeUpdate(deleteSql);
				if (rowsAffected == 1) {
					System.out.println("Records deleted Successfully");
				} else {
					System.out.println("Failed To delete Record Doesn't Exists " + ENO);
				}
			}
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		// Update Single Record Without Scanner Class
		try (Connection connection = DriverManager.getConnection(jdbc_Url, userName, password);
				Statement statement = connection.createStatement()) {
			String updateSql = "UPDATE EMPLOYEE SET ESALE = 85000 WHERE ENO = 2";
			int rowsAffected = statement.executeUpdate(updateSql);
			if (rowsAffected == 1) {
				System.out.println("Record Updated Successfully");
			} else {
				System.out.println("Failed To Update Record Into DataBase");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		// Update Single Record From End User
		try (Connection connection = DriverManager.getConnection(jdbc_Url, userName, password);
				Statement statement = connection.createStatement()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Number: ");
			int ENO = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Employee Name: ");
			String ENAME = sc.next();
			String updateSql = "UPDATE EMPLOYEE SET ENAME ='" + ENAME + "' WHERE ENO =" + ENO;
			int rowsAffected = statement.executeUpdate(updateSql);
			if (rowsAffected == 1) {
				System.out.println("Record Updated Successfully");
			} else {
				System.out.println("Failed To Update Records Into DataBase" + ENO);
			}
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		// Update Multiple Records From End User
		try (Connection connection = DriverManager.getConnection(jdbc_Url, userName, password);
				Statement statement = connection.createStatement()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter No Of Records Required: ");
			int NoOfRecords = sc.nextInt();
			for (int i = 0; i < NoOfRecords; i++) {
				System.out.println("Enter Details For records: " + (i + 1));
				System.out.println("Enter Employee Number: ");
				int ENO = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Salary: ");
				String ESALE = sc.next();
				String updateSql = "UPDATE EMPLOYEE SET ENAME ='" + ESALE + "' WHERE ENO =" + ENO;
				int rowsAffected = statement.executeUpdate(updateSql);
				if (rowsAffected == 1) {
					System.out.println("Record Updated Successfully");
				} else {
					System.out.println("Failed To Update Records Into DataBase" + ENO);
				}
			}
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

