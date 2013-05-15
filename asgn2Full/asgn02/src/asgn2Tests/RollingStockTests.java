package asgn2Tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;

public class RollingStockTests {

	/* Variables for all test  */
	private final Integer STANDARD_TEST_WEIGHT = 50;
	private final Integer ZERO_VALUE = 0;
	private final Integer NEGATIVE_VALUE = -10;
	
	/* Variables for FreightCar test */
	private final String STANDARD_GOODS_TYPE = "G";
	private final String INVALID_GOODS_TYPE = "CAR";
	
	/* Variables for Locomotive test */
	private final String VALID_CLASSIFICATION_TYPE = "4S";
	private final String INVALID_CLASSIFICATION_LENGTH_OF_3 = "4SS";
	private final String INVALID_CLASSIFICATION_LENGTH_OF_1 = "4";
	private final String INVALID_CLASSIFICATION_ENGINE_TYPE = "4K";
	private final String INVALID_CLASSIFICATION_POWER_TYPE = "0S";
	
	private final Integer OVER_STANDARD_TEST_WEIGHT = 400;
	private final Integer MAXIMUM_LIMIT_LOCOMOTIVE_WEIGHT = 900;
	
	/* Variables for PassengerCar test */
	private final Integer VALID_NUM_OF_EMPTY_SEATS = 20;
	private final Integer VALID_NUM_OF_BOARDING_PASSENGERS = 18;
	private final Integer VALID_OVER_NUM_OF_BOARDING_PASSENGERS = 22;
	private final Integer VALID_NUM_OF_ALIGHTING_PASSENGERS = 10;
	
	///////////////////////////////////////////FREIGHT CAR TEST STARTS HERE//////////////////////////////////////////
	
	/*TEST IF FreightCar1 == FreightCar2???*/
	private boolean objectsEqual(FreightCar subject1, FreightCar subject2) {
		if(subject1 instanceof FreightCar && subject2 instanceof FreightCar) {
			if(subject1.getGrossWeight() == subject2.getGrossWeight() && 
					subject1.goodsType() == subject2.goodsType())
				return true;
		}
		return false;
	}
	
	@Test
	/*
	 * Attempt to construct a new FreightCar object with valid args.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithValidArguments() throws TrainException {
		FreightCar newFreightCar = new FreightCar(STANDARD_TEST_WEIGHT, STANDARD_GOODS_TYPE);
		assertTrue(objectsEqual(newFreightCar, new FreightCar(STANDARD_TEST_WEIGHT, STANDARD_GOODS_TYPE)));
	}
    
	@Test(expected = TrainException.class) 
	/*
	 * Attempt to construct a new FreightCar object with a gross
	 * weight of negative value, which should throw a TrainException.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithNegativeGrossWeight() throws TrainException {
		FreightCar newFreightCar = new FreightCar(NEGATIVE_VALUE, STANDARD_GOODS_TYPE);
	}
	
	@Test(expected = TrainException.class) 
	/*
	 * Attempt to construct a new FreightCar object with a gross
	 * weight of 0, which should throw a TrainException.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithZeroGrossWeight() throws TrainException {
		FreightCar newFreightCar = new FreightCar(ZERO_VALUE, STANDARD_GOODS_TYPE);
	}
	
	
	@Test(expected = TrainException.class) 
	/*
	 * Attempt to construct a new FreightCar object with a gross
	 * weight of 0, which should throw a TrainException.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithNullGrossWeight() throws TrainException {
		FreightCar newFreightCar = new FreightCar(null, STANDARD_GOODS_TYPE);
	}
	
	@Test(expected = TrainException.class) 
	/*
	 * Attempt to construct a new FreightCar object with a valid
	 * gross weight but an invalid goods type.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithInvalidGoodsType() throws TrainException {
		FreightCar newFreightCar = new FreightCar(STANDARD_TEST_WEIGHT, INVALID_GOODS_TYPE);
	}
	
	@Test(expected = TrainException.class) 
	/*
	 * Attempt to construct a new FreightCar object with a valid
	 * gross weight but a goods type of null.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithNullGoodsType() throws TrainException {
		FreightCar newFreightCar = new FreightCar(STANDARD_TEST_WEIGHT, null);
	}

	@Test(expected = TrainException.class) 
	/*
	 * Attempt to construct a new FreightCar object with an invalid
	 * gross weight and an invalid goods type.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithInvalidArgs() throws TrainException {
		FreightCar newFreightCar = new FreightCar(ZERO_VALUE, INVALID_GOODS_TYPE);
	}
	
	@Test
	/*
	 * Attempt to retrieve the gross weight of a FreightCar object.
	 * @author Jackson Powell
	 */
	public void testFreightCarGetGrossWeight() throws TrainException {
		FreightCar newFreightCar = new FreightCar(STANDARD_TEST_WEIGHT, STANDARD_GOODS_TYPE);
		assertEquals(STANDARD_TEST_WEIGHT, newFreightCar.getGrossWeight());
	}
	
