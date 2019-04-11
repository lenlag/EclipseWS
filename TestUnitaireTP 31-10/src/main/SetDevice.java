package main;

import java.util.Set;
import java.util.TreeSet;

public class SetDevice {

	Set <String> set = new TreeSet<>();
	
	public Set <String> list () {
		return set;
	}
	
	public void add(String s) {
		if (s==null) {
			return;		// on ne fait rien !
		}
		set.add(s);
	}
	
	public void remove(String s) {
		if (s==null) {
			return;
		}
		set.remove(s);
	}
	
	public void update (String oldVal, String newVal) {
		if ((oldVal == null) || (newVal==null)) {
			return;
		} else if (!set.contains(oldVal)) {
			return;
		} else if (set.contains(newVal)) {
			return;
		}
		set.remove(oldVal);
		set.add(newVal);
			
	}

}
