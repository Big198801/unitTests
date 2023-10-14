package seminar3_task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EvenOddNumberTest {

    @ParameterizedTest
    @CsvSource({"2, true", "3, false"})
    public void isEvenNumberTest(int n, boolean expectedResult) {
        EvenOddNumber evenOddNumber = new EvenOddNumber();
        boolean result = evenOddNumber.isEvenNumber(n);
        assertEquals(expectedResult, result); // JUnit
        assertThat(result).isEqualTo(expectedResult); // AssertJ
    }
}
