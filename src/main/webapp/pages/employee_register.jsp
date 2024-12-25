<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
    <center><h2>Employee Registration page</h2></center>
    <frm:form modelAttribute="emp">
    <table align="center" bgcolor="cyan">
    <tr>
    <td>Name</td>
    <td><frm:input path="ename"/></td>
    </tr>
    <tr>
    <td>Job</td>
    <td><frm:input path="job"/></td>
    </tr>
    <tr>
    <td>Salary</td>
    <td><frm:input path="sal"/></td>
    </tr>
    <tr>
    <td>Dept no:</td>
    <td><frm:select path="deptno">
    <frm:option value="">--select--</frm:option>
    <frm:option value="10">10</frm:option>     
     <frm:option value="20">20</frm:option>
    <frm:option value="30">30</frm:option>
    </frm:select>
    </td>
    </tr>
    <td><input type="submit" value="register"></td>
     <td><input type="reset" value="cancel"></td>
    
    </table>
    
    
    
    </frm:form>