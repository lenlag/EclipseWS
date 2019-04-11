package FromScratch;


public interface IParler {
	public default void parler(String s) {
		System.out.println(s);
	};
	
	

}
