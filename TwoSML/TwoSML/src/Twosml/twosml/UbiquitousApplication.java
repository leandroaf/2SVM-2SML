/**
 */
package Twosml.twosml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ubiquitous Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Twosml.twosml.UbiquitousApplication#getUbiAppH <em>Ubi App H</em>}</li>
 *   <li>{@link Twosml.twosml.UbiquitousApplication#getUbiAppID <em>Ubi App ID</em>}</li>
 *   <li>{@link Twosml.twosml.UbiquitousApplication#getEReference3 <em>EReference3</em>}</li>
 * </ul>
 * </p>
 *
 * @see Twosml.twosml.TwosmlPackage#getUbiquitousApplication()
 * @model
 * @generated
 */
public interface UbiquitousApplication extends EObject {

	/**
	 * Returns the value of the '<em><b>Ubi App H</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ubi App H</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ubi App H</em>' containment reference.
	 * @see #setUbiAppH(Hosts)
	 * @see Twosml.twosml.TwosmlPackage#getUbiquitousApplication_UbiAppH()
	 * @model containment="true"
	 * @generated
	 */
	Hosts getUbiAppH();

	/**
	 * Sets the value of the '{@link Twosml.twosml.UbiquitousApplication#getUbiAppH <em>Ubi App H</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ubi App H</em>' containment reference.
	 * @see #getUbiAppH()
	 * @generated
	 */
	void setUbiAppH(Hosts value);

	/**
	 * Returns the value of the '<em><b>Ubi App ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ubi App ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ubi App ID</em>' attribute.
	 * @see #setUbiAppID(String)
	 * @see Twosml.twosml.TwosmlPackage#getUbiquitousApplication_UbiAppID()
	 * @model
	 * @generated
	 */
	String getUbiAppID();

	/**
	 * Sets the value of the '{@link Twosml.twosml.UbiquitousApplication#getUbiAppID <em>Ubi App ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ubi App ID</em>' attribute.
	 * @see #getUbiAppID()
	 * @generated
	 */
	void setUbiAppID(String value);

	/**
	 * Returns the value of the '<em><b>EReference3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference3</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference3</em>' containment reference.
	 * @see #setEReference3(Hosts)
	 * @see Twosml.twosml.TwosmlPackage#getUbiquitousApplication_EReference3()
	 * @model containment="true"
	 * @generated
	 */
	Hosts getEReference3();

	/**
	 * Sets the value of the '{@link Twosml.twosml.UbiquitousApplication#getEReference3 <em>EReference3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference3</em>' containment reference.
	 * @see #getEReference3()
	 * @generated
	 */
	void setEReference3(Hosts value);

} // UbiquitousApplication
