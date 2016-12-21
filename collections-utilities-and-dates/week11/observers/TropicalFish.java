package observers;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TropicalFish implements Observer {
	
	private String name;
	
	public TropicalFish(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(arg != null && arg instanceof FishFeederMessage) {
			FishFeederMessage message = (FishFeederMessage) arg;
			
			if(message.quantityOfFood > 0) {
				System.out.println(getName() + " is busy eating");
			}
			if(message.dateLightOn != null && 
					message.dateLightOn.before(new Date())) {
				System.out.println(getName() + " is swimming around quickly");
			}
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
