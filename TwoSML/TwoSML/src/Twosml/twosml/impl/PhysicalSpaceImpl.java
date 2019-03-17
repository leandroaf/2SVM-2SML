/**
 */
package Twosml.twosml.impl;

import Twosml.twosml.ConsistsOf;
import Twosml.twosml.PhysicalSpace;
import Twosml.twosml.TwosmlPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Twosml.twosml.impl.PhysicalSpaceImpl#getPSpaceCO <em>PSpace CO</em>}</li>
 *   <li>{@link Twosml.twosml.impl.PhysicalSpaceImpl#getPSpaceID <em>PSpace ID</em>}</li>
 *   <li>{@link Twosml.twosml.impl.PhysicalSpaceImpl#getEReference2 <em>EReference2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PhysicalSpaceImpl extends MinimalEObjectImpl.Container implements PhysicalSpace {
	/**
	 * The cached value of the '{@link #getPSpaceCO() <em>PSpace CO</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPSpaceCO()
	 * @generated
	 * @ordered
	 */
	protected ConsistsOf pSpaceCO;
	/**
	 * The default value of the '{@link #getPSpaceID() <em>PSpace ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPSpaceID()
	 * @generated
	 * @ordered
	 */
	protected static final String PSPACE_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPSpaceID() <em>PSpace ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPSpaceID()
	 * @generated
	 * @ordered
	 */
	protected String pSpaceID = PSPACE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEReference2() <em>EReference2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference2()
	 * @generated
	 * @ordered
	 */
	protected ConsistsOf eReference2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TwosmlPackage.Literals.PHYSICAL_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsistsOf getPSpaceCO() {
		return pSpaceCO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPSpaceCO(ConsistsOf newPSpaceCO, NotificationChain msgs) {
		ConsistsOf oldPSpaceCO = pSpaceCO;
		pSpaceCO = newPSpaceCO;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO, oldPSpaceCO, newPSpaceCO);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPSpaceCO(ConsistsOf newPSpaceCO) {
		if (newPSpaceCO != pSpaceCO) {
			NotificationChain msgs = null;
			if (pSpaceCO != null)
				msgs = ((InternalEObject)pSpaceCO).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO, null, msgs);
			if (newPSpaceCO != null)
				msgs = ((InternalEObject)newPSpaceCO).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO, null, msgs);
			msgs = basicSetPSpaceCO(newPSpaceCO, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO, newPSpaceCO, newPSpaceCO));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPSpaceID() {
		return pSpaceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPSpaceID(String newPSpaceID) {
		String oldPSpaceID = pSpaceID;
		pSpaceID = newPSpaceID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.PHYSICAL_SPACE__PSPACE_ID, oldPSpaceID, pSpaceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsistsOf getEReference2() {
		return eReference2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEReference2(ConsistsOf newEReference2, NotificationChain msgs) {
		ConsistsOf oldEReference2 = eReference2;
		eReference2 = newEReference2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2, oldEReference2, newEReference2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference2(ConsistsOf newEReference2) {
		if (newEReference2 != eReference2) {
			NotificationChain msgs = null;
			if (eReference2 != null)
				msgs = ((InternalEObject)eReference2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2, null, msgs);
			if (newEReference2 != null)
				msgs = ((InternalEObject)newEReference2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2, null, msgs);
			msgs = basicSetEReference2(newEReference2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2, newEReference2, newEReference2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO:
				return basicSetPSpaceCO(null, msgs);
			case TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2:
				return basicSetEReference2(null, msgs);
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
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO:
				return getPSpaceCO();
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_ID:
				return getPSpaceID();
			case TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2:
				return getEReference2();
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
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO:
				setPSpaceCO((ConsistsOf)newValue);
				return;
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_ID:
				setPSpaceID((String)newValue);
				return;
			case TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2:
				setEReference2((ConsistsOf)newValue);
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
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO:
				setPSpaceCO((ConsistsOf)null);
				return;
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_ID:
				setPSpaceID(PSPACE_ID_EDEFAULT);
				return;
			case TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2:
				setEReference2((ConsistsOf)null);
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
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_CO:
				return pSpaceCO != null;
			case TwosmlPackage.PHYSICAL_SPACE__PSPACE_ID:
				return PSPACE_ID_EDEFAULT == null ? pSpaceID != null : !PSPACE_ID_EDEFAULT.equals(pSpaceID);
			case TwosmlPackage.PHYSICAL_SPACE__EREFERENCE2:
				return eReference2 != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (pSpaceID: ");
		result.append(pSpaceID);
		result.append(')');
		return result.toString();
	}

} //PhysicalSpaceImpl
