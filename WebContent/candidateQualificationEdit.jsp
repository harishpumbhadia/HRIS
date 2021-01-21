<%@page import="com.dsynhub.HRIS.bean.CandidateQualificationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>
<h2>Update Qualification</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
<body>

<form action="CandidateQualificationUpdateServlet" method="post" name="canididateQualificationPage" id="canididateQualificationPage">
		<input type="hidden" name="candidateQualificationId" id="candidateQualificationId" value="${candidateQualificationBean.candidateQualificationId}">
		<table width=40%>

		<% CandidateQualificationBean candidateQualificationBean= (CandidateQualificationBean)request.getAttribute("candidateQualificationBean");	 %>
			<tr>
				  <div class="form-group">
				<td><label for="candidateQualificationName"> Qualification Name<font color=red>   *</font></label> </td>
					<td> <input type="text" name="candidateQualificationName" placeholder="Enter Qualification " class="form-control" id="candidateQualificationName" value = <%= candidateQualificationBean.getCandidateQualificationName() %>>${candidateQualificationName}</td> 
					</div>
			</tr>

			
			<tr>
			<td>&nbsp;</td>
			</tr>

				<tr>			
                   <td> <button type="reset" class="btn btn-warning">Reset</button></td>
                 
              
                   <td> <button type="submit" class="btn btn-success">Submit</button></td>
                 
				</tr>

		</table>
	</form>



</body>
</html>