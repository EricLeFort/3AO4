package tools;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Eric Le Fort
 * @version 1.0
 */
public class Forum{
	ArrayList<Rock> common;
	
	/**
	 * Initializes a new list using the passed in array to begin with. Common rocks will
	 * include the whole array since there is nothing to compare to.
	 * @param array - The original array to compare to.
	 */
	public CommonElementsList(Rock[] array){
		common = new ArrayList<Rock>();
		common.addAll(Arrays.asList(array));
	}//Constructor

	/**
	 * Reduces the list of common rocks to only include those found in the list passed in.
	 * @param array - The array of new rocks to check against.
	 */
	public void addList(Rock[] array){
		ArrayList<Rock> newCommon = new ArrayList<Rock>();
		
		for(int i = 0; i < array.length; i++){
			if(common.contains(array[i])){
				newCommon.add(array[i]);
			}
		}
		
		common = newCommon;
	}//addList()
	
	/**
	 * Returns the current list of common rocks.
	 * @return The current list of common rocks.
	 */
	public Rock[] getCommonElements(){
		return common.toArray(new Rock[0]);
	}//getCommonElements()
	
}//CommonElementsList
