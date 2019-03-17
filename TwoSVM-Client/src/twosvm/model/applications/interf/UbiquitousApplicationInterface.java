package twosvm.model.applications.interf;

import java.io.Serializable;

import twosvm.model.applications.ApplicationState;

public interface UbiquitousApplicationInterface extends Serializable {
	
	public abstract void startApplication();
	
	public abstract void pauseApplication();
	
	public abstract void resumeApplication();
	
	public abstract void stopApplication();
	
	public abstract void destroyApplication();
	
	public abstract ApplicationState saveApplicationState();
	
	public abstract void restoreApplicationState(ApplicationState applicationState);
	
	public abstract void notifyUser();
	
}