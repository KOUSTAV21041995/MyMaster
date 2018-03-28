<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Machine Requisition Module</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapmincss"/>
		<spring:url value="/resources/css/bootstrap-theme.min.css" var="bootstraptheme"/>
		<spring:url value="/resources/css/formstyle.css" var="formstyle"/>
		<spring:url value="/resources/js/jquery.min.js" var="jqueryminjs"/>
		<spring:url value="/resources/js/validations.js" var="Val"/>
		<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapminjs"/>
		<spring:url value="/resources/images/Cerner_logo.png" var="logo"/>
		<spring:url value="/resources/css/jquery-ui.css" var="jqueryuiCss"/>
		<spring:url value="/resources/js/jquery-ui.js" var="jqueryUi"/>
		
  
		<link href="${bootstrapmincss}" rel="stylesheet" />
		<link href="${bootstraptheme}" rel="stylesheet" />
		<link href="${formstyle}" rel="stylesheet" />
		<script src="${jqueryminjs}"></script>
		<script src="${Val}"></script>
		<script src="${bootstrapminjs}"></script>
		<link href="${jqueryuiCss}" rel="stylesheet" />
		<script src="${jqueryUi}"></script>
		               
	</head>

	<body background='<spring:url value="/resources/images/bgimage.jpg"></spring:url>'>
		<div class="container" >
			<legend id="title"> Machine Requisition Request</legend>
  
			<form class="form-horizontal form-style background-format" method="post" name="form1" action="mail">
				<img src="${logo}" class="img-responsive " >     
				<table class="table" >
					<tr>
						<td id="form-table">
							<label id="detail">Enter the following details</label>
							
							<div class="form-group">
								<label class="control-label col-sm-3" for="option">Select input type</label>
									<div class="col-sm-6">
										<select class="form-control" id="option" required>
											<option value="" selected disabled>Select Option</option>
        									<option value="ip">IP address</option>
        									<option value="server">Server name</option>
      									</select>
	  								</div>
							</div>
							
							<div class="form-group">
      							<label class="control-label col-sm-3" for="ip" id="ipLabel">IP/Server</label>
      							<div class="col-sm-6">
      								<div class="input-group">
      									<span class="input-group-addon">
     		 								<i class="glyphicon glyphicon-modal-window"></i>
      									</span>
        								<input disabled type="text" class="form-control"  onkeypress="return isIp(event)" required name="ip" id="ip" autocomplete="off">
        								<input disabled type="text" class="form-control" required name="server" id="server" autocomplete="off">
										<span class="input-group-addon "  id="wrong1" style="background-color:white;">
											<i class="glyphicon glyphicon-remove-circle" ></i>
										</span>
										<span class="input-group-addon "  id="right1" style=" border:none;">
											<i class="glyphicon glyphicon-ok-circle" ></i>
										</span>
      								</div>
      							</div>
      							<span class="error_form" id="ip_error"></span>
    						</div>
	
							<div class="form-group">
      							<label class="control-label col-sm-3" for="userid">Requestor ID</label>
      							<div class="col-sm-6">
      								<div class="input-group">
      									<span class="input-group-addon">
      										<i class="glyphicon glyphicon-user"></i>
      									</span>
        								<input type="text" class="form-control" placeholder="XY123456" required name="associd" id="userid" autocomplete="off">
	  									<input type="text" id="useriddummy">
	  									<span class="input-group-addon " id="wrong2" style="background-color:white;">
        									<i class="glyphicon glyphicon-remove-circle" ></i>
        								</span>
										<span class="input-group-addon " id="right2" style=" border:none;">
											<i class="glyphicon glyphicon-ok-circle" ></i>
										</span>
	  								</div>
	  							</div>
	  							<span class="error_form" id="user_error"></span>
    						</div>
	
							<div class="form-group">
     							<label class="control-label col-sm-3" for="fromDate">Start Date:</label>
      							<div class="col-sm-6">
      								<div class="input-group">
      									<span class="input-group-addon">
      										<i class="glyphicon glyphicon-calendar"></i>
      									</span>
        								<input type="text" class="form-control" required name="fromDate" id="fromDate" autocomplete="off">
      								</div>
      							</div>
    						</div>
	
							<div class="form-group">
      							<label class="control-label col-sm-3" for="toDate">End Date:</label>
     							<div class="col-sm-6">
     								<div class="input-group">
      									<span class="input-group-addon">
      										<i class="glyphicon glyphicon-calendar"></i>
      									</span>
        								<input type="text" class="form-control" required name="toDate" id="toDate" autocomplete="off">
      								</div>
      							</div>
    						</div>
    						<div class="form-group">
                              <label class="control-label col-sm-3" for="did">Division Name:</label>
                              <div class="col-sm-6">
                              <div class="input-group">
                              <span class="input-group-addon">
                              <i class="glyphicon glyphicon-user"></i>
                              </span>
                          <input type="text" class="form-control" id="did"  required name="did" disabled>
                          <input type="text" name="" id="hiddenId" value="">
                          <input type="text" name="aid" id="aid" value="" />
                          </div>
                      </div>
                    </div>
	
    						<div class="form-group">        
      							<div class="col-sm-offset-4 col-sm-12">
        							<input type="reset" class="btn btn-primary" value="Reset" onclick="reset_all()">&nbsp;&nbsp;&nbsp;
									<input type="submit" class="btn btn-success" value="Request" >
      							</div>
    						</div>
  						</td>
  						<td>
							<Label class="notes" >Note</Label>
							<ul class="notepoints">
								<li >You can request only one machine at a time</li>
								<li >Your request can be accepted or rejected based on the division and the tenure of machine requisition request</li>
							</ul>
  						</td>
  					</tr>
  				</table>
  			</form>
		</div>
	</body>
</html>
