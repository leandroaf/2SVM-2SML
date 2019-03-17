package twosvm.model.instance.contextchange;

import twosvm.model.instance.user.User;

public class MainTest {

	public static void main(String args[]) {

		String condition = new String();
		condition = "(contextChange.user.userNameSS() == 'Leandro') && (contextChange.user.appTypeSS() == 'textEditor') && (contextChange.user.deviceSS() == 'notebook')";

		ContextChangeGroovy conGroovy = new ContextChangeGroovy();
		ContextChange cChange = new ContextChange();

		User user = new User();
		user.setAppType("textEditor");
		user.setDeviceName("notebook");
		user.setUserName("Leandro");

		cChange.setUser(user);

		System.out.println(conGroovy.interpreterCtx(cChange, condition));

	}

}
