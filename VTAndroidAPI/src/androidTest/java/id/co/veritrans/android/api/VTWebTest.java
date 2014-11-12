package id.co.veritrans.android.api;

import android.test.InstrumentationTestCase;

/**
 * Created by Anis on 11/11/2014.
 */
public class VTWebTest extends InstrumentationTestCase {

    public void testMock()  {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected,reality);
    }
}
