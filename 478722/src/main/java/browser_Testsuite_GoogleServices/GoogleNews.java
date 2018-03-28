package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleNews extends BrowserCommon {
	private boolean clickTopStoriesFlag;
	private boolean clickWorldFlag;
	private boolean clickVietnameseFlag;
	private boolean clickBusinessFlag;
	private boolean clickEntertaimentFlag;
	private boolean clickSportsFlag;
		
	private void Click_Menu_TopStories() {
		clickOn("pictures\\Website_GoogleNews_menu_TopStoriesNewsVN.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_title_TopStoriesNewsVN.png", 5)) {
			clickTopStoriesFlag = true;
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on [Top Stories] option on the left menu");
		} else {
			clickTopStoriesFlag = false;
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on [Top Stories] option on the left menu");
		}
		sleep(2);
	}
	private void Click_Menu_World() {
		clickOn("pictures\\Website_GoogleNews_menu_WorldNewsVN.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_title_WorldNewsVN.png", 5)) {
			clickWorldFlag = true;
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on [World] option on the left menu");
		} else {
			clickWorldFlag = false;
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on [World] option on the left menu");
		}
		sleep(2);
	}
	private void Click_Menu_Vietnamese() {
		clickOn("pictures\\Website_GoogleNews_menu_VietnameseNewsVN.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_title_VietnameseNewsVN.png", 5)) {
			clickVietnameseFlag = true;
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on [Vietnamese] option on the left menu");
		} else {
			clickVietnameseFlag = false;
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on [Vietnamese] option on the left menu");
		}
		sleep(2);
	}
	private void Click_Menu_Business() {
		clickOn("pictures\\Website_GoogleNews_menu_BusinessNewsVN.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_title_BusinessNewsVN.png", 5)) {
			clickBusinessFlag = true;
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on [Business] option on the left menu");
		} else {
			clickBusinessFlag = false;
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on [Business] option on the left menu");
		}
		sleep(2);
	}
	private void Click_Menu_Entertaiment() {
		clickOn("pictures\\Website_GoogleNews_menu_EntertaimentNewsVN.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_title_EntertaimentNewsVN.png", 5)) {
			clickEntertaimentFlag = true;
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on [Entertaiment] option on the left menu");
		} else {
			clickEntertaimentFlag = false;
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on [Entertaiment] option on the left menu");
		}
		sleep(2);
	}
	private void Click_Menu_Sports() {
		clickOn("pictures\\Website_GoogleNews_menu_SportsNewsVN.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_title_SportsNewsVN.png", 5)) {
			clickSportsFlag = true;
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on [Sports] option on the left menu");
		} else {
			clickSportsFlag = false;
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on [Sports] option on the left menu");
		}
		sleep(2);
	}
	
	@Test
	public void GoogleService_GoogleNews() {
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_GoogleNews_01 </br>
		* <b> CaseTitle: </b>Verify that user can access to Google News page after login on Gmail page without relogin "</br>
		* <b> Steps: </b>
		* 		1. Open Google News page (https://news.google.com/news/?ned=us&hl=eni)
		* 		2. Observe on Google News page
		*  EXPECT : 
	  	*	 #2: Must show logo Google News and avatar of user
	  	*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/26
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                            << GoogleServices_GoogleNews_01 >>                               |");
		TestLogger.info("===============================================================================================");
		Open_CocCoc_Browser_From_Desktop();
		Check_Login_Gmail_Account("coccoc.test003@gmail.com", "browsertest003");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Open Google News page [https://news.google.com/news/headlines?ned=vi_vn&hl=vi&gl=VN]");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		openLink("https://news.google.com/news/headlines?ned=vi_vn&hl=vi&gl=VN");
		
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Observe on Google News page");
		TestLogger.info("EXPECT: Must show logo Google News and avatar of user");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_title_GoogleNews.png", 5) 
				&& waitForObjectPresent("pictures\\Website_GoogleAcc_avatar_AccountGoogle.png", 5)) {
			setTestcaseStatus("PASSED", "It's show logo Google News and Avatar of user");
		} else {
			setTestcaseStatus("FAILED", "It not show logo Google News and Avatar of user");
		}
		sleep(3);
		Check_CCBrowser_available_to_work();
		
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_GoogleNews_02 </br>
		* <b> CaseTitle: </b>Verify that user will be redirect to correct pages after clicking on options on the left menu"</br>
		* <b> Steps: </b>
		* 		1. Open Google News page (https://news.google.com/news/?ned=us&hl=eni)
		* 		2. Click on Options on the left menu. 
		*  EXPECT : 
	  	*	 #2: User must be redirected to correct page after clicking on options on the menus : 
	  	*		- Top Stories news
	  	*		- World news
	  	*		- Vietnamese news
	  	*		- Business news
	  	*		- Entertaiment news
	  	*		- Sports news
	  	*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/26
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                            << GoogleServices_GoogleNews_02 >>                               |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		TestLogger.info("Click on Options on the left menu. ");
		TestLogger.info("EXPECT:  User must be redirected to correct page after clicking on options on the menus: \n"
				+ "- Top Stories news\n"
				+ "- World news\n"
				+ "- Vietnamese news\n"
				+ "- Business news\n"
				+ "- Entertaiment news\n"
				+ "- Sports news");
		TestLogger.info("--------------------------------------------------------------------------------------------");
		Click_Menu_World();
		Click_Menu_Vietnamese();
		Click_Menu_Business();
		Click_Menu_Entertaiment();
		Click_Menu_Sports();
		Click_Menu_TopStories();
		if (clickTopStoriesFlag 
				&& clickWorldFlag 
				&& clickVietnameseFlag 
				&& clickBusinessFlag 
				&& clickEntertaimentFlag 
				&& clickSportsFlag) {
			setTestcaseStatus("PASSED", "User must be redirected to correct all page after clicking on options on the menus:\n"
					+ "- Top Stories news\n"
					+ "- World news\n"
					+ "- Vietnamese news\n"
					+ "- Business news\n"
					+ "- Entertaiment news\n"
					+ "- Sports news");
		} else {
			setTestcaseStatus("FAILED", "User it NOT redirected to correct all page after clicking on options on the menus");
			
		}
		//Exit browser
		 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		 sleep (2);
		 s.type("q", Key.CTRL + Key.SHIFT);
		 s.type("d", Key.WIN);
		
	}
	
}
