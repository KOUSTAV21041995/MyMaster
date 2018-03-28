describe("IP key restriction",function (){            
    //test 1
    it(". is a valid key",function (){   
		expect(isIp(46)).toBeTruthy();    
	}); 
              
	//test 2
	it("All numbers are valid keys",function (){  
		for (var i = 48; i < 58; i++){ 
			expect(isIp(i)).toBeTruthy(); 
		}               
	});  

	//test3
	it("Special character is not a valid key",function (){ 
		for (var i = 32; i < 48 && i!=46; i++){    
			expect(isIp(i)).toBeFalsy(); 
		}               
	}); 
   
	//test4
	it("Remaining invalid special characters",function (){  
		for (var i = 58; i < 127; i++){ 
			expect(isIp(i)).toBeFalsy();
		}               
	});
});
