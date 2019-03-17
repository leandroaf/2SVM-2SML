/**
 */
package Twosml.twosml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consists Of</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Twosml.twosml.ConsistsOf#getTargetPS <em>Target PS</em>}</li>
 * </ul>
 * </p>
 *
 * @see Twosml.twosml.TwosmlPackage#getConsistsOf()
 * @model
 * @generated
 */
public interface ConsistsOf extends EObject {

	/**
	 * Returns the value of the '<em><b>Target PS</b></em>' reference list.
	 * The list contents are of type {@link Twosml.twosml.PhysicalSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target PS</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target PS</em>' reference list.
	 * @see Twosml.twosml.TwosmlPackage#getConsistsOf_TargetPS()
	 * @model required="true"
	 * @generated
	 */
	EList<PhysicalSpace> getTargetPS();

} // ConsistsOf
