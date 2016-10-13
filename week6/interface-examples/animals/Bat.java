package animals;

public class Bat extends Mammal {

	@Override
	public boolean canSwim() {
		return false;
	}
	
	@Override
	public boolean canFly() {
		return true;
	}
	
	
}
