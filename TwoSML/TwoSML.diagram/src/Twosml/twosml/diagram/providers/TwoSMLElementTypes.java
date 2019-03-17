package Twosml.twosml.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class TwoSMLElementTypes {

	/**
	 * @generated
	 */
	private TwoSMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType ControlSchema_1000 = getElementType("TwoSML-v5.diagram.ControlSchema_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SmartSpace_2005 = getElementType("TwoSML-v5.diagram.SmartSpace_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UbiquitousApplication_2006 = getElementType("TwoSML-v5.diagram.UbiquitousApplication_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PhysicalSpace_2007 = getElementType("TwoSML-v5.diagram.PhysicalSpace_2007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Hosts_4001 = getElementType("TwoSML-v5.diagram.Hosts_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConsistsOf_4002 = getElementType("TwoSML-v5.diagram.ConsistsOf_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(ControlSchema_1000,
					Twosml.twosml.TwosmlPackage.eINSTANCE.getControlSchema());

			elements.put(SmartSpace_2005,
					Twosml.twosml.TwosmlPackage.eINSTANCE.getSmartSpace());

			elements.put(UbiquitousApplication_2006,
					Twosml.twosml.TwosmlPackage.eINSTANCE
							.getUbiquitousApplication());

			elements.put(PhysicalSpace_2007,
					Twosml.twosml.TwosmlPackage.eINSTANCE.getPhysicalSpace());

			elements.put(Hosts_4001,
					Twosml.twosml.TwosmlPackage.eINSTANCE.getHosts());

			elements.put(ConsistsOf_4002,
					Twosml.twosml.TwosmlPackage.eINSTANCE.getConsistsOf());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(ControlSchema_1000);
			KNOWN_ELEMENT_TYPES.add(SmartSpace_2005);
			KNOWN_ELEMENT_TYPES.add(UbiquitousApplication_2006);
			KNOWN_ELEMENT_TYPES.add(PhysicalSpace_2007);
			KNOWN_ELEMENT_TYPES.add(Hosts_4001);
			KNOWN_ELEMENT_TYPES.add(ConsistsOf_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			return ControlSchema_1000;
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
			return SmartSpace_2005;
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
			return UbiquitousApplication_2006;
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			return PhysicalSpace_2007;
		case Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID:
			return Hosts_4001;
		case Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID:
			return ConsistsOf_4002;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return Twosml.twosml.diagram.providers.TwoSMLElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return Twosml.twosml.diagram.providers.TwoSMLElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return Twosml.twosml.diagram.providers.TwoSMLElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
