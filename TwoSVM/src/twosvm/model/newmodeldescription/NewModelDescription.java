package twosvm.model.newmodeldescription;

import java.util.ArrayList;

/**
 * Esta classe contem duas listas com os elementos que ser adicionados ao espaco
 * inteligente e uma lista com aqules que devem ser removidos
 * A partir destas listas, novos scripts deverao ser criados
 * @author leandroalexandre
 *
 */
public class NewModelDescription {
	
	private ArrayList<String> elementsToBeAddeds = new ArrayList<String>();
	private ArrayList<String> elementsToBeRemoveds = new ArrayList<String>();
	private ArrayList<String> elementsToBeMaintained = new ArrayList<String>();
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getElementsToBeAddeds() {
		return elementsToBeAddeds;
	}
	
	/**
	 * 
	 * @param elementsToBeAddeds
	 */
	public void setElementsToBeAddeds(ArrayList<String> elementsToBeAddeds) {
		this.elementsToBeAddeds = elementsToBeAddeds;
	}
	
	/**
	 * 
	 * @param elementToBeAdded
	 */
	public void setElementsToBeAdded(String elementToBeAdded) {
		this.elementsToBeAddeds.add(elementToBeAdded);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getElementsToBeRemoveds() {
		return elementsToBeRemoveds;
	}
	
	/**
	 * 
	 * @param elementsToBeRemoveds
	 */
	public void setElementsToBeRemoveds(ArrayList<String> elementsToBeRemoveds) {
		this.elementsToBeRemoveds = elementsToBeRemoveds;
	}
	
	/**
	 * 
	 * @param elementsToBeRemoved
	 */
	public void setElementsToBeRemoved(String elementsToBeRemoved) {
		this.elementsToBeRemoveds.add(elementsToBeRemoved);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getElementsToBeMaintained() {
		return elementsToBeMaintained;
	}

	/**
	 * 
	 * @param elementsToBeMaintained
	 */
	public void setElementsToBeMaintained(ArrayList<String> elementsToBeMaintained) {
		this.elementsToBeMaintained = elementsToBeMaintained;
	}
	
	/**
	 * 
	 * @param elementToBeMaintained
	 */
	public void setElementToBeMaintained(String elementToBeMaintained) {
		this.elementsToBeMaintained.add(elementToBeMaintained);
	}

	@Override
	public String toString() {
		return "NewModelDescription [elementsToBeAddeds=" + elementsToBeAddeds
				+ ", elementsToBeRemoveds=" + elementsToBeRemoveds
				+ ", elementsToBeMaintained=" + elementsToBeMaintained + "]";
	}

}
