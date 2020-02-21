package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

class TestOrder {

	Order order;

	@BeforeEach
	public void init() {
		order = new Order();
	}

	// System.out/void method tesztelése...ennek még utánna kell néznem!

	//@formatter:off
    @Test
    @DisplayName("getter és setter tesztelése")
    public void testGetterSetter() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(Order.class);
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
	@DisplayName("toString tesztelése - üres lista")
	public void testToStringWithEmptyList() {
		assertTrue(order.toString().contains("Megrendelés tartalma: "));

		if (order.getProducts().isEmpty()) {
			assertTrue(order.toString().contains("üres."));
		}
	}

	@Test
	@DisplayName("toString tesztelése - nem üres lista")
	public void testToStringWithNotEmptyList() {
		GlassyProduct product = new GlassyProduct("termék", 100, 100, 100, 100, 100);
		ArrayList<GlassyProduct> products = new ArrayList<GlassyProduct>();
		products.add(product);
		order.setProducts(products);
		assertTrue(order.toString().contains("Megrendelés tartalma: "));

		if (!order.getProducts().isEmpty()) {
			for (int i = 0; i < order.getProducts().size(); i++) {

				if (order.getProducts().get(i) != null) {
					assertTrue(order.toString().contains("db."));
				}
			}
		}
	}

}
