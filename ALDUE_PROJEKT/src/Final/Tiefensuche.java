package Final;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tiefensuche {
	
	  private final ArrayList<Vertex> nodes;
	  private final ArrayList<Edge> edges;
	  private final ArrayList<Vertex> visited_nodes;
	  private final ArrayList<Vertex> finished_nodes;
	  
	  public Tiefensuche(Graph graph) {
	    this.edges = new ArrayList<Edge>(graph.getEdges());
	    this.nodes = new ArrayList<Vertex>(graph.getVertexes());
	    this.visited_nodes = new ArrayList<Vertex>();
	    this.finished_nodes = new ArrayList<Vertex>();
	    nodes.size();
	  
	  }
	public LinkedList<Vertex> initialize(Vertex startvertex, Vertex endvertex, ArrayList<Edge> edge_list)
	{
		
		LinkedList<Vertex> result = new LinkedList<>();
		Vertex current = startvertex;
		
		int x = -1;
		String way = null;
		
	
		while(!current.equals(endvertex))
		{
			for (Edge edge : edges)
			{
				if(edge.getSource().equals(current))
				{
					//alle von current aus erreichbaren Knoten
					if(!finished_nodes.contains(edge.getDestination()))
					{
						if(!visited_nodes.contains(edge.getDestination()))
						{
							visited_nodes.add(edge.getDestination());
							x++;
							if(edge.getDestination().equals(endvertex))
							{
								result.add(current);
								for (Edge e : edge_list) {
									if((e.getSource().equals(current))&&e.getDestination().equals(edge.getDestination()))
									{
										way = e.getName();
									}
								}		
								result.add(new Vertex("", way));
								result.add(edge.getDestination());
								return result;
							}
						}
					}	
				}
			
			}
			if(x<0)
			{
				result.add(new Vertex("", "no path found :("));
				return result;
			}
			for (Edge e : edge_list) {
				if((e.getSource().equals(current))&&e.getDestination().equals(visited_nodes.get(x)))
				{
					way = e.getName();
				}
			}
			finished_nodes.add(current);
			result.add(current);
			result.add(new Vertex("", way));
			if(current.equals(visited_nodes.get(x))){current = visited_nodes.get(x);x--;}
					current = visited_nodes.get(x);
					x--;
	
			
		}
		return result;
	}

}



