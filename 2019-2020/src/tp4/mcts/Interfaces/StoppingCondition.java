/**
 * @author Dr. Denis PALLEZ </br> 
 * {@link http://denispallez.i3s.unice.fr}
 * @version 2019-2020
 * 
 * @param <T> 
 */


package tp4.mcts.Interfaces;

public interface StoppingCondition {
	public void reset() ;
	public boolean canContinue() ;
}
