package Twosml.twosml.diagram.providers;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			Twosml.twosml.diagram.part.TwoSMLDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
