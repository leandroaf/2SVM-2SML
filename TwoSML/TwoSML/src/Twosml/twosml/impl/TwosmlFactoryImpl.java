/**
 */
package Twosml.twosml.impl;

import Twosml.twosml.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TwosmlFactoryImpl extends EFactoryImpl implements TwosmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TwosmlFactory init() {
		try {
			TwosmlFactory theTwosmlFactory = (TwosmlFactory)EPackage.Registry.INSTANCE.getEFactory(TwosmlPackage.eNS_URI);
			if (theTwosmlFactory != null) {
				return theTwosmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TwosmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TwosmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TwosmlPackage.CONTROL_SCHEMA: return createControlSchema();
			case TwosmlPackage.PHYSICAL_SPACE: return createPhysicalSpace();
			case TwosmlPackage.SMART_SPACE: return createSmartSpace();
			case TwosmlPackage.CONSISTS_OF: return createConsistsOf();
			case TwosmlPackage.HOSTS: return createHosts();
			case TwosmlPackage.UBIQUITOUS_APPLICATION: return createUbiquitousApplication();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlSchema createControlSchema() {
		ControlSchemaImpl controlSchema = new ControlSchemaImpl();
		return controlSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalSpace createPhysicalSpace() {
		PhysicalSpaceImpl physicalSpace = new PhysicalSpaceImpl();
		return physicalSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmartSpace createSmartSpace() {
		SmartSpaceImpl smartSpace = new SmartSpaceImpl();
		return smartSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsistsOf createConsistsOf() {
		ConsistsOfImpl consistsOf = new ConsistsOfImpl();
		return consistsOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hosts createHosts() {
		HostsImpl hosts = new HostsImpl();
		return hosts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UbiquitousApplication createUbiquitousApplication() {
		UbiquitousApplicationImpl ubiquitousApplication = new UbiquitousApplicationImpl();
		return ubiquitousApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TwosmlPackage getTwosmlPackage() {
		return (TwosmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TwosmlPackage getPackage() {
		return TwosmlPackage.eINSTANCE;
	}

} //TwosmlFactoryImpl
