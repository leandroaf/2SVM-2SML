package twosvm.uctwosmiddleware.manager;

public class UcTwosMiddlewareFacade {

	private UcTwosMiddlewareManager ucTwosMiddlewareManager = new UcTwosMiddlewareManager();
	
	/**
	 * 
	 */
	public void startMiddlewareLayer() {
		ucTwosMiddlewareManager.startServicesMiddlewareLayer();
	} // fim do metodo startMiddlewareLayer

}
