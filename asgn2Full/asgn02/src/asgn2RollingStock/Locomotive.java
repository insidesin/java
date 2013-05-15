package asgn2RollingStock;

import asgn2Exceptions.TrainException;


/**
 * 
 * @author Jackson Powell, Yeo Fei Wen
 *
 **/
public class Locomotive extends RollingStock {
	
	
	private Integer weightOfLocomotive;
	private Integer pullTotalWeight;
	private String locomotiveClassification;
	private int powerClass;
	private String engineType;
	
	private Integer enginePower = 100;
	
	private String classificationError = "Starting with a power value of (1-9), followed by" +
									"an engine type of either 'E' for Electrical, 'D' for Diesel or 'S' for Steam. " + 
									"An example will be '4S'.";
	
	/**
	 * Creates a new Locomotive Engine/instance.
	 * 
	 * @param grossWeight The gross weight associated with this type of locomotive.
	 * @param classification The type of engine this locomotive have.
	 */
	public Locomotive(Integer grossWeight, String classification) throws TrainException {
		super(grossWeight);
		
		if(classification == null){
			throw new TrainException("A locomotive classification have to be added with these guidelines:" +
					classificationError);
			
		}
		
		if(classification.length() != 2){
			throw new TrainException("A locomotive classification have to consist of only two characters. " + 
					classificationError);
		}
		

		int powerTest = Integer.parseInt(classification.substring(0,1));
		String engineTest = classification.substring(1,2);
		
		
		if(powerTest < 1 || powerTest > 9){
			throw new TrainException("Invalid power class in classification. Must define using the guidelines. " +
					classificationError);
			
		}
		
		if(!engineTest.equals("S") && !engineTest.equals("D") && !engineTest.equals("E")){
			throw new TrainException("Invalid engine type in classification." + engineTest + " Must define using the guidelines. " +
					classificationError);
		}
		
		
		this.locomotiveClassification = classification;
		
		//PowerClass (0-9)
		this.powerClass = powerTest;
		
		//Engine Type (Steam / Diesel / Electirc)
		this.engineType = engineTest;
		
		//Weight of the Locomotive
		this.weightOfLocomotive = grossWeight;
		
		
		if(((powerClass * enginePower) - weightOfLocomotive) <= 0){
			throw new TrainException("Locomotive cannot generate the amount of power to pull and move. " +
					"Please place a higher power class higher than : " + powerClass);
		}
		
		//total weight the locomotive can pull
		this.pullTotalWeight = (powerClass * enginePower) - weightOfLocomotive;
	
	}
	
	/**
	 * Returns how much total weight the locomotive can pull (including itself), calculated as explained above.
	 * @return the locomotive's "pulling power" in tonnes
	 */
	public Integer power(){
		return pullTotalWeight;
	}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see asgn2RollingStock.RollingStock#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return "Loco("+locomotiveClassification+")";
	}

}
