package com.robimolte.subitotest;

import org.junit.Test;

import com.robimolte.subitotest.util.Utils;

import static junit.framework.Assert.assertEquals;

/**
 * Created by robimolte on 04/02/2017.
 */

public class StargazerUnitTest {

    @Test
    public void checkInputFieldOneEmpty() {
        boolean actual = Utils.checkInputFields("","customRepo");
        assertEquals(actual,false);
    }

    @Test
    public void checkInputFieldFilled() {
        boolean actual = Utils.checkInputFields("ownerRepo","customRepo");
        assertEquals(actual,true);
    }
}
