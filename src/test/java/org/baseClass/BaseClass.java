package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static  WebDriver driver;

	public static Select select;

	public static Actions actions;

	public static TakesScreenshot ts;

	public void getBrowser(String browserType) {
		try {
			switch (browserType) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("Enter the valid browser");
				break;
			}

		} catch (Exception e) {

		}

	}

	public void winMax() {
		driver.manage().window().maximize();

	}

	public void launchURL(String url) {
		driver.manage().window().maximize();
		driver.get(url);

	}

	public   void sendKeysByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	public void sendKeysByJSE(String keysToSend, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);

	}

	public void clickByJava(WebElement element) {
		element.click();
	}

	public void clickByJSE(WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);

	}

	public void navigations(String commands) {
		switch (commands) {
		case "Refresh":
			driver.navigate().refresh();
			break;
		case "Forward":
			driver.navigate().forward();
			break;
		case "Backward":
			driver.navigate().back();
			break;

		default:
			break;
		}
	}

	public void clear(WebElement element) {
		element.clear();

	}

	public void alertHandling(String commands) {
		try {
			switch (commands) {
			case "accept":
				driver.switchTo().alert().accept();

				break;
			case "dismiss":
				driver.switchTo().alert().dismiss();

			default:

				break;
			}

		} catch (Exception e) {
			System.out.println("Value should be either accept or dismiss");
		}

	}

	public void selectBy(String type, WebElement element, String value) {
		select = new Select(element);
		try {
			switch (type) {
			case "value":
				select.selectByValue(value);
				break;
			case "text":
				select.selectByVisibleText(value);
				break;

			default:
				System.out.println("Enter the correct value");
				break;
			}

		} catch (Exception e) {

		}
	}

	public void selectByIndex(int index, WebElement element) {
		select = new Select(element);
		try {
			select.selectByIndex(index);

		} catch (Exception e) {

		}
	}

	public void promptAlert(String keysToSend, String commands) {
		driver.switchTo().alert().sendKeys(keysToSend);
		try {
			switch (commands) {
			case "accept":
				driver.switchTo().alert().accept();

				break;
			case "dismiss":
				driver.switchTo().alert().dismiss();

			default:

				break;
			}

		} catch (Exception e) {
			System.out.println("Value should be either accept or dismiss");
		}

	}

	public void mouseHoverActions(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void dragAndDropActions(WebElement src, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(src, target).build().perform();

	}

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void doubleClick() {
		actions = new Actions(driver);
		actions.doubleClick().build().perform();

	}

	public void enterByAction() {
		actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();

	}

	public void clickByActions(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

	public void screenCapture() throws IOException {
		try {
			ts = (TakesScreenshot) driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("target\\" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(sourceFile, targetFile);

		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void takeScreenShot(String refName) {
		ts = (TakesScreenshot) driver;
		try {
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("target\\" + refName + "_" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(sourceFile, targetFile);

		} catch (Exception e) {

		}

	}

	public void windowsHandling(int requiredWindowIndex) {
		try {
			String currentWindowID = driver.getWindowHandle();
			Set<String> allWindowID = driver.getWindowHandles();
			List<String> list = new LinkedList();
			list.addAll(allWindowID);
			String requiredWindowID = list.get(requiredWindowIndex);
			System.out.println(requiredWindowID);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String getWindowsHandleID(int requiredWindowsIndex) {
		String requiredWindowId = null;
		try {
			String currentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			List<String> list = new LinkedList();
			list.addAll(allWindows);
			requiredWindowId = list.get(requiredWindowsIndex);

		} catch (Exception e) {

		}
		return requiredWindowId;
	}

	public void switchToWindow(String id) {
		driver.switchTo().window(id);
	}

	public String getText(WebElement element) {

		return element.getText();

	}

	public String getDataFromExcelSheet(String sheetName, int rownum, int cellnum) throws IOException {
		String requiredDatasfromExcel = null;
		try {

			// create the file and add the location of the excel folder
			File file = new File("C:\\Users\\user\\eclipse-workspace\\SampleProject\\DataBase\\Book1.xlsx");

			// to get the input data file from the location

			FileInputStream fileInputStream = new FileInputStream(file);
			// to define the workbook
			Workbook book = new XSSFWorkbook(fileInputStream);
			// to get the sheet
			Sheet sheet = book.getSheet(sheetName);
			
			// to get the row
			Row row = sheet.getRow(rownum);
			
			// to get the cell
			
			Cell cell = row.getCell(cellnum);
			
			// to get cell type
			
			CellType cellType = cell.getCellType();
			

			switch (cellType) {
			case STRING:

				// To get String kind of values
				 requiredDatasfromExcel = cell.getStringCellValue();

				break;

			case NUMERIC:

				// It find Date formated values
				if (DateUtil.isCellDateFormatted(cell)) {
					// to get Date values
					Date dateCellValue = cell.getDateCellValue();

					// To arrange Date format requirements
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					requiredDatasfromExcel = simpleDateFormat.format(dateCellValue);

				} else {

					// To get Numeric cell value
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					requiredDatasfromExcel = valueOf.toString();

				}

				break;

			default:
				System.out.println("No Datas");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return requiredDatasfromExcel;

	}

}
