package Twosml.twosml.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TwoSMLParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser smartSpaceSSpaceID_5005Parser;

	/**
	 * @generated
	 */
	private IParser getSmartSpaceSSpaceID_5005Parser() {
		if (smartSpaceSSpaceID_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { Twosml.twosml.TwosmlPackage.eINSTANCE
					.getSmartSpace_SSpaceID() };
			Twosml.twosml.diagram.parsers.MessageFormatParser parser = new Twosml.twosml.diagram.parsers.MessageFormatParser(
					features);
			smartSpaceSSpaceID_5005Parser = parser;
		}
		return smartSpaceSSpaceID_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser ubiquitousApplicationUbiAppID_5006Parser;

	/**
	 * @generated
	 */
	private IParser getUbiquitousApplicationUbiAppID_5006Parser() {
		if (ubiquitousApplicationUbiAppID_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { Twosml.twosml.TwosmlPackage.eINSTANCE
					.getUbiquitousApplication_UbiAppID() };
			Twosml.twosml.diagram.parsers.MessageFormatParser parser = new Twosml.twosml.diagram.parsers.MessageFormatParser(
					features);
			ubiquitousApplicationUbiAppID_5006Parser = parser;
		}
		return ubiquitousApplicationUbiAppID_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser physicalSpacePSpaceID_5007Parser;

	/**
	 * @generated
	 */
	private IParser getPhysicalSpacePSpaceID_5007Parser() {
		if (physicalSpacePSpaceID_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { Twosml.twosml.TwosmlPackage.eINSTANCE
					.getPhysicalSpace_PSpaceID() };
			Twosml.twosml.diagram.parsers.MessageFormatParser parser = new Twosml.twosml.diagram.parsers.MessageFormatParser(
					features);
			physicalSpacePSpaceID_5007Parser = parser;
		}
		return physicalSpacePSpaceID_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case Twosml.twosml.diagram.edit.parts.SmartSpaceSSpaceIDEditPart.VISUAL_ID:
			return getSmartSpaceSSpaceID_5005Parser();
		case Twosml.twosml.diagram.edit.parts.UbiquitousApplicationUbiAppIDEditPart.VISUAL_ID:
			return getUbiquitousApplicationUbiAppID_5006Parser();
		case Twosml.twosml.diagram.edit.parts.PhysicalSpacePSpaceIDEditPart.VISUAL_ID:
			return getPhysicalSpacePSpaceID_5007Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(Twosml.twosml.diagram.part.TwoSMLVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (Twosml.twosml.diagram.providers.TwoSMLElementTypes
					.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
