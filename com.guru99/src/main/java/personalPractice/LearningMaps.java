package personalPractice;

import java.util.HashMap;
import java.util.Map;

public class LearningMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Map<String,String> mp = new HashMap<String, String>();
		
		mp.put("Execute", "Yes");
		mp.put("userName", "mgr123");
		//mp.put("dept", "IT");
		
		
		
		System.out.println(mp.get("Name"));//sachin
		System.out.println(mp.get("id"));//1234
		System.out.println(mp.get("dept"));//IT

	}

}
