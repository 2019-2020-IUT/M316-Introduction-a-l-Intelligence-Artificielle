package tp4.mcts;

import java.io.FileWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class implements a N-ary tree containing elements of type {@code T}.
 * Moreover, K is the type of object linking current node with one of its children. 
 * Any node has also a reference to its father (parent node). 
 * An empty tree is an instance of class {@code ANaire} where {@code value=sag=sad=null}.
 * @author Dr. Denis PALLEZ </br> 
 * {@link http://denispallez.i3s.unice.fr}
 * @version 2019-2020
 * 
 * @param <T> 
 */

public class ANaire<K,T> {
	protected T value ;
	protected LinkedHashMap<K,ANaire<K,T>> fils;
	protected ANaire<K,T> parent ;

	public ANaire() {
		value=null ;
		fils = null ;
		parent = null ;
	}
	
	public ANaire(T val, LinkedHashMap<K,ANaire<K,T>> fils) {
		value = val ;
		this.fils = fils ;
		parent=null ;
	}
	
	public ANaire(T val, ANaire<K,T> parent, LinkedHashMap<K,ANaire<K,T>> fils) {
		value = val ;
		this.fils = fils ;
		this.parent = parent ;
		for (ANaire<K,T> child:fils.values()) {
			child.setParent(this);
		}
	}
	
	public boolean isEmpty() {
		return (value==null) ;
	}
	
	public boolean isLeaf() {
		if (!isEmpty()) {
			for (ANaire<K,T> child:fils.values()) {
				if (!child.isEmpty())
					return false;
			}
			return true ;
		}
		else return false ;
	}
	
	public ANaire<K,T> getOneChild(int index) {
		return fils.get(index) ;
	}
	
	public LinkedHashMap<K,ANaire<K,T>> getChildren() {
		return fils ;
	}
	
	public int getNbChildren() {
		return fils.size() ;
	}
	
	public T getUserObject() {
		return value ;
	}
	
	public void setChildren(LinkedHashMap<K,ANaire<K,T>> children) {
		this.fils=children ;
		for (ANaire<K,T> child:fils.values()) {
			child.setParent(this);
		}
	}
	
	public void addOneChild(K key, ANaire<K,T> oneChild) {
		if (fils==null) 
			fils = new LinkedHashMap<K,ANaire<K,T>>() ;
		fils.put(key, oneChild) ;
		oneChild.setParent(this);
	}
	
	public void setValue(T val) {
		value=val ;
	}
	
	public void setParent(ANaire<K,T> p) {
		this.parent = p ;
	}
	
	public ANaire<K,T> getParent() {
		return parent ;
	}
	
	public int maxNumberOfChild() {
		if (isEmpty()||isLeaf()) {
			return 0 ;
		}
		else {
			int max = fils.size() ;
			for (ANaire<K,T> child:fils.values()) {
				max = Math.max(max, child.maxNumberOfChild()) ;
			}
			return max ;
		}
	}
	
	public boolean containsValue(T v) {
		if (isEmpty()){
			return false;
		}
		else if (getUserObject().equals(v)){
			return true ;
		}
		else {
			for (ANaire<K,T> child:fils.values()) {
				if (child.containsValue(v))
					return true ;
			}
			return false ;
		}
	}
	
	public boolean containsKey(K k) {
		if (isEmpty()){
			return false;
		}
		else return fils.containsKey(k) ;
	}
	
	@Override
	public String toString(){
		if (isEmpty()) return "vide" ;
		else {
			String s= "("+value+"," ;
			for (ANaire<K,T> child:fils.values()) {
				s+=child+",";
			}
			s+=")" ;
			return s ;
		}
	}
	
	public DefaultMutableTreeNode toNTree() {
		if (!isEmpty()) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(value.toString()) ;
			for (ANaire<K,T> child:fils.values()) {
				if (!child.isEmpty()) node.add(child.toNTree());
			}
			return node ;
		}
		else return null ;
	}
	
	public void showInFrame() {
		JFrame f= new JFrame("A Nary tree vizualized with JTree");
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		// 	Ajouter l'arbre a ce cadre
		f.getContentPane().add(new JTree(this.toNTree()));
		// Visualiser le cadre
		f.setVisible(true);
		while(true) ;
	}
}
