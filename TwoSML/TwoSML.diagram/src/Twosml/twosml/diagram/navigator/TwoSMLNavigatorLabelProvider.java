package Twosml.twosml.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class TwoSMLNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem
				&& !isOwnView(((Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof Twosml.twosml.diagram.navigator.TwoSMLNavigatorGroup) {
			Twosml.twosml.diagram.navigator.TwoSMLNavigatorGroup group = (Twosml.twosml.diagram.navigator.TwoSMLNavigatorGroup) element;
			return Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem) {
			Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem navigatorItem = (Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getVisualID(view)) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://twosml/1.0?ControlSchema", Twosml.twosml.diagram.providers.TwoSMLElementTypes.ControlSchema_1000); //$NON-NLS-1$
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://twosml/1.0?SmartSpace", Twosml.twosml.diagram.providers.TwoSMLElementTypes.SmartSpace_2005); //$NON-NLS-1$
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://twosml/1.0?UbiquitousApplication", Twosml.twosml.diagram.providers.TwoSMLElementTypes.UbiquitousApplication_2006); //$NON-NLS-1$
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://twosml/1.0?PhysicalSpace", Twosml.twosml.diagram.providers.TwoSMLElementTypes.PhysicalSpace_2007); //$NON-NLS-1$
		case Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://twosml/1.0?Hosts", Twosml.twosml.diagram.providers.TwoSMLElementTypes.Hosts_4001); //$NON-NLS-1$
		case Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://twosml/1.0?ConsistsOf", Twosml.twosml.diagram.providers.TwoSMLElementTypes.ConsistsOf_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& Twosml.twosml.diagram.providers.TwoSMLElementTypes
						.isKnownElementType(elementType)) {
			image = Twosml.twosml.diagram.providers.TwoSMLElementTypes
					.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof Twosml.twosml.diagram.navigator.TwoSMLNavigatorGroup) {
			Twosml.twosml.diagram.navigator.TwoSMLNavigatorGroup group = (Twosml.twosml.diagram.navigator.TwoSMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem) {
			Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem navigatorItem = (Twosml.twosml.diagram.navigator.TwoSMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
				.getVisualID(view)) {
		case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
			return getControlSchema_1000Text(view);
		case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
			return getSmartSpace_2005Text(view);
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
			return getUbiquitousApplication_2006Text(view);
		case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
			return getPhysicalSpace_2007Text(view);
		case Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID:
			return getHosts_4001Text(view);
		case Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID:
			return getConsistsOf_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getControlSchema_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSmartSpace_2005Text(View view) {
		IParser parser = Twosml.twosml.diagram.providers.TwoSMLParserProvider
				.getParser(
						Twosml.twosml.diagram.providers.TwoSMLElementTypes.SmartSpace_2005,
						view.getElement() != null ? view.getElement() : view,
						Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
								.getType(Twosml.twosml.diagram.edit.parts.SmartSpaceSSpaceIDEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUbiquitousApplication_2006Text(View view) {
		IParser parser = Twosml.twosml.diagram.providers.TwoSMLParserProvider
				.getParser(
						Twosml.twosml.diagram.providers.TwoSMLElementTypes.UbiquitousApplication_2006,
						view.getElement() != null ? view.getElement() : view,
						Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
								.getType(Twosml.twosml.diagram.edit.parts.UbiquitousApplicationUbiAppIDEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPhysicalSpace_2007Text(View view) {
		IParser parser = Twosml.twosml.diagram.providers.TwoSMLParserProvider
				.getParser(
						Twosml.twosml.diagram.providers.TwoSMLElementTypes.PhysicalSpace_2007,
						view.getElement() != null ? view.getElement() : view,
						Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
								.getType(Twosml.twosml.diagram.edit.parts.PhysicalSpacePSpaceIDEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getHosts_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConsistsOf_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.MODEL_ID
				.equals(Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
						.getModelID(view));
	}

}
