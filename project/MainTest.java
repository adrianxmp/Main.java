package project;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import project.data.Timeline;
import project.menu.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the total fouls in a game on 2022-1-3
     */
    @Test
    void totalFoulsTest() {
        Menu.testData();
        //assertEquals(62, Main.totalFouls(2022, "Manchester vs. Glasborough on 2022-1-3"));
    }

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the total fouls in a game on 2020-1-2
     */
    @Test
    void totalFoulsTestOnADifferentGame() {
        Menu.testData();
        //assertEquals(57, Main.totalFouls(2020, "Manchester vs. Glasborough on 2020-1-2"));
    }

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the total shots in a game on 2021-1-3
     */
    @Test
    void totalShotsTest() {
        Menu.testData();
        //assertEquals(39, Main.totalShots(2021, "Manchester vs. Glasborough on 2021-1-3"));
    }

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the total shots in a game on 2020-1-1
     */
    @Test
    void totalShotsTestOnDifferentGame() {
        Menu.testData();
        //assertEquals(29, Main.totalShots(2020, "Manchester vs. Glasborough on 2020-1-1"));
    }

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the total shots in a game on 2020-1-1
     */
    @Test
    void topTeamGoalsTest() {
        Menu.testData();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("9");
        expectedList.add("9");
        expectedList.add("8");
        expectedList.add("8");
        expectedList.add("7");
        //assertArrayEquals(expectedList.toArray(), Main.topTeamGoals().toArray());
    }

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the top 5 team fouls commited
     */
    @Test
    void topTeamFoulsTest() {
        Menu.testData();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("41");
        expectedList.add("40");
        expectedList.add("39");
        expectedList.add("38");
        expectedList.add("37");
        //assertArrayEquals(expectedList.toArray(), Main.topTeamFouls().toArray());
    }

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the top 5 team shots
     */
    @Test
    void topTeamShotsTest() {
        Menu.testData();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("26");
        expectedList.add("25");
        expectedList.add("24");
        expectedList.add("23");
        expectedList.add("22");
        //assertArrayEquals(expectedList.toArray(), Main.topTeamShots().toArray());
    }

    /**
     * @author Adrian Ponce, Feb 28, 2022, T03
     * Test to find the tally of the games ended in a tie
     */
    @Test
    void gamesWithATie() {
        Menu.testData();
        int x = 3;
        //assertEquals(3, Main.gamesWithATie());
    }

    /**
     * Test if a year is added correctly
     * @author Robert Engel, T03, Feb 28, 2022
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