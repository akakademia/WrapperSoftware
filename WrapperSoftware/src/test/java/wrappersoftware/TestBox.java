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

class TestBox {

	Box box1;
	Box box2;

	@BeforeEach
	public void init() {
		box1 = new Box();
		box2 = new Box(100, 100, 100);
	}

	@Test
	@DisplayName("getter és setter tesztelése")
	public void testGetterSetter() {
		PojoClass pojoclass = PojoClassFactory.getPojoClass(Box.class);
		Validator validator = ValidatorBuilder.create().with(new SetterMustExistRule()).with(new GetterMustExistRule())
				.with(new SetterTester()).with(new GetterTester()).build();
		validator.validate(pojoclass);
	}

}
