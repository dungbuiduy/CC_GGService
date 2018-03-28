package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleCalendar extends BrowserCommon {
	private boolean clickDayFlag;
	private boolean clickWeekFlag;
	private boolean clickMonthFlag;
	private boolean clickYearFlag;
	private boolean clickScheduleFlag;
	private boolean click4DaysFlag;	
	
	private void Click_Option_Day() {
		clickOn("pictures\\GoogleService_GoogleCalendar_optionWeek.png");
		sleep(1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionDay.png", 5)) {
			clickDayFlag = true;
			setTestcaseStatus("PASSED", "#2: It is redirected to correct [Day] page");
		} else {
			clickDayFlag = false;
			setTestcaseStatus("FAILED", "#2: It NOT redirected to correct [Day] page");
		}
		sleep(2);
	}
	private void Click_Option_Week() {
		clickOn("pictures\\GoogleService_GoogleCalendar_option4Days.png");
		sleep(1);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionWeek.png", 3)) {
			clickWeekFlag = true;
			setTestcaseStatus("PASSED", "#2: It is redirected to correct [Week] page");
		} else {
			clickWeekFlag = false;
			setTestcaseStatus("FAILED", "#2: It NOT redirected to correct [Week] page");
		}
		sleep(2);
	}
	private void Click_Option_Month() {
		clickOn("pictures\\GoogleService_GoogleCalendar_optionDay.png");
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionMonth.png", 5)) {
			clickMonthFlag = true;
			setTestcaseStatus("PASSED", "#2: It is redirected to correct [Month] page");
		} else {
			clickMonthFlag = false;
			setTestcaseStatus("FAILED", "#2: It NOT redirected to correct [Month] page");	
		}
		sleep(2);
	}
	private void Click_Option_Year() {
		clickOn("pictures\\GoogleService_GoogleCalendar_optionMonth.png");
		sleep(1);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionYear.png", 5)) {
			clickYearFlag = true;
			setTestcaseStatus("PASSED", "#2: It is redirected to correct [Year] page");
		} else {
			clickYearFlag = false;
			setTestcaseStatus("FAILED", "#2: It NOT redirected to correct [Year] page");
		}
		sleep(2);
	}
	private void Click_Option_Schedule() {
		clickOn("pictures\\GoogleService_GoogleCalendar_optionYear.png");
		sleep(1);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_optionSchedule.png", 5)) {
			clickScheduleFlag = true;
			setTestcaseStatus("PASSED", "#2: It is redirected to correct [Schedule] page");
		} else {
			clickScheduleFlag = false;
			setTestcaseStatus("FAILED", "#2: It NOT redirected to correct [Schedule] page");
		}
		sleep(2);
	}
	private void Click_Option_4Days() {
		clickOn("pictures\\GoogleService_GoogleCalendar_optionSchedule.png");
		sleep(1);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		if (waitForObjectPresent("pictures\\GoogleService_GoogleCalendar_option4Days.png", 5)) {
			click4DaysFlag = true;
			setTestcaseStatus("PASSED", "#2.1: Option [4Days] is displayed");
		} else {
			click4DaysFlag = false;
			setTestcaseStatus("FAILED", "#2.1: Don't display [4Days] option ");
		}
		sleep(3);
	}
	
	private void Create_Remind() {
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 TestLogger.info("2. Create a remind on Google Calendar ");
		 TestLogger.info("-----------------------------------------------------------------------------------------------");
		 sleep(2);
		 clickOn("pictures\\Website_GoogleCalendar_button_CreateRemind.png");
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
			 		+ "- User can create a Remind successfully on Google Calendar page");
		 } else {
			 setTestcaseStatus("FAILED", "GoogleServices_GoogleCalendar_02:\n"
			 		+ "- User can NOT create a Remind successfully on Google Calendar page"); 
		 }
		 sleep(3);
	}
	private void Edit_Remind() {
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
	}
	private void Delete_Remind() {
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
		TestLogger.info("1. Open link [https://calendar.google.com/calendar]");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		Open_CocCoc_Browser_From_Desktop();
		Check_Login_Gmail_Account("coccoc.test003@gmail.com", "browsertest003");
		openLink("https://calendar.google.com/calendar/?hl=vi");
		waitForObjectPresent("pictures\\Browser_Notifications_popup_AllowBlockNotifyEN.png", 10);
		sleep(1);
		clickOn("pictures\\Browser_Notifications_button_BlockNotifyEN.png");
		sleep(1);
		if (waitForObjectPresent("pictures\\Website_GoogleCalendar_logo_GoogleCalendarVN.png", 5) 
				&& (waitForObjectPresent("pictures\\Website_GoogleCalendar_button_CreateRemind.png", 5))){
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("Showed logo Google Calendar and avatar of user");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
		 }
		 else {
			TestLogger.info("-----------------------------------------------------------------------------------------------");
			TestLogger.info("Did NOT show logo Google Calendar and avatar of user");
			TestLogger.info("-----------------------------------------------------------------------------------------------");
		 }
		sleep(3);
		clickOn("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		TestLogger.info("2. Click on Options :  Day, Week, Month,4 days, Agenda");
		TestLogger.info("EXPECTED: #2 - User must be redirected to correct views after click on menus:\n" 
				+ "- Day\n"
				+ "- Week\n"
				+ "- Month\n"
				+ "- Year\n"
				+ "- Schedule\n"
				+ "- 4Days");
		TestLogger.info("-----------------------------------------------------------------------------------------------");
		Click_Option_Day();
		Click_Option_Month();
		Click_Option_Year();
		Click_Option_Schedule();
		Click_Option_4Days();
		Click_Option_Week();
		
		if (clickDayFlag 
				&& clickWeekFlag
				&& clickMonthFlag
				&& clickYearFlag
				&& clickScheduleFlag
				&& click4DaysFlag) {
			setTestcaseStatus("PASSED", "Google Calendar is showed logo and redirected to correct views after click on menus:\n"
					+ "- Day\n"
					+ "- Week\n"
					+ "- Month\n"
					+ "- Year\n"
					+ "- Schedule\n"
					+ "- 4Days");
		} else {
			setTestcaseStatus("FAILED", "Did NOT redirected to correct views after click on menus:\n"
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
		 openLink("https://calendar.google.com/calendar");
		 waitForObjectPresent("pictures\\GoogleService_Calendar_TextCalendarVN.png", 10);
		 Create_Remind();
		 Edit_Remind();
		 Delete_Remind();
		 sleep(3);
		//Exit browser
		 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		 sleep (2);
		 s.type("q", Key.CTRL + Key.SHIFT);
		 s.type("d", Key.WIN);
	}
}
