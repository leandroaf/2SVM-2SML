/**
 */
package Twosml.twosml.impl;

import Twosml.twosml.Hosts;
import Twosml.twosml.TwosmlPackage;
import Twosml.twosml.UbiquitousApplication;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ubiquitous Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Twosml.twosml.impl.UbiquitousApplicationImpl#getUbiAppH <em>Ubi App H</em>}</li>
 *   <li>{@link Twosml.twosml.impl.UbiquitousApplicationImpl#getUbiAppID <em>Ubi App ID</em>}</li>
 *   <li>{@link Twosml.twosml.impl.UbiquitousApplicationImpl#getEReference3 <em>EReference3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UbiquitousApplicationImpl extends MinimalEObjectImpl.Container implements UbiquitousApplication {
	/**
	 * The cached value of the '{@link #getUbiAppH() <em>Ubi App H</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUbiAppH()
	 * @generated
	 * @ordered
	 */
	protected Hosts ubiAppH;
	/**
	 * The default value of the '{@link #getUbiAppID() <em>Ubi App ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUbiAppID()
	 * @generated
	 * @ordered
	 */
	protected static final String UBI_APP_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUbiAppID() <em>Ubi App ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUbiAppID()
	 * @generated
	 * @ordered
	 */
	protected String ubiAppID = UBI_APP_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEReference3() <em>EReference3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference3()
	 * @generated
	 * @ordered
	 */
	protected Hosts eReference3;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UbiquitousApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TwosmlPackage.Literals.UBIQUITOUS_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hosts getUbiAppH() {
		return ubiAppH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUbiAppH(Hosts newUbiAppH, NotificationChain msgs) {
		Hosts oldUbiAppH = ubiAppH;
		ubiAppH = newUbiAppH;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H, oldUbiAppH, newUbiAppH);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUbiAppH(Hosts newUbiAppH) {
		if (newUbiAppH != ubiAppH) {
			NotificationChain msgs = null;
			if (ubiAppH != null)
				msgs = ((InternalEObject)ubiAppH).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H, null, msgs);
			if (newUbiAppH != null)
				msgs = ((InternalEObject)newUbiAppH).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H, null, msgs);
			msgs = basicSetUbiAppH(newUbiAppH, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H, newUbiAppH, newUbiAppH));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUbiAppID() {
		return ubiAppID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUbiAppID(String newUbiAppID) {
		String oldUbiAppID = ubiAppID;
		ubiAppID = newUbiAppID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_ID, oldUbiAppID, ubiAppID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hosts getEReference3() {
		return eReference3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEReference3(Hosts newEReference3, NotificationChain msgs) {
		Hosts oldEReference3 = eReference3;
		eReference3 = newEReference3;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3, oldEReference3, newEReference3);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference3(Hosts newEReference3) {
		if (newEReference3 != eReference3) {
			NotificationChain msgs = null;
			if (eReference3 != null)
				msgs = ((InternalEObject)eReference3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3, null, msgs);
			if (newEReference3 != null)
				msgs = ((InternalEObject)newEReference3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3, null, msgs);
			msgs = basicSetEReference3(newEReference3, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3, newEReference3, newEReference3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H:
				return basicSetUbiAppH(null, msgs);
			case TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3:
				return basicSetEReference3(null, msgs);
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
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H:
				return getUbiAppH();
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_ID:
				return getUbiAppID();
			case TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3:
				return getEReference3();
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
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H:
				setUbiAppH((Hosts)newValue);
				return;
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_ID:
				setUbiAppID((String)newValue);
				return;
			case TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3:
				setEReference3((Hosts)newValue);
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
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H:
				setUbiAppH((Hosts)null);
				return;
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_ID:
				setUbiAppID(UBI_APP_ID_EDEFAULT);
				return;
			case TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3:
				setEReference3((Hosts)null);
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
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_H:
				return ubiAppH != null;
			case TwosmlPackage.UBIQUITOUS_APPLICATION__UBI_APP_ID:
				return UBI_APP_ID_EDEFAULT == null ? ubiAppID != null : !UBI_APP_ID_EDEFAULT.equals(ubiAppID);
			case TwosmlPackage.UBIQUITOUS_APPLICATION__EREFERENCE3:
				return eReference3 != null;
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
		result.append(" (ubiAppID: ");
		result.append(ubiAppID);
		result.append(')');
		return result.toString();
	}

} //UbiquitousApplicationImpl
