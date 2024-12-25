<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<center><h2>Search Data Dynamically</h2></center>
<frm:form action="search" modelAttribute="emp" >
<table align="center" border="1" bgcolor="cyan">
  <tr>
   <td>Emp Name::</td>
   <td><frm:input path="ename"/></td>
  </tr>
  <tr>
   <td>Job::</td>
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
<tr>
    <td><input type="submit" value="Search Dynamic"></td>
         <td><input type="reset" value="cancel"></td>
  </tr>
  
</table>
</frm:form>



<hr><hr>
<center><h2>Employee Data</h2></center>

<c:choose>

<c:when test="${!empty page}">

  <table align="center" cellspacing="0" border="1">
  <tr bgcolor="yellow">
  <th>sno</th>
  <th>ename</th>
  <th>job</th>
  <th>eno&nbsp;&nbsp;&nbsp;</th>
  <th>salary</th>
  <th>deptno</th>
  <th>Operations</th>
  </tr>
  <c:forEach var="emp" varStatus="index" items="${page.getContent()}">
  <tr>
   <td>${index.count}</td>
   <td>${emp.ename}</td>
  <td>${emp.job}</td>
  <td>${emp.empno}</td>
  <td>${emp.sal}</td>
  <td>${emp.deptno}</td>
  <td><a href="edit?no=${emp.empno}">Edit</a>
  &nbsp;&nbsp; <a onclick="return confirm('Are you sure to delete')" href="delete?no=${emp.empno}">Delete</a></td>
 
  </tr>
  </c:forEach>
  </table>
</c:when>
</c:choose>
<center>
 <c:if test="${!pageData.isFirst()}">
   <a href="report?page=0">First</a>&nbsp;&nbsp; 
  </c:if>
  <c:if test="${!pageData.isLast()}">
   <a href="report?page=${pageData.getPageable().getPageNumber()+1}">Next</a>&nbsp;&nbsp; 
  </c:if>
  
   
 <c:forEach var="i" begin="0" step="1" end="${pageData.getTotalPages+1}">
    [<a href="report?page=${i}">${i+1}</a>]&nbsp;&nbsp; 
 
 </c:forEach>
  
  
   <c:if test="${!pageData.isFirst()}">
     <a href="report?page=${pageData.getPageable().getPageNumber()-1}">Previous</a>&nbsp;&nbsp; 
  </c:if>
  <c:if test="${!pageData.isLast()}">
   <a href="report?page=${pageData.getTotalPages()-1}">Last</a>&nbsp;&nbsp; 
  </c:if>
  
  
 
</center>


















    <h1>${resultMsg}</h1>


<center><h3><a href="/register">Add Employee</a></h3></center>


<br><br>
<hr>

<center><h2><a href="/">Home</a></h2></center>