	@Test
	/*
	 * Attempt to retrieve a readable String output of a FreightCar.
	 * @author Jackson Powell
	 */
	public void testFreightCarGetGoodsType() throws TrainException {
		FreightCar newFreightCar = new FreightCar(STANDARD_TEST_WEIGHT, STANDARD_GOODS_TYPE);
		assertEquals(STANDARD_TEST_WEIGHT, newFreightCar.getGrossWeight());
	}
	
	@Test
	/*
	 * Attempt to retrieve a readable String output of a FreightCar.
	 * @author Jackson Powell
	 */
	public void testFreightCarToString() throws TrainException {
		FreightCar newFreightCar = new FreightCar(STANDARD_TEST_WEIGHT, STANDARD_GOODS_TYPE);
		assertEquals("Freight(" + STANDARD_GOODS_TYPE + ")", newFreightCar.toString());
	}
	
	//////////////////////////////////////////////LOCOMOTIVE TEST STARTS HERE////////////////////////////////////
	
	@Test
	/*
	 * Attempt to construct a new FreightCar object with valid args.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithvalidArguments() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, VALID_CLASSIFICATION_TYPE);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with null gross weight.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithNullGrossWeight() throws TrainException{
		Locomotive newLocomotive = new Locomotive(null, VALID_CLASSIFICATION_TYPE);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with zero gross weight.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithZeroGrossWeight() throws TrainException{
		Locomotive newLocomotive = new Locomotive(ZERO_VALUE, VALID_CLASSIFICATION_TYPE);
	}

	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with negative gross weight.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithNegativeGrossWeight() throws TrainException{
		Locomotive newLocomotive = new Locomotive(NEGATIVE_VALUE, VALID_CLASSIFICATION_TYPE);
	}

	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with null for classification.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithNullClassification() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, null);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with null for classification.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithInvalidClassificationLengthOfOne() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, INVALID_CLASSIFICATION_LENGTH_OF_1);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with null for classification.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithInvalidClassificationLengthOfThree() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, INVALID_CLASSIFICATION_LENGTH_OF_3);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with null for classification.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithInvalidClassificationPowerType() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, INVALID_CLASSIFICATION_POWER_TYPE);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to construct a new Locomotive object with null for classification.
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveConstructorWithInvalidClassificationEngineType() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, INVALID_CLASSIFICATION_ENGINE_TYPE);
	}
	
	@Test
	/*
	 * Attempt to get the gross weight with valid args
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveGetGrossWeight() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, VALID_CLASSIFICATION_TYPE);
		Integer testWeight = STANDARD_TEST_WEIGHT;
		assertEquals(testWeight, newLocomotive.getGrossWeight());
	}
	
	@Test
	/*
	 * Attempt to get the Integer value from Locomotive.power() method with valid args
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveGetPower() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, VALID_CLASSIFICATION_TYPE);
		Integer locomotivePower = null;
		locomotivePower = (4*100) - STANDARD_TEST_WEIGHT;
		Integer returnedLocomotivePower = null;
		returnedLocomotivePower = newLocomotive.power();
		assertEquals(locomotivePower,returnedLocomotivePower);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to get the Integer value from Locomotive.power() method with same gross weight to amount of weight
	 * locomotive is able to pull
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveGetPowerSameAsGrossWeight() throws TrainException{
		Locomotive newLocomotive = new Locomotive(OVER_STANDARD_TEST_WEIGHT, VALID_CLASSIFICATION_TYPE);
		Integer returnedLocomotivePower = null;
		returnedLocomotivePower = newLocomotive.power();
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to get the Integer value from Locomotive.power() method with same gross weight to amount of weight
	 * locomotive is able to pull
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveGetPowerLowerToGrossWeight() throws TrainException{
		Locomotive newLocomotive = new Locomotive(MAXIMUM_LIMIT_LOCOMOTIVE_WEIGHT, VALID_CLASSIFICATION_TYPE);
		Integer returnedLocomotivePower = null;
		returnedLocomotivePower = newLocomotive.power();
	}
	
	@Test
	/*
	 * Attempt to get valid string statement from Locomotive.toString() method
	 * @author Yeo Fei Wen
	 */
	public void testLocomotiveToString() throws TrainException{
		Locomotive newLocomotive = new Locomotive(STANDARD_TEST_WEIGHT, VALID_CLASSIFICATION_TYPE);
		String testString = "Loco("+VALID_CLASSIFICATION_TYPE+")";
		assertEquals(testString,newLocomotive.toString());
	}
	
	///////////////////////////////////////PASSENGER CAR TEST STARTS HERE///////////////////////////////////////
	
