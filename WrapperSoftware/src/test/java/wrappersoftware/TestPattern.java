package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
