package browser_Testsuite_GoogleServices;

import java.awt.Desktop;
import org.sikuli.script.Key;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Geolocation extends BrowserCommon {
	
	@BeforeMethod
	public void Google_Services_Geolocation_ClearData ()
	{
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Cleaning data before execute test script");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
//		if ((System.getProperty("os.name").contains("Windows 8.1"))
//	    		|| (System.getProperty("os.name").contains("Windows 8"))) {
//	   		s.type("desktop");
//	   		s.type(Key.ENTER);
//	  	}
		s.type("d", Key.WIN);
		s.type(Key.F5);
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		//Open setting users page
		openLink("coccoc://settings/#coccoc-settings-users"); 
		waitForObjectPresent("pictures\\GoogleService_OtherSettigns_UsersSettingsPage.png", 3);
		sleep(2);
		clickOn("pictures\\GoogleService_OtherSettigns_PersonAvailable.png");
		sleep(2);
		waitForObjectPresent("pictures\\GoogleService_OtherSettigns_SelectPerson.png", 3);
		sleep(2);
		s.type(Key.DELETE);
		waitForObjectPresent("pictures\\GoogleService_OtherSettings_RemovePersonPopup1.png", 5);
		sleep(5);
		clickOn("pictures\\GoogleService_OtherSettings_RemovePersonButton.png");
		if (waitForObjectPresent("pictures\\GoogleService_OtherSettings_LogoAfterRemovePersonSuccessful.png", 5))
		{
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("Remove person successfully");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
		}
		else
		{
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("Failure to remove person");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
		}
		s.type("q", Key.CTRL + Key.SHIFT);
		sleep(3);
		s.type("d", Key.WIN);
		sleep(3);
		s.type(Key.F5);
		sleep(3);
	}

	@Test
	public void Google_Services_Geolocation ()
	{
		//Verify that default of POI setting is "Ask when a site wants to show notifications (recommended)
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> Google_services_Geolocation_01 </br>
		* <b> CaseTitle: </b>Verify that default of POI setting is "Ask when a site wants to show notifications (recommended)"</br>
		* <b> Steps: </b>
		* 		1. Open settings page
		* 		2. Go to Privacy -> content settings… -> location
		*  EXPECT : 
		*	 '#2:
	    * 		- There are 3 options: 
	  	* 		 + "Ask when a site wants to show notifications (recommended)" (default)
	  	* 		 + Allow all sites to track your physical location
	  	* 		 + Do not allow any site to track your physical location
		* 		- Button: Manage Exceptions…
		* @author hanv
		* @updaters: dung.buiduy
		* @date: 2018/03/08
		*/
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                           << Google_services_Geolocation_01 >>                               |");
		TestLogger.info("===============================================================================================");
		//Go to Desktop if PC is Win 8 or Win 8.1
//		if ((System.getProperty("os.name").contains("Windows 8.1"))
//			    || (System.getProperty("os.name").contains("Windows 8"))) {
//			   s.type("desktop");
//			   s.type(Key.ENTER);
//			}
		s.type("d", Key.WIN);
		s.type(Key.F5);
		startCocCocInEnglish();
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("1.Open settings page");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		openLink("coccoc://settings/#coccoc-settings-general");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2.Go to Privacy -> content settings… -> location");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		waitForObjectPresent("pictures\\Browser_Settings_TextLink_Privacy.png", 8);
		clickOn("pictures\\Browser_Settings_TextLink_Privacy.png");
		waitForObjectPresent("pictures\\Browser_Settings_button_contentSettings.png", 8);
		clickOn("pictures\\Browser_Settings_button_contentSettings.png");
		waitForObjectPresent("pictures\\Browser_Settings_button_Done.png", 8);
		moveMouseDownFromLogo("pictures\\Browser_Settings_button_Done.png", -150);
		s.click();
		int i =1;
		do
		{
			i++ ;
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			
		} while (! waitForObjectPresent("pictures\\Browser_Settings_Text_Notifications.png", 1) && (i<6)) ;
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("#2.- There are 3 options:\n" 
		        + "Ask when a site wants to show notifications (recommended)\n" 
		        + "Allow all sites to track your physical location\n"
		        + "Do not allow any site to track your physical location\n"
		        + "Button: Manage Exceptions");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Browser_Settings_Modal_Location.png", 6)) 
		{
			waitForObjectPresent("pictures\\Browser_Settings_button_Done.png", 8);
			clickOn("pictures\\Browser_Settings_button_Done.png");
			setTestcaseStatus("PASSED", "PASSED =>  : #2. There are 3 options:");
			s.type(Key.ENTER);
			
		}
		else
		{
			waitForObjectPresent("pictures\\Browser_Settings_button_Done.png", 8);
			clickOn("pictures\\Browser_Settings_button_Done.png");
			setTestcaseStatus("FAILED", "FAILED : ==> #2. There are NOT 3 options:");
			s.type(Key.ENTER);

		}
		
		// Check button [Allow/Block] when website requite to use Geolocation  API on the first time.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Google_services_Geolocation_02 </br>
		 * <b> CaseTitle: </b>Check button (Cho phép/chặn) when website requite to use Geolocation  API on the first time.</br>
		 * <b> Steps: </b>
		 *		1. Open any web require permission to access POI
		 *		2. Click on Allow or Block button
	 	 * 		3. Observe on Ominibox
		 *  EXPECT : 
	 	 *	 #1: A modal appears to confirm user Allow/Block website access POI.
		 *	 #3: The POI icon appears beside Addtone icon.
		 * @author hanv
		 * @updaters: dung.buiduy
		 * @date: 2018/03/08
		 */
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                          << Google_services_Geolocation_02 >>                               |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
	    TestLogger.info("1. Open any web require permission to access POI");
	    TestLogger.info("-----------------------------------------------------------------------------------------------");
	    if (waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 5))
	    {
	    	clickOn("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png");
	    	s.type("t", Key.CTRL);
	    } else {
	    	s.type("d", Key.WIN);
	    	if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		    else
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
	    	
	    }
	    sleep(2);
	    openLink("https://www.google.com/maps/"); 	    
		waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
		clickOn("pictures\\website_googleMap_icon_showDialog.png");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("#1: A modal appears to confirm user Allow/Block website access POI.");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\Browser_Modal_Dialog_Allow_Block.png", 10))
		{
			setTestcaseStatus("PASSED", "PASSED : ==> #1 : A modal appears to confirm user Allow/Block website access POI. ");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "FAILED : ==> #1 : A modal DOES NOT appear to confirm user Allow/Block website access POI. ");
			//Clear setting when Cốc Cốc Browser doesn't detect my location
			waitForObjectPresent("pictures\\GoogleService_Location_BlockIcon.png", 5);
			clickOn("pictures\\GoogleService_Location_BlockIcon.png");
			sleep(2);
			waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupManageTrackingLocation.png", 3);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			sleep(2);
			clickOn("pictures\\GoogleService_Geolocation_ReloadBrowser.png");
			sleep(2);
			clickOn("pictures\\website_googleMap_icon_showDialog.png");
		}

		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2. Click on [Allow] or [Block] button");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		
		waitForObjectPresent("pictures\\WebSite_CoccocMap_Dialog_Allow.png", 8);
		clickOn("pictures\\WebSite_CoccocMap_Dialog_Allow.png");
		setTestcaseStatus("PASSED", "PASSES : ==> #2 : Click on Allow button to website access POI. ");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("3. Observe on Ominibox");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		
		if (waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 6))
		{   
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("#3: The POI icon appears beside Addtone icon.");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			waitForObjectPresent("pictures\\GoogleService_Geolocation_DetectLocationIcon.png", 5);
			moveMouseDownFromLogo("pictures\\GoogleService_Geolocation_DetectLocationIcon.png", -100);
			hoverImage("pictures\\GoogleService_Geolocation_DetectLocationIcon.png");
			setTestcaseStatus("PASSED", "PASSED : ==> #3 : The POI icon appears beside Addtone icon. ");
			clickOn("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			sleep(2);
			clickOn("pictures\\GoogleService_Geolocation_ReloadBrowser.png");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED : ==> #3 : The POI icon DOES NOT appear beside Addtone icon. ");
			waitForObjectPresent("pictures\\GoogleService_Location_BlockIcon.png", 8);
			clickOn("pictures\\GoogleService_Location_BlockIcon.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			sleep(2);
			clickOn("pictures\\GoogleService_Geolocation_ReloadBrowser.png");
		}
		//Verify CocCoc can support Geolocation (IP or GPS (if have))
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Google_services_Geolocation_03 </br>
		 * <b> CaseTitle: </b>Verify CocCoc can support Geolocation (IP or GPS (if have))</br>
		 * <b> Steps: </b>
		 *		1. Open any web require permission to access POI. (e.g.: opens page: https://maps.google.com).
		 *		2. On confirm modal, click on Allow button.
		 *		3. Observe on website.
		 *  EXPECT : 
		 *		#3: Website can detect user's location.
		 * @author hanv
		 * @updaters: dung.buiduy
		 * @date: 2018/03/08
		 */		
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Google_services_Geolocation_04 </br>
		 * <b> CaseTitle: </b>Verify that Geolocation works as settings mention ( disable/enable Geolocation, exception).</br>
		 * <b> Steps: </b>
		 *		1. Open any web require permission to access POI.
		 *		2. On confirm modal, click on "Block"("Chặn") button.
		 *		3. Observe on website.
		 *		4. Open location settings.
		 *		5. Click on "Manage exceptions…" button
		 *		6. Remove the website on step #1 on list
		 *		7. Re-open website on step #1
		 *		8. On confirm modal, click on "Allow"("Cho phép") button.
		 *		9. Observe on Website
		 *  EXPECT : 
		 *		#2: The small, red "x" appears on POI icon.
		 *		#3: Website cannot detect to user's location.
		 *		#8: POI icon appears without "x".
		 *		#9: Website can detect user's location.
		 * @author hanv
		 * @updaters: dung.buiduy
		 * @date: 2018/03/08
		 */
		
		 TestLogger.info("===============================================================================================");	
		 TestLogger.info("|                         << Google_services_Geolocation_03&04 >>                                |");
		 TestLogger.info("===============================================================================================");
		 if (waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 5))
		    {
		    	clickOn("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png");
		    } else {
		    	s.type("d", Key.WIN);
		    	if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
					doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			    else
					doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		    	
		    }
		 sleep(2);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("1. Open any web require permission to access POI.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 openLink("https://www.google.com/maps/") ; 
		 waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
	     clickOn("pictures\\website_googleMap_icon_showDialog.png");
		 waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupNotifications.png", 8);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");	
		 TestLogger.info("2. On confirm modal, click on [Block] button.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 waitForObjectPresent("pictures\\GoogleService_Geolocation_BlockButton.png", 8);
		 clickOn("pictures\\GoogleService_Geolocation_BlockButton.png");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("#2: The small, red [X] appears on POI icon.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 if (waitForObjectPresent("pictures\\GoogleService_Geolocation_POIdisableIcon.png", 6)) 
		 {
			 setTestcaseStatus("PASSED", "PASSED : ==>#2: The small, red [X] appears on POI icon. ");
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", "FAILED : ==>#2: The small, red [X] DOES NOT appear on POI icon. ");
		 }
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("3. Observe on website.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 waitForObjectPresent("pictures\\GoogleService_Geolocation_POIdisableIcon.png", 8);
		 clickOn("pictures\\GoogleService_Geolocation_ReloadBrowser.png");
		 sleep(1);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("#3 : Website cannot detect to user's location.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 clickOn("pictures\\website_googleMap_icon_showDialog.png");
		 moveMouseDownFromLogo("pictures\\GoogleService_Geolocation_POIdisableIcon2.png", -100);
		 hoverImage("pictures\\GoogleService_Geolocation_POIdisableIcon2.png");
		 sleep(1);
		 clickOn("pictures\\GoogleService_Geolocation_POIdisableIcon2.png");
		 
		 if (waitForObjectPresent("pictures\\GoogleService_Geolocation_Can'tDetectLocationNotificationVN.png", 10))
		 {
			 setTestcaseStatus("PASSED", "PASSED : ==> #3 : Website cannot detect to user's location. ");
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", "FAILED :==> #3 : Website STILL CAN detect to user's location. ");
		 }
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("4. Open location settings.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 clickOn("pictures\\GoogleService_Geolocation_POIdisableIcon.png");
		 waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupManageTrackingLocation.png", 5);
		 sleep(2);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("5. Click on Manage exceptions… button");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 clickOn("pictures\\GoogleService_Geolocation_ButtonManageTracking.png");
		 waitForObjectPresent("pictures\\GoogleService_Geolocation_ManageExceptionsPopup.png", 5);	
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info(" Remove the website on on list");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 clickOn("pictures\\GoogleService_Geolocation_GoogleHostNamePattern.png");
		 sleep(2);
		 s.type(Key.DELETE);
		 //waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupAfterDelGoogleHostName.png", 3);
		 s.type(Key.ENTER);
		 s.type(Key.ENTER);
		 sleep(2);
		 s.type("q", Key.CTRL + Key.SHIFT);
		 if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("7. Re-open website on step #1");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 openLink("https://www.google.com/maps/");
		 waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15);
	     //clickOn("pictures\\website_googleMap_icon_showDialog.png");
		 waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupNotifications.png", 8);	
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("8. On confirm modal, click on [Allow/Cho phép] button.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 clickOn("pictures\\GoogleService_Geolocation_AllowButton.png");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("#8: EXPECT : ==> POI icon appears without x.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 waitForObjectPresent("pictures\\Website_CoccocMap_Icon_displayMyLocation.png", 8);
		 clickOn("pictures\\Website_CoccocMap_Icon_displayMyLocation.png");
		 
		  if (waitForObjectPresent("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png", 5) )
		  {
			  setTestcaseStatus("PASSED", "PASSED : ==> POI icon appears without [X] ");
		  }
		  else
		  {
			  setTestcaseStatus("FAILED", "FAILED : ==> POI icon STILL appear with [X]. ");
		  }
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("9. Observe on Website");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 
		 waitForObjectPresent("pictures\\GoogleService_Geolocation_DetectLocationIcon.png", 5);
		 moveMouseDownFromLogo("pictures\\GoogleService_Geolocation_DetectLocationIcon.png", -100);
		 hoverImage("pictures\\GoogleService_Geolocation_DetectLocationIcon.png");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("#9: EXPECT: ==>  Website can detect user's location.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 if (waitForObjectPresent("pictures\\GoogleService_Geolocation_MyLocationPopupVN.png", 5))
		 {  
			 setTestcaseStatus("PASSED", "PASSED :==> #9 : Website can detect user's location ");
		 	 waitForObjectPresent("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png", 8);
			 clickOn("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png");
			 waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			 clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			 sleep(2);
			 clickOn("pictures\\GoogleService_Geolocation_ReloadBrowser.png");
			 
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", "FAILED : ==> #9 : Website can NOT detect user's location  ");
			 waitForObjectPresent("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png", 8);
			 clickOn("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png");
			 waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			 clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			 sleep(2);
			 clickOn("pictures\\GoogleService_Geolocation_ReloadBrowser.png");
		
		 }
		//Verify that user can open POI setting by click POI icon on Ominibox
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> Google_services_Geolocation_05 </br>
		* <b> CaseTitle: </b>Verify that user can open POI setting by double click POI icon on Ominibox</br>
		* <b> Steps: </b>
		* 		1. Open any web require permission to access POI
		* 		2. Click on Allow or Block button
		* 		3. Click POI button on Ominibox .
		* 		4. Click Manage Location Settings . 
		*  EXPECT : 
		* 		#4: Dialog : Gelocation Exception appear and CocCoc open settings page and modal "location setting" .
		* 
		* @author hanv
		* @updaters: dung.buiduy
		* @date: 2018/03/08
		*/
			TestLogger.info("===============================================================================================");
			TestLogger.info("|                        << Google_services_Geolocation_05 >>                                 |");
			TestLogger.info("===============================================================================================");

			if (waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 5))
			    {
			    	clickOn("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png");
			    } else {
			    	s.type("d", Key.WIN);
			    	if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
						doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
				    else
						doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");  	
			   }
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("1. Open any web require permission to access POI.");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			sleep(2);
			openLink("https://www.google.com/maps");
			if (waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15))
			{
		     clickOn("pictures\\website_googleMap_icon_showDialog.png");
			}
			waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupNotifications.png", 5);
			sleep(1);
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("2.1 When click on [Allow] button");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			clickOn("pictures\\GoogleService_Geolocation_AllowButton.png");		
			sleep(1);
			waitForObjectPresent("pictures\\GoogleService_Geolocation_MyLocationPopupVN.png", 5);
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("3.1 Click POI button on Ominibox.");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			clickOn("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png");
			waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupManageTrackingLocation.png", 5);
			sleep(1);
			// Check Dialog : Gelocation Exception appear 
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("4.1 Click Manage Location Settings.");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			clickOn("pictures\\GoogleService_Geolocation_ButtonManageTracking.png");		
			if (waitForObjectPresent("pictures\\GoogleService_Geolocation_GeolocationExceptionPopup.png", 5)) 
			{
				setTestcaseStatus("PASSED", "PASSED : ==> Dialog : Gelocation Exception appear ");
				sleep(3);
				s.type(Key.ENTER);
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED : ==> Dialog : Gelocation Exception DOES NOT appear ");
			}
			// Check CocCoc will open modal 'location setting' .
			if (waitForObjectPresent("pictures\\GoogleService_Geolocation_ContenSettignsPopup.png", 3))
			{
				sleep(3);
				setTestcaseStatus("PASSED", "PASSED : =>  CocCoc opened  modal [Location setting]");
			}
			else
			{
				sleep(3);
				setTestcaseStatus("FAILED", "FAILED : =>  CocCoc DID NOT open  modal [Location setting]");
			}
			sleep(2);
			s.type(Key.ENTER);
			s.type("w", Key.CTRL);
			waitForObjectPresent("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png", 8);
			clickOn("pictures\\GoogleService_Geolocation_LocationOnAddressBarIcon.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			sleep(2);
			clickOn("pictures\\GoogleService_Geolocation_ReloadBrowser.png");
			sleep(2);
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("Reopen [maps.google.com] and check when click [Block] button");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			openLink("https://www.google.com/maps");
			if (waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15))
			{
		     clickOn("pictures\\website_googleMap_icon_showDialog.png");
			}
			waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupNotifications.png", 5);
			sleep(1);
			clickOn("pictures\\GoogleService_Geolocation_BlockButton.png");
			waitForObjectPresent("pictures\\GoogleService_Geolocation_POIdisableIcon2.png", 5);
			moveMouseDownFromLogo("pictures\\GoogleService_Geolocation_POIdisableIcon2.png", 100);
			hoverImage("pictures\\GoogleService_Geolocation_POIdisableIcon2.png");
			sleep(1);
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("2.2 Click on [Block] button");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			clickOn("pictures\\GoogleService_Geolocation_POIdisableIcon2.png");
			waitForObjectPresent("pictures\\GoogleService_Geolocation_Can'tDetectLocationNotificationVN.png", 5);
			waitForObjectPresent("pictures\\GoogleService_Geolocation_POIdisableIcon.png", 3);
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("3.2 Click POI button on Ominibox.");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			clickOn("pictures\\GoogleService_Geolocation_POIdisableIcon.png");
			waitForObjectPresent("pictures\\GoogleService_Geolocation_PopupManageTrackingLocation.png", 5);
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("4.2 Click Manage Location Settings.");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			clickOn("pictures\\GoogleService_Geolocation_ButtonManageTracking.png");	
			if (waitForObjectPresent("pictures\\GoogleService_Geolocation_GeolocationExceptionPopup.png", 5)) 
			{
				setTestcaseStatus("PASSED", "PASSED : ==> Dialog : Gelocation Exception appear");
				sleep(3);
				s.type(Key.ENTER);
			}
			else
			{
				sleep(3);
				setTestcaseStatus("FAILED", "FAILED : ==> Dialog : Gelocation Exception DOES NOT appear ");
			}
			// Check CocCoc will open modal 'location setting' .
			if (waitForObjectPresent("pictures\\GoogleService_Geolocation_ContenSettignsPopup.png", 3))
			{
				sleep(3);
				setTestcaseStatus("PASSED", "PASSED : =>  CocCoc opened  modal [Location setting]");
			}
			else
			{
				sleep(3);
				setTestcaseStatus("FAILED", "FAILED : =>  CocCoc DID NOT open  modal [Location setting]");
			}
			sleep(2);
			s.type(Key.ENTER);
			s.type("q", Key.CTRL + Key.SHIFT);
			s.type("q", Key.WIN);
			
	}
		
	}
