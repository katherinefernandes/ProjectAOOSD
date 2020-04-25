package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphicalInterface.Graphs;

public class GraphController {
	private Graphs showgraph;
	
	public GraphController (String containerID) {
		  List<Float> scores = new ArrayList<Float>();
	      Random random = new Random();
	      int maxDataPoints = 16;
	      int maxScore = 20;
	      for (int i = 0; i < maxDataPoints ; i++) {
	         scores.add((float) random.nextInt(maxScore));
	      }
		
		showgraph = new Graphs(scores);
		showgraph.createAndShowGui(scores);
	}
}
