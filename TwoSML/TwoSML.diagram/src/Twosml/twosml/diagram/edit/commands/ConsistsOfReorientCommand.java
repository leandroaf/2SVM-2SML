package Twosml.twosml.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class ConsistsOfReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public ConsistsOfReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Twosml.twosml.ConsistsOf) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Twosml.twosml.PhysicalSpace && newEnd instanceof Twosml.twosml.PhysicalSpace)) {
			return false;
		}
		if (getLink().getTargetPS().size() != 1) {
			return false;
		}
		Twosml.twosml.PhysicalSpace target = (Twosml.twosml.PhysicalSpace) getLink()
				.getTargetPS().get(0);
		return Twosml.twosml.diagram.edit.policies.TwoSMLBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistConsistsOf_4002(getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Twosml.twosml.PhysicalSpace && newEnd instanceof Twosml.twosml.PhysicalSpace)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Twosml.twosml.PhysicalSpace)) {
			return false;
		}
		Twosml.twosml.PhysicalSpace source = (Twosml.twosml.PhysicalSpace) getLink()
				.eContainer();
		return Twosml.twosml.diagram.edit.policies.TwoSMLBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistConsistsOf_4002(getLink(),
						source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().setPSpaceCO(null);
		getNewSource().setPSpaceCO(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getTargetPS().remove(getOldTarget());
		getLink().getTargetPS().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.ConsistsOf getLink() {
		return (Twosml.twosml.ConsistsOf) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.PhysicalSpace getOldSource() {
		return (Twosml.twosml.PhysicalSpace) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.PhysicalSpace getNewSource() {
		return (Twosml.twosml.PhysicalSpace) newEnd;
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.PhysicalSpace getOldTarget() {
		return (Twosml.twosml.PhysicalSpace) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.PhysicalSpace getNewTarget() {
		return (Twosml.twosml.PhysicalSpace) newEnd;
	}
}
