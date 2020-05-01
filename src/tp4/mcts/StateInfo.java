/**
 * @author Dr. Denis PALLEZ </br> 
 * {@link http://denispallez.i3s.unice.fr}
 * @version 2019-2020
 * 
 * @param <T> 
 */


package tp4.mcts;

public class StateInfo {
	private State currentState;
	private int numberOfVisits;
	private double reward ;
	private boolean fullyExpanded ;
	
	public StateInfo(State s) {
		this.currentState = s ;
	}

	public State getState() {
		return currentState;
	}

	public int getNumberOfVisits() {
		return numberOfVisits;
	}

	public void setNumberOfVisits(int numberOfVisits) {
		this.numberOfVisits = numberOfVisits;
	}

	public double getReward() {
		return reward;
	}
	
	public void setReward(double reward) {
		this.reward=reward;
	}
	
	public boolean isFullyExpanded() {
		return fullyExpanded;
	}
	
	public void setFullyExpanded(boolean expanded) {
		this.fullyExpanded = expanded ;
	}
	
	
	@Override
	public String toString( ) {
		String chaine="" ;
		chaine+=currentState+"\n"+reward+"/"+numberOfVisits ;
//		chaine+="\nPlay:"+ s.getCurrentPlayer() ;
		return chaine ;
	}
}
