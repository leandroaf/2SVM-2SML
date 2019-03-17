/**
 */
package Twosml.twosml.impl;

import Twosml.twosml.ConsistsOf;
import Twosml.twosml.ControlSchema;
import Twosml.twosml.Hosts;
import Twosml.twosml.PhysicalSpace;
import Twosml.twosml.SmartSpace;
import Twosml.twosml.TwosmlFactory;
import Twosml.twosml.TwosmlPackage;
import Twosml.twosml.UbiquitousApplication;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TwosmlPackageImpl extends EPackageImpl implements TwosmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smartSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consistsOfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hostsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ubiquitousApplicationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see Twosml.twosml.TwosmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TwosmlPackageImpl() {
		super(eNS_URI, TwosmlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TwosmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TwosmlPackage init() {
		if (isInited) return (TwosmlPackage)EPackage.Registry.INSTANCE.getEPackage(TwosmlPackage.eNS_URI);

		// Obtain or create and register package
		TwosmlPackageImpl theTwosmlPackage = (TwosmlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TwosmlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TwosmlPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTwosmlPackage.createPackageContents();

		// Initialize created meta-data
		theTwosmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTwosmlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TwosmlPackage.eNS_URI, theTwosmlPackage);
		return theTwosmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlSchema() {
		return controlSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlSchema_HasPhysicalSpace() {
		return (EReference)controlSchemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlSchema_HasSmartSpace() {
		return (EReference)controlSchemaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlSchema_HasUbiquitousApplication() {
		return (EReference)controlSchemaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalSpace() {
		return physicalSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalSpace_PSpaceCO() {
		return (EReference)physicalSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalSpace_PSpaceID() {
		return (EAttribute)physicalSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalSpace_EReference2() {
		return (EReference)physicalSpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmartSpace() {
		return smartSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartSpace_EReference1() {
		return (EReference)smartSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartSpace_EReference0() {
		return (EReference)smartSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartSpace_SSpaceID() {
		return (EAttribute)smartSpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartSpace_SourceSS() {
		return (EReference)smartSpaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartSpace_Source() {
		return (EReference)smartSpaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConsistsOf() {
		return consistsOfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsistsOf_TargetPS() {
		return (EReference)consistsOfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHosts() {
		return hostsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHosts_Target() {
		return (EReference)hostsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUbiquitousApplication() {
		return ubiquitousApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUbiquitousApplication_UbiAppH() {
		return (EReference)ubiquitousApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUbiquitousApplication_UbiAppID() {
		return (EAttribute)ubiquitousApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUbiquitousApplication_EReference3() {
		return (EReference)ubiquitousApplicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TwosmlFactory getTwosmlFactory() {
		return (TwosmlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		controlSchemaEClass = createEClass(CONTROL_SCHEMA);
		createEReference(controlSchemaEClass, CONTROL_SCHEMA__HAS_PHYSICAL_SPACE);
		createEReference(controlSchemaEClass, CONTROL_SCHEMA__HAS_SMART_SPACE);
		createEReference(controlSchemaEClass, CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION);

		physicalSpaceEClass = createEClass(PHYSICAL_SPACE);
		createEReference(physicalSpaceEClass, PHYSICAL_SPACE__PSPACE_CO);
		createEAttribute(physicalSpaceEClass, PHYSICAL_SPACE__PSPACE_ID);
		createEReference(physicalSpaceEClass, PHYSICAL_SPACE__EREFERENCE2);

		smartSpaceEClass = createEClass(SMART_SPACE);
		createEReference(smartSpaceEClass, SMART_SPACE__EREFERENCE1);
		createEReference(smartSpaceEClass, SMART_SPACE__EREFERENCE0);
		createEAttribute(smartSpaceEClass, SMART_SPACE__SSPACE_ID);
		createEReference(smartSpaceEClass, SMART_SPACE__SOURCE_SS);
		createEReference(smartSpaceEClass, SMART_SPACE__SOURCE);

		consistsOfEClass = createEClass(CONSISTS_OF);
		createEReference(consistsOfEClass, CONSISTS_OF__TARGET_PS);

		hostsEClass = createEClass(HOSTS);
		createEReference(hostsEClass, HOSTS__TARGET);

		ubiquitousApplicationEClass = createEClass(UBIQUITOUS_APPLICATION);
		createEReference(ubiquitousApplicationEClass, UBIQUITOUS_APPLICATION__UBI_APP_H);
		createEAttribute(ubiquitousApplicationEClass, UBIQUITOUS_APPLICATION__UBI_APP_ID);
		createEReference(ubiquitousApplicationEClass, UBIQUITOUS_APPLICATION__EREFERENCE3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(controlSchemaEClass, ControlSchema.class, "ControlSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlSchema_HasPhysicalSpace(), this.getPhysicalSpace(), null, "hasPhysicalSpace", null, 1, -1, ControlSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getControlSchema_HasSmartSpace(), this.getSmartSpace(), null, "hasSmartSpace", null, 1, 1, ControlSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getControlSchema_HasUbiquitousApplication(), this.getUbiquitousApplication(), null, "hasUbiquitousApplication", null, 1, -1, ControlSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalSpaceEClass, PhysicalSpace.class, "PhysicalSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPhysicalSpace_PSpaceCO(), this.getConsistsOf(), null, "pSpaceCO", null, 0, 1, PhysicalSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalSpace_PSpaceID(), ecorePackage.getEString(), "pSpaceID", null, 0, 1, PhysicalSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalSpace_EReference2(), this.getConsistsOf(), null, "EReference2", null, 0, 1, PhysicalSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(smartSpaceEClass, SmartSpace.class, "SmartSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSmartSpace_EReference1(), this.getConsistsOf(), null, "EReference1", null, 0, 1, SmartSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmartSpace_EReference0(), this.getHosts(), null, "EReference0", null, 0, 1, SmartSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartSpace_SSpaceID(), ecorePackage.getEString(), "sSpaceID", null, 0, 1, SmartSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmartSpace_SourceSS(), this.getConsistsOf(), null, "sourceSS", null, 0, 1, SmartSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmartSpace_Source(), this.getHosts(), null, "source", null, 0, 1, SmartSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consistsOfEClass, ConsistsOf.class, "ConsistsOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsistsOf_TargetPS(), this.getPhysicalSpace(), null, "targetPS", null, 1, -1, ConsistsOf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hostsEClass, Hosts.class, "Hosts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHosts_Target(), this.getUbiquitousApplication(), null, "target", null, 1, -1, Hosts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ubiquitousApplicationEClass, UbiquitousApplication.class, "UbiquitousApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUbiquitousApplication_UbiAppH(), this.getHosts(), null, "ubiAppH", null, 0, 1, UbiquitousApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUbiquitousApplication_UbiAppID(), ecorePackage.getEString(), "ubiAppID", null, 0, 1, UbiquitousApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUbiquitousApplication_EReference3(), this.getHosts(), null, "EReference3", null, 0, 1, UbiquitousApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TwosmlPackageImpl
