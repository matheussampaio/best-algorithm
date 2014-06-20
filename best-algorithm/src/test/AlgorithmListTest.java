package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.AlgorithmList;

public class AlgorithmListTest {
    AlgorithmList list;
    int INIT_LENGTH;

    @Before
    public void setUp() throws Exception {
        list = new AlgorithmList();
        INIT_LENGTH = list.lenght();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testIsFull() throws Exception {
        for (int i = 0; i < INIT_LENGTH; i++) {
            Assert.assertFalse(list.isFull());
            list.insert(String.valueOf(i));
        }

        Assert.assertTrue(list.isFull());
    }

    @Test
    public void testDoubleSize() throws Exception {
        for (int i = 0; i < INIT_LENGTH; i++) {
            assertEquals(INIT_LENGTH, list.lenght());
            list.insert(String.valueOf(i));
        }

        list.insert("DOUBLE!");

        assertEquals(INIT_LENGTH * 2, list.lenght());

        for (int i = INIT_LENGTH + 1; i < INIT_LENGTH * 2; i++) {
            assertEquals(INIT_LENGTH * 2, list.lenght());
            list.insert(String.valueOf(i));
        }

        list.insert("DOUBLE AGAIN!");

        assertEquals(INIT_LENGTH * 4, list.lenght());

    }

    @Test
    public void testInsert() throws Exception {
        String word = "Hi!";

        // should insert
        assertTrue(list.insert(word));

        // shouldnt insert
        assertFalse(list.insert(word));
    }

    @Test
    public void testContains() throws Exception {
        String word = "Hi!";

        // shouldnt contains
        assertFalse(list.contains(word));

        list.insert(word);

        // should caontains
        assertTrue(list.contains(word));
    }

}
