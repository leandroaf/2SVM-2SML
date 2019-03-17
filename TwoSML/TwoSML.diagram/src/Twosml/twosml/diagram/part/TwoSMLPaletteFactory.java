package Twosml.twosml.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class TwoSMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createTwosml1Group());
	}

	/**
	 * Creates "twosml" palette tool group
	 * @generated
	 */
	private PaletteContainer createTwosml1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Twosml.twosml.diagram.part.Messages.Twosml1Group_title);
		paletteContainer.setId("createTwosml1Group"); //$NON-NLS-1$
		paletteContainer.add(createPhysicalSpace1CreationTool());
		paletteContainer.add(createSmartSpace2CreationTool());
		paletteContainer.add(createConsistsOf3CreationTool());
		paletteContainer.add(createHosts4CreationTool());
		paletteContainer.add(createUbiquitousApplication5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPhysicalSpace1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Twosml.twosml.diagram.part.Messages.PhysicalSpace1CreationTool_title,
				Twosml.twosml.diagram.part.Messages.PhysicalSpace1CreationTool_desc,
				Collections
						.singletonList(Twosml.twosml.diagram.providers.TwoSMLElementTypes.PhysicalSpace_2007));
		entry.setId("createPhysicalSpace1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Twosml.twosml.diagram.providers.TwoSMLElementTypes
				.getImageDescriptor(Twosml.twosml.diagram.providers.TwoSMLElementTypes.PhysicalSpace_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSmartSpace2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Twosml.twosml.diagram.part.Messages.SmartSpace2CreationTool_title,
				Twosml.twosml.diagram.part.Messages.SmartSpace2CreationTool_desc,
				Collections
						.singletonList(Twosml.twosml.diagram.providers.TwoSMLElementTypes.SmartSpace_2005));
		entry.setId("createSmartSpace2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Twosml.twosml.diagram.providers.TwoSMLElementTypes
				.getImageDescriptor(Twosml.twosml.diagram.providers.TwoSMLElementTypes.SmartSpace_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConsistsOf3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Twosml.twosml.diagram.part.Messages.ConsistsOf3CreationTool_title,
				Twosml.twosml.diagram.part.Messages.ConsistsOf3CreationTool_desc,
				Collections
						.singletonList(Twosml.twosml.diagram.providers.TwoSMLElementTypes.ConsistsOf_4002));
		entry.setId("createConsistsOf3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Twosml.twosml.diagram.providers.TwoSMLElementTypes
				.getImageDescriptor(Twosml.twosml.diagram.providers.TwoSMLElementTypes.ConsistsOf_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHosts4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Twosml.twosml.diagram.part.Messages.Hosts4CreationTool_title,
				Twosml.twosml.diagram.part.Messages.Hosts4CreationTool_desc,
				Collections
						.singletonList(Twosml.twosml.diagram.providers.TwoSMLElementTypes.Hosts_4001));
		entry.setId("createHosts4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Twosml.twosml.diagram.providers.TwoSMLElementTypes
				.getImageDescriptor(Twosml.twosml.diagram.providers.TwoSMLElementTypes.Hosts_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUbiquitousApplication5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Twosml.twosml.diagram.part.Messages.UbiquitousApplication5CreationTool_title,
				Twosml.twosml.diagram.part.Messages.UbiquitousApplication5CreationTool_desc,
				Collections
						.singletonList(Twosml.twosml.diagram.providers.TwoSMLElementTypes.UbiquitousApplication_2006));
		entry.setId("createUbiquitousApplication5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Twosml.twosml.diagram.providers.TwoSMLElementTypes
				.getImageDescriptor(Twosml.twosml.diagram.providers.TwoSMLElementTypes.UbiquitousApplication_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
