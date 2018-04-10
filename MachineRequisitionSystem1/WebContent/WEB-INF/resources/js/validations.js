/*
 * Jquery validations for all fields in the form
 */
var check=0; //variable to check for IP or server name

$( document ).ready(function() {
	//hiding initially
	$("#ip_error").hide(); 
	$("#user_error").hide();
	$("#wrong1").hide();
	$("#right1").hide();
	$("#wrong2").hide();
	$("#right2").hide();
	$("#server").hide();
	$("#useriddummy").hide(); //added
	$("#hiddenId").hide();
	//$("#aid").hide();
	
	//selecting the options IP/Server
	$("#option").change(function(){
        var selectedOption = $("#option option:selected").val();
        $('#ip').val('');
        $('#server').val('');
        if(selectedOption == "ip"){
             check=0;
             $("#server").hide();
             $("#ip").show();
             $("#ip_error").hide();
             $("#user_error").hide();
             $('#did').val("");
             $("#wrong1").hide();
         	 $("#right1").hide();
         	 $("#wrong2").hide();
        	 $("#right2").hide();
        	 $("#ip").css("border","1px solid #ddd");
             $("#ipLabel").text("IP address: ");
             $("#ip").prop('disabled', false);
             $("#ip").attr("placeholder", "000.000.000.000");
             $("#ip").focusout(function(){
            	$("#did").val(""); 
            	$("#wrong1").hide(); //added
            	$("#right1").hide(); //added
         		check_ip();
         	});
        } 
        else if(selectedOption == "server"){
             check=1;
             $("#ip").hide();
             $("#server").show();
             $("#ip_error").hide();
             $("#user_error").hide();
             $('#did').val("");
             $("#wrong1").hide();
 			 $("#right1").hide();
 			 $("#wrong2").hide();
			 $("#right2").hide();
			 $("#server").css("border","1px solid #ddd");
             $("#server").prop('disabled', false);
             $("#server").attr("placeholder", "Server name");
             $("#ipLabel").text("Server name: "); 
             $("#server").focusout(function(){
         		$("#did").val("");
         		$("#ip_error").hide();
         		$("#user_error").hide();
         		$("#wrong1").hide();
         		$("#right1").hide();
         		$("#wrong2").hide();
         		$("#right2").hide();
         		populatebyServer();
         		getAdminEmail();
         	});
        }
        else{
             $("#ip").prop('disabled', true);  
        }
    });
	
	//ip format validation 
	function check_ip() {
		if(check==0){
			var pattern = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
			var cip = $("#ip").val();
			if(cip !== ''){
				if (pattern.test(cip)) {
					$("#ip_error").hide();
					$("#wrong1").hide();
					populatebyIP();	
					getAdminEmail();
				} 
				else {
					$("#right1").hide();
					$("#ip_error").html("Please enter valid IP");
					$("#ip_error").css("color","#F90A0A");
					$("#ip_error").show();
					$("#ip").css("border","1px solid #F90A0A");
					$("#wrong1").show();
					$("#wrong1").css("color","#F90A0A");
					error_ip = true;
				}
			}
		}
	}
	
	//date validation
	var from = $( "#fromDate" )
	.datepicker({
	      minDate:0,
	      dateFormat: "yy-mm-dd",
	      changeMonth: true
	})
	.on( "change", function() {
	      to.datepicker( "option", "minDate", getDate( this ) );
	}),
	to = $( "#toDate" ).datepicker({
	      dateFormat: "yy-mm-dd",
	      changeMonth: true
	})
	.on( "change", function() {
	      from.datepicker( "option", "maxDate", getDate( this ) );
	});

	function getDate( element ) {
	      var date;
	      var dateFormat = "yy-mm-dd";
	      try {
	             date = $.datepicker.parseDate( dateFormat, element.value );
	      } 
	      catch( error ) {
	             date = null;
	      }
	      return date;
	}
	
	$("#userid").focusout(function(){
		check_requestorid();
		getAdminEmail();
	});

	//RequestorId Validation
	function check_requestorid(){
		var associateId= $("#userid").val();
		if(associateId!=''){
			$.ajax({
				type:'POST',
				url:'RequestorIDValidation',
				data: {associateId:associateId},
				success:function(response){
					$("#useriddummy").val(response);
					if($('#useriddummy').val()=="true"){ 
						$("#user_error").hide();
						$("#wrong2").hide();
						$("#right2").css("color","#1aa34a");
						$("#userid").css("border","1px solid #1aa34a");
						$("#right2").show();
					}
					else{
						$("#right2").hide();
						$("#user_error").html("Please enter correct Requestor ID");
						$("#user_error").css("color","#F90A0A");
						$("#user_error").show();
						$("#wrong2").css("color","#F90A0A");
						$("#wrong2").show();
						$("#userid").css("border","1px solid #F90A0A");
						}
				},
				error:function(response){
					alert("Error");
				}
			});
		}	
	}
	
	//Auto populate division name by IP Address
	function populatebyIP(){
		var credentialvalue= $("#ip").val();
		if(credentialvalue!=''){
			$.ajax({
				type:'POST',
				url:'credentialbyIP',
				data: {credentialvalue:credentialvalue},
				success:function(response){
					$('#did').val(response);
					$('#hiddenId').attr("value",response); //hidden
					if($('#did').val()!="Invalid IP Address"){
						$("#right1").css("color","#1aa34a");
						$("#ip").css("border","1px solid #1aa34a");
						$("#right1").show();
						getAdminEmail()
					}
					else {
						$('#did').val("");
						$("#ip_error").html("Please type correct IP address");
						$("#ip_error").css("color","#F90A0A");
						$("#ip_error").show();
						$("#wrong1").css("color","#F90A0A");
						$("#wrong1").show();
						$("#ip").css("border","1px solid #F90A0A");
					}
				},
				error:function(response){
					alert("Cannot autopopulate Division Name");
				}
			});
		}
	}

	//Auto populate division name by Server Name
	function populatebyServer(){
		var credentialvalue= $("#server").val();
		if(credentialvalue!=''){
			$.ajax({
				type:'POST',
				url:'credentialbyServer',
				data: {credentialvalue:credentialvalue},
				success:function(response){
					$('#did').val(response);
					$('#hiddenId').attr("value",response); //hidden
					if($('#did').val()!="Invalid Server Name"){
						$("#right1").show();
						$("#right1").css("color","#1aa34a");
						$("#server").css("border","1px solid #1aa34a");
						getAdminEmail()
					}
					else{
						$('#did').val("");
						$("#ip_error").html("Invalid server name ");
						$("#ip_error").css("color","#F90A0A");
						$("#ip_error").show();
						$("#wrong1").show();
						$("#server").css("border","1px solid #F90A0A");
						$("#wrong1").css("color","#F90A0A");
					}
				},
				error:function(response){
					alert("Cannot autopopulate Division Name");
				}
			});
		}
	}
	//Admin Email
	
});

//ip key restriction
function isIp(evt){
	if(check==0){
		var charCode = (evt.which) ? evt.which : event.keyCode;
		if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)){       
			$("#ip_error").html("Please type proper IP");
			$("#ip_error").css("color","#F90A0A");
			$("#ip_error").show();                 
			return false;
		}
		else{
			$("#ip_error").hide();
			return true;
		}
	}
}

//reset all error messages and icons
function reset_all(){
	$("#ip_error").hide();
	$("#ip").css("border","1px solid #ddd");
	$("#server").css("border","1px solid #ddd");
	$("#userid").css("border","1px solid #ddd");
	$("#user_error").hide();
	$("#wrong1").hide();
	$("#right1").hide();
	$("#wrong2").hide();
	$("#right2").hide();
	$("#myModal").hide();
}
function getAdminEmail(){
	var divName=$('#hiddenId').val();
	if(divName!=''){
		$.ajax({
			type:'POST',
			url:'getAdminMail',
			data: {divName:divName},
			success:function(response){
				$('#aid').val(response);
				$("#hiddenId").hide();
				//$("#aid").hide();
			},
			error:function(response){
				alert("Cannot autopopulate Admin Email");
				//$("#myModal").show();
			}
		});
	}
}