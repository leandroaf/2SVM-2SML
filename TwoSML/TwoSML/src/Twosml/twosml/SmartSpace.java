/**
 */
package Twosml.twosml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Smart Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Twosml.twosml.SmartSpace#getEReference1 <em>EReference1</em>}</li>
 *   <li>{@link Twosml.twosml.SmartSpace#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link Twosml.twosml.SmartSpace#getSSpaceID <em>SSpace ID</em>}</li>
 *   <li>{@link Twosml.twosml.SmartSpace#getSourceSS <em>Source SS</em>}</li>
 *   <li>{@link Twosml.twosml.SmartSpace#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see Twosml.twosml.TwosmlPackage#getSmartSpace()
 * @model
 * @generated
 */
public interface SmartSpace extends EObject {
	/**
	 * Returns the value of the '<em><b>EReference1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference1</em>' containment reference.
	 * @see #setEReference1(ConsistsOf)
	 * @see Twosml.twosml.TwosmlPackage#getSmartSpace_EReference1()
	 * @model containment="true"
	 * @generated
	 */
	ConsistsOf getEReference1();

	/**
	 * Sets the value of the '{@link Twosml.twosml.SmartSpace#getEReference1 <em>EReference1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference1</em>' containment reference.
	 * @see #getEReference1()
	 * @generated
	 */
	void setEReference1(ConsistsOf value);

	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' containment reference.
	 * @see #setEReference0(Hosts)
	 * @see Twosml.twosml.TwosmlPackage#getSmartSpace_EReference0()
	 * @model containment="true"
	 * @generated
	 */
	Hosts getEReference0();

	/**
	 * Sets the value of the '{@link Twosml.twosml.SmartSpace#getEReference0 <em>EReference0</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' containment reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(Hosts value);

	/**
	 * Returns the value of the '<em><b>SSpace ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSpace ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSpace ID</em>' attribute.
	 * @see #setSSpaceID(String)
	 * @see Twosml.twosml.TwosmlPackage#getSmartSpace_SSpaceID()
	 * @model
	 * @generated
	 */
	String getSSpaceID();

	/**
	 * Sets the value of the '{@link Twosml.twosml.SmartSpace#getSSpaceID <em>SSpace ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSpace ID</em>' attribute.
	 * @see #getSSpaceID()
	 * @generated
	 */
	void setSSpaceID(String value);

	/**
	 * Returns the value of the '<em><b>Source SS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source SS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source SS</em>' reference.
	 * @see #setSourceSS(ConsistsOf)
	 * @see Twosml.twosml.TwosmlPackage#getSmartSpace_SourceSS()
	 * @model
	 * @generated
	 */
	ConsistsOf getSourceSS();

	/**
	 * Sets the value of the '{@link Twosml.twosml.SmartSpace#getSourceSS <em>Source SS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source SS</em>' reference.
	 * @see #getSourceSS()
	 * @generated
	 */
	void setSourceSS(ConsistsOf value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Hosts)
	 * @see Twosml.twosml.TwosmlPackage#getSmartSpace_Source()
	 * @model
	 * @generated
	 */
	Hosts getSource();

	/**
	 * Sets the value of the '{@link Twosml.twosml.SmartSpace#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Hosts value);

} // SmartSpace
