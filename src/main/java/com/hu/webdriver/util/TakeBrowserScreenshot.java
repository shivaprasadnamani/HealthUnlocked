package com.hu.webdriver.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

/**
 * Take Browser Screenshot.
 * @author Venkatesh Aarelly
 *
 */
public class TakeBrowserScreenshot {
	private final TestLogger LOG = TestLogger.getLogger(TakeBrowserScreenshot.class);
    private WebDriver driver;
    /**
	 * Screen shot directory name.
	 */
	public static final String SCREEN_SHOT_DIR_NAME = "Screenshots";

    public TakeBrowserScreenshot(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public String shoot() {
        if (null == this.driver) {
        	LOG.logError("Errror taking screen shots. WebDriver is null");
            return null;
        } else {
            try {
                this.driver = (new Augmenter()).augment(this.driver);
                String th = (String) ((TakesScreenshot) this.driver).getScreenshotAs(
                        OutputType.BASE64);
                return th;
            } catch (Throwable arg1) {
            	LOG.logError("Failed to take screen shot. Exception: \n" + arg1.getStackTrace());
                return null;
            }
        }
    }
    
	/**
	 * Take screenshot.
	 * 
	 * @param msg
	 *            the message to be logged with screen shots.
	 * @return {@link File}.
	 */
	public File takeScreenShot() {
		String base64String = null;
		try {
			base64String = shoot();
		} catch (Throwable th) {
			LOG.logError("Failed to take screenshot. Exception: \n", th);
		}
		if (StringUtils.isBlank(base64String)) {
			return null;
		}
		BufferedImage newImg = decodeToImage(base64String);
		try {
			File imgFile = saveFile(newImg);
			return imgFile;
		} catch (Throwable th) {
			LOG.logError("Unable to Take ScreenShot - Exception : \n" + th);
		}
		return null;
	}
	
	/**
	 * Decode string to image.
	 * 
	 * @param imageString
	 *            The string to decode
	 * @return decoded image
	 */
	private static BufferedImage decodeToImage(final String imageString) {
		BufferedImage image = null;
		byte[] imageByte = null;
		try {
			imageByte = DatatypeConverter.parseBase64Binary(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Method to save the screen in screenshot dir.
	 * 
	 * @param screen
	 *            {@link BufferedImage}.
	 * @return {@link File}.
	 */
	private File saveFile(final BufferedImage screen) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File imgFile = new File(SCREEN_SHOT_DIR_NAME,
				fileName + formatter.format(calendar.getTime()) + "-" + Long.toString(Thread.currentThread().getId())
						+ "-" + java.util.UUID.randomUUID().toString() + ".png");
		try {
			ImageIO.write(screen, "png", imgFile);
		} catch (IOException e) {
			LOG.logError("Error writing screenshot to file.\nException: " + e, new Object[0]);
		}
		if (!imgFile.exists()) {
			LOG.logError("Error in taking screenshot");
		}

		return imgFile;

	}
}
