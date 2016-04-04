package tools;

/**
 * @author Eric Le Fort
 * @version 1.0
 */
public class Rock{
	private String name;
	private Colour colour;
	private Hardness hardness;
	private Size size;
	private Texture texture;
	private double lat, lon, radius;
	
	public static void main(String[] args){
		new Rock("", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP, 1, 2, 3).toString();
	}
	
	/**
	 * Creates a new <code>Rock</code> using the following provided information.
	 * @param name - The name of this rock.
	 * @param colour - The usual colour of this rock.
	 * @param hardness - The average hardness of rocks of this type.
	 * @param size - The average size of rocks of this type.
	 * @param texture - The usual texture of rocks of this type.
	 * @param lat - The latitude coordinate that rocks of this type are usually found near.
	 * @param lon - The longitude coordinate that rocks of this type are usually found near.
	 * @param radius - The radius around the central latitude/longitude coordinates where this
	 * rock is commonly found in kilometers.
	 */
	public Rock(String name, Colour colour, Hardness hardness, Size size, Texture texture, double lat, double lon, double radius){
		this.name = name;
		this.colour = colour;
		this.hardness = hardness;
		this.size = size;
		this.texture = texture;
		this.lat = lat;
		this.lon = lon;
		this.radius = radius;
	}//Constructor
	
	/**
	 * Creates a new <code>Rock</code> using the following provided information. Sets the latitude and longitude to be
	 * <code>Long.MAX_VALUE</code> and the radius to be 0.
	 * @param name - The name of this rock.
	 * @param colour - The usual colour of this rock.
	 * @param hardness - The average hardness of rocks of this type.
	 * @param size - The average size of rocks of this type.
	 * @param texture - The usual texture of rocks of this type.
	 */
	public Rock(String name, Colour colour, Hardness hardness, Size size, Texture texture){
		this.name = name;
		this.colour = colour;
		this.hardness = hardness;
		this.size = size;
		this.texture = texture;
		
		lat = Double.MAX_VALUE;
		lon = Double.MAX_VALUE;
		radius = 0;
	}//Constructor
	
	/**
	 * Returns a <code>String</code> representation of this <code>Rock</code> by returning its name.
	 * @return The name of this <code>Rock</code>.
	 */
	@Override
	public String toString(){ return name; }//toString()
	
	/**
	 * Returns the colour of this <code>Rock</code>.
	 * @return The colour of this <code>Rock</code>.
	 */
	public Colour getColour(){
		return colour;
	}//getColour()
	
	/**
	 * Returns the hardness of this <code>Rock</code>.
	 * @return The hardness of this <code>Rock</code>.
	 */
	public Hardness getHardness(){
		return hardness;
	}//getHardness()
	
	/**
	 * Returns the average size of this <code>Rock</code>.
	 * @return The average size of this <code>Rock</code>.
	 */
	public Size getSize(){
		return size;
	}//getSize()
	
	/**
	 * Returns the texture of this <code>Rock</code>.
	 * @return The texture of this <code>Rock</code>.
	 */
	public Texture getTexture(){
		return texture;
	}//getTexture()
	
	/**
	 * Returns the maximum latitude where these rocks are usually found.
	 * @return The maximum latitude where these rocks are usually found.
	 */
	public double maxLat(){ return addToDegreeLatLon(lat, radius); }//maxLat()
	
	/**
	 * Returns the minimum latitude where these rocks are usually found.
	 * @return The minimum latitude where these rocks are usually found.
	 */
	public double minLat(){ return addToDegreeLatLon(lat, -radius); }//minLat()
	
	/**
	 * Returns the maximum longitude where these rocks are usually found.
	 * @return The maximum longitude where these rocks are usually found.
	 */
	public double maxLon(){ return addToDegreeLatLon(lon, radius); }//maxLon()
	
	/**
	 * Returns the minimum longitude where these rocks are usually found.
	 * @return The minimum longitude where these rocks are usually found.
	 */
	public double minLon(){ return addToDegreeLatLon(lon, -radius); }//minLon()
	
	private static double addToDegreeLatLon(double l, double dist){ return l + dist / 111.0; }//addToDegreeLatLon()
	
}//Rock
