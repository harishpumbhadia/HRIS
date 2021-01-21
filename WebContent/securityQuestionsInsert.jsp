<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<body>

<h2>Add Security Question</h2>
<small>[<font color=red>  *</font><font size=2> Fields Are Required </font>]</small> 

<hr>
		<form action="SecurityQuestionsInsertServlet" name="addQuestions"
			id="addQuestion" method="post">
			<table width=40%>
		<tr>
		  <div class="form-group">
         <td><label for="statusName">Security Question  <font color=red>   *</font></label></td>
   			<td><input type="text" name="question" id="question"
						value="${question}" maxlength="50" class="form-control" placeholder="Enter Sequrity Questioon "  required autofocus></td>
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

<script type="text/javascript">
      $(function () {
        $("#example1").dataTable();
        $('#example2').dataTable({
          "bPaginate": true,
          "bLengthChange": false,
          "bFilter": false,
          "bSort": true,
          "bInfo": true,
          "bAutoWidth": false
        });
      });
    </script>
</html>