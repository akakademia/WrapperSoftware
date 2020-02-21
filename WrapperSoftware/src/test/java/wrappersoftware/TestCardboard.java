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

class TestCardboard {

	Cardboard cardboard;

	@BeforeEach
	public void init() {
		cardboard = new Cardboard("név", 100, 100, 1.5, 5, 100);
	}

	@Test
	@DisplayName("toString tesztelése")
	public void testToString() {
		assertTrue(cardboard.toString().contains("Dekorkarton: " + cardboard.getName()));
	}

	//@formatter:off
	@Test
    @DisplayName("getter és setter tesztelése")
    public void testGetterSetter() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(Cardboard.class);
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
}
