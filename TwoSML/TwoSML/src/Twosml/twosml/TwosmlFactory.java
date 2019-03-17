/**
 */
package Twosml.twosml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Twosml.twosml.TwosmlPackage
 * @generated
 */
public interface TwosmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TwosmlFactory eINSTANCE = Twosml.twosml.impl.TwosmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Control Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Schema</em>'.
	 * @generated
	 */
	ControlSchema createControlSchema();

	/**
	 * Returns a new object of class '<em>Physical Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Physical Space</em>'.
	 * @generated
	 */
	PhysicalSpace createPhysicalSpace();

	/**
	 * Returns a new object of class '<em>Smart Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smart Space</em>'.
	 * @generated
	 */
	SmartSpace createSmartSpace();

	/**
	 * Returns a new object of class '<em>Consists Of</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consists Of</em>'.
	 * @generated
	 */
	ConsistsOf createConsistsOf();

	/**
	 * Returns a new object of class '<em>Hosts</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hosts</em>'.
	 * @generated
	 */
	Hosts createHosts();

	/**
	 * Returns a new object of class '<em>Ubiquitous Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ubiquitous Application</em>'.
	 * @generated
	 */
	UbiquitousApplication createUbiquitousApplication();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TwosmlPackage getTwosmlPackage();

} //TwosmlFactory
