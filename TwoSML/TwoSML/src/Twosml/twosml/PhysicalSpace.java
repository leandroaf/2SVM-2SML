/**
 */
package Twosml.twosml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Twosml.twosml.PhysicalSpace#getPSpaceCO <em>PSpace CO</em>}</li>
 *   <li>{@link Twosml.twosml.PhysicalSpace#getPSpaceID <em>PSpace ID</em>}</li>
 *   <li>{@link Twosml.twosml.PhysicalSpace#getEReference2 <em>EReference2</em>}</li>
 * </ul>
 * </p>
 *
 * @see Twosml.twosml.TwosmlPackage#getPhysicalSpace()
 * @model
 * @generated
 */
public interface PhysicalSpace extends EObject {

	/**
	 * Returns the value of the '<em><b>PSpace CO</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PSpace CO</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PSpace CO</em>' containment reference.
	 * @see #setPSpaceCO(ConsistsOf)
	 * @see Twosml.twosml.TwosmlPackage#getPhysicalSpace_PSpaceCO()
	 * @model containment="true"
	 * @generated
	 */
	ConsistsOf getPSpaceCO();

	/**
	 * Sets the value of the '{@link Twosml.twosml.PhysicalSpace#getPSpaceCO <em>PSpace CO</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PSpace CO</em>' containment reference.
	 * @see #getPSpaceCO()
	 * @generated
	 */
	void setPSpaceCO(ConsistsOf value);

	/**
	 * Returns the value of the '<em><b>PSpace ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PSpace ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PSpace ID</em>' attribute.
	 * @see #setPSpaceID(String)
	 * @see Twosml.twosml.TwosmlPackage#getPhysicalSpace_PSpaceID()
	 * @model
	 * @generated
	 */
	String getPSpaceID();

	/**
	 * Sets the value of the '{@link Twosml.twosml.PhysicalSpace#getPSpaceID <em>PSpace ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PSpace ID</em>' attribute.
	 * @see #getPSpaceID()
	 * @generated
	 */
	void setPSpaceID(String value);

	/**
	 * Returns the value of the '<em><b>EReference2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference2</em>' containment reference.
	 * @see #setEReference2(ConsistsOf)
	 * @see Twosml.twosml.TwosmlPackage#getPhysicalSpace_EReference2()
	 * @model containment="true"
	 * @generated
	 */
	ConsistsOf getEReference2();

	/**
	 * Sets the value of the '{@link Twosml.twosml.PhysicalSpace#getEReference2 <em>EReference2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference2</em>' containment reference.
	 * @see #getEReference2()
	 * @generated
	 */
	void setEReference2(ConsistsOf value);

} // PhysicalSpace
