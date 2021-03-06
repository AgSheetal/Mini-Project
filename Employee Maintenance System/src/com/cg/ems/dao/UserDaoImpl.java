package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EMSException;
import com.cg.ems.util.ConnectionProvider;
import com.cg.ems.util.Messages;
import com.cg.ems.dao.IQueryMapper;

public class UserDaoImpl implements IUserDao {

	@Override
	public Employee getEmployeeById(String empId) throws EMSException {
		Employee emp = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(IQueryMapper.FIND_BY_ID);

			st.setString(1, empId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setEmpFName(rs.getString(2));
				emp.setEmpLName(rs.getString(3));
				emp.setEmpDOB(rs.getDate(4));
				emp.setEmpDOJ(rs.getDate(5));
				emp.setEmpDeptId(rs.getInt(6));
				emp.setEmpGrade(rs.getString(7));
				emp.setEmpDesignation(rs.getString(8));
				emp.setEmpBasic(rs.getInt(9));
				emp.setEmpGender(rs.getString(10).charAt(0));
				emp.setEmpMarital(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpContact(rs.getString(13));
				emp.setMgrId(rs.getString(14));
				emp.setEmpLeaveBal(rs.getInt(15));
			}

		} catch (SQLException e) {
			throw new EMSException(Messages.NOT_FETCHED);
		} finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				throw new EMSException(Messages.CONNECTION_NOT_CLOSED);
			}

		}
		return emp;

	}

	@Override
	public List<Employee> searchById(String empId, char wildcardChar) throws EMSException {

		Employee emp = null;
		Connection con = null;
		PreparedStatement st = null;
		List<Employee> empList = null;

		try {

			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(IQueryMapper.SEARCH_BY_ID);

			if (wildcardChar == '*') {
				st.setString(1, empId + '%');
			} else {
				st.setString(1, empId + '_');
			}

			ResultSet rs = st.executeQuery();
			empList = new ArrayList<Employee>();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setEmpFName(rs.getString(2));
				emp.setEmpLName(rs.getString(3));
				emp.setEmpDOB(rs.getDate(4));
				emp.setEmpDOJ(rs.getDate(5));
				emp.setEmpDeptId(rs.getInt(6));
				emp.setEmpGrade(rs.getString(7));
				emp.setEmpDesignation(rs.getString(8));
				emp.setEmpBasic(rs.getInt(9));
				emp.setEmpGender(rs.getString(10).charAt(0));
				emp.setEmpMarital(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpContact(rs.getString(13));
				emp.setMgrId(rs.getString(14));
				emp.setEmpLeaveBal(rs.getInt(15));
				empList.add(emp);
			}

		} catch (SQLException e) {

			throw new EMSException(Messages.NOT_FETCHED);
		} finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				throw new EMSException(Messages.CONNECTION_NOT_CLOSED);
			}

		}
		return empList;

	}

	@Override
	public List<Employee> searchByFirstName(String empFName, char wildcardChar) throws EMSException {

		Employee emp = null;
		Connection con = null;
		PreparedStatement st = null;
		List<Employee> empList = null;

		try {

			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(IQueryMapper.SEARCH_BY_FIRST_NAME);

			if (wildcardChar == '*') {
				st.setString(1, empFName + '%');
			} else {
				st.setString(1, empFName + '_');
			}

			ResultSet rs = st.executeQuery();
			empList = new ArrayList<Employee>();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setEmpFName(rs.getString(2));
				emp.setEmpLName(rs.getString(3));
				emp.setEmpDOB(rs.getDate(4));
				emp.setEmpDOJ(rs.getDate(5));
				emp.setEmpDeptId(rs.getInt(6));
				emp.setEmpGrade(rs.getString(7));
				emp.setEmpDesignation(rs.getString(8));
				emp.setEmpBasic(rs.getInt(9));
				emp.setEmpGender(rs.getString(10).charAt(0));
				emp.setEmpMarital(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpContact(rs.getString(13));
				emp.setMgrId(rs.getString(14));
				emp.setEmpLeaveBal(rs.getInt(15));
				empList.add(emp);
			}

		} catch (SQLException e) {

			throw new EMSException(Messages.NOT_FETCHED);
		} finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				throw new EMSException(Messages.CONNECTION_NOT_CLOSED);
			}

		}
		return empList;
	}

	@Override
	public List<Employee> searchByLastName(String empLName, char wildcardChar) throws EMSException {
		Employee emp = null;
		Connection con = null;
		PreparedStatement st = null;
		List<Employee> empList = null;

		try {

			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(IQueryMapper.SEARCH_BY_LAST_NAME);

			if (wildcardChar == '*') {
				st.setString(1, empLName + '%');
			} else {
				st.setString(1, empLName + '_');
			}

			ResultSet rs = st.executeQuery();
			empList = new ArrayList<Employee>();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setEmpFName(rs.getString(2));
				emp.setEmpLName(rs.getString(3));
				emp.setEmpDOB(rs.getDate(4));
				emp.setEmpDOJ(rs.getDate(5));
				emp.setEmpDeptId(rs.getInt(6));
				emp.setEmpGrade(rs.getString(7));
				emp.setEmpDesignation(rs.getString(8));
				emp.setEmpBasic(rs.getInt(9));
				emp.setEmpGender(rs.getString(10).charAt(0));
				emp.setEmpMarital(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpContact(rs.getString(13));
				emp.setMgrId(rs.getString(14));
				emp.setEmpLeaveBal(rs.getInt(15));
				empList.add(emp);
			}

		} catch (SQLException e) {

			throw new EMSException(Messages.NOT_FETCHED);
		} finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				throw new EMSException(Messages.CONNECTION_NOT_CLOSED);
			}

		}
		return empList;

	}

	@Override
	public List<Employee> searchByDept(List<String> empDeptNames) throws EMSException {

		Employee emp = null;
		Connection con = null;
		PreparedStatement st = null;
		String query = "SELECT * FROM Employee WHERE Emp_Dept_Id IN"
				+ "(SELECT DISTINCT Dept_Id FROM Department WHERE Dept_Name IN (";
		List<Employee> empList;
		int size = empDeptNames.size();
		for (int count = 0; count < size; count++) {
			if (count == 0)
				query += "?";
			else
				query += ", ?";
		}
		query += "))";
		try {

			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(query);
			for (int count = 0; count < size; count++)
				st.setString(count + 1, empDeptNames.get(count));
			ResultSet rs = st.executeQuery();
			empList = new ArrayList<Employee>();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setEmpFName(rs.getString(2));
				emp.setEmpLName(rs.getString(3));
				emp.setEmpDOB(rs.getDate(4));
				emp.setEmpDOJ(rs.getDate(5));
				emp.setEmpDeptId(rs.getInt(6));
				emp.setEmpGrade(rs.getString(7));
				emp.setEmpDesignation(rs.getString(8));
				emp.setEmpBasic(rs.getInt(9));
				emp.setEmpGender(rs.getString(10).charAt(0));
				emp.setEmpMarital(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpContact(rs.getString(13));
				emp.setMgrId(rs.getString(14));
				emp.setEmpLeaveBal(rs.getInt(15));
				empList.add(emp);
			}

		} catch (SQLException e) {

			throw new EMSException(Messages.NOT_FETCHED);
		} finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				throw new EMSException(Messages.CONNECTION_NOT_CLOSED);
			}

		}
		return empList;

	}

	@Override
	public List<Employee> searchByGrade(List<String> empGrades) throws EMSException {

		Employee emp = null;
		Connection con = null;
		PreparedStatement st = null;
		List<Employee> empList = null;
		String query = "SELECT * FROM Employee WHERE Emp_Grade IN (";
		int size = empGrades.size();
		for (int count = 0; count < size; count++) {
			if (count == 0)
				query += "?";
			else
				query += ", ?";
		}
		query += ")";
		
		try {

			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(query);
			for (int count = 0; count < size; count++)
				st.setString(count + 1, empGrades.get(count));
			ResultSet rs = st.executeQuery();
			empList = new ArrayList<Employee>();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setEmpFName(rs.getString(2));
				emp.setEmpLName(rs.getString(3));
				emp.setEmpDOB(rs.getDate(4));
				emp.setEmpDOJ(rs.getDate(5));
				emp.setEmpDeptId(rs.getInt(6));
				emp.setEmpGrade(rs.getString(7));
				emp.setEmpDesignation(rs.getString(8));
				emp.setEmpBasic(rs.getInt(9));
				emp.setEmpGender(rs.getString(10).charAt(0));
				emp.setEmpMarital(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpContact(rs.getString(13));
				emp.setMgrId(rs.getString(14));
				emp.setEmpLeaveBal(rs.getInt(15));
				empList.add(emp);
			}

		} catch (SQLException e) {

			throw new EMSException(Messages.NOT_FETCHED);
		} finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				throw new EMSException(Messages.CONNECTION_NOT_CLOSED);
			}

		}
		return empList;

	}

	@Override
	public List<Employee> searchByMarital(List<String> empMarital) throws EMSException {

		Employee emp = null;
		Connection con = null;
		PreparedStatement st = null;
		List<Employee> empList = null;
		String query = "SELECT * FROM Employee WHERE Emp_Marital_Status IN (";
		int size = empMarital.size();
		for (int count = 0; count < size; count++) {
			if (count == 0)
				query += "?";
			else
				query += ", ?";
		}
		query += ")";
		
		try {

			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(query);

			for (int count = 0; count < size; count++)
				st.setString(count + 1, empMarital.get(count));

			ResultSet rs = st.executeQuery();
			empList = new ArrayList<Employee>();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setEmpFName(rs.getString(2));
				emp.setEmpLName(rs.getString(3));
				emp.setEmpDOB(rs.getDate(4));
				emp.setEmpDOJ(rs.getDate(5));
				emp.setEmpDeptId(rs.getInt(6));
				emp.setEmpGrade(rs.getString(7));
				emp.setEmpDesignation(rs.getString(8));
				emp.setEmpBasic(rs.getInt(9));
				emp.setEmpGender(rs.getString(10).charAt(0));
				emp.setEmpMarital(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpContact(rs.getString(13));
				emp.setMgrId(rs.getString(14));
				emp.setEmpLeaveBal(rs.getInt(15));
				empList.add(emp);
			}

		} catch (SQLException e) {

			throw new EMSException(Messages.NOT_FETCHED);
		} finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				throw new EMSException(Messages.CONNECTION_NOT_CLOSED);
			}

		}
		return empList;

	}
}
