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

public class TestPattern {
    
    Pattern pattern1;
    Pattern pattern2;
    
    @BeforeEach
    public void init(){
        pattern1 = new Pattern();
        pattern2 = new Pattern(100, 200);
    }
    
    @Test
    @DisplayName("calculateWidthOfThePaperFromBoxSize tesztelése")
    public void TestCalculateWidthOfThePaperFromBoxSize(){
        assertEquals(500, pattern1.calculateWidthOfThePaperFromBoxSize(100, 200));
    }
    
    @Test
    @DisplayName("calculateLengthOfThePaperFromBoxSize tesztelése")
    public void TestCalculateLengthOfThePaperFromBoxSize(){
        assertEquals(605, pattern1.calculateLengthOfThePaperFromBoxSize(100, 200));
    }
    
    //@formatter:off
    @Test
    @DisplayName("getter és setter tesztelése")
    public void testGetterSetter() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(Pattern.class);
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
