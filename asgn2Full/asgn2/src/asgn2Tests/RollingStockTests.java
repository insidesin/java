package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.RollingStock;

public class RollingStockTests {

	private final Integer STANDARD_TEST_WEIGHT = 50;
	private final Integer ZERO_TEST_WEIGHT = 0;
	private final String STANDARD_GOODS_TYPE = "G";
	private final String INVALID_GOODS_TYPE = "CAR";
	
	//TEST IF FreightCar1 == FreightCar2???
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
		FreightCar newFreightCar = new FreightCar(-STANDARD_TEST_WEIGHT, STANDARD_GOODS_TYPE);
	}
	
	@Test(expected = TrainException.class) 
	/*
	 * Attempt to construct a new FreightCar object with a gross
	 * weight of 0, which should throw a TrainException.
	 * @author Jackson Powell
	 */
	public void testFreightCarConstructorWithZeroGrossWeight() throws TrainException {
		FreightCar newFreightCar = new FreightCar(ZERO_TEST_WEIGHT, STANDARD_GOODS_TYPE);
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
		FreightCar newFreightCar = new FreightCar(ZERO_TEST_WEIGHT, INVALID_GOODS_TYPE);
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

}
