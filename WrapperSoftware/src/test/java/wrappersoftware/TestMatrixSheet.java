package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

class TestMatrixSheet {

	MatrixSheet matrixSheet;

	@BeforeEach
	public void init() {
		matrixSheet = new MatrixSheet("név", 100, 100, 21, 150);

	}

	@Test
	@DisplayName("toString tesztelése")
	public void testToString() {
		assertTrue(matrixSheet.toString().contains("Matrica: " + matrixSheet.getName()));
	}

	//@formatter:off
	@Test
	@DisplayName("getter és setter tesztelése")
	public void testGetterSetter() {
	    PojoClass pojoclass = PojoClassFactory.getPojoClass(MatrixSheet.class);
	    Validator validator = ValidatorBuilder
	              .create()
	              .with(new SetterMustExistRule())
	              .with(new GetterMustExistRule())
	              .with(new SetterTester())
	              .with(new GetterTester())
	              .build();
	      validator.validate(pojoclass);
	}
	//@formatter:on
	
	@Test
	@DisplayName("calculatePrice() tesztelése")
	public void testcalculatePrice() {
		matrixSheet.setNumberOfNeccesaryMatrixes(1);
		matrixSheet.setPrice(50);
		assertTrue(matrixSheet.calculatePrice() == 50, "1 * 50 = 50");
	}
	
	
}
