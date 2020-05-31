package it.polito.tdp.food.model;

public class Vicino implements Comparable<Vicino> {

	private Food f;
	private Double peso;
	/**
	 * @param f
	 * @param peso
	 */
	public Vicino(Food f, Double peso) {
		super();
		this.f = f;
		this.peso = peso;
	}
	/**
	 * @return the f
	 */
	public Food getF() {
		return f;
	}
	/**
	 * @param f the f to set
	 */
	public void setF(Food f) {
		this.f = f;
	}
	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return f.getDisplay_name() + " " + peso ;
	}
	@Override
	public int compareTo(Vicino o) {
		return -(int)(this.peso-o.getPeso());
	}
	
	
}
