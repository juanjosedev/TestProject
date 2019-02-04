package constantes_;

public class SingletonTest {

	private static SingletonTest instance = null;

	private SingletonTest() {

	}
	
	public static SingletonTest getInstance() {
		
		return new SingletonTest();
		
	}

}
