package com.github.hcsp;

import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.blindpirate.extensions.CaptureSystemOutput;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    @CaptureSystemOutput
    public void importStringUtilsCorrectly(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(containsStringIgnoringCase("hello"));
        Main.main(null);
    }

    @Test
    public void hasMessageMember() throws Exception {
        Field field = Main.class.getDeclaredField("message");
        field.setAccessible(true);
        assertEquals(field.get(null).toString().toLowerCase(), "hello");
    }
}
