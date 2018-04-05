package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;
import browser_Framework.BrowserFramework;

public class Googleplus extends BrowserCommon {

	private boolean click_menu_Home() {
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Click [Home] button");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		clickOn("pictures\\Website_GooglePlus_menu_Home.png");
		if (waitForObjectPresent("pictures\\Website_GooglePlus_title_Home.png", 5)) {
			setTestcaseStatus("PASSED", "User is redirected to correct [Home] page after clicking on the left menu");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILSE", "User is NOT redirected to correct [Home] page after clicking on the left menu");
			sleep(2);
			return false;
		}
	}
	private boolean click_menu_Discover() {
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Click [Discover] button");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		clickOn("pictures\\Website_GooglePlus_menu_Discover.png");
		if (waitForObjectPresent("pictures\\Website_GooglePlus_title_Discover.png", 5)) {
			setTestcaseStatus("PASSED", "User is redirected to correct [Discover] page after clicking on the left menu");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILSE", "User is NOT redirected to correct [Discover] page after clicking on the left menu");
			sleep(2);
			return false;
		}
	}

	private boolean post_status() {
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Verify that user can post status successfully on Google Plus");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		clickOn("pictures\\Website_Googleplus_TextFiled_postStatus.png");
		sleep (3);
		s.type("Today is a beautiful day") ;
		clickOn("pictures\\Website_GooglePlus_button_Post.png");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Post a status on page");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GooglePlus_text_Status.png", 10)){
			setTestcaseStatus("PASSED",  "User can post status successfully on Google Plus");
			sleep(2);
			return true;
		} else {
			setTestcaseStatus("FAILED",  "User can NOT post status successfully on Google Plus");
			sleep(2);
			return false;
		}
	}
	private boolean edit_status() {
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Verify that user can Edit status successfully on Google Plus");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		hoverImage("pictures\\Website_GooglePlus_text_Status.png");
		sleep(1);
		clickOn("pictures\\Website_GooglePlus_menu_EditPost.png");
		if (waitForObjectPresent("pictures\\Website_GooglePlus_menu_listEditPost.png", 5)) {
			sleep(1);
			TestLogger.info("--------------------------------------------------------------------------------------------");
			TestLogger.info("Edit a status on page");
			TestLogger.info("--------------------------------------------------------------------------------------------");
			clickOn("pictures\\Website_GooglePlus_subMenu_EditPost.png");
			sleep(2);
			s.type("a", Key.CTRL);
			s.type("Today is a bad day");
			clickOn("pictures\\Website_GooglePlus_button_SaveEditPost.png");
			if (waitForObjectPresent("pictures\\Website_GooglePlus_text_StatusEditedOK.png", 5)) {
				setTestcaseStatus("PASSED", "User edited status successfully on Google Plus");
				sleep(2);
				return true;
			} else {
				setTestcaseStatus("FAILED", "User can NOT Edit status successfully on Google Plus");
				sleep(2);
				return false;
			}
		} else {
			setTestcaseStatus("FAILED", "User can NOT open Edit menu on Google Plus");
			return false;
		}
	}
	private boolean delete_status() {
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Verify that user can Delete status successfully on Google Plus");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		hoverImage("pictures\\Website_GooglePlus_text_StatusEditedOK.png");
		sleep(1);
		clickOn("pictures\\Website_GooglePlus_menu_EditPost.png");
		if (waitForObjectPresent("pictures\\Website_GooglePlus_menu_listEditPost.png", 5)) {
			sleep(1);
			TestLogger.info("--------------------------------------------------------------------------------------------");
			TestLogger.info("Choose a post to delete.");
			TestLogger.info("--------------------------------------------------------------------------------------------");
			clickOn("pictures\\Website_GooglePlus_subMenu_DeletePost.png");
			sleep(2);
			clickOn("pictures\\Website_GooglePlus_button_DeletePost.png");
			if (waitforObjectNotexist("pictures\\Website_GooglePlus_text_StatusEditedOK.png", 5)) {
				setTestcaseStatus("PASSED", "User deleted status successfully on Google Plus");
				sleep(2);
				return true;
			} else {
				setTestcaseStatus("FAILED", "User can NOT delelte status successfully on Google Plus");
				sleep(2);
				return false;
			}
		} else {
			setTestcaseStatus("FAILED", "User can NOT open Edit menu on Google Plus");
			sleep(2);
			return false;
		}
	}
		

	@Test
	public void GoogleService_GooglePlus() {
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_Googleplus_01 </br>
		* <b> CaseTitle: </b>Verify that user can access to Google plus page after login on Gmail page without relogin "</br>
		* <b> Steps: </b>
		*	1. Open Google Plus page (https://plus.google.com/?hl=vi)
		*	2. Observe on Google Plus page
		*  EXPECT : 
	  	*	 #2: Must show logo Google + and avatar of user
	  	*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/28
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                            << GoogleServices_Googleplus_01 >>                               |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Verify that user can access to Google plus page after login on Gmail page without relogin ");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		Open_CocCoc_Browser_From_Desktop();
		Delete_User_Account();
		Check_Login_Gmail_Account("coccoc.test003@gmail.com", "browsertest003");
		openLink("https://plus.google.com/?hl=vi");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Observe on Google Plus page");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		sleep(3);
		if (waitForObjectPresent("pictures\\Website_GooglePlus_popup_NotifyGoogle+.png", 5)) {
			clickOn("pictures\\Website_GooglePlus_button_EnbalbeNotify.png");
		}
		sleep(2);
		if (waitForObjectPresent("pictures\\Browser_GooglePlus_popup_DisplayNotify.png", 5)) {
			clickOn("pictures\\Browser_GooglePlus_button_AllowNotification.png");
		}
		sleep(2);
		if (waitForObjectPresent("pictures\\Website_GooglePlus_logo_Google+.png", 5)
				&& waitForObjectPresent("pictures\\Website_Googleplus_menu_profile.png", 5)) {
			setTestcaseStatus("PASSED", "It's showed logo Google + and avatar of user");
		} else {
			setTestcaseStatus("FAILED", "DO NOT show logo Google + and avatar of user");
		}
		sleep(3);
		Check_CCBrowser_available_to_work();
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_Googleplus_02 </br>
		* <b> CaseTitle: </b>Verify that user will be redirect to correct pages after clicking on menus on the left"</br>
		* <b> Steps: </b>
		*	 1. Open Google Plus page (https://plus.google.com/?hl=vi)
		*	 2. Click on menus on the left
		*  EXPECT : 
	  	*	 #2: User must be redirected to correct pages after click on menus 
	  	*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/28
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                            << GoogleServices_Googleplus_02 >>                               |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Verify that user will be redirect to correct pages after clicking on menus on the left ");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		openLink("https://plus.google.com/?hl=vi");
		click_menu_Discover();
		click_menu_Home();
		if (click_menu_Discover() && click_menu_Home()) {
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on the left menu ");
		} else {
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on the left menu");
		}
		sleep(3);
		Check_CCBrowser_available_to_work();
		
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_Googleplus_03&04&05 </br>
		* <b> CaseTitle: </b>Verify that user can post/edit/delete status successfully on Google Plus</br>
		* <b> Steps: </b>
		*	 1. Open Google Plus page (https://plus.google.com/?hl=vi)
		*	 2. Post a status on page
		*	 3. Edit content on that post
		*	 4. Delete that post
		*  EXPECT : 
	  	*	 #2: This status must be posted successflly and show on page right after. 
	  	*	 #3: Must that that content must be updated after editting.
	  	*	 #4: That post must be deleted successfully.
	  	*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/28
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                         << GoogleServices_Googleplus_03&4&5 >>                              |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Verify that user can post/edit/delete status successfully on Google Plus");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		openLink("https://plus.google.com/?hl=vi");
		sleep (15);
		post_status();
		edit_status();
		delete_status();
		
		//Exit browser
		 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		 sleep (2);
		 s.type("q", Key.CTRL + Key.SHIFT);
		 s.type("d", Key.WIN);	
	}	  
	
}
