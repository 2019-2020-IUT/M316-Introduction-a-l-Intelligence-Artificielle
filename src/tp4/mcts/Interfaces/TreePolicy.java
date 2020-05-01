/**
 * @author Dr. Denis PALLEZ </br> 
 * {@link http://denispallez.i3s.unice.fr}
 * @version 2019-2020
 * 
 * @param <T> 
 */

package tp4.mcts.Interfaces;

import java.util.Random;

import tp4.mcts.ANaire;
import tp4.mcts.Action;
import tp4.mcts.StateInfo;

public interface TreePolicy {
	public ANaire<Action,StateInfo> selectBestStateInTree(Random rand, ANaire<Action,StateInfo> s, double explorationConstante) ;
	public Action selectBestActionFromState(Random rand, ANaire<Action,StateInfo> s, double explorationConstante) ;
}
