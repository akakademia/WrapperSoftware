package wrappersoftware;

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

class TestResults {
	//Nem működik a construktor paraméterezés így nem tudok gettert settert tesztelni
	
	Results results;

	@BeforeEach
	public void init() {
//		Order o = new Order();
//		ArrayList<GlassyProduct> products = new ArrayList<GlassyProduct>();
//		GlassyProduct p = new GlassyProduct("p", 100, 100, 100, 100, 100);
//		products.add(p);
//		o.setProducts(products);
//		o.setDiscount(0);
//		
//		BasicDates b = new BasicDates();
		
		
		
//		results = new Results(new Order(), new BasicDates());
	}

//	//@formatter:off
//    @Test
//    @DisplayName("getter és setter tesztelése")
//    public void testGetterSetter() {
//        PojoClass pojoclass = PojoClassFactory.getPojoClass(Results.class);
//        Validator validator = ValidatorBuilder
//                .create()
//                .with(new SetterMustExistRule())
//                .with(new GetterMustExistRule())
//                .with(new SetterTester())
//                .with(new GetterTester())
//                .build();
//        validator.validate(pojoclass);
//    }
//    //@formatter:on

}
