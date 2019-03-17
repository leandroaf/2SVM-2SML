/**
 */
package Twosml.twosml.impl;

import Twosml.twosml.ConsistsOf;
import Twosml.twosml.Hosts;
import Twosml.twosml.SmartSpace;
import Twosml.twosml.TwosmlPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Smart Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Twosml.twosml.impl.SmartSpaceImpl#getEReference1 <em>EReference1</em>}</li>
 *   <li>{@link Twosml.twosml.impl.SmartSpaceImpl#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link Twosml.twosml.impl.SmartSpaceImpl#getSSpaceID <em>SSpace ID</em>}</li>
 *   <li>{@link Twosml.twosml.impl.SmartSpaceImpl#getSourceSS <em>Source SS</em>}</li>
 *   <li>{@link Twosml.twosml.impl.SmartSpaceImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SmartSpaceImpl extends MinimalEObjectImpl.Container implements SmartSpace {
	/**
	 * The cached value of the '{@link #getEReference1() <em>EReference1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference1()
	 * @generated
	 * @ordered
	 */
	protected ConsistsOf eReference1;

	/**
	 * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference0()
	 * @generated
	 * @ordered
	 */
	protected Hosts eReference0;

	/**
	 * The default value of the '{@link #getSSpaceID() <em>SSpace ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSpaceID()
	 * @generated
	 * @ordered
	 */
	protected static final String SSPACE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSpaceID() <em>SSpace ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSpaceID()
	 * @generated
	 * @ordered
	 */
	protected String sSpaceID = SSPACE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceSS() <em>Source SS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceSS()
	 * @generated
	 * @ordered
	 */
	protected ConsistsOf sourceSS;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Hosts source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SmartSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TwosmlPackage.Literals.SMART_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsistsOf getEReference1() {
		return eReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEReference1(ConsistsOf newEReference1, NotificationChain msgs) {
		ConsistsOf oldEReference1 = eReference1;
		eReference1 = newEReference1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TwosmlPackage.SMART_SPACE__EREFERENCE1, oldEReference1, newEReference1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference1(ConsistsOf newEReference1) {
		if (newEReference1 != eReference1) {
			NotificationChain msgs = null;
			if (eReference1 != null)
				msgs = ((InternalEObject)eReference1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.SMART_SPACE__EREFERENCE1, null, msgs);
			if (newEReference1 != null)
				msgs = ((InternalEObject)newEReference1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.SMART_SPACE__EREFERENCE1, null, msgs);
			msgs = basicSetEReference1(newEReference1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.SMART_SPACE__EREFERENCE1, newEReference1, newEReference1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hosts getEReference0() {
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEReference0(Hosts newEReference0, NotificationChain msgs) {
		Hosts oldEReference0 = eReference0;
		eReference0 = newEReference0;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TwosmlPackage.SMART_SPACE__EREFERENCE0, oldEReference0, newEReference0);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference0(Hosts newEReference0) {
		if (newEReference0 != eReference0) {
			NotificationChain msgs = null;
			if (eReference0 != null)
				msgs = ((InternalEObject)eReference0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.SMART_SPACE__EREFERENCE0, null, msgs);
			if (newEReference0 != null)
				msgs = ((InternalEObject)newEReference0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TwosmlPackage.SMART_SPACE__EREFERENCE0, null, msgs);
			msgs = basicSetEReference0(newEReference0, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.SMART_SPACE__EREFERENCE0, newEReference0, newEReference0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSpaceID() {
		return sSpaceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSpaceID(String newSSpaceID) {
		String oldSSpaceID = sSpaceID;
		sSpaceID = newSSpaceID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.SMART_SPACE__SSPACE_ID, oldSSpaceID, sSpaceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsistsOf getSourceSS() {
		if (sourceSS != null && sourceSS.eIsProxy()) {
			InternalEObject oldSourceSS = (InternalEObject)sourceSS;
			sourceSS = (ConsistsOf)eResolveProxy(oldSourceSS);
			if (sourceSS != oldSourceSS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TwosmlPackage.SMART_SPACE__SOURCE_SS, oldSourceSS, sourceSS));
			}
		}
		return sourceSS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsistsOf basicGetSourceSS() {
		return sourceSS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceSS(ConsistsOf newSourceSS) {
		ConsistsOf oldSourceSS = sourceSS;
		sourceSS = newSourceSS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.SMART_SPACE__SOURCE_SS, oldSourceSS, sourceSS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hosts getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Hosts)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TwosmlPackage.SMART_SPACE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hosts basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Hosts newSource) {
		Hosts oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TwosmlPackage.SMART_SPACE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TwosmlPackage.SMART_SPACE__EREFERENCE1:
				return basicSetEReference1(null, msgs);
			case TwosmlPackage.SMART_SPACE__EREFERENCE0:
				return basicSetEReference0(null, msgs);
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
			case TwosmlPackage.SMART_SPACE__EREFERENCE1:
				return getEReference1();
			case TwosmlPackage.SMART_SPACE__EREFERENCE0:
				return getEReference0();
			case TwosmlPackage.SMART_SPACE__SSPACE_ID:
				return getSSpaceID();
			case TwosmlPackage.SMART_SPACE__SOURCE_SS:
				if (resolve) return getSourceSS();
				return basicGetSourceSS();
			case TwosmlPackage.SMART_SPACE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TwosmlPackage.SMART_SPACE__EREFERENCE1:
				setEReference1((ConsistsOf)newValue);
				return;
			case TwosmlPackage.SMART_SPACE__EREFERENCE0:
				setEReference0((Hosts)newValue);
				return;
			case TwosmlPackage.SMART_SPACE__SSPACE_ID:
				setSSpaceID((String)newValue);
				return;
			case TwosmlPackage.SMART_SPACE__SOURCE_SS:
				setSourceSS((ConsistsOf)newValue);
				return;
			case TwosmlPackage.SMART_SPACE__SOURCE:
				setSource((Hosts)newValue);
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
			case TwosmlPackage.SMART_SPACE__EREFERENCE1:
				setEReference1((ConsistsOf)null);
				return;
			case TwosmlPackage.SMART_SPACE__EREFERENCE0:
				setEReference0((Hosts)null);
				return;
			case TwosmlPackage.SMART_SPACE__SSPACE_ID:
				setSSpaceID(SSPACE_ID_EDEFAULT);
				return;
			case TwosmlPackage.SMART_SPACE__SOURCE_SS:
				setSourceSS((ConsistsOf)null);
				return;
			case TwosmlPackage.SMART_SPACE__SOURCE:
				setSource((Hosts)null);
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
			case TwosmlPackage.SMART_SPACE__EREFERENCE1:
				return eReference1 != null;
			case TwosmlPackage.SMART_SPACE__EREFERENCE0:
				return eReference0 != null;
			case TwosmlPackage.SMART_SPACE__SSPACE_ID:
				return SSPACE_ID_EDEFAULT == null ? sSpaceID != null : !SSPACE_ID_EDEFAULT.equals(sSpaceID);
			case TwosmlPackage.SMART_SPACE__SOURCE_SS:
				return sourceSS != null;
			case TwosmlPackage.SMART_SPACE__SOURCE:
				return source != null;
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
		result.append(" (sSpaceID: ");
		result.append(sSpaceID);
		result.append(')');
		return result.toString();
	}

} //SmartSpaceImpl
