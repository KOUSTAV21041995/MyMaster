package com.cerner.MachineRequisition.Email;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	new FileDataSource(
		//		"C:\\Users\\kg056519\\Desktop\\SlantWithLogo.png");
		//Paths.get("resources/images/SlantWithLogo.png");
		
		
		System.out.println(new File("../MachineRequisitionSystem1/WebContent/WEB-INF/resources/images/SlantWithLogo.png").exists());
	
		DataSource fds = new FileDataSource(new File("../MachineRequisitionSystem1/WebContent/WEB-INF/resources/images/SlantWithLogo.png"));
		System.out.println(fds.getName());
	}

}
