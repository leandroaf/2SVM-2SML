package twosvm.model.manipulatorlanguage;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import Twosml.TwosmlPackage;
import Twosml.impl.TwosmlFactoryImpl;

public class LoadModel {
	
	private static ResourceSet resourceSet;
	
	/**
	 *  
	 * @return
	 */
	public static ResourceSet getResourceSet() {

		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			Resource.Factory.Registry rfr = resourceSet
					.getResourceFactoryRegistry();
			resourceSet.getPackageRegistry().put(TwosmlPackage.eNS_URI,
					TwosmlPackage.eINSTANCE);

			rfr.getExtensionToFactoryMap().put("ecore",
					new EcoreResourceFactoryImpl());
			rfr.getExtensionToFactoryMap().put("twosml",
					new XMIResourceFactoryImpl());

			TwosmlFactoryImpl.init();
		}

		return resourceSet;
	}
	
	/**
	 * 
	 * @param uri
	 * @return
	 */
	public static Resource loadURL(URI uri) {
		return getResourceSet()
				.getResource(URI.createURI(uri.toString()), true);
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static Resource loadResource(String path) {
		return loadURL(URI.createURI(path));
	}
 
	/**
	 * Retorna o primeiro tipo que encontrar
	 * @param path
	 * @param type
	 * @return
	 */
	public static EObject loadFirst(String path, Class type) {
		List<EObject> list = loadAll(path, type);
		for (EObject obj : list) {
			if (type.isAssignableFrom(obj.getClass())) {
				return obj;
			}
		}
		return null;
	}

	/**
	 * Retorna todos os elementos do tipo "type"
	 * @param path
	 * @param type
	 * @return
	 */
	public static List<EObject> loadAll(String path, Class type) {
		
		Resource res = loadResource(path);

		TreeIterator<EObject> i = res.getAllContents();

		List<EObject> list = new LinkedList<EObject>();

		while (i.hasNext()) {
			EObject resource = i.next();
			if (type.isAssignableFrom(resource.getClass())) {
				list.add(resource);
			}
		}
		return list;
	}

}
