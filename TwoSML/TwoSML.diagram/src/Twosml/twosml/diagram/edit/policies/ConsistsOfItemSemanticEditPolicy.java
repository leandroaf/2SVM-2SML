package Twosml.twosml.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class ConsistsOfItemSemanticEditPolicy extends
		Twosml.twosml.diagram.edit.policies.TwoSMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ConsistsOfItemSemanticEditPolicy() {
		super(
				Twosml.twosml.diagram.providers.TwoSMLElementTypes.ConsistsOf_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
