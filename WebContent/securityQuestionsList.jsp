<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.SecurityQuestionsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>


<body>
<div class="box">
                <div class="box-header">
                  <h3 class="box-title">Security Question Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<table id="example1" class="table table-bordered table-striped">
<thead>
<th>Security Question</th>
<th>Update</th>
<th>Delete</th>
</thead>

<tbody>
</tr>
<%
		ArrayList<SecurityQuestionsBean> questionList=(ArrayList)request.getAttribute("questionList");

			for(int i=0;i<questionList.size();i++)
			{
				SecurityQuestionsBean questionBean=questionList.get(i);
				if(questionBean!=null)
				{
				 
%>
<tr>
<td><%=questionBean.getQuestion()%></td>

<td><a href="SecurityQuestionsEditServlet?securityQuestionId=<%=questionBean.getQuestionId()%>"><img src=image\Update.png height="42" width="42"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td>
<a href="SecurityQuestionsDeleteServlet?securityQuestionId=<%=questionBean.getQuestionId()%>"><img src=image\Delete.png height="42" width="42"></a> </td>
</td>
</tr>


<% 
				
			}
		}
%>
</tbody>
</table>

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