/**
 */
package Twosml.twosml.impl;

import Twosml.twosml.ConsistsOf;
import Twosml.twosml.PhysicalSpace;
import Twosml.twosml.TwosmlPackage;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consists Of</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Twosml.twosml.impl.ConsistsOfImpl#getTargetPS <em>Target PS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConsistsOfImpl extends MinimalEObjectImpl.Container implements ConsistsOf {
	/**
	 * The cached value of the '{@link #getTargetPS() <em>Target PS</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPS()
	 * @generated
	 * @ordered
	 */
	protected EList<PhysicalSpace> targetPS;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsistsOfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TwosmlPackage.Literals.CONSISTS_OF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PhysicalSpace> getTargetPS() {
		if (targetPS == null) {
			targetPS = new EObjectResolvingEList<PhysicalSpace>(PhysicalSpace.class, this, TwosmlPackage.CONSISTS_OF__TARGET_PS);
		}
		return targetPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TwosmlPackage.CONSISTS_OF__TARGET_PS:
				return getTargetPS();
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
			case TwosmlPackage.CONSISTS_OF__TARGET_PS:
				getTargetPS().clear();
				getTargetPS().addAll((Collection<? extends PhysicalSpace>)newValue);
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
			case TwosmlPackage.CONSISTS_OF__TARGET_PS:
				getTargetPS().clear();
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
			case TwosmlPackage.CONSISTS_OF__TARGET_PS:
				return targetPS != null && !targetPS.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConsistsOfImpl
