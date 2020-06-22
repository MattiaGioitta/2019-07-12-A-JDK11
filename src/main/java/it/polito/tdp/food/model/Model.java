package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private Map<Integer, Food> idMap;
	private FoodDao dao;
	private Graph<Food, DefaultWeightedEdge> graph;
	
	public Model() {
		this.dao = new FoodDao();
	}
	
	public void createGraph(Integer portionNum) {
		//i create the graph
		this.graph = new SimpleWeightedGraph<Food,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		this.idMap = new HashMap<>();
		this.dao.listAllFoods(this.idMap);
		//insert vertexes
		Graphs.addAllVertices(this.graph, this.dao.getAllFoods(idMap, portionNum));
		List<Adiacenze> adiacenze = this.dao.getAdiacenze(this.idMap,this.dao.getAllFoods(idMap, portionNum));
		for(Adiacenze a : adiacenze) {
			if(this.graph.getEdge(a.getF1(), a.getF2()) == null)
				Graphs.addEdgeWithVertices(this.graph, a.getF1(), a.getF2(), a.getAvg());
		}
		System.out.println(adiacenze);
	}

	
	public Integer numVertex() {
		return this.graph.vertexSet().size();
	}
	public Integer numEdges() {
		return this.graph.edgeSet().size();
		}
	public List<Food> getFoods(){
		List<Food> list = new ArrayList<>();
		for(DefaultWeightedEdge f : this.graph.edgeSet()) {
			if(!list.contains(this.graph.getEdgeSource(f)))
				list.add(this.graph.getEdgeSource(f));
			if(!list.contains(this.graph.getEdgeTarget(f)))
				list.add(this.graph.getEdgeTarget(f));
		}
		Collections.sort(list);
		return list;
	}
	public List<Vicino> getVicino(Food f){
		List<Vicino> vicini = new ArrayList<>();
		for(Food e : Graphs.neighborListOf(this.graph, f)) {
			double peso = this.graph.getEdgeWeight(this.graph.getEdge(f, e));
			vicini.add(new Vicino(e,peso));
		}
		Collections.sort(vicini);
		if(vicini.size()<=5)
			return vicini;
		else {
			List<Vicino> l = new ArrayList<>();		
			for(int i = 0;i<5;i++) {
				l.add(vicini.get(i));
			}
			return l;
		}
		
		}
}

