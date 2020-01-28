package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPattern {
    
    Pattern pattern;
    
    @BeforeEach
    public void init(){
        pattern = new Pattern();
    }
    
    @Test
    @DisplayName("calculateWidthOfThePaperFromBoxSize tesztelése")
    public void TestCalculateWidthOfThePaperFromBoxSize(){
        assertEquals(500, pattern.calculateWidthOfThePaperFromBoxSize(100, 200));
    }
    
    @Test
    @DisplayName("calculateLengthOfThePaperFromBoxSize tesztelése")
    public void TestCalculateLengthOfThePaperFromBoxSize(){
        assertEquals(605, pattern.calculateLengthOfThePaperFromBoxSize(100, 200));
    }
}
