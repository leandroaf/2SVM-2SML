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
public class HostsReorientCommand extends EditElementCommand {

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
	public HostsReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Twosml.twosml.Hosts) {
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
		if (!(oldEnd instanceof Twosml.twosml.UbiquitousApplication && newEnd instanceof Twosml.twosml.UbiquitousApplication)) {
			return false;
		}
		if (getLink().getTarget().size() != 1) {
			return false;
		}
		Twosml.twosml.UbiquitousApplication target = (Twosml.twosml.UbiquitousApplication) getLink()
				.getTarget().get(0);
		return Twosml.twosml.diagram.edit.policies.TwoSMLBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistHosts_4001(getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Twosml.twosml.UbiquitousApplication && newEnd instanceof Twosml.twosml.UbiquitousApplication)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Twosml.twosml.UbiquitousApplication)) {
			return false;
		}
		Twosml.twosml.UbiquitousApplication source = (Twosml.twosml.UbiquitousApplication) getLink()
				.eContainer();
		return Twosml.twosml.diagram.edit.policies.TwoSMLBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistHosts_4001(getLink(), source,
						getNewTarget());
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
		getOldSource().setEReference3(null);
		getNewSource().setEReference3(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getTarget().remove(getOldTarget());
		getLink().getTarget().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.Hosts getLink() {
		return (Twosml.twosml.Hosts) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.UbiquitousApplication getOldSource() {
		return (Twosml.twosml.UbiquitousApplication) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.UbiquitousApplication getNewSource() {
		return (Twosml.twosml.UbiquitousApplication) newEnd;
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.UbiquitousApplication getOldTarget() {
		return (Twosml.twosml.UbiquitousApplication) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Twosml.twosml.UbiquitousApplication getNewTarget() {
		return (Twosml.twosml.UbiquitousApplication) newEnd;
	}
}
