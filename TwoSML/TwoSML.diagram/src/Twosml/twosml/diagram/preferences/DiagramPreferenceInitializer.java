package Twosml.twosml.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		Twosml.twosml.diagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		Twosml.twosml.diagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		Twosml.twosml.diagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		Twosml.twosml.diagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		Twosml.twosml.diagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin
				.getInstance().getPreferenceStore();
	}
}
