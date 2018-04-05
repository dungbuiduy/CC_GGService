package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleDrive extends BrowserCommon {
	
	private boolean Click_Menu_Computers() {
		//Click on option [Computer]
		clickOn("pictures\\Website_GoogleDrive_menu_ComputersVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_ComputersVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Computers page after click on [Computers] button on the left menu");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILED", "Do NOT Show Commputers page after click on [Computers] button on the left menu");
			sleep(2);
			return false;
		}
	}
	private boolean Click_Menu_SharedWithMe() {
		//Click on option [Shared with me]
		clickOn("pictures\\Website_GoogleDrive_menu_SharedWithMeVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_SharedWithMeVN.png", 5)){
			setTestcaseStatus("PASSED", "Showed Shared with me page after click on [Shared with me] button on the left menu");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Shared with me page after click on [Shared with me] button on the left menu");
			sleep(2);
			return false;
		}
	}
	private boolean Click_Menu_Recent() {
		//Click on option [Recent]
		clickOn("pictures\\Website_GoogleDrive_menu_RecentVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_RecentVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Recent page after click on [Recent] button on the left menu");
			sleep(2);
			return true;
			
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Recent page after click on [Recent] button on the left menu");
			sleep(2);
			return false;
		}
		
	}
	private boolean Click_Menu_Starred() {
		//Click on option [Starred]
		clickOn("pictures\\Website_GoogleDrive_menu_StarredVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_StarredVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Starred page after click on [Start] button on the left menu");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Starred page after click on");
			sleep(2);
			return false;
		}
	}
	private boolean Click_Menu_Trash() {
		//Click on option [Trash]
		clickOn("pictures\\Website_GoogleDrive_menu_TrashVN.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_TrashVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed Trash page after click on [Trash] button on the left menu");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILED", "Do NOT show Trash page after click on [Trash] button on the left menu");
			sleep(2);
			return false;
		}
	}
	
	private boolean Upload_File_To_Drive() {
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Click [New] button to Upload File");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		clickOn("pictures\\Website_GoogleDrive_button_CreateNewVN.png");
		sleep(2);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Choose file to Upload");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		sleep(1);
		s.type("C:");
		s.type(Key.ENTER);
		sleep(1);
		s.type("GoogleDriveData");
		s.type(Key.ENTER);
		sleep(1);
		s.type("GoogleDrive_UploadFile.jpg");
		s.type(Key.ENTER);
		sleep(10);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("EXPECT: File must be uploaded successfully");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_thumbnail_UploadFileOK.png", 20) 
				&& waitForObjectPresent("pictures\\Website_GoogleDrive_popup_UploadFileOK.png", 20) ) {
			setTestcaseStatus("PASSED", "File is uploaded successfully");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILED", "File is NOT uploaded successfully");
			sleep(2);
			return false;
		}
	}
	private boolean Edit_File_On_Drive() {
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Choose file uploaded to edit");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		rightClick("pictures\\Website_GoogleDrive_thumbnail_UploadFileOK.png");
		waitForObjectPresent("pictures\\Website_GoogleDrive_menu_ContextMenuFile.png", 3);
		clickOn("pictures\\Website_GoogleDrive_menuSub_Rename.png");
		sleep(5);
		s.type("GG_Rename");
		s.type(Key.ENTER);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("EXPECT: Content and title of File must be changed successfully  ");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_thumbnail_RenameFile.png", 5)) {
			setTestcaseStatus("PASSED", "Content and title of File is changed successfully");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILED", "Content and title of File is NOT changed successfully");
			sleep(2);
			return false;
		}
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
		Open_CocCoc_Browser_From_Desktop();
		Check_Login_Gmail_Account("coccoc.test003@gmail.com", "browsertest003");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("1. Open Google Driver page (https://www.google.com/drive/)");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		openLink("https://www.google.com/drive/");
		if (waitForObjectPresent("pictures\\Browser_Translate_popup_TranslatePageEN.png", 5)) {
			clickOn("pictures\\Browser_Translate_button_NopeEN.png");
		}
		
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2. Observe on Google Driver page");
		TestLogger.info("#2: Must show logo Google Drive and Button [Go to Google Drive]");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_logo_GoogleDrive.png", 5) 
				&& waitForObjectPresent("pictures\\Website_GoogleDrive_Button_AccessToGoogleDriveEN.png", 5)) {
			sleep(2);
			setTestcaseStatus("PASSED", "Showed logo Google Drive and Button 'Go to Google Drive");
		} else {
			sleep(2);
			setTestcaseStatus("FAILED", "DO NOT Show logo Google Drive and Button [Go to Google Drive]"); 
		}
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep(2);
		Check_CCBrowser_available_to_work();
		
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
		clickOn("pictures\\Website_GoogleDrive_Button_AccessToGoogleDriveEN.png");
		sleep(2);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2. Click on options on the left menu");
		TestLogger.info("#2 : Must show correct pages after clicking on the options on the menu ");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_menu_MyDriveVN.png", 5)) {
			setTestcaseStatus("PASSED", "Showed My Drive page on left menu");			
			sleep(2);
		} else {
			setTestcaseStatus("FAILED", "Do NOT show My Drive page on left menu");
			sleep(2);
		}
		Click_Menu_SharedWithMe();
		Click_Menu_Recent();
		Click_Menu_Starred();
		Click_Menu_Trash();
		Click_Menu_Computers();
		
		//Check if all option is redirected exactly to page
		if (Click_Menu_Computers()
				&& Click_Menu_Recent()
				&& Click_Menu_SharedWithMe()
				&& Click_Menu_Starred()
				&& Click_Menu_Trash()) {
			setTestcaseStatus("PASSED", "All option on left menu is showed exactly to page");
			
		} else {
			setTestcaseStatus("FAILED", "Do NOT show correct pages after click on the left menu");
			
		}
		sleep(2);
		Check_CCBrowser_available_to_work();
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
		Upload_File_To_Drive();
		Edit_File_On_Drive();
		sleep(2);
		s.type(Key.ENTER);
		s.type("q", Key.CTRL + Key.SHIFT);
		s.type("q", Key.WIN);
		   
	} 	

}
