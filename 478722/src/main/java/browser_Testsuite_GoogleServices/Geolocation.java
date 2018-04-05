package browser_Testsuite_GoogleServices;

import java.awt.Desktop;
import org.sikuli.script.Key;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Geolocation extends BrowserCommon {
	boolean denyOK = true;
	
	private void Grant_Location_Access(boolean POIaccess){  
        TestLogger.info("Open any web require permission to access POI");
        openLink("https://www.google.com/maps/");       
        waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
        clickOn("pictures\\website_googleMap_icon_showDialog.png");
        if (waitForObjectPresent("pictures\\Browser_Modal_Dialog_Allow_Block.png", 10)){
        	
        	if(POIaccess == true){
        		TestLogger.info("Allow sharing Location");
        		clickOn("pictures\\Website_GoogleMap_button_Allow.png");
        		// OR you should capture another picture to confirm location is allowed
        		if(waitForObjectPresent("pictures\\Website_GoogleMap_icon_POIenable.png", 10)){
                        setTestcaseStatus("PASSED", "A modal dialog to confirm Location access right displayed AND button ALLOW works well.");
                        
                } else {
                        setTestcaseStatus("FAILED", "Button ALLOW doesn't work well OR Allowed icon next to Omnibox is shown.");
                }
                                                                                     
            } else {
            	TestLogger.info("Choose Block location option");
            	clickOn("pictures\\Website_GoogleMap_button_Block.png");
            	if(waitForObjectPresent("pictures\\Website_GoogleMap_icon_POIdisable.png", 10)){
                   setTestcaseStatus("PASSED", "A modal dialog to confirm Location access right displayed AND button DENY works well.");
                   
                } else{
                   setTestcaseStatus("FAILED", "Button DENY doesn't work well OR Denied icon next to Omnibox is shown.");
                   denyOK = false;
                }
            }                       
         } else {
        	 setTestcaseStatus("FAILED", "A modal dialog to confirm Location access right NOT displayed.");        
          }       
    }
	private void Clear_Settings_Location(boolean POIaccess) {
		if (POIaccess == true) {
			waitForObjectPresent("pictures\\Browser_Omnibox_icon_POIenable.png", 5);
			clickOn("pictures\\Website_GoogleMap_icon_POIenable.png");
			sleep(2);
			waitForObjectPresent("pictures\\Website_GoogleMap_popup_TrackingLocation.png", 3);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			sleep(3);
			s.type(Key.F5);
			if (waitForObjectPresent("pictures\\Browser_Omnibox_icon_POIdon'tShow.png", 5)) {
				TestLogger.info("Clear setting user successfully");
				
			} else {
				TestLogger.info("Can't clear setting user");
				String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
				captureSnapshot(homePath, "NotClearSettingUser", 2);
			} 
		} else {
			waitForObjectPresent("pictures\\Browser_Omnibox_icon_POIdisable.png", 5);
			clickOn("pictures\\Website_GoogleMap_icon_POIdisable.png");
			sleep(2);
			waitForObjectPresent("pictures\\Website_GoogleMap_popup_TrackingLocation.png", 3);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			sleep(3);
			s.type(Key.F5);
			if (waitForObjectPresent("pictures\\Browser_Omnibox_icon_POIdon'tShow.png", 5)) {
				TestLogger.info("Clear setting user successfully");
				
			} else {
				TestLogger.info("Can't clear setting user");
				String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
				captureSnapshot(homePath, "NotClearSettingUser", 2);
			}
		  } 
		sleep(3);
		} 
		
	private void Open_Geolocation_Exceptions(boolean POIaccess) {
		if (POIaccess == true) {
			waitForObjectPresent("pictures\\Browser_Omnibox_icon_POIenable.png", 3);
			clickOn("pictures\\Website_GoogleMap_icon_POIenable.png");
			sleep(2);
			waitForObjectPresent("pictures\\Website_GoogleMap_popup_TrackingLocation.png", 3);
			clickOn("pictures\\Website_GoogleMap_button_ManageExceptions.png");
			if (waitForObjectPresent("pictures\\Browser_Geolocation_popup_ManageExceptions.png", 3)) {
				TestLogger.info("Geolocation Exceptions popup is opened");
				String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
				captureSnapshot(homePath, "Open_GeoExceptions", 2);
			} else {
				TestLogger.info("Can't open Geolocation exceptions page");
				String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
				captureSnapshot(homePath, "Can'tOpen_GeoExceptions", 2);
			}
		} else {
			waitForObjectPresent("pictures\\Browser_Omnibox_icon_POIdisable.png", 3);
			clickOn("pictures\\Website_GoogleMap_icon_POIdisable.png");
			sleep(2);
			waitForObjectPresent("pictures\\Website_GoogleMap_popup_TrackingLocation.png", 3);
			clickOn("pictures\\Website_GoogleMap_button_ManageExceptions.png");
			if (waitForObjectPresent("pictures\\Browser_Geolocation_popup_ManageExceptions.png", 3)) {
				TestLogger.info("Geolocation Exceptions popup is opened");
				String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
				captureSnapshot(homePath, "Open_GeoExceptions", 2);
			} else {
				TestLogger.info("Can't open Geolocation exceptions page");
				String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
				captureSnapshot(homePath, "Can'tOpen_GeoExceptions", 2);
			}
		}
		sleep(3);

	}
	
	@Test
	public void Google_Services_Geolocation (){
            //Verify that default of POI setting is "Ask when a site wants to show notifications (recommended)
            /**
            * <b> Browser_GoogleServices_v1.1 </b> </br>
            * <b> CaseID: </b> Google_services_Geolocation_01 </br>
            * <b> CaseTitle: </b>Verify that default of POI setting is "Ask when a site wants to show notifications (recommended)"</br>
            * <b> Steps: </b>
            *               1. Open settings page
            *               2. Go to Privacy -> content settings -> location
            *  EXPECT :
            *        '#2:
        *           - There are 3 options:
            *                + "Ask when a site wants to show notifications (recommended)" (default)
            *                + Allow all sites to track your physical location
            *                + Do not allow any site to track your physical location
            *               - Button: Manage Exceptions
            * @author hanv
            * @updaters: dung.buiduy
            * @date: 2018/03/08
            */
			TestLogger.info("===============================================================================================");
            TestLogger.info("|                           << Google_services_Geolocation_01 >>                              |");
            TestLogger.info("===============================================================================================");
            Open_CocCoc_Browser_From_Desktop();
            Delete_User_Account();
            //startCocCocInEnglish();
            openLink("coccoc://settings/content");
            if(waitForObjectPresent("pictures\\Browser_Settings_title_ContentSettings.png", 8)){
               s.type(Key.PAGE_DOWN);
               s.type(Key.PAGE_DOWN);
               sleep(2);
               if (waitForObjectPresent("pictures\\Browser_Settings_Modal_Location.png", 6)) {
            	   setTestcaseStatus("PASSED", "Google_services_Geolocation_01: check OK with default values of Location setting");
           
               } else {
            	   setTestcaseStatus("FAILED", "Google_services_Geolocation_01: there is no Location setting or Location setting default values are wrong");
                 
                 }
                                    
            } else {
            	setTestcaseStatus("FAILED", "Google_services_Geolocation_01: Location setting page can not be openned");
                    
            }
 
            /**
             * <b> Browser_GoogleServices_v1.1 </b> </br>
             * <b> CaseID: </b> Google_services_Geolocation_02 </br>
             * <b> CaseTitle: </b>Check button (Allow/Block) when website requite to use Geolocation  API on the first time.</br>
             * <b> Steps: </b>
             *        1. Open any web require permission to access POI
             *        2. Click on Allow or Block button
             *        3. Observe on Ominibox
             *  EXPECT :
             *       #1: A modal appears to confirm user Allow/Block website access POI.
             *       #3: The POI icon appears beside Addtone icon.
             *       
             * <b> Browser_GoogleServices_v1.1 </b> </br>
             * <b> CaseID: </b> Google_services_Geolocation_03 </br>
             * <b> CaseTitle: </b>Verify CocCoc can support Geolocation (IP or GPS (if have))</br>
             * <b> Steps: </b>
             *              1. Open any web require permission to access POI. (e.g.: opens page: https://maps.google.com).
             *              2. On confirm modal, click on Allow button.
             *              3. Observe on website.
             *  EXPECT :
             *              #3: Website can detect user's location.

             * @author hanv
             * @updaters: dung.buiduy
             * @date: 2018/03/08
             */
            TestLogger.info("===============================================================================================");
            TestLogger.info("|                          << Google_services_Geolocation_02&3 >>                             |");
            TestLogger.info("===============================================================================================");
            //Allow access location option
            Grant_Location_Access(false);
            if (waitForObjectPresent("pictures\\Website_GoogleMap_icon_POIdisable.png", 5)) {
            	setTestcaseStatus("PASSED", "Google_services_Geolocation_02: POI icon is diplay by clicking [Block] button");
            	
            } else {
            	setTestcaseStatus("FAILED", "Google_services_Geolocation_02: POI icon is not display on Omnibox");
            }
            sleep(2);
            //restore setting of Location access right
            Clear_Settings_Location(false); 
            //Block access location option
            Grant_Location_Access(true);
            if (waitForObjectPresent("pictures\\Website_GoogleMap_icon_POIenable.png", 5)) {
            	hoverImage("pictures\\Website_GoogleMap_icon_POIenable2.png");
            	waitForObjectPresent("pictures\\Website_GoogleMap_popup_YourLocationEN.png", 3);
            	setTestcaseStatus("PASSED", "Google_services_Geolocation_03: User can detect they location by clicking [Allow] button");
            	
            } else {
            	setTestcaseStatus("FAILED", "Google_services_Geolocation_03: User can't detect they location by clicking [Allow] button");
            }
            Clear_Settings_Location(true); 
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
   		 	*
   		 	*
   		 	* @author hanv
   		 	* @updaters: dung.buiduy
   		 	* @date: 2018/03/08
   		 	*/
            
            TestLogger.info("===============================================================================================");
            TestLogger.info("|                         << Google_services_Geolocation_04&05 >>                              |");
            TestLogger.info("===============================================================================================");
            Grant_Location_Access(false);
            Open_Geolocation_Exceptions(false);
    		clickOn("pictures\\Browser_GeolocationException_hostname_Google.png");
    		s.type(Key.DELETE);
    		sleep(2);
    		s.type(Key.ENTER);
    		if (waitForObjectPresent("pictures\\Browser_Settings_title_ContentSettings.png", 3)) {
    			setTestcaseStatus("PASSED", "Google_services_Geolocation_05: Content setting page is opened");
    		} else {
    			setTestcaseStatus("FAILED", "Google_services_Geolocation_05: Content setting page is NOT open ");
    		}
    		sleep(2);
    		s.type(Key.ENTER);
    		sleep(2);
    		//waitForObjectPresent("pictures\\Browser_Setting_title_SettingsPage.png", 3);
    		s.type("w", Key.CTRL);
    		sleep(2);
    		s.type(Key.F5);
    		Grant_Location_Access(true);
    		if (waitForObjectPresent("pictures\\Website_GoogleMap_icon_POIenable.png", 5)) {
            	hoverImage("pictures\\Website_GoogleMap_icon_POIenable2.png");
            	waitForObjectPresent("pictures\\Website_GoogleMap_popup_YourLocationEN.png", 3);
            	setTestcaseStatus("PASSED", "Google_services_Geolocation_04: User can detect they location by clicking [Allow] button");
            	
            } else {
            	setTestcaseStatus("FAILED", "Google_services_Geolocation_04: User can't detect they location by clicking [Allow] button");
            }
			sleep(2);
			//exit browser
			s.type("q", Key.CTRL + Key.SHIFT);
			s.type("q", Key.WIN);  
    		
	}	
}	
	