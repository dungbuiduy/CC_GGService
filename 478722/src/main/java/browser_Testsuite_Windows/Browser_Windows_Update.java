package browser_Testsuite_Windows;

import java.io.File;

import org.seleniumhq.jetty9.servlet.ServletTester;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_Update extends BrowserCommon {

	public Browser_Windows_Update() {
	}

	// Get environment:
//	private String userprofile = System.getenv("USERPROFILE");
//	private String localUserdata = System.getenv("LOCALAPPDATA");
//	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");
	private String versionTest = "";
	private boolean testcaseFlag = true;
	String CocCoclatestVersion = CocCocVersion[1];
	private String OmahaVersion = CocCocVersion[2];
	private String latestVersion = CocCocVersion[1];

	// @BeforeClass
	public void Browser_SMOKE_Update_00() {

		TestLogger.info(
				"=====================================================================================================");
		TestLogger.info("|      EXECUTE TEST SCRIPT FOR TEST UPDATE COC COC BROWSER FOR VERSION: " + CocCocVersion[1]
				+ "            |");
		TestLogger.info(
				"======================================================================================================");
		s.type("d", Key.WIN);
		UninstallAndClearAllData(CocCocVersion[1]);
		// Download Coccoc to local
		testcaseFlag = DownloadCCBrowser(CocCocVersion[0]);

		/*
		 * for (int i = 1; i <= countVersionUpdate; i++){ testcaseFlag = testcaseFlag &
		 * DownloadCCBrowserOnFTP(CocCocVersion[5 + i]); }
		 */

		if (!testcaseFlag)
			setTestcaseStatus("SKIPTED", "Skip to test update due cannot download coc coc browser");
	}

	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Update_01</br>
	 * <b> CaseTitle: </b>Check update browser via About us </br>
	 * <b> Steps: </b></br>
	 * "Pre-condition: Make sure that there was an old CC Browser with old Omaha
	 * (2.5.15.25) is installed on machine 1. Add hosts of Dev environment 2. Open
	 * Browser 3. Go to Menu, open About Us/Giới thiệu về Cốc Cốc -> relaunch
	 * browser 4. Go to folder path:
	 * C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\Application
	 * 5.Go to Update folder:
	 * C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Update" <b>
	 * 
	 * "1. Add hosts of Dev environment 2. Open old version of Browser 3. Go to
	 * Menu, open About Us/Giới thiệu về Cốc Cốc -> relaunch browser 4. Go to folder
	 * path:
	 * C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\Application 5.
	 * Go to Update folder:
	 * C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Update"
	 * 
	 * 
	 * ExpectedOutput: </b></br>
	 * "3. Update process run normally (without error). After relauching, new
	 * correct version of Browser is displayed. 4. In install folder, display: +
	 * sub-folder named current version (after updating) + file browser.exe +
	 * Dictionaries folder + SetupMetrics folder + VisualElementsManifest.xml file
	 * 5. Because there is updated Omaha now, it contains: - Folder of old
	 * Omaha_version: No file inside - Folder of latest Omaha version: new files
	 * added"
	 *
	 * @author nhung.nguyen
	 * @date 17/11/2017
	 * 
	 */

	@Test(groups = { "execute" })
	public void Browser_SMOKE_Update_01() {
		TestLogger.info(
				"===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Update_01: Check update browser via About us ");
		killprocess("browser.exe");
		killprocess("CocCocCrashHandler.exe");
		killprocess("delegate_execute.exe");
		killprocess("CocCocUpdate.exe");
		int count;
		String olderCocCocVersion = "";
		String message = "";
		boolean isCocCocUpdateSuccess = true;
		String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
		System.out.println("leght: "+countOldVersionBrowser);
		for (count = 0; count < countOldVersionBrowser; count++) {
			// olderCocCocVersion = CocCocVersion[5];
			olderCocCocVersion = CocCocVersion[(5 + count)];
			TestLogger.info("Test Coc Coc update for version: " + olderCocCocVersion);
			TestLogger.info("==============================================================");
			// Add hosts of Dev environment
			TestLogger.info("Change host to dev");
			changeHoststoDev();
			s.type("m", Key.WIN);
			// Step 1: install old version
			// Uninstall old browser if any and clean all data
			TestLogger.info("Uninstall CC new and clear all data");
			UninstallAndClearAllData(CocCocVersion[1]);
			String olderVersionPath = userprofile + "\\Downloads\\" + olderCocCocVersion + "\\coccoc_vi.exe";
			if (testcaseFlag) {
				TestLogger.info("Install CC with version old");
				if (InstallCoccocWithDefaultOption(olderVersionPath)) {
					// Step 2: goto menu -> About us -> Check version is latest, no warning appears
					TestLogger.info("Check update process for about us");
					if (checkCoccocUpdateProcess(olderCocCocVersion, latestVersion, OmahaVersion)) {

						isCocCocUpdateSuccess = true;
						TestLogger.info("-----------------------------PASSED UPDATE FOR " + olderCocCocVersion
								+ " -------------------------------------");
						setTestcaseStatus("PASSED", "Update Coc Coc from "+olderCocCocVersion+"  version success");
					} else {
						captureSnapshot(homePath, "ScreenShotforUpdateFailed", 1);
						message = message + "\n -> Update Coc Coc from version " + olderCocCocVersion + " to version "
								+ CocCocVersion[1] + " Failed\n-------------";
						isCocCocUpdateSuccess = false;
						setTestcaseStatus("FAILED", "Can not update Coc Coc from "+olderCocCocVersion+"  version success");
					}
				} else {
					isCocCocUpdateSuccess = false;
//					setTestcaseStatus("SKIP", "Download Coc Coc failed, Stop to test.");
					if (waitForObjectPresent("pictures\\noInternet.png", 10)) {
						setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Update_01: lost connect internet");
					} else {
						setTestcaseStatus("FAILED", "Browser_SMOKE_Update_01: Coc Coc install unsuccessful");
					}
				}
			}
		}
		
		if (isCocCocUpdateSuccess) {
			TestLogger.info("-----------------------------PASSED UPDATE FOR " + olderCocCocVersion+ " -------------------------------------");
			setTestcaseStatus("PASSED", "Update Coc Coc from all old verrsions version success");
		} else {
			TestLogger.info("-----------------------------FAILED UPDATE FOR " + olderCocCocVersion+ " -------------------------------------");
			setTestcaseStatus("FAILED","Update Coc Coc from some old verrsions version unsuccess due" + message);
		}

	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Update_03</br>
	 * <b> CaseTitle: </b>Check binary files in browser folder after update vs
	 * binary files from fresh installer</br>
	 * <b> Steps: </b></br>
	 * 1. Update successfully (followed steps in sheet #Test Environment)</br>
	 * 2. Go to folder path:</br>
	 * C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\Application
	 * </br>
	 * => Copy and save following files/folders:</br>
	 * + folder has folder name as latest version which has been updated</br>
	 * + file: browser.exe, first run, VisualElementsManifest</br>
	 * + folder: Dictionaries (if update version has this extension)</br>
	 * 3. Install from fresh installer latest version, copy and save files/folders
	 * as step 2 after install</br>
	 * 4. Open tool Total Commander> From menu bar>Commands>Synchronize dirs...</br>
	 * => select target 2 folders including 2 copies in 2 steps above to
	 * compare</br>
	 * <b> Expected Output: </b></br>
	 * + 2 these folders must be the same about name, number of files, file content
	 * (exclude date time difference)</br>
	 * + Upgrade version has more file old_browser.exe</br>
	 * 
	 * @author loandtt
	 * @date 2-JUNE-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Update_03() {
		TestLogger.info(
				"===============================================================================================================");
		TestLogger.info(
				"Run Browser_SMOKE_Update_03: Check binary files in browser folder after update vs binary files from fresh installer");

		int count;
		String coccocFolder = localUserdata + "\\CocCoc\\Browser\\Application\\";
		String CocCoclatestVersion = CocCocVersion[1];
		File srcFolder = new File(coccocFolder + CocCoclatestVersion);
		String coccocSetupLocation = userprofile + "\\Downloads\\coccoc_vi.exe";
		boolean isFoldersCorrect = true;
		File destFolder;
		String olderCocCocVersion;

		// Step 1: Continue testcase Update_01: Do this step on testcase 01
		// Step 2: Copied file and folder of latest version on test case #01
		// Step 3: install latest cc version and compare files

		UninstallAndClearAllData(CocCocVersion[1]);
		sleep(3);
		if (InstallCoccocWithDefaultOption(coccocSetupLocation)) {
			for (count = 0; count < countOldVersionBrowser; count++) {
				olderCocCocVersion = CocCocVersion[5 + count];
				// if (versionTest.contains(olderCocCocVersion)) {
				TestLogger.info(
						"--- Check these folders must be the same about name, number of files, file content for update from version: "
								+ olderCocCocVersion);

				// Step 3: Make sure files and folders on steps 2 are same, file older_version
				// not exist
				// destFolder = new File("C:\\tmp\\" + "\\" + olderCocCocVersion + "\\" +
				// CocCoclatestVersion);
				destFolder = new File("C:\\tmp\\" + olderCocCocVersion + "\\" + CocCoclatestVersion);
				try {
					TestLogger.info("\t --->Compare all file between 2 folders .....");
					if (getDiff(srcFolder, destFolder, true)) {
						File f = new File(localUserdata + "\\CocCoc\\Browser\\Application\\old_browser.exe");
						if (!f.exists()) {
							TestLogger.info(
									"\t\t ->> All files and folders are same name, number of file, file contains");
							isFoldersCorrect = true;
						} else {
							TestLogger.warn("The file old_browser.exe still exist");
							isFoldersCorrect = false;
						}
					} else {
						isFoldersCorrect = false;
						TestLogger.warn("Some file or Folders not match");
					}
				} catch (Exception e) {
					isFoldersCorrect = false;
					TestLogger.warn("Some error occour! Pls check testscrit!!!!");
				}
				// } else
				// TestLogger.warn("Do not test file for version " + olderCocCocVersion + " due
				// update failed!");
			}
			if (isFoldersCorrect)
				setTestcaseStatus("PASSED", "All file and folder same about name, number of file and file contains");
			else
				setTestcaseStatus("FAILED", "Some thing not correct, pls check log for more details");
		} else
			setTestcaseStatus("SKIP", "Cannot install Coc Coc browser, Skip this testcase.");
	}

}