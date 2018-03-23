package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleCalendar extends BrowserCommon {
	private boolean calendarFlag = false;
	
	@BeforeMethod
	 public void GoogleServices_GoogleCalendar_CheckLoginBefore () {
		s.type("d", Key.WIN);
		sleep(2);
		s.type(Key.F5);
//		if ((System.getProperty("os.name").contains("Windows 8.1"))
//	    || (System.getProperty("os.name").contains("Windows 8"))) {
//	   s.type("desktop");
//	   s.type(Key.ENTER);
//	  }
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
	    else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		
		openLink("https://calendar.google.com/calendar");
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_PopupLoginCalendar.png", 10)) {
			TestLogger.info("--------------------------------------------------------------------------------------------");
			TestLogger.info("Login Google account [coccoc.test001@gmail.com] before execute test Calendar");
			TestLogger.info("--------------------------------------------------------------------------------------------");
			s.type("coccoc.test001@gmail.com");
			s.type(Key.ENTER);
			sleep(3);
			waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_inputPasswordScreen.png", 10);
			s.type("browsertest001");
			s.type(Key.ENTER);
			sleep(3);
			TestLogger.info("--------------------------------------------------------------------------------------------");
			TestLogger.info("Login to Google Calendar successfully");
			TestLogger.info("--------------------------------------------------------------------------------------------");
			waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_PopupSavePassword.png", 20);
			sleep(1);
			clickOn("pictures\\GoogleService_GoogleCalendar_buttonSavePassword.png");
			waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_PopupShowNotifications.png", 10);
			sleep(1);
			clickOn("pictures\\GoogleService_GoogleCalendar_buttonBlockNofitications.png");
			sleep(1);
			waitForObjectPresent("pictures\\GoogleService_Calendar_TextCalendarVN.png", 5);
				
		} else {
			waitForObjectPresent("pictures\\GoogleService_Calendar_TextCalendarVN.png", 5);
			TestLogger.info("--------------------------------------------------------------------------------------------");
			TestLogger.info("Logged-on to Google Calendar successfully before that");
			TestLogger.info("--------------------------------------------------------------------------------------------");
			sleep(2);
		}	
	}
	
	@Test
	public void GoogleServices_GoogleCalendar () {
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_GoogleCalendar_01 </br>
		* <b> CaseTitle: </b>Verify that user will be redirect to correct options after clicking on Day, Week, Month,4 days, Agenda</br>
		* <b> Steps: </b>
		* 		1. Open Google Calendar page. (https://calendar.google.com/calendar) 
		* 		2. Click on Options :  Day, Week, Month,4 days, Agenda
		*  EXPECT : 
		*		#2: User must be redirected to correct views after click on menus: 
		* 			- Day
		* 			- Week
		* 			- Month
		* 			- Year
		* 			- Schedule
		* 			- 4Days
		*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/15
		*/
		
		TestLogger.info("===============================================================================================");
		TestLogger.info("|                        << GoogleServices_GoogleCalendar_01 >>                               |");
		TestLogger.info("===============================================================================================");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Verify that user can access to Google Calendar page after login on Gmail page without relogin ");
		TestLogger.info("1. Open link [https://calendar.google.com/calendar]");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		openLink("https://calendar.google.com/calendar");
		if (waitForObjectPresent("pictures\\GoogleService_Calendar_TextCalendarVN.png", 5) 
				&& (waitForObjectPresent("pictures\\GoogleService_Calendar_CreateCalendarButton.png", 5)))
		 {
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("Showed logo Google Calendar and avatar of user");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
		 }
		 else
		 {
			 TestLogger.info("-----------------------------------------------------------------------------------------------");
			 TestLogger.info("Did NOT show logo Google Calendar and avatar of user");
			 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 }
		sleep(3);
		clickOn("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2. Click on Options :  Day, Week, Month,4 days, Agenda");
		TestLogger.info("EXPECTED: #2 - User must be redirected to correct views after click on menus : Day, Week, Month, Year, Schedule, 4Days");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_titleWeek.png", 5)) {
			setTestcaseStatus("PASSED", "#2.1: Option [Week] is displayed");
			calendarFlag = true;
		} else {
			setTestcaseStatus("FAILED", "#2.1: Don't show [Week] option on Gooogle Calendar");
		}
		sleep(3);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Select option [Day] on Google Calendar");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionWeek.png", 5);
		sleep(2);
		clickOn("pictures\\GoogleService_GoogleCalendar_optionWeek.png");
		sleep(2);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_allOptionCalendar.png", 5)) {
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("All Calendar options is display:\n"
					+ "- Day\n"
					+ "- Week\n"
					+ "- Month\n"
					+ "- Year\n"
					+ "- Schedule\n"
					+ "- 4 days");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
		} else {
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("Don't show Google Calendar all options");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
		}
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionDay.png", 5)) {
			setTestcaseStatus("PASSED", "#2.1: Option [Day] is displayed");
			calendarFlag = true;
		} else {
			setTestcaseStatus("FAILED", "#2.1: Don't display [Day] option");
		}
		sleep(3);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Select option [Month] on Google Calendar");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		clickOn("pictures\\GoogleService_GoogleCalendar_optionDay.png");
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionMonth.png", 5)) {
			setTestcaseStatus("PASSED", "#2.1: Option [Month] is displayed");
			calendarFlag = true;
		} else {
			setTestcaseStatus("FAILED", "#2.1: Don't display [Month] option");	
		}
		sleep(3);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Select option [Year] on Google Calendar");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		clickOn("pictures\\GoogleService_GoogleCalendar_optionMonth.png");
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionYear.png", 5)) {
			setTestcaseStatus("PASSED", "#2.1: Option [Year] is displayed");
			calendarFlag = true;
		} else {
			setTestcaseStatus("FAILED", "#2.1: Don't display [Year] option");
		}
		sleep(3);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Select option [Schedule] on Google Calendar");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		clickOn("pictures\\GoogleService_GoogleCalendar_optionYear.png");
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionSchedule.png", 5)) {
			setTestcaseStatus("PASSED", "#2.1: Option [Schedule] is displayed");
			calendarFlag = true;
		} else {
			setTestcaseStatus("FAILED", "#2.1: Don't display [Schedule] option");
		}
		sleep(3);
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Select option [4 days] on Google Calendar");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		clickOn("pictures\\GoogleService_GoogleCalendar_optionSchedule.png");
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_option4Days.png", 5)) {
			setTestcaseStatus("PASSED", "#2.1: Option [4Days] is displayed");
			calendarFlag = true;
		} else {
			setTestcaseStatus("FAILED", "#2.1: Don't display [4Days] option ");
		}
		sleep(3);
		clickOn("pictures\\GoogleService_GoogleCalendar_option4Days.png");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("Set [Week] option is default on Google Calendar");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		
		if (calendarFlag == true) {
			setTestcaseStatus("PASSED", "Google Calendar is showed logo and redirected to correct views after click on menus:\n"
					+ "- Day\n"
					+ "- Week\n"
					+ "- Month\n"
					+ "- Year\n"
					+ "- Schedule\n"
					+ "- 4Days");
		} else {
			setTestcaseStatus("FAILED", "Did NOT redirected to correct views after click on menus: "
					+ "- Day\n"
					+ "- Week\n"
					+ "- Month\n"
					+ "- Year\n"
					+ "- Schedule\n"
					+ "- 4Days");
		}
		/**
		* <b> Browser_GoogleServices_v1.1 </b> </br>
		* <b> CaseID: </b> GoogleServices_GoogleCalendar_02&03&04 </br>
		* <b> CaseTitle: </b>Verify that user can create/update/delete a Remind successfully on Google Calendar page</br>
		* <b> Steps: </b>
		* 		1. Open Google Calendar page. (https://calendar.google.com/calendar) 
		* 		2. Choose a day to create a remind
		* 		3. Edit content on that Remind
		* 		4. Delete that remind
		*  EXPECT : 
		*		#2: The remind must be created successfully.
		*		#3: That content must be updated after editing.
		*		#4: That remind must be deleted successfully.
		*
		* @author 
		* @updaters: dung.buiduy
		* @date: 2018/03/15
		*/ 
		
		 TestLogger.info("===============================================================================================");
		 TestLogger.info("|                        << GoogleServices_GoogleCalendar_02&03&04 >>                           |");
		 TestLogger.info("===============================================================================================");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("1. Open Google Calendar page. (https://calendar.google.com/calendar) ");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 sleep(3);
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
		 openLink("https://calendar.google.com/calendar");
		 waitForObjectPresent("pictures\\GoogleService_Calendar_TextCalendarVN.png", 10);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("2. Create a remind on Google Calendar ");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 sleep(2);
		 clickOn("pictures\\GoogleService_Calendar_CreateCalendarButton.png");
		 sleep(2);
		 waitForObjectPresent("pictures\\GoogleService_Calendar_addTitleEvent.png", 5);
		 sleep(2);
		 clickOn("pictures\\GoogleService_Calendar_addTitleEvent.png");
		 s.type("Google Service test");
		 sleep(2);
		 clickOn("pictures\\GoogleService_Calendar_buttonSave.png");
		 sleep(2);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("EXPECED: #2- The remind must be created successflly.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 if (waitForObjectPresent("pictures\\GoogleService_Calendar_createdGoogleCalendarTestSuccessful.png", 5)) {
			 setTestcaseStatus("PASSED", "GoogleServices_GoogleCalendar_02:\n"
			 		+ "User can create a Remind successfully on Google Calendar page");
		 } else {
			 setTestcaseStatus("FAILED", "GoogleServices_GoogleCalendar_02:\n"
			 		+ "User can NOT create a Remind successfully on Google Calendar page"); 
		 }
		 sleep(3);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("3. Edit content on that Remind");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 clickOn("pictures\\GoogleService_Calendar_createdGoogleCalendarTestSuccessful.png");
		 waitForObjectPresent("pictures\\GoogleService_Calendar_popupRemind.png", 3);
		 sleep(2);
		 clickOn("pictures\\GoogleService_Calendar_buttonEditEvent.png");
		 sleep(2);
		 s.type(Key.TAB);
		 s.type("a", Key.CTRL);
		 sleep(1);
		 s.type(Key.BACKSPACE);
		 s.type("Google Service test - edit");
		 sleep(2);
		 clickOn("pictures\\GoogleService_Calendar_buttonSave.png");
		 sleep(3);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("EXPECED: #3 - That content must be updated after editting.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 if (waitForObjectPresent("pictures\\GoogleService_Calendar_evenGoogleCalendarTestEdit.png", 10))
		 {
			 setTestcaseStatus("PASSED", "GoogleServices_GoogleCalendar_03:\n"
			 		+ "User can EDIT a Remind successfully on Google Calendar page");
			 sleep(2);
			 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			 
		 } else {
			 setTestcaseStatus("FAILED", "GoogleServices_GoogleCalendar_03:\n"
			 		+ "Can't edit a Remind  successfully on Google Calendar page");
		 }
		 sleep(3);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("4. Edit content on that Remind");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 clickOn("pictures\\GoogleService_Calendar_evenGoogleCalendarTestEdit.png");
		 sleep(2);
		 waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_buttonDelRemind.png", 5);
		 clickOn("pictures\\GoogleService_GoogleCalendar_buttonDelRemind.png");
		 sleep(2);
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("EXPECED: #4 - That remind must be deleted successfully.");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 if (waitForObjectPresent("pictures\\GoogleService_Calendar_evenGoogleCalendarTestEdit.png", 5)) {
			 setTestcaseStatus("FAILED", "GoogleServices_GoogleCalendar_04:\n"
			 		+ "User can NOT DELETE a Remind successfully on Google Calendar page");
		 } else {
			 setTestcaseStatus("PASSED", "GoogleServices_GoogleCalendar_04:\n"
			 		+ "User can DELETE a Remind successfully on Google Calendar page");
		 }
		//Exit browser
		 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		 sleep (2);
		 s.type("q", Key.CTRL + Key.SHIFT);
		 s.type("d", Key.WIN);
	}
}
