/**
 */
package Twosml.twosml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Twosml.twosml.ControlSchema#getHasPhysicalSpace <em>Has Physical Space</em>}</li>
 *   <li>{@link Twosml.twosml.ControlSchema#getHasSmartSpace <em>Has Smart Space</em>}</li>
 *   <li>{@link Twosml.twosml.ControlSchema#getHasUbiquitousApplication <em>Has Ubiquitous Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see Twosml.twosml.TwosmlPackage#getControlSchema()
 * @model
 * @generated
 */
public interface ControlSchema extends EObject {
	/**
	 * Returns the value of the '<em><b>Has Physical Space</b></em>' containment reference list.
	 * The list contents are of type {@link Twosml.twosml.PhysicalSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Physical Space</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Physical Space</em>' containment reference list.
	 * @see Twosml.twosml.TwosmlPackage#getControlSchema_HasPhysicalSpace()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PhysicalSpace> getHasPhysicalSpace();

	/**
	 * Returns the value of the '<em><b>Has Smart Space</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Smart Space</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Smart Space</em>' containment reference.
	 * @see #setHasSmartSpace(SmartSpace)
	 * @see Twosml.twosml.TwosmlPackage#getControlSchema_HasSmartSpace()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SmartSpace getHasSmartSpace();

	/**
	 * Sets the value of the '{@link Twosml.twosml.ControlSchema#getHasSmartSpace <em>Has Smart Space</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Smart Space</em>' containment reference.
	 * @see #getHasSmartSpace()
	 * @generated
	 */
	void setHasSmartSpace(SmartSpace value);

	/**
	 * Returns the value of the '<em><b>Has Ubiquitous Application</b></em>' containment reference list.
	 * The list contents are of type {@link Twosml.twosml.UbiquitousApplication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Ubiquitous Application</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Ubiquitous Application</em>' containment reference list.
	 * @see Twosml.twosml.TwosmlPackage#getControlSchema_HasUbiquitousApplication()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<UbiquitousApplication> getHasUbiquitousApplication();

} // ControlSchema
