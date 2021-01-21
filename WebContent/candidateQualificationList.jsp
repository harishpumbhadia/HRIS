<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.HRIS.bean.CandidateQualificationBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="admin_header.html"%>
<%@ include file="admin_sidebar.html"%>
<%@ include file="admin_dashboard.html"%>

<script type="text/javascript">

function del(id) {
	//alert("ID : "+id);
	var f = document.candidateQualificationListPage;
	f.candidateQualificationId.value = id;
	f.action = "CandidateQualificationDeleteServlet";
	f.submit();
}

</script>

</head>
<body>


<form action="" name=candidateQualificationListPage id="candidateQualificationListPage">
<input type="hidden" name="candidateQualificationId" id="candidateQualificationId">
<center>
 <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Candidate Qualification Detail</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
<table id="example1" class="table table-bordered table-striped">
<thead>

<tr>
<th>CandidateQualificationID</th>
<th>CandidateQualificationName</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>

<tbody>
<% 


List<CandidateQualificationBean> listOfCanididateQualification= (ArrayList)request.getAttribute("listOfCandidateQualification");

if(listOfCanididateQualification!=null ){
for(int i=0;i<listOfCanididateQualification.size();i++){
	CandidateQualificationBean candidateQualificationBean= listOfCanididateQualification.get(i);
	
%>	
<tr>
<td><%= candidateQualificationBean.getCandidateQualificationId() %></td>
<td><%= candidateQualificationBean.getCandidateQualificationName()%></td>


<td> 
<a href="CandidateQualificationEditServlet?candidateQualificationId=<%= candidateQualificationBean.getCandidateQualificationId() %>"><img src=image\Update.png height="42" width="42"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td>
<a href="#" onclick="del(<%= candidateQualificationBean.getCandidateQualificationId() %>)"><img src=image\Delete.png height="42" width="42"></a> 
</td>
</tr>

<%}
}else{
%>	
	<h1>NO Records Found.......</h1>
<% }
%>
</tbody>
</table>
</center>
</form>
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

</body>
</html>