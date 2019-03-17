package Twosml.twosml.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class TwoSMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem) {
			Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem item = (Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem) element;
			return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
