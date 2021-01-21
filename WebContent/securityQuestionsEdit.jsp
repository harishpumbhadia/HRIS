<%@page import="com.dsynhub.HRIS.bean.SecurityQuestionsBean"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>

<h2>Update Security Question</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
<%
	SecurityQuestionsBean questionBean=(SecurityQuestionsBean)request.getAttribute("questionBean");
	if(questionBean!=null)
	{

%>
<form action="SecurityQuestionsUpdateServlet" name="securityQuestionUpdate" id="securityQuestionUpdate" method="post">
<input type="hidden" name="securityQuestionId" id="securityQuestionId" value="<%= questionBean.getQuestionId()%>" >
	<table width=40%>
		<tr>
		  <div class="form-group">
         <td><label for="statusName">Security Question  <font color=red>   *</font></label></td>
   		<td><input type="text" name="securityQuestion" value="${questionBean.question}"  maxlength="50" class="form-control" placeholder="Enter Security Question"  required autofocus></td>
</tr>

<tr>
<td>&nbsp;</td>
</tr>

	<tr>			
                   <td> <button type="reset" class="btn btn-warning">Reset</button></td>
                 
              
                   <td> <button type="submit" class="btn btn-success">Submit</button></td>
              
    </tr>
<%

	}

%>
</table>

</form>
</body>
</html>