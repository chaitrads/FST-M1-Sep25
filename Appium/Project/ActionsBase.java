package activities;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {

	// Set the pointer input type
	static final PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {

		// Create the sequence of actions to perform a swipe
		Sequence swipe = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
				.addAction(finger.createPointerDown(LEFT.asArg())). // 0 means left click
				addAction(finger.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
				.addAction(finger.createPointerUp(0));

		// perform the sequence
		driver.perform(Arrays.asList(swipe));

	}

	public static void doTap(AppiumDriver driver, Point start) {

		// Create the sequence of actions to perform a swipe
		Sequence tap = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
				.addAction(finger.createPointerDown(LEFT.asArg())). // 0 means left click
				addAction(new Pause(finger, Duration.ofMillis(80))).addAction(finger.createPointerUp(0));

		// perform the sequence
		driver.perform(Arrays.asList(tap));

	}
	
	public static void longPress(AppiumDriver driver, Point start) {
		//create the long press action
		Sequence press =  new Sequence(finger, 1)
				.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
				.addAction(finger.createPointerDown(LEFT.asArg())). // 0 means left click
				addAction(new Pause(finger, Duration.ofMillis(800))).addAction(finger.createPointerUp(0));
		
		//perform the sequence
		driver.perform(Arrays.asList(press));
		
	}

}
