package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleDrive extends BrowserCommon {
	private boolean googledriveFlag = false;
	
	@BeforeMethod
	public void GoogleService_GoogleDrive_LoginGmail ()
	{
		s.type("d", Key.WIN);
		sleep(2);
		s.type(Key.F5);
		
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
	    else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Open [http://google.com.vn]");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		openLink("https://www.google.com.vn");
		if (waitForObjectPresent("pictures\\Website_Google_button_LoginGoogleVN.png", 5)) {
			clickOn("pictures\\Website_Google_button_LoginGoogleVN.png");
			sleep(2);
			waitForObjectPresent("pictures\\Website_AccountGoogle_textLoginGoogleAcc.png", 5);
			s.type("coccoc.test001@gmail.com");
			sleep(1);
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\Website_AccountGoogle_textInputPassword.png", 5);
			s.type("browsertest001");
			sleep(1);
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\Website_AccountGoogle_logoAvatarAccount.png", 5);
			TestLogger.info("--------------------------------------------------------------------------------------------");
			TestLogger.info("Login Google Account successfully");
			TestLogger.info("--------------------------------------------------------------------------------------------");
		}
		sleep(2);
		waitForObjectPresent("pictures\\Website_AccountGoogle_logoAvatarAccount.png", 5);
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Google Account had logged-in successfully before");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		
	}
	
	@Test
	public void GoogleServices_GoogleDrive()
	{
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_GoogleDrive_01</br>
		* <b> CaseTitle: </b>Verify that user can access to Google Drive page after login on Gmail page without relogin</br>
		* <b> Steps: </b>
		* 		1. Open Google Driver page (https://www.google.com/drive/) 
		* 		2. Observe on Google Driver page
		*  EXPECT : 
		*		#2: Must show logo Google Drive and Button "Go to Google Drive"    
		*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/16
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                           << GoogleServices_GoogleDrive_01 >>                               |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("1. Open Google Driver page (https://www.google.com/drive/)");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		openLink("https://www.google.com/drive/");
		
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2. Observe on Google Driver page");
		TestLogger.info("#2: Must show logo Google Drive and Button [Go to Google Drive]");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_logo_GoogleDrive.png", 5) && waitForObjectPresent("pictures\\Website_GoogleDrive_Button_AccessToGoogleDriveVN.png", 5)) {
			sleep(2);
			setTestcaseStatus("PASSED", "Showed logo Google Drive and Button 'Go to Google Drive");
		} else {
			sleep(2);
			setTestcaseStatus("FAILED", "DO NOT Show logo Google Drive and Button [Go to Google Drive]"); 
		}
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep(2);
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_GoogleDrive_02</br>
		* <b> CaseTitle: </b>Verify that user can see correcs pages  click on Options on My Drive page</br>
		* <b> Steps: </b>
		* 		1. Access on Google Drive page :  https://drive.google.com/drive/my-drive  
		* 		2. Click on options on the left menu
		*  EXPECT : 
		*		#2 : Must show correct pages after clicking on the options on the menu.  
		*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/16
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                           << GoogleServices_GoogleDrive_02 >>                               |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("1. Access on Google Drive page :  https://drive.google.com/drive/my-drive ");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		clickOn("pictures\\Website_GoogleDrive_Button_AccessToGoogleDriveVN.png");
		sleep(2);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2. Click on options on the left menu");
		TestLogger.info("#2 : Must show correct pages after clicking on the options on the menu ");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_menu_MyDriveVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed My Drive page on left menu");
			googledriveFlag = true;
			sleep(2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT show My Drive page on left menu");
			sleep(2);
		}
		
		//Click on option [Computer]
		clickOn("pictures\\Website_GoogleDrive_menu_ComputersVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_ComputersVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Computers page after click on [Computers] button on the left menu");
			googledriveFlag = true;
			sleep(2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT Show Commputers page after click on [Computers] button on the left menu");
			sleep(2);
		}
		
		//Click on option [Shared with me]
		clickOn("pictures\\Website_GoogleDrive_menu_SharedWithMeVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_SharedWithMeVN.png", 5)){
			setTestcaseStatus("PASSED", "Showed Shared with me page after click on [Shared with me] button on the left menu");
			googledriveFlag = true;
			sleep (2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Shared with me page after click on [Shared with me] button on the left menu");
			sleep(2);
		}
		
		//Click on option [Recent]
		clickOn("pictures\\Website_GoogleDrive_menu_RecentVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_RecentVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Recent page after click on [Recent] button on the left menu");
			googledriveFlag = true;
			sleep(2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Recent page after click on [Recent] button on the left menu");
			sleep(2);
		}
		
		//Click on option [Starred]
		clickOn("pictures\\Website_GoogleDrive_menu_StarredVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_StarredVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Starred page after click on [Start] button on the left menu");
			googledriveFlag = true;
			sleep(2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Starred page after click on");
			sleep(2);
		}
		
		//Click on option [Trash]
		clickOn("pictures\\Website_GoogleDrive_menu_TrashVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_TrashVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Trash page after click on [Trash] button on the left menu");
			googledriveFlag = true;
			sleep(2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Trash page after click on [Trash] button on the left menu");
			sleep(2);
		}
		
		//Check if all option is redirected exactly to page
		if (googledriveFlag == true) {
			setTestcaseStatus("PASSED", "All option on left menu is showed exactly to page");
			sleep(2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT show correct pages after click on the left menu");
			sleep(2);
		}
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_GoogleDrive_03&4</br>
		* <b> CaseTitle: </b>Verify that Function "Upload/Edit file" works correctly</br>
		* <b> Steps: </b>
		* 		1. Access page: https://drive.google.com/drive/my-drive 
		*		2. Click on New Button
		*		3. Choose Upload file
		*		4. Choose a file to upload
		*		5. Choose a file to edit
		*		6. Add or change title of file
		*  EXPECT: 
		*		#4: File must be uploaded successfully
		*		#6: Content and title of File must be changed successfully   
		*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/16
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                           << GoogleServices_GoogleDrive_03&4 >>                               |");
		TestLogger.info("===============================================================================================");
		clickOn("pictures\\Website_GoogleDrive_menu_MyDriveVN.png");
		sleep(2);
		waitForObjectPresent("pictures\\Website_GoogleDrive_text_MyDriveVN.png", 5);
		sleep(2);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Click [New] button to Upload File");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		clickOn("pictures\\Website_GoogleDrive_button_CreateNewVN.png");
		sleep(2);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		s.type("C:");
		sleep(1);
		s.type("GoogleDriveData");
		sleep(1);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Choose file to Upload");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		s.type("GoogleDrive_UploadFile.jpg");
		sleep(1);
		s.type(Key.ENTER);
		sleep(10);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_thumbnail_UploadFileOK.png", 20) 
				&& waitForObjectPresent("pictures\\Website_GoogleDrive_popup_UploadFileOK.png", 20) ) {
			
		}
		   
		   
		   
		   
	} 
	
	
/*	@Test
	public void GoogleServices_GoogleDrive_02()
	{
		TestLogger.info("1. Access on Google Drive page :  https://drive.google.com/drive/my-drive"); 
		startCocCoc();
		openLink("https://drive.google.com/drive/my-drive"); 
		TestLogger.info("2. Click on options on the left menu ");
		TestLogger.info("Expect :  Must show correct pages after clicking on the options on the menu.");
		clickOn("pictures\\Website_GoogleDrive_menu_MyDrive.png");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_MyDrive.png", 5))
		{
		
			setTestcaseStatus("PASSED", "Showed My Drive page after click on My Driver option"); 
			
		}
		else
		{
			
			setTestcaseStatus("PASSED", "Do NOT Show My Drive page after click on My Driver option"); 
		}
		
		// Click on options Computer 
		clickOn("pictures\\Website_GoogleDrive_menu_Computers.png");
		 
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_computer.png", 5))
		{
			setTestcaseStatus("PASSED", "Showed Computers page after click on Computers option"); 
			
		}
		else
		{
			setTestcaseStatus("PASSED", "Do NOT Show Computers page after click on Computers option"); 
		}
		
		// Click on options Shared with me 
		  clickOn("pictures\\Website_GoogleDrive_menu_SharedWihMe.png");
		 if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_SharedWithMe.png", 5))
		{
				setTestcaseStatus("PASSED", "Showed Shared With Me page after click on Shared with Me option"); 
				
		}
		 else
		{
				setTestcaseStatus("PASSED", "Do NOT Shared with me page after click on Shared with Me option"); 
		}
		 
		 //exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
		 
		
	}
	
	@Test
	public void GoogleServices_GoogleDrive_03()
	{
		
		TestLogger.info("1. Access page : https://drive.google.com/drive/my-drive ");
		startCocCocInEnglish();
		openLink("https://drive.google.com/drive/my-drive ");
		sleep (20);
		TestLogger.info("2. Click on New Button");
		clickOn("pictures\\Website_GoogleDrive_Button_New.png");
		TestLogger.info("3. Choose Upload file");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_button_uploadFile.png", 2))
		{
		clickOn("pictures\\Website_GoogleDrive_button_uploadFile.png");
		}
		else
		{
			clickOn("pictures\\Website_GoogleDrive_button_uploadFileEN.png");
		}
		
		TestLogger.info("4. Choose a file to upload");
		
		clickOn("pictures\\Website_GoogleDrive_folfer_Downloads.png");
		s.type(Key.TAB);
		s.type(Key.TAB);	
		sleep(5);
		s.type("coccoc_vi.exe");
		s.type(Key.ENTER);
		s.type(Key.ENTER);
		TestLogger.info("Expect : File must be uploaded successfully ");
		sleep(120);
		
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_Button_OK.png", 15))
		{
			 //exit browser
			closeBrowser();
			if (waitForObjectPresent("pictures\\Website_GoogleDrive_Button_Leave.png", 5))
			{
			clickOn("pictures\\Website_GoogleDrive_Button_Leave.png");
			}
			
			setTestcaseStatus("PASSED", "File is uploaded successfully");
		}
		else
		{
			 //exit browser
			closeBrowser();
			setTestcaseStatus("FAILED", "File is NOT uploaded successfully");
		}
			
	}
	
	@Test
	public void GoogleServices_GoogleDrive_04()
	{
		
		TestLogger.info("1. Access page : https://drive.google.com/drive/my-drive ");
		startCocCocInEnglish();
		openLink(" https://drive.google.com/drive/my-drive");
		sleep (25);
		TestLogger.info("2. Choose an file to edit");
		clickOn("pictures\\Website_GoogleDrive_file_coccoc_vi.png");
		s.type(Key.CONTEXT);
		TestLogger.info("3. Add or change title of file ");
		clickOn("pictures\\Website_GoogleDrive_Submenu_Rename.png");
		sleep (5);
		s.type("coccoc");
		s.type(Key.ENTER);
		TestLogger.info("Expect :  Content and title of File must be changed successfully");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_File_Coccoc.png", 4))
		{
			clickOn("pictures\\Website_GoogleDrive_File_Coccoc.png");
			s.type(Key.CONTEXT);
			clickOn("pictures\\Website_GoogleDrive_submenu_Remove.png");
			setTestcaseStatus("PASSED", "Content and title of File is changed successfully");
		}
		else
		{
			setTestcaseStatus("FAILED", "Content and title of File is NOT changed successfully");
		}
			
		
	}*/
	

}
