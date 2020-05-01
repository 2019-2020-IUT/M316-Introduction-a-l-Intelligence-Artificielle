/**
 * @author Dr. Denis PALLEZ </br> 
 * {@link http://denispallez.i3s.unice.fr}
 * @version 2019-2020
 * 
 * @param <T> 
 */


package tp4.mcts;

import java.util.LinkedList;

public abstract class State {
	private Player currentPlayer;
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public abstract LinkedList<Action> getPossibleActions() ;
	public abstract State takeAction(Action a) ;
	public abstract boolean isTerminal() ;
	public abstract double getReward(Player p) ;
}
