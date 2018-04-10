<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Machine Requisition Module</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapmincss" />
<spring:url value="/resources/css/bootstrap-theme.min.css"
	var="bootstraptheme" />
<spring:url value="/resources/css/formstyle.css" var="formstyle" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryminjs" />
<spring:url value="/resources/js/validations.js" var="Val" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapminjs" />
<spring:url value="/resources/images/Cerner_logo.png" var="logo" />
<spring:url value="/resources/images/success.png" var="success" />
<spring:url value="/resources/css/jquery-ui.css" var="jqueryuiCss" />
<spring:url value="/resources/js/jquery-ui.js" var="jqueryUi" />


<link href="${bootstrapmincss}" rel="stylesheet" />
<link href="${bootstraptheme}" rel="stylesheet" />
<link href="${formstyle}" rel="stylesheet" />
<script src="${jqueryminjs}"></script>
<script src="${Val}"></script>
<script src="${bootstrapminjs}"></script>
<link href="${jqueryuiCss}" rel="stylesheet" />
<script src="${jqueryUi}"></script>



<style type="text/css">
#confirmationNote1{
	text-align: center;
	font-size: xx-large;
	vertical-align: middle;
	font-weight: bolder;
	background-color: white;
	color: #15317E;
}
#confirmationNote2{
	text-align: center;
	font-size: large;
	vertical-align: middle;
	font-weight:normal;
	background-color: white;
	color: #1569C7;
}
#confirmationNote3{
	text-align: center;
	font-size: medium;
	vertical-align: middle;
	font-weight:normal;
	
}

</style>

</head>

<body
	background='<spring:url value="/resources/images/bgimage.jpg"></spring:url>'>
	<div class="container">
		<legend id="title"> Machine Requisition Request</legend>

		<form class="form-horizontal form-style background-format"
			 name="form1" action="backToRequest">
			<img src="${logo}" class="img-responsive ">
			<table border="0">
				<tbody>
					<tr>
						<td id="confirmationNote1" height="160px">Your request has been successfully submitted</td>
					</tr>
					
					<tr>
						<td id="confirmationNote2" height="80px">Please check your email for detailed notification</td>
					</tr>
					<tr>
						<td id="confirmationNote3" height="60px">for more request click here...<input type="submit" value="<< back to request page" class="btn btn-primary"/></td>
					</tr>
				</tbody>
				
			</table>
		</form>
	</div>
</body>
</html>
