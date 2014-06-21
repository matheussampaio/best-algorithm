package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.AlgorithmHashtable;

public class AlgorithmHashtableTest {
	AlgorithmHashtable map;
    int INIT_LENGTH;

    @Before
    public void setUp() throws Exception {
        map = new AlgorithmHashtable();
        INIT_LENGTH = map.length();
    }

    @After
    public void tearDown() throws Exception {
        map = null;
    }

    @Test
    public void testInsert() throws Exception {
        String word = "Hi!";

        // should insert
        assertTrue(map.insert(word));

        // shouldnt insert
        assertFalse(map.insert(word));
    }

    @Test
    public void testContains() throws Exception {
        String word = "Hi!";

        // shouldnt contains
        assertFalse(map.contains(word));

        map.insert(word);

        // should caontains
        assertTrue(map.contains(word));
    }

}
