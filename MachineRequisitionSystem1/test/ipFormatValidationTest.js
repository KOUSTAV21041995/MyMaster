describe("IP Format Validation", function() {
	it("should be Successful 1", function() {
		expect(check_ip("1.1.1.1")).toBeTruthy();
	});
	it("should be Successful 2", function() {
		expect(check_ip("1111")).toBeFalsy();
	});
	it("should be Successful 3", function() {
		expect(check_ip("123.123.123.123")).toBeTruthy();
	});
	it("should be Successful 4", function() {
		expect(check_ip("12.123.1.123")).toBeTruthy();
	});
	it("should be Successful 5", function() {
		expect(check_ip("123.1234.1.0")).toBeFalsy();
	});
	it("should be Successful 6", function() {
		expect(check_ip(".123.1.0")).toBeFalsy();
	});
	it("should be Successful 7", function() {
		expect(check_ip("1,1,1,1")).toBeFalsy();
	});
	it("should be Successful 8", function() {
		expect(check_ip("@cmnv55")).toBeFalsy();
	});
	it("should be Successful 9", function() {
		expect(check_ip("1-2-3-4")).toBeFalsy();
	});
	it("should be Successful 10", function() {
		expect(check_ip("0.0.0.0")).toBeTruthy();
	});
});