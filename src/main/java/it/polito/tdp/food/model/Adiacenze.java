package it.polito.tdp.food.model;

public class Adiacenze {

	private Food f1;
	@Override
	public String toString() {
		return "Adiacenze [f1=" + f1 + ", f2=" + f2 + ", avg=" + avg + "]";
	}
	private Food f2;
	private double avg;
	/**
	 * @param f1
	 * @param f2
	 * @param avg
	 */
	public Adiacenze(Food f1, Food f2, double avg) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.avg = avg;
	}
	/**
	 * @return the f1
	 */
	public Food getF1() {
		return f1;
	}
	/**
	 * @param f1 the f1 to set
	 */
	public void setF1(Food f1) {
		this.f1 = f1;
	}
	/**
	 * @return the f2
	 */
	public Food getF2() {
		return f2;
	}
	/**
	 * @param f2 the f2 to set
	 */
	public void setF2(Food f2) {
		this.f2 = f2;
	}
	/**
	 * @return the avg
	 */
	public double getAvg() {
		return avg;
	}
	/**
	 * @param avg the avg to set
	 */
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
