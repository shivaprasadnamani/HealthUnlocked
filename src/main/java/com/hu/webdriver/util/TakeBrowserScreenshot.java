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
	/**
	 * Screen shot directory name.
	 */
	public static final String SCREEN_SHOT_DIR_NAME = "Screenshots";
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
			final ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	private WebDriver driver;

	private final TestLogger LOG = TestLogger.getLogger(TakeBrowserScreenshot.class);

	public TakeBrowserScreenshot(WebDriver webDriver) {
		this.driver = webDriver;
	}

	/**
	 * Method to save the screen in screenshot dir.
	 *
	 * @param screen
	 *            {@link BufferedImage}.
	 * @return {@link File}.
	 */
	private File saveFile(final BufferedImage screen) {
		final String fileName = "";
		final Calendar calendar = Calendar.getInstance();
		final SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		final File imgFile = new File(SCREEN_SHOT_DIR_NAME,
				fileName + formatter.format(calendar.getTime()) + "-" + Long.toString(Thread.currentThread().getId())
				+ "-" + java.util.UUID.randomUUID().toString() + ".png");
		try {
			ImageIO.write(screen, "png", imgFile);
		} catch (final IOException e) {
			LOG.logError("Error writing screenshot to file.\nException: " + e, new Object[0]);
		}
		if (!imgFile.exists()) {
			LOG.logError("Error in taking screenshot");
		}

		return imgFile;

	}

	public String shoot() {
		if (null == this.driver) {
			LOG.logError("Errror taking screen shots. WebDriver is null");
			return null;
		} else {
			try {
				this.driver = (new Augmenter()).augment(this.driver);
				final String th = (String) ((TakesScreenshot) this.driver).getScreenshotAs(
						OutputType.BASE64);
				return th;
			} catch (final Throwable arg1) {
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
		} catch (final Throwable th) {
			LOG.logError("Failed to take screenshot. Exception: \n", th);
		}
		if (StringUtils.isBlank(base64String)) {
			return null;
		}
		final BufferedImage newImg = decodeToImage(base64String);
		try {
			final File imgFile = saveFile(newImg);
			return imgFile;
		} catch (final Throwable th) {
			LOG.logError("Unable to Take ScreenShot - Exception : \n" + th);
		}
		return null;
	}
}
