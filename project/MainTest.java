package project;

import org.junit.jupiter.api.Test;

import java.util.*;

import project.data.Timeline;
import project.menu.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the total fouls in a game on 2020-1-1
     */
    @Test
    void totalFoulsTest() {
        Menu.testData();
        assertEquals(3, Output.getFouls(2020, "Manchester United vs. Glasborough on 2020-1-1"));
    }

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the total fouls in a game on 2020-1-2
     */
    @Test
    void totalFoulsTestOnADifferentGame() {
        Menu.testData();
        assertEquals(11, Output.getFouls(2020, "Manchester United vs. Glasborough on 2020-1-2"));
    }

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the total shots in a game on 2021-1-1
     */
    @Test
    void totalShotsTest() {
        Menu.testData();
        assertEquals(23, Output.getShots(2021, "Manchester United vs. Glasborough on 2021-1-1"));
    }

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the total shots in a game on 2020-1-1
     */
    @Test
    void totalShotsTestOnDifferentGame() {
        Menu.testData();
        assertEquals(7, Output.getShots(2020, "Manchester United vs. Glasborough on 2020-1-1"));
    }

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the top five team goals
     */
    @Test
    void topTeamGoalsTest() {
        Menu.testData();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(12);
        expectedList.add(11);
        expectedList.add(10);
        expectedList.add(9);
        expectedList.add(8);
        assertArrayEquals(expectedList.toArray(), Output.getTopFiveGoals().toArray());
    }

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the top 5 team fouls commited
     */
    @Test
    void topTeamFoulsTest() {
        Menu.testData();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(22);
        expectedList.add(21);
        expectedList.add(18);
        expectedList.add(17);
        expectedList.add(14);
        assertArrayEquals(expectedList.toArray(), Output.getTopFiveFouls().toArray());
    }

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the top 5 team shots
     */
    @Test
    void topTeamShotsTest() {
        Menu.testData();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(24);
        expectedList.add(23);
        expectedList.add(20);
        expectedList.add(19);
        expectedList.add(16);
        assertArrayEquals(expectedList.toArray(), Output.getTopFiveShots().toArray());
    }

    /**
     * @author Adrian Ponce, March 20, 2022, T03
     * Test to find the tally of the games ended in a tie
     */
    @Test
    void gamesWithATie() {
        Menu.testData();
        assertEquals(2, Output.getGamesWithATie());
    }

    /**
     * Test if a year is added correctly
     * @author Robert Engel, T03, March 20, 2022
     * */
    @Test
    void addYearTest() {
        Timeline.addYear(2020);
        //assertEquals(true, Main.Year.containsKey("2020"));
    }
    /**
     * Test if a game is added correctly
     * @author Robert Engel, T03, Feb 28, 2022
     * */
    @Test
    void addGameTest() {
        Menu.testData();
        String[] game1 = {"Manchester", "Glasborough", "22", "33", "11", "18", "5", "7", "Home", "2020-1-1"};
        //assertArrayEquals(game1, Main.Year.get("2020").get("Manchester vs. Glasborough on 2020-1-1"));
    }
    /**
     * Test if a game is retrieved correctly
     * @author Robert Engel, T03, Feb 28, 2022
     * */
    @Test
    void getGameDataTest() {
        Menu.testData();
        //assertArrayEquals(Main.Year.get("2020").get("Manchester vs. Glasborough on 2020-1-1"), Main.getGameData(2020, "Manchester vs. Glasborough on 2020-1-1"));
    }
}