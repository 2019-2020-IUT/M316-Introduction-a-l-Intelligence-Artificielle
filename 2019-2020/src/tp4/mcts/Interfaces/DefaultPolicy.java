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

public interface DefaultPolicy {
	public double doSimulation(State s, Player p);
	public LinkedList<Action> getActions();
}
