package observers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class FishBowlRunner {

	public static void main(String[] args) {

		List<TropicalFish> fishies = new ArrayList<TropicalFish>();
		
		fishies.add(new TropicalFish("inkly"));
		fishies.add(new TropicalFish("blinky"));
		fishies.add(new TropicalFish("slinky"));

		FishFeeder theFishFeeder = new FishFeeder();
		
		for(TropicalFish fish : fishies) {
			theFishFeeder.addObserver(fish);
		}
		
		theFishFeeder.feedTheFish(100);
		
		// let us create a calendar and set the time BACKWARDS a single minute.
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		theFishFeeder.turnOnLight(cal.getTime());
		
		
	}

}
