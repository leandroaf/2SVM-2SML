package Twosml.twosml.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class TwoSMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLNodeDescriptor> getSemanticChildren(
			View view) {
		switch (Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getVisualID(view)) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			return getControlSchema_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLNodeDescriptor> getControlSchema_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Twosml.twosml.ControlSchema modelElement = (Twosml.twosml.ControlSchema) view
				.getElement();
		LinkedList<Twosml.twosml.diagram.part.TwoSMLNodeDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLNodeDescriptor>();
		{
			Twosml.twosml.SmartSpace childElement = modelElement
					.getHasSmartSpace();
			int visualID = Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID) {
				result.add(new Twosml.twosml.diagram.part.TwoSMLNodeDescriptor(
						childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getHasUbiquitousApplication()
				.iterator(); it.hasNext();) {
			Twosml.twosml.UbiquitousApplication childElement = (Twosml.twosml.UbiquitousApplication) it
					.next();
			int visualID = Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID) {
				result.add(new Twosml.twosml.diagram.part.TwoSMLNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getHasPhysicalSpace().iterator(); it
				.hasNext();) {
			Twosml.twosml.PhysicalSpace childElement = (Twosml.twosml.PhysicalSpace) it
					.next();
			int visualID = Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID) {
				result.add(new Twosml.twosml.diagram.part.TwoSMLNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getContainedLinks(
			View view) {
		switch (Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getVisualID(view)) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			return getControlSchema_1000ContainedLinks(view);
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
			return getSmartSpace_2005ContainedLinks(view);
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
			return getUbiquitousApplication_2006ContainedLinks(view);
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			return getPhysicalSpace_2007ContainedLinks(view);
		case Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID:
			return getHosts_4001ContainedLinks(view);
		case Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID:
			return getConsistsOf_4002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getIncomingLinks(
			View view) {
		switch (Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getVisualID(view)) {
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
			return getSmartSpace_2005IncomingLinks(view);
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
			return getUbiquitousApplication_2006IncomingLinks(view);
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			return getPhysicalSpace_2007IncomingLinks(view);
		case Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID:
			return getHosts_4001IncomingLinks(view);
		case Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID:
			return getConsistsOf_4002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getVisualID(view)) {
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
			return getSmartSpace_2005OutgoingLinks(view);
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
			return getUbiquitousApplication_2006OutgoingLinks(view);
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			return getPhysicalSpace_2007OutgoingLinks(view);
		case Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID:
			return getHosts_4001OutgoingLinks(view);
		case Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID:
			return getConsistsOf_4002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getControlSchema_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getSmartSpace_2005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getUbiquitousApplication_2006ContainedLinks(
			View view) {
		Twosml.twosml.UbiquitousApplication modelElement = (Twosml.twosml.UbiquitousApplication) view
				.getElement();
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Hosts_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getPhysicalSpace_2007ContainedLinks(
			View view) {
		Twosml.twosml.PhysicalSpace modelElement = (Twosml.twosml.PhysicalSpace) view
				.getElement();
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ConsistsOf_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getHosts_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getConsistsOf_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getSmartSpace_2005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getUbiquitousApplication_2006IncomingLinks(
			View view) {
		Twosml.twosml.UbiquitousApplication modelElement = (Twosml.twosml.UbiquitousApplication) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Hosts_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getPhysicalSpace_2007IncomingLinks(
			View view) {
		Twosml.twosml.PhysicalSpace modelElement = (Twosml.twosml.PhysicalSpace) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ConsistsOf_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getHosts_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getConsistsOf_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getSmartSpace_2005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getUbiquitousApplication_2006OutgoingLinks(
			View view) {
		Twosml.twosml.UbiquitousApplication modelElement = (Twosml.twosml.UbiquitousApplication) view
				.getElement();
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Hosts_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getPhysicalSpace_2007OutgoingLinks(
			View view) {
		Twosml.twosml.PhysicalSpace modelElement = (Twosml.twosml.PhysicalSpace) view
				.getElement();
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ConsistsOf_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getHosts_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getConsistsOf_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getContainedTypeModelFacetLinks_Hosts_4001(
			Twosml.twosml.UbiquitousApplication container) {
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		Twosml.twosml.Hosts link = container.getEReference3();
		if (Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID != Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getLinkWithClassVisualID(link)) {
			return result;
		}
		List targets = link.getTarget();
		Object theTarget = targets.size() == 1 ? targets.get(0) : null;
		if (false == theTarget instanceof Twosml.twosml.UbiquitousApplication) {
			return result;
		}
		Twosml.twosml.UbiquitousApplication dst = (Twosml.twosml.UbiquitousApplication) theTarget;
		result.add(new Twosml.twosml.diagram.part.TwoSMLLinkDescriptor(
				container, dst, link,
				Twosml.twosml.diagram.providers.TwoSMLElementTypes.Hosts_4001,
				Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getContainedTypeModelFacetLinks_ConsistsOf_4002(
			Twosml.twosml.PhysicalSpace container) {
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		Twosml.twosml.ConsistsOf link = container.getPSpaceCO();
		if (Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID != Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getLinkWithClassVisualID(link)) {
			return result;
		}
		List targets = link.getTargetPS();
		Object theTarget = targets.size() == 1 ? targets.get(0) : null;
		if (false == theTarget instanceof Twosml.twosml.PhysicalSpace) {
			return result;
		}
		Twosml.twosml.PhysicalSpace dst = (Twosml.twosml.PhysicalSpace) theTarget;
		result.add(new Twosml.twosml.diagram.part.TwoSMLLinkDescriptor(
				container,
				dst,
				link,
				Twosml.twosml.diagram.providers.TwoSMLElementTypes.ConsistsOf_4002,
				Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getIncomingTypeModelFacetLinks_Hosts_4001(
			Twosml.twosml.UbiquitousApplication target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != Twosml.twosml.TwosmlPackage.eINSTANCE
					.getHosts_Target()
					|| false == setting.getEObject() instanceof Twosml.twosml.Hosts) {
				continue;
			}
			Twosml.twosml.Hosts link = (Twosml.twosml.Hosts) setting
					.getEObject();
			if (Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID != Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Twosml.twosml.UbiquitousApplication) {
				continue;
			}
			Twosml.twosml.UbiquitousApplication container = (Twosml.twosml.UbiquitousApplication) link
					.eContainer();
			result.add(new Twosml.twosml.diagram.part.TwoSMLLinkDescriptor(
					container,
					target,
					link,
					Twosml.twosml.diagram.providers.TwoSMLElementTypes.Hosts_4001,
					Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getIncomingTypeModelFacetLinks_ConsistsOf_4002(
			Twosml.twosml.PhysicalSpace target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> result = new LinkedList<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != Twosml.twosml.TwosmlPackage.eINSTANCE
					.getConsistsOf_TargetPS()
					|| false == setting.getEObject() instanceof Twosml.twosml.ConsistsOf) {
				continue;
			}
			Twosml.twosml.ConsistsOf link = (Twosml.twosml.ConsistsOf) setting
					.getEObject();
			if (Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID != Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Twosml.twosml.PhysicalSpace) {
				continue;
			}
			Twosml.twosml.PhysicalSpace container = (Twosml.twosml.PhysicalSpace) link
					.eContainer();
			result.add(new Twosml.twosml.diagram.part.TwoSMLLinkDescriptor(
					container,
					target,
					link,
					Twosml.twosml.diagram.providers.TwoSMLElementTypes.ConsistsOf_4002,
					Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<Twosml.twosml.diagram.part.TwoSMLNodeDescriptor> getSemanticChildren(
				View view) {
			return TwoSMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getContainedLinks(
				View view) {
			return TwoSMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getIncomingLinks(
				View view) {
			return TwoSMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<Twosml.twosml.diagram.part.TwoSMLLinkDescriptor> getOutgoingLinks(
				View view) {
			return TwoSMLDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
