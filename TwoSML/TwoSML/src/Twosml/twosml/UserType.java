/**
 */
package Twosml.twosml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Twosml.twosml.UserType#getUTypeH <em>UType H</em>}</li>
 *   <li>{@link Twosml.twosml.UserType#getUTypeID <em>UType ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see Twosml.twosml.TwosmlPackage#getUserType()
 * @model
 * @generated
 */
public interface UserType extends EObject {
	/**
	 * Returns the value of the '<em><b>UType H</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UType H</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UType H</em>' containment reference.
	 * @see #setUTypeH(Hosts)
	 * @see Twosml.twosml.TwosmlPackage#getUserType_UTypeH()
	 * @model containment="true"
	 * @generated
	 */
	Hosts getUTypeH();

	/**
	 * Sets the value of the '{@link Twosml.twosml.UserType#getUTypeH <em>UType H</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UType H</em>' containment reference.
	 * @see #getUTypeH()
	 * @generated
	 */
	void setUTypeH(Hosts value);

	/**
	 * Returns the value of the '<em><b>UType ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UType ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UType ID</em>' attribute.
	 * @see #setUTypeID(String)
	 * @see Twosml.twosml.TwosmlPackage#getUserType_UTypeID()
	 * @model
	 * @generated
	 */
	String getUTypeID();

	/**
	 * Sets the value of the '{@link Twosml.twosml.UserType#getUTypeID <em>UType ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UType ID</em>' attribute.
	 * @see #getUTypeID()
	 * @generated
	 */
	void setUTypeID(String value);

} // UserType
