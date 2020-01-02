package poo;

public class Coche {
	private int wheels;
	private int larg;
	private int anch;
	private int engine;
	private int weight;
	
	public Coche(){
		setWheels(4);
		setLarg(2000);
		setAnch(300);
		setEngine(1600);
		setWeight(500);
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getLarg() {
		return larg;
	}

	public void setLarg(int larg) {
		this.larg = larg;
	}

	public int getAnch() {
		return anch;
	}

	public void setAnch(int anch) {
		this.anch = anch;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
