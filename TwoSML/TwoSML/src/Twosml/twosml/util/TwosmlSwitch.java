/**
 */
package Twosml.twosml.util;

import Twosml.twosml.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see Twosml.twosml.TwosmlPackage
 * @generated
 */
public class TwosmlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TwosmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TwosmlSwitch() {
		if (modelPackage == null) {
			modelPackage = TwosmlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TwosmlPackage.CONTROL_SCHEMA: {
				ControlSchema controlSchema = (ControlSchema)theEObject;
				T result = caseControlSchema(controlSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TwosmlPackage.PHYSICAL_SPACE: {
				PhysicalSpace physicalSpace = (PhysicalSpace)theEObject;
				T result = casePhysicalSpace(physicalSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TwosmlPackage.SMART_SPACE: {
				SmartSpace smartSpace = (SmartSpace)theEObject;
				T result = caseSmartSpace(smartSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TwosmlPackage.CONSISTS_OF: {
				ConsistsOf consistsOf = (ConsistsOf)theEObject;
				T result = caseConsistsOf(consistsOf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TwosmlPackage.HOSTS: {
				Hosts hosts = (Hosts)theEObject;
				T result = caseHosts(hosts);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TwosmlPackage.UBIQUITOUS_APPLICATION: {
				UbiquitousApplication ubiquitousApplication = (UbiquitousApplication)theEObject;
				T result = caseUbiquitousApplication(ubiquitousApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlSchema(ControlSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Physical Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Physical Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhysicalSpace(PhysicalSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Smart Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Smart Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmartSpace(SmartSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consists Of</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consists Of</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsistsOf(ConsistsOf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hosts</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hosts</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHosts(Hosts object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ubiquitous Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ubiquitous Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUbiquitousApplication(UbiquitousApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TwosmlSwitch
