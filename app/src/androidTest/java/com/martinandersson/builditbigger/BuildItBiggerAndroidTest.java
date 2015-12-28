package com.martinandersson.builditbigger;

import android.test.AndroidTestCase;

import com.martinandersson.jokelibrary.Joker;

public class BuildItBiggerAndroidTest extends AndroidTestCase {

    public void testVerifyJoker() {

        Joker joker = new Joker();
        assertNotNull(joker);
        assertNotNull(joker.getJoke());
        assertTrue(joker.getJoke().startsWith("This is joke number"));

    }

}
