package Twosml.twosml.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class TwoSMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "TwoSML-v5.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.MODEL_ID
					.equals(view.getType())) {
				return Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin
						.getInstance().logError(
								"Unable to parse view type as a visualID number: "
										+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (Twosml.twosml.TwosmlPackage.eINSTANCE.getControlSchema()
				.isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Twosml.twosml.ControlSchema) domainElement)) {
			return Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getModelID(containerView);
		if (!Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.MODEL_ID
				.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			if (Twosml.twosml.TwosmlPackage.eINSTANCE.getSmartSpace()
					.isSuperTypeOf(domainElement.eClass())) {
				return Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID;
			}
			if (Twosml.twosml.TwosmlPackage.eINSTANCE
					.getUbiquitousApplication().isSuperTypeOf(
							domainElement.eClass())) {
				return Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID;
			}
			if (Twosml.twosml.TwosmlPackage.eINSTANCE.getPhysicalSpace()
					.isSuperTypeOf(domainElement.eClass())) {
				return Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getModelID(containerView);
		if (!Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.MODEL_ID
				.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			if (Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
			if (Twosml.twosml.diagram.edit.parts.SmartSpaceSSpaceIDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
			if (Twosml.twosml.diagram.edit.parts.UbiquitousApplicationUbiAppIDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			if (Twosml.twosml.diagram.edit.parts.PhysicalSpacePSpaceIDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (Twosml.twosml.TwosmlPackage.eINSTANCE.getHosts().isSuperTypeOf(
				domainElement.eClass())) {
			return Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID;
		}
		if (Twosml.twosml.TwosmlPackage.eINSTANCE.getConsistsOf()
				.isSuperTypeOf(domainElement.eClass())) {
			return Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Twosml.twosml.ControlSchema element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			return false;
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
