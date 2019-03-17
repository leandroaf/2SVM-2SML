/**
 */
package Twosml.twosml.impl;

import Twosml.twosml.ControlSchema;
import Twosml.twosml.PhysicalSpace;
import Twosml.twosml.SmartSpace;
import Twosml.twosml.TwosmlPackage;
import Twosml.twosml.UbiquitousApplication;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Twosml.twosml.impl.ControlSchemaImpl#getHasPhysicalSpace <em>Has Physical Space</em>}</li>
 *   <li>{@link Twosml.twosml.impl.ControlSchemaImpl#getHasSmartSpace <em>Has Smart Space</em>}</li>
 *   <li>{@link Twosml.twosml.impl.ControlSchemaImpl#getHasUbiquitousApplication <em>Has Ubiquitous Application</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlSchemaImpl extends MinimalEObjectImpl.Container implements ControlSchema {
	/**
	 * The cached value of the '{@link #getHasPhysicalSpace() <em>Has Physical Space</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasPhysicalSpace()
	 * @generated
	 * @ordered
	 */
	protected EList<PhysicalSpace> hasPhysicalSpace;

	/**
	 * The cached value of the '{@link #getHasSmartSpace() <em>Has Smart Space</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasSmartSpace()
	 * @generated
	 * @ordered
	 */
	protected SmartSpace hasSmartSpace;

	/**
	 * The cached value of the '{@link #getHasUbiquitousApplication() <em>Has Ubiquitous Application</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasUbiquitousApplication()
	 * @generated
	 * @ordered
	 */
	protected EList<UbiquitousApplication> hasUbiquitousApplication;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlSchemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TwosmlPackage.Literals.CONTROL_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PhysicalSpace> getHasPhysicalSpace() {
		if (hasPhysicalSpace == null) {
			hasPhysicalSpace = new EObjectContainmentEList<PhysicalSpace>(PhysicalSpace.class, this, TwosmlPackage.CONTROL_SCHEMA__HAS_PHYSICAL_SPACE);
		}
		return hasPhysicalSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmartSpace getHasSmartSpace() {
		return hasSmartSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasSmartSpace(SmartSpace newHasSmartSpace, NotificationChain msgs) {
		SmartSpace oldHasSmartSpace = hasSmartSpace;
		hasSmartSpace = newHasSmartSpace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE, oldHasSmartSpace, newHasSmartSpace);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasSmartSpace(SmartSpace newHasSmartSpace) {
		if (newHasSmartSpace != hasSmartSpace) {
			NotificationChain msgs = null;
			if (hasSmartSpace != null)
				msgs = ((InternalEObject)hasSmartSpace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE, null, msgs);
			if (newHasSmartSpace != null)
				msgs = ((InternalEObject)newHasSmartSpace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE, null, msgs);
			msgs = basicSetHasSmartSpace(newHasSmartSpace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE, newHasSmartSpace, newHasSmartSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UbiquitousApplication> getHasUbiquitousApplication() {
		if (hasUbiquitousApplication == null) {
			hasUbiquitousApplication = new EObjectContainmentEList<UbiquitousApplication>(UbiquitousApplication.class, this, TwosmlPackage.CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION);
		}
		return hasUbiquitousApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TwosmlPackage.CONTROL_SCHEMA__HAS_PHYSICAL_SPACE:
				return ((InternalEList<?>)getHasPhysicalSpace()).basicRemove(otherEnd, msgs);
			case TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE:
				return basicSetHasSmartSpace(null, msgs);
			case TwosmlPackage.CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION:
				return ((InternalEList<?>)getHasUbiquitousApplication()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TwosmlPackage.CONTROL_SCHEMA__HAS_PHYSICAL_SPACE:
				return getHasPhysicalSpace();
			case TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE:
				return getHasSmartSpace();
			case TwosmlPackage.CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION:
				return getHasUbiquitousApplication();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TwosmlPackage.CONTROL_SCHEMA__HAS_PHYSICAL_SPACE:
				getHasPhysicalSpace().clear();
				getHasPhysicalSpace().addAll((Collection<? extends PhysicalSpace>)newValue);
				return;
			case TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE:
				setHasSmartSpace((SmartSpace)newValue);
				return;
			case TwosmlPackage.CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION:
				getHasUbiquitousApplication().clear();
				getHasUbiquitousApplication().addAll((Collection<? extends UbiquitousApplication>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TwosmlPackage.CONTROL_SCHEMA__HAS_PHYSICAL_SPACE:
				getHasPhysicalSpace().clear();
				return;
			case TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE:
				setHasSmartSpace((SmartSpace)null);
				return;
			case TwosmlPackage.CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION:
				getHasUbiquitousApplication().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TwosmlPackage.CONTROL_SCHEMA__HAS_PHYSICAL_SPACE:
				return hasPhysicalSpace != null && !hasPhysicalSpace.isEmpty();
			case TwosmlPackage.CONTROL_SCHEMA__HAS_SMART_SPACE:
				return hasSmartSpace != null;
			case TwosmlPackage.CONTROL_SCHEMA__HAS_UBIQUITOUS_APPLICATION:
				return hasUbiquitousApplication != null && !hasUbiquitousApplication.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ControlSchemaImpl