	@Test
	/*
	 * Attempt to create a passenger car object with valid args
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarConstructorWithValidArgs() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to create a passenger car object 
	 * with zero gross weight with valid number of seats
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarConstructorWithZeroGrossWeight() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(ZERO_VALUE, VALID_NUM_OF_EMPTY_SEATS);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to create a passenger car object 
	 * with zero gross weight with valid number of seats
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarConstructorWithNegativeGrossWeight() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(NEGATIVE_VALUE, VALID_NUM_OF_EMPTY_SEATS);
	}
	
	@Test
	/*
	 * Attempt to create a passenger car object 
	 * with zero number of seats with valid gross weight
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarConstructorWithZeroNumOfSeats() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, ZERO_VALUE);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to create a passenger car object 
	 * with negative number of seats with valid gross weight
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarConstructorWithNegativeNumOfSeats() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, NEGATIVE_VALUE);
	}
	
	@Test
	/*
	 * Attempt to get the number of passengers who could not get on board the train
	 * with number of boarding passengers not exceeding or equal to the current number of seats
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarBoardWithValidArgs() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		Integer testNumOfBoardingPassengers = 0;
		assertEquals(testNumOfBoardingPassengers ,testPassengerCar.board(VALID_NUM_OF_BOARDING_PASSENGERS));
	}
	
	@Test
	/*
	 * Attempt to get the number of passengers who could not get on board the train
	 * with number of boarding passengers being zero
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarBoardWithZeroBoardingPassengers() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		Integer testNumOfBoardingPassengers = 0;
		assertEquals(testNumOfBoardingPassengers ,testPassengerCar.board(ZERO_VALUE));
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to get the number of passengers who could not get on board the train
	 * with number of boarding passengers being negative
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarBoardWithNegativeBoardingPassengers() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		testPassengerCar.board(NEGATIVE_VALUE);
	}
	
	@Test
	/*
	 * Attempt to get the number of passengers who could not get on board the train
	 * with number of boarding passengers being more than the number of seats
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarBoardWithOverMaximumBoardingPassengers() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		Integer testNumOfBoardingPassengers = 2;
		assertEquals(testNumOfBoardingPassengers ,testPassengerCar.board(VALID_OVER_NUM_OF_BOARDING_PASSENGERS));
	}
	
	@Test
	/*
	 * Attempt to alight a valid number of passengers off the passenger car
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarAlightWithValidArgs() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		testPassengerCar.board(VALID_NUM_OF_BOARDING_PASSENGERS);
		testPassengerCar.alight(VALID_NUM_OF_ALIGHTING_PASSENGERS);
	}
	
	@Test
	/*
	 * Attempt to alight zero number of passengers off the passenger car
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarAlightWithZeroAlightingPassengers() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		testPassengerCar.board(VALID_NUM_OF_BOARDING_PASSENGERS);
		testPassengerCar.alight(ZERO_VALUE);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to alight negative number of passengers off the passenger car
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarAlightWithNegativeAlightingPassengers() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		testPassengerCar.board(VALID_NUM_OF_BOARDING_PASSENGERS);
		testPassengerCar.alight(NEGATIVE_VALUE);
	}
	
	@Test(expected = TrainException.class)
	/*
	 * Attempt to alight a number of passengers more than the bumber of passengers on board,
	 * off the passenger car
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarAlightWithOverMaximumAlightingPassengers() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		testPassengerCar.board(VALID_NUM_OF_BOARDING_PASSENGERS);
		testPassengerCar.alight(VALID_OVER_NUM_OF_BOARDING_PASSENGERS);
	}
	
	@Test
	/*
	 * Attempt to get the number of passengers from a passenger car before boarding with valid args
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarNumberOnBoardFunctionBeforeBoarding() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		Integer testNumOfPassengers = 0;
		assertEquals(testNumOfPassengers,testPassengerCar.numberOnBoard());
	}
	
	@Test
	/*
	 * Attempt to get the number of passengers from a passenger car before boarding with valid args
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarNumberOnBoardFunctionAfterBoarding() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		testPassengerCar.board(VALID_NUM_OF_BOARDING_PASSENGERS);
		Integer testNumOfPassengers = VALID_NUM_OF_BOARDING_PASSENGERS;
		assertEquals(testNumOfPassengers,testPassengerCar.numberOnBoard());
	}
	
	@Test
	/*
	 * Attempt to get the number of passengers from a passenger car before boarding with valid args
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarNumberOnBoardFunctionAfterAlight() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		testPassengerCar.board(VALID_NUM_OF_BOARDING_PASSENGERS);
		testPassengerCar.alight(VALID_NUM_OF_ALIGHTING_PASSENGERS);
		Integer testNumOfPassengers = VALID_NUM_OF_BOARDING_PASSENGERS - VALID_NUM_OF_ALIGHTING_PASSENGERS;
		assertEquals(testNumOfPassengers,testPassengerCar.numberOnBoard());
	}
	
	@Test
	/*
	 * Attempt to get the number of seats from a passenger car with valid args
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarNumberOfSeatsFunctionWithValidArgs() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, VALID_NUM_OF_EMPTY_SEATS);
		assertEquals(testPassengerCar.numberOfSeats(),VALID_NUM_OF_EMPTY_SEATS);
	}
	
	@Test
	/*
	 * Attempt to get the number of seats from a passenger car with zero number of seats and valid gross weight
	 * @author Yeo Fei Wen
	 */
	public void testPassengerCarNumberOfSeatsFunctionWithZeroSeats() throws TrainException{
		PassengerCar testPassengerCar = new PassengerCar(STANDARD_TEST_WEIGHT, ZERO_VALUE);
		assertEquals(testPassengerCar.numberOfSeats(),ZERO_VALUE);
	}
	
}
