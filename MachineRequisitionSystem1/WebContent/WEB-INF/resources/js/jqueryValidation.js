var check=0;
$( document ).ready(function() {
	
	$("#ip_error").hide();
	$("#user_error").hide();
	$("#wrong1").hide();
	$("#right1").hide();
	$("#wrong2").hide();
	$("#right2").hide();
	
	var error_ip = false;
	var error_user = false;
	
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
	
	//Selecting IP or Server
	$("#option").change(function(){
        var selectedOption = $("#option option:selected").val();
        $('#ip').val('');
        if(selectedOption == "ip"){
        	check=0;
        	$("#ipLabel").text("IP address: ");
        	$("#ip").prop('disabled', false);
        	$("#ip").attr("placeholder", "000.000.000.000");
        	$("#ip").focusout(function(){
        		check_ip();
        	});
    	} 
        else if(selectedOption == "server"){
        	check=1;
        	$("#ip_error").hide();
			$("#wrong1").hide();
			$("#right1").hide();
			$("#ip").css("border","1px solid #ddd");
        	$("#ip").prop('disabled', false);
        	$("#ip").attr("placeholder", "Server name");
        	$("#ipLabel").text("Server name: "); 
        }
        else{
        	$("#ip").prop('disabled', true);
        	
        }
    });
	
	$("#userid").focusout(function(){
		check_userid();
		});
	
	//RequestorId Validation
	function check_userid(){
		var userId = $("#userid").val();
		
			if(userId.length!=0){
					if(userId.length==8)
					{
						if(userId.substring(0,2).match(/^[A-Za-z]+$/) && (userId.substring(2)).match(/^[0-9]+$/)){
							$("#user_error").hide();
							$("#userid").css("border","1px solid #1aa34a");
							$("#wrong2").hide();
							$("#right2").show();
							$("#right2").css("color","#1aa34a");
						} else{		
							$("#right2").hide();
							$("#user_error").html("Please enter valid userId");
							$("#user_error").css("color","#F90A0A");
							$("#user_error").show();
							$("#userid").css("border","1px solid #F90A0A");
							$("#wrong2").show();
							$("#wrong2").css("color","#F90A0A");
							error_user = true;

						}
					}
					else{		
							$("#user_error").html("Please enter valid userId");
							$("#user_error").css("color","#F90A0A");
							$("#user_error").show();
							$("#right2").hide();
							$("#wrong2").css("color","#F90A0A");
							$("#wrong2").show();
							$("#userid").css("border","1px solid #F90A0A");
							error_user = true;
						}
				}	
			}
	
	//ip validation 
	function check_ip() {
		if(check==0){
			var pattern = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
			var cip = $("#ip").val();
			if(cip !== ''){
				if (pattern.test(cip)) {
					$("#ip_error").hide();
					$("#wrong1").hide();
					$("#right1").show();
					$("#right1").css("color","#1aa34a");
					$("#ip").css("border","1px solid #1aa34a");
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

//reset all
function reset_all(){
	$("#ip_error").hide();
	$("#ip").css("border","1px solid #ddd");
	$("#userid").css("border","1px solid #ddd");
	$("#user_error").hide();
	$("#wrong1").hide();
	$("#right1").hide();
	$("#wrong2").hide();
	$("#right2").hide();
}