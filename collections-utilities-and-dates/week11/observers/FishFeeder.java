package observers;
import java.util.Date;
import java.util.Observable;

public class FishFeeder extends Observable {

	public void feedTheFish(int quantityOfFood) {
		
		FishFeederMessage message = new FishFeederMessage();
		message.quantityOfFood = quantityOfFood;
		
		setChanged();
		notifyObservers(message);
	}
	
	public void turnOnLight(Date dateLightOn) {
		FishFeederMessage message = new FishFeederMessage();
		message.dateLightOn = dateLightOn;
		
		setChanged();
		notifyObservers(message);
	}
	
	
}
