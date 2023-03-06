package backend;

public class UseStub {
	private static boolean stubFlag = false;
	/**
	 * if the stubFlag is false, then the actual database is used, if it is true, then the stub database is used
	 */
	public static void setStubFlag(boolean flag) {
		stubFlag=flag;
	}
	public static boolean getStubFlag() { 
		return stubFlag;
	}
}
