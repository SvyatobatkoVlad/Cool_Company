package impl;

import static org.junit.Assert.assertEquals;


import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.*;
import static org.hamcrest.core.IsEqual.*;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.svyatobatko.dimploma.models.OrderData;
import com.svyatobatko.dimploma.models.UserData;
import com.svyatobatko.dimploma.models.UserTourData;

public class BonusCalculationServiceTest {
	
	
	private static final int RANDOM_ORDER_TOTAL_AMOUNT = 1000;
	private static final double DISCOUNT_RATE = 0.05;
	private static final int TOURS_AMOUNT_BONUS_TRESHOLD = 10;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	private BonusCalculationService testInstance;
	
	
	@Before
	public void setUp() {
		testInstance = new BonusCalculationService();
	}
	
	
	
	
	@Test (expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenOrderIsNull() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(equalTo("specific error message")); 
		//expectedException.expect(instanceOf(FileNotFoundException.class));                                 //(instanceOf(FileNotFoundException.class));
		testInstance.getDiscountForOrderAndUser(null, new UserData()); 
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenUserIsNull() {
		testInstance.getDiscountForOrderAndUser(new OrderData(), null);
	}
	
	
	@Test(timeout = 100)
	public void shouldReturnDiscountWhenUserHasMoreThanAvailableTresholdToursAmount() {
		// GIVEN
		UserData user = new UserData();
		List<UserTourData> tours = new ArrayList<UserTourData>();
		for (int i = 0; i < TOURS_AMOUNT_BONUS_TRESHOLD; i++) {
			tours.add(new UserTourData());
		}
		user.setTours(tours);
		OrderData order = new OrderData();
		order.setTotalAmount(BigDecimal.valueOf(RANDOM_ORDER_TOTAL_AMOUNT));
		
		//WHEN
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(order, user);
		
		//THEN
		assertEquals(BigDecimal.valueOf(50).setScale(2), discount);
	}
	
	
	@Test
	public void shouldReturnZeroDiscountWhenUserHasNoTours() {
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(new OrderData(), new UserData());
		
		assertEquals(BigDecimal.valueOf(0), discount);
	}
	
	@Test
	public void shouldReturnZeroDiscountWhenUserHasLessThanAvailableTresholdToursAmount() {
		UserData user = new UserData();
		List<UserTourData> tours = new ArrayList<UserTourData>(Arrays.asList(new UserTourData()));
		user.setTours(tours);
		
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(new OrderData(), user);
		
		assertEquals(BigDecimal.valueOf(0), discount);
	}
	
	@Test
	public void shouldReturnZeroDiscountWhenUserHasZeroToursAmount() {
		UserData user = new UserData();
		List<UserTourData> tours = new ArrayList<UserTourData>();
		user.setTours(tours);
		
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(new OrderData(), user);
		
		assertEquals(BigDecimal.valueOf(0), discount);
	}
	
	//Need to finish!!!!
	@Test
	public void shouldAddMoneyToReferer() {
		UserData refererUser = new UserData();
		OrderData order = new OrderData();
		order.setTotalAmount(BigDecimal.valueOf(RANDOM_ORDER_TOTAL_AMOUNT));
		
		BigDecimal initialMoneyBalance = refererUser.getMoney();
		
		testInstance.processBonuesForReferer(refererUser, order);
		
		assertEquals(BigDecimal.valueOf(50).setScale(2, RoundingMode.HALF_UP)
				, refererUser.getMoney());
	}
	


}