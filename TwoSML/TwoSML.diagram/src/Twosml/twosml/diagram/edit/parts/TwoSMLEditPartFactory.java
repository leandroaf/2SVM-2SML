package Twosml.twosml.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class TwoSMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getVisualID(view)) {

			case Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.ControlSchemaEditPart(
						view);

			case Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.SmartSpaceEditPart(
						view);

			case Twosml.twosml.diagram.edit.parts.SmartSpaceSSpaceIDEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.SmartSpaceSSpaceIDEditPart(
						view);

			case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.UbiquitousApplicationEditPart(
						view);

			case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationUbiAppIDEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.UbiquitousApplicationUbiAppIDEditPart(
						view);

			case Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.PhysicalSpaceEditPart(
						view);

			case Twosml.twosml.diagram.edit.parts.PhysicalSpacePSpaceIDEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.PhysicalSpacePSpaceIDEditPart(
						view);

			case Twosml.twosml.diagram.edit.parts.HostsEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.HostsEditPart(view);

			case Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart.VISUAL_ID:
				return new Twosml.twosml.diagram.edit.parts.ConsistsOfEditPart(
						view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
