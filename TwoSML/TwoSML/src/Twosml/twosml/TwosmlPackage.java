/**
 */
package Twosml.twosml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Twosml.twosml.TwosmlFactory
 * @model kind="package"
 * @generated
 */
public interface TwosmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "twosml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://twosml/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "twosml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TwosmlPackage eINSTANCE = Twosml.twosml.impl.TwosmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link Twosml.twosml.impl.ControlSchemaImpl <em>Control Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Twosml.twosml.impl.ControlSchemaImpl
	 * @see Twosml.twosml.impl.TwosmlPackageImpl#getControlSchema()
	 * @generated
	 */
	int CONTROL_SCHEMA = 0;

	/**
	 * The feature id for the '<em><b>Has Physical Space</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SCHEMA__HAS_PHYSICAL_SPACE = 0;

	/**
	 * The feature id for the '<em><b>Has Smart Space</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SCHEMA__HAS_SMART_SPACE = 1;

	/**
	 * The feature id for the '<em><b>Has Ubiquitous Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION = 2;

	/**
	 * The number of structural features of the '<em>Control Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SCHEMA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Control Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SCHEMA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Twosml.twosml.impl.PhysicalSpaceImpl <em>Physical Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Twosml.twosml.impl.PhysicalSpaceImpl
	 * @see Twosml.twosml.impl.TwosmlPackageImpl#getPhysicalSpace()
	 * @generated
	 */
	int PHYSICAL_SPACE = 1;

	/**
	 * The feature id for the '<em><b>PSpace CO</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_SPACE__PSPACE_CO = 0;

	/**
	 * The feature id for the '<em><b>PSpace ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_SPACE__PSPACE_ID = 1;

	/**
	 * The feature id for the '<em><b>EReference2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_SPACE__EREFERENCE2 = 2;

	/**
	 * The number of structural features of the '<em>Physical Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_SPACE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Physical Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_SPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Twosml.twosml.impl.SmartSpaceImpl <em>Smart Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Twosml.twosml.impl.SmartSpaceImpl
	 * @see Twosml.twosml.impl.TwosmlPackageImpl#getSmartSpace()
	 * @generated
	 */
	int SMART_SPACE = 2;

	/**
	 * The feature id for the '<em><b>EReference1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SPACE__EREFERENCE1 = 0;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SPACE__EREFERENCE0 = 1;

	/**
	 * The feature id for the '<em><b>SSpace ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SPACE__SSPACE_ID = 2;

	/**
	 * The feature id for the '<em><b>Source SS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SPACE__SOURCE_SS = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SPACE__SOURCE = 4;

	/**
	 * The number of structural features of the '<em>Smart Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SPACE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Smart Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Twosml.twosml.impl.ConsistsOfImpl <em>Consists Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Twosml.twosml.impl.ConsistsOfImpl
	 * @see Twosml.twosml.impl.TwosmlPackageImpl#getConsistsOf()
	 * @generated
	 */
	int CONSISTS_OF = 3;

	/**
	 * The feature id for the '<em><b>Target PS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSISTS_OF__TARGET_PS = 0;

	/**
	 * The number of structural features of the '<em>Consists Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSISTS_OF_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Consists Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSISTS_OF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Twosml.twosml.impl.HostsImpl <em>Hosts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Twosml.twosml.impl.HostsImpl
	 * @see Twosml.twosml.impl.TwosmlPackageImpl#getHosts()
	 * @generated
	 */
	int HOSTS = 4;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTS__TARGET = 0;

	/**
	 * The number of structural features of the '<em>Hosts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Hosts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Twosml.twosml.impl.UbiquitousApplicationImpl <em>Ubiquitous Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Twosml.twosml.impl.UbiquitousApplicationImpl
	 * @see Twosml.twosml.impl.TwosmlPackageImpl#getUbiquitousApplication()
	 * @generated
	 */
	int UBIQUITOUS_APPLICATION = 5;

	/**
	 * The feature id for the '<em><b>Ubi App H</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBIQUITOUS_APPLICATION__UBI_APP_H = 0;

	/**
	 * The feature id for the '<em><b>Ubi App ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBIQUITOUS_APPLICATION__UBI_APP_ID = 1;

	/**
	 * The feature id for the '<em><b>EReference3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBIQUITOUS_APPLICATION__EREFERENCE3 = 2;

	/**
	 * The number of structural features of the '<em>Ubiquitous Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBIQUITOUS_APPLICATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Ubiquitous Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBIQUITOUS_APPLICATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Twosml.twosml.ControlSchema <em>Control Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Schema</em>'.
	 * @see Twosml.twosml.ControlSchema
	 * @generated
	 */
	EClass getControlSchema();

	/**
	 * Returns the meta object for the containment reference list '{@link Twosml.twosml.ControlSchema#getHasPhysicalSpace <em>Has Physical Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Has Physical Space</em>'.
	 * @see Twosml.twosml.ControlSchema#getHasPhysicalSpace()
	 * @see #getControlSchema()
	 * @generated
	 */
	EReference getControlSchema_HasPhysicalSpace();

	/**
	 * Returns the meta object for the containment reference '{@link Twosml.twosml.ControlSchema#getHasSmartSpace <em>Has Smart Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Has Smart Space</em>'.
	 * @see Twosml.twosml.ControlSchema#getHasSmartSpace()
	 * @see #getControlSchema()
	 * @generated
	 */
	EReference getControlSchema_HasSmartSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link Twosml.twosml.ControlSchema#getHasUbiquitousApplication <em>Has Ubiquitous Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Has Ubiquitous Application</em>'.
	 * @see Twosml.twosml.ControlSchema#getHasUbiquitousApplication()
	 * @see #getControlSchema()
	 * @generated
	 */
	EReference getControlSchema_HasUbiquitousApplication();

	/**
	 * Returns the meta object for class '{@link Twosml.twosml.PhysicalSpace <em>Physical Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physical Space</em>'.
	 * @see Twosml.twosml.PhysicalSpace
	 * @generated
	 */
	EClass getPhysicalSpace();

	/**
	 * Returns the meta object for the containment reference '{@link Twosml.twosml.PhysicalSpace#getPSpaceCO <em>PSpace CO</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PSpace CO</em>'.
	 * @see Twosml.twosml.PhysicalSpace#getPSpaceCO()
	 * @see #getPhysicalSpace()
	 * @generated
	 */
	EReference getPhysicalSpace_PSpaceCO();

	/**
	 * Returns the meta object for the attribute '{@link Twosml.twosml.PhysicalSpace#getPSpaceID <em>PSpace ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PSpace ID</em>'.
	 * @see Twosml.twosml.PhysicalSpace#getPSpaceID()
	 * @see #getPhysicalSpace()
	 * @generated
	 */
	EAttribute getPhysicalSpace_PSpaceID();

	/**
	 * Returns the meta object for the containment reference '{@link Twosml.twosml.PhysicalSpace#getEReference2 <em>EReference2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference2</em>'.
	 * @see Twosml.twosml.PhysicalSpace#getEReference2()
	 * @see #getPhysicalSpace()
	 * @generated
	 */
	EReference getPhysicalSpace_EReference2();

	/**
	 * Returns the meta object for class '{@link Twosml.twosml.SmartSpace <em>Smart Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smart Space</em>'.
	 * @see Twosml.twosml.SmartSpace
	 * @generated
	 */
	EClass getSmartSpace();

	/**
	 * Returns the meta object for the containment reference '{@link Twosml.twosml.SmartSpace#getEReference1 <em>EReference1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference1</em>'.
	 * @see Twosml.twosml.SmartSpace#getEReference1()
	 * @see #getSmartSpace()
	 * @generated
	 */
	EReference getSmartSpace_EReference1();

	/**
	 * Returns the meta object for the containment reference '{@link Twosml.twosml.SmartSpace#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference0</em>'.
	 * @see Twosml.twosml.SmartSpace#getEReference0()
	 * @see #getSmartSpace()
	 * @generated
	 */
	EReference getSmartSpace_EReference0();

	/**
	 * Returns the meta object for the attribute '{@link Twosml.twosml.SmartSpace#getSSpaceID <em>SSpace ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSpace ID</em>'.
	 * @see Twosml.twosml.SmartSpace#getSSpaceID()
	 * @see #getSmartSpace()
	 * @generated
	 */
	EAttribute getSmartSpace_SSpaceID();

	/**
	 * Returns the meta object for the reference '{@link Twosml.twosml.SmartSpace#getSourceSS <em>Source SS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source SS</em>'.
	 * @see Twosml.twosml.SmartSpace#getSourceSS()
	 * @see #getSmartSpace()
	 * @generated
	 */
	EReference getSmartSpace_SourceSS();

	/**
	 * Returns the meta object for the reference '{@link Twosml.twosml.SmartSpace#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see Twosml.twosml.SmartSpace#getSource()
	 * @see #getSmartSpace()
	 * @generated
	 */
	EReference getSmartSpace_Source();

	/**
	 * Returns the meta object for class '{@link Twosml.twosml.ConsistsOf <em>Consists Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consists Of</em>'.
	 * @see Twosml.twosml.ConsistsOf
	 * @generated
	 */
	EClass getConsistsOf();

	/**
	 * Returns the meta object for the reference list '{@link Twosml.twosml.ConsistsOf#getTargetPS <em>Target PS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target PS</em>'.
	 * @see Twosml.twosml.ConsistsOf#getTargetPS()
	 * @see #getConsistsOf()
	 * @generated
	 */
	EReference getConsistsOf_TargetPS();

	/**
	 * Returns the meta object for class '{@link Twosml.twosml.Hosts <em>Hosts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hosts</em>'.
	 * @see Twosml.twosml.Hosts
	 * @generated
	 */
	EClass getHosts();

	/**
	 * Returns the meta object for the reference list '{@link Twosml.twosml.Hosts#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see Twosml.twosml.Hosts#getTarget()
	 * @see #getHosts()
	 * @generated
	 */
	EReference getHosts_Target();

	/**
	 * Returns the meta object for class '{@link Twosml.twosml.UbiquitousApplication <em>Ubiquitous Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ubiquitous Application</em>'.
	 * @see Twosml.twosml.UbiquitousApplication
	 * @generated
	 */
	EClass getUbiquitousApplication();

	/**
	 * Returns the meta object for the containment reference '{@link Twosml.twosml.UbiquitousApplication#getUbiAppH <em>Ubi App H</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ubi App H</em>'.
	 * @see Twosml.twosml.UbiquitousApplication#getUbiAppH()
	 * @see #getUbiquitousApplication()
	 * @generated
	 */
	EReference getUbiquitousApplication_UbiAppH();

	/**
	 * Returns the meta object for the attribute '{@link Twosml.twosml.UbiquitousApplication#getUbiAppID <em>Ubi App ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ubi App ID</em>'.
	 * @see Twosml.twosml.UbiquitousApplication#getUbiAppID()
	 * @see #getUbiquitousApplication()
	 * @generated
	 */
	EAttribute getUbiquitousApplication_UbiAppID();

	/**
	 * Returns the meta object for the containment reference '{@link Twosml.twosml.UbiquitousApplication#getEReference3 <em>EReference3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference3</em>'.
	 * @see Twosml.twosml.UbiquitousApplication#getEReference3()
	 * @see #getUbiquitousApplication()
	 * @generated
	 */
	EReference getUbiquitousApplication_EReference3();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TwosmlFactory getTwosmlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Twosml.twosml.impl.ControlSchemaImpl <em>Control Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Twosml.twosml.impl.ControlSchemaImpl
		 * @see Twosml.twosml.impl.TwosmlPackageImpl#getControlSchema()
		 * @generated
		 */
		EClass CONTROL_SCHEMA = eINSTANCE.getControlSchema();

		/**
		 * The meta object literal for the '<em><b>Has Physical Space</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_SCHEMA__HAS_PHYSICAL_SPACE = eINSTANCE.getControlSchema_HasPhysicalSpace();

		/**
		 * The meta object literal for the '<em><b>Has Smart Space</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_SCHEMA__HAS_SMART_SPACE = eINSTANCE.getControlSchema_HasSmartSpace();

		/**
		 * The meta object literal for the '<em><b>Has Ubiquitous Application</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION = eINSTANCE.getControlSchema_HasUbiquitousApplication();

		/**
		 * The meta object literal for the '{@link Twosml.twosml.impl.PhysicalSpaceImpl <em>Physical Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Twosml.twosml.impl.PhysicalSpaceImpl
		 * @see Twosml.twosml.impl.TwosmlPackageImpl#getPhysicalSpace()
		 * @generated
		 */
		EClass PHYSICAL_SPACE = eINSTANCE.getPhysicalSpace();

		/**
		 * The meta object literal for the '<em><b>PSpace CO</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_SPACE__PSPACE_CO = eINSTANCE.getPhysicalSpace_PSpaceCO();

		/**
		 * The meta object literal for the '<em><b>PSpace ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_SPACE__PSPACE_ID = eINSTANCE.getPhysicalSpace_PSpaceID();

		/**
		 * The meta object literal for the '<em><b>EReference2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_SPACE__EREFERENCE2 = eINSTANCE.getPhysicalSpace_EReference2();

		/**
		 * The meta object literal for the '{@link Twosml.twosml.impl.SmartSpaceImpl <em>Smart Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Twosml.twosml.impl.SmartSpaceImpl
		 * @see Twosml.twosml.impl.TwosmlPackageImpl#getSmartSpace()
		 * @generated
		 */
		EClass SMART_SPACE = eINSTANCE.getSmartSpace();

		/**
		 * The meta object literal for the '<em><b>EReference1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMART_SPACE__EREFERENCE1 = eINSTANCE.getSmartSpace_EReference1();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMART_SPACE__EREFERENCE0 = eINSTANCE.getSmartSpace_EReference0();

		/**
		 * The meta object literal for the '<em><b>SSpace ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_SPACE__SSPACE_ID = eINSTANCE.getSmartSpace_SSpaceID();

		/**
		 * The meta object literal for the '<em><b>Source SS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMART_SPACE__SOURCE_SS = eINSTANCE.getSmartSpace_SourceSS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMART_SPACE__SOURCE = eINSTANCE.getSmartSpace_Source();

		/**
		 * The meta object literal for the '{@link Twosml.twosml.impl.ConsistsOfImpl <em>Consists Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Twosml.twosml.impl.ConsistsOfImpl
		 * @see Twosml.twosml.impl.TwosmlPackageImpl#getConsistsOf()
		 * @generated
		 */
		EClass CONSISTS_OF = eINSTANCE.getConsistsOf();

		/**
		 * The meta object literal for the '<em><b>Target PS</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSISTS_OF__TARGET_PS = eINSTANCE.getConsistsOf_TargetPS();

		/**
		 * The meta object literal for the '{@link Twosml.twosml.impl.HostsImpl <em>Hosts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Twosml.twosml.impl.HostsImpl
		 * @see Twosml.twosml.impl.TwosmlPackageImpl#getHosts()
		 * @generated
		 */
		EClass HOSTS = eINSTANCE.getHosts();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOSTS__TARGET = eINSTANCE.getHosts_Target();

		/**
		 * The meta object literal for the '{@link Twosml.twosml.impl.UbiquitousApplicationImpl <em>Ubiquitous Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Twosml.twosml.impl.UbiquitousApplicationImpl
		 * @see Twosml.twosml.impl.TwosmlPackageImpl#getUbiquitousApplication()
		 * @generated
		 */
		EClass UBIQUITOUS_APPLICATION = eINSTANCE.getUbiquitousApplication();

		/**
		 * The meta object literal for the '<em><b>Ubi App H</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UBIQUITOUS_APPLICATION__UBI_APP_H = eINSTANCE.getUbiquitousApplication_UbiAppH();

		/**
		 * The meta object literal for the '<em><b>Ubi App ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UBIQUITOUS_APPLICATION__UBI_APP_ID = eINSTANCE.getUbiquitousApplication_UbiAppID();

		/**
		 * The meta object literal for the '<em><b>EReference3</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UBIQUITOUS_APPLICATION__EREFERENCE3 = eINSTANCE.getUbiquitousApplication_EReference3();

	}

} //TwosmlPackage
