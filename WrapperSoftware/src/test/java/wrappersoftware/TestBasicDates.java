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
import com.openpojo.validation.test.impl.GetterTester;

class TestBasicDates {

	BasicDates basicDates;

	@BeforeEach
	public void init() {
		basicDates = new BasicDates();
	}

	//@formatter:off
    @Test
    @DisplayName("getter és setter tesztelése")
    public void testGetterSetter() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(BasicDates.class);
        Validator validator = ValidatorBuilder
                .create()
                .with(new GetterMustExistRule())
                .with(new GetterTester())
                .build();
        validator.validate(pojoclass);
    }
    //@formatter:on

	@Test
	@DisplayName("listCategories() tesztelése")
	public void testListCategories() {
		assertTrue(basicDates.listCategories().length != 0);
	}

	@Test
	@DisplayName("listProducts() tesztelése")
	public void testlistProducts() {
		for (int i = 0; i < 4; i++) {
			assertTrue(basicDates.listProducts(i).length != 0);
		}
	}
}
