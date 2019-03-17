/**
 */
package Twosml.twosml.util;

import Twosml.twosml.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Twosml.twosml.TwosmlPackage
 * @generated
 */
public class TwosmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TwosmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TwosmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TwosmlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TwosmlSwitch<Adapter> modelSwitch =
		new TwosmlSwitch<Adapter>() {
			@Override
			public Adapter caseControlSchema(ControlSchema object) {
				return createControlSchemaAdapter();
			}
			@Override
			public Adapter casePhysicalSpace(PhysicalSpace object) {
				return createPhysicalSpaceAdapter();
			}
			@Override
			public Adapter caseSmartSpace(SmartSpace object) {
				return createSmartSpaceAdapter();
			}
			@Override
			public Adapter caseConsistsOf(ConsistsOf object) {
				return createConsistsOfAdapter();
			}
			@Override
			public Adapter caseHosts(Hosts object) {
				return createHostsAdapter();
			}
			@Override
			public Adapter caseUbiquitousApplication(UbiquitousApplication object) {
				return createUbiquitousApplicationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link Twosml.twosml.ControlSchema <em>Control Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Twosml.twosml.ControlSchema
	 * @generated
	 */
	public Adapter createControlSchemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Twosml.twosml.PhysicalSpace <em>Physical Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Twosml.twosml.PhysicalSpace
	 * @generated
	 */
	public Adapter createPhysicalSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Twosml.twosml.SmartSpace <em>Smart Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Twosml.twosml.SmartSpace
	 * @generated
	 */
	public Adapter createSmartSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Twosml.twosml.ConsistsOf <em>Consists Of</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Twosml.twosml.ConsistsOf
	 * @generated
	 */
	public Adapter createConsistsOfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Twosml.twosml.Hosts <em>Hosts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Twosml.twosml.Hosts
	 * @generated
	 */
	public Adapter createHostsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Twosml.twosml.UbiquitousApplication <em>Ubiquitous Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Twosml.twosml.UbiquitousApplication
	 * @generated
	 */
	public Adapter createUbiquitousApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TwosmlAdapterFactory
