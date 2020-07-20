package junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestParam {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void testWithValueSource(int argument){
        assertTrue(argument >0 && argument <4);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" "," ","\t","\n"})
    void nullEmptyAndBlankStrings(String text){
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testWithEnumSource(TemporalUnit unit){
        assertNotNull(unit);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument){
        assertNotNull(argument);
    }

    static Stream<String> stringProvider(){
        return Stream.of("apple","banana");
    }

}
