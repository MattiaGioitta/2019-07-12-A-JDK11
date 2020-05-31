package it.polito.tdp.food.model;

public class testModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model m = new Model();
		m.createGraph(5);
		System.out.println(m.numVertex());
		System.out.println(m.numEdges());
	
	
	}

}
