package Twosml.twosml.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class ControlSchemaItemSemanticEditPolicy extends
		Twosml.twosml.diagram.edit.policies.TwoSMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ControlSchemaItemSemanticEditPolicy() {
		super(
				Twosml.twosml.diagram.providers.TwoSMLElementTypes.ControlSchema_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (Twosml.twosml.diagram.providers.TwoSMLElementTypes.SmartSpace_2005 == req
				.getElementType()) {
			return getGEFWrapper(new Twosml.twosml.diagram.edit.commands.SmartSpaceCreateCommand(
					req));
		}
		if (Twosml.twosml.diagram.providers.TwoSMLElementTypes.UbiquitousApplication_2006 == req
				.getElementType()) {
			return getGEFWrapper(new Twosml.twosml.diagram.edit.commands.UbiquitousApplicationCreateCommand(
					req));
		}
		if (Twosml.twosml.diagram.providers.TwoSMLElementTypes.PhysicalSpace_2007 == req
				.getElementType()) {
			return getGEFWrapper(new Twosml.twosml.diagram.edit.commands.PhysicalSpaceCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
