package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        City city1 = new City("Toronto", "Canada");
        City city2 = new City("New York", "USA");
        list.addCity(city1);
        assertTrue(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
    }

    @Test
    public void testDelete() {
        list = MockCityList();
        City city1 = new City("Toronto", "Canada");
        City city2 = new City("New York", "USA");
        list.addCity(city1);
        list.addCity(city2);
        assertEquals(2, list.getCount());
        list.delete(city1);
        assertEquals(1, list.getCount());
        assertFalse(list.hasCity(city1));
        assertTrue(list.hasCity(city2));
        assertThrows(IllegalArgumentException.class, () -> list.delete(city1));
    }

    @Test
    public void testCountCities() {
        list = MockCityList();
        City city1 = new City("Toronto", "Canada");
        City city2 = new City("New York", "USA");
        City city3 = new City("Paris", "France");
        list.addCity(city1);
        list.addCity(city2);
        list.addCity(city3);
        assertEquals(3, list.countCities());
    }

}
