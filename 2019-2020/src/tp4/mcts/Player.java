/**
 * @author Dr. Denis PALLEZ </br> 
 * {@link http://denispallez.i3s.unice.fr}
 * @version 2019-2020
 * 
 * @param <T> 
 */

package tp4.mcts;

public enum Player {
	p1, p2 ;
	
	public Player getOpponent() {
		int opponent = (this.ordinal() + 1) % 2 ; 
		return (Player.values())[opponent] ;
	}
	
	public int toInteger() {
		return this.ordinal() +1 ;
	}
}
