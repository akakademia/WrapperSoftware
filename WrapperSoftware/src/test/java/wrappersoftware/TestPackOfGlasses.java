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

class TestPackOfGlasses {

	  PackOfGlasses packOfGlasses;
		    
	    @BeforeEach
	    public void init(){
	       packOfGlasses = new PackOfGlasses(1, 1, 1, 1);
	    }
	    
	    //@formatter:off
	    @Test
	    @DisplayName("getter és setter tesztelése")
	    public void testGetterSetter() {
	        PojoClass pojoclass = PojoClassFactory.getPojoClass(PackOfGlasses.class);
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
		@DisplayName("toString tesztelése")
		public void testToString() {
	    
			assertTrue(packOfGlasses.toString().contains("1"));
		}
	    
	    @Test
	    @DisplayName("toEmptyPackOfGlasses() tesztelése ")
	    public void testToEmptyPackOfGlasses() {
	    	packOfGlasses.toEmptyPackOfGlasses();
	    	assertEquals(0, packOfGlasses.getWidth(),"szélesség kinullázva");
	    	assertEquals(0, packOfGlasses.getHeigth(),"magasság kinullázva");
	    	assertEquals(0, packOfGlasses.getLength(),"hosszúság kinullázva");
	    	assertEquals(0, packOfGlasses.getWeight(),"súly kinullázva");
	    }
}
