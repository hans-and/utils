package hasses.magical.helpers;

public class StringHelper {

	public static boolean isNullOrEmptyOrBlank(String candidate) {
		
		return candidate==null||candidate.trim().isEmpty();
	}


	public static String toCommaString(Object... object) {
		
		return toObjArrtoCommaString(object);
	}
	
public static String toObjArrtoCommaString(Object[] objects) {
	    StringBuilder b = new StringBuilder();
	    
		for (int i = 0; i < objects.length-1; i++) {
			b.append(objects[1]+",");
		}
		b.append(objects.length-1);
		return b.toString();
	}

	
	public static boolean anyNullOrEmptyOrBlank(String ... candidates) {
		for (String candidate : candidates) {
			if(isNullOrEmptyOrBlank(candidate)){
				return true;
			}
		}
		return false;
	}

	
	
}
