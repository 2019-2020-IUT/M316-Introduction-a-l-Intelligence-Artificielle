/**
 * @author Dr. Denis PALLEZ </br> 
 * {@link http://denispallez.i3s.unice.fr}
 * @version 2019-2020
 * 
 * @param <T> 
 */


package tp4.mcts.Interfaces;

import java.util.LinkedList;
import java.util.Random;

import tp4.mcts.ANaire;
import tp4.mcts.Action;
import tp4.mcts.Player;
import tp4.mcts.State;
import tp4.mcts.StateInfo;

public class RandomPolicy implements DefaultPolicy {
	LinkedList<Action> actions ;
	Random rand ;
	
	public RandomPolicy(Random r) {
		rand = r ;
	}
	
	@Override
	public double doSimulation(State s, Player p) {
		actions = new LinkedList<Action>() ;
		while (!s.isTerminal()) {
			LinkedList<Action> possibleActions = s.getPossibleActions() ;
			int numAction = rand.nextInt(possibleActions.size()) ;
			Action action = possibleActions.get(numAction) ;
			actions.add(action) ;
			s=s.takeAction(action) ;
		}
		double reward  = s.getReward(p);
		return reward ;
	}

	@Override
	public LinkedList<Action> getActions() {
		return actions ; 
	}
	
}
