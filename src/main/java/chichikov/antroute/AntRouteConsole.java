package chichikov.antroute;

import chichikov.antroute.core.Tracked;

import java.util.List;
import java.util.Scanner;

import static chichikov.antroute.core.CoreFactory.getGenerator;
import static chichikov.antroute.core.CoreFactory.getPosition;

/**
 * AntRouteConsole
 *
 * @author Anatoly Chichikov (01.07.2013)
 */
public class AntRouteConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input \'X\'");
        int x = scanner.nextInt();
        System.out.println("Input \'Y\'");
        int y = scanner.nextInt();
        System.out.println("Start point is 1x1");

        System.out.println("End point is " + x + "x" + y);
        System.out.println("Generating routes for " + x + "x" + y + " matrix...\n");
        List<Tracked> routes = getGenerator().generateAllPossibleRoutes(getPosition(1, 1), getPosition(x, y));
        int i = 1;
        for (Tracked route : routes) {
            System.out.println(i + " " + route + "\n");
            i++;
        }
    }
}

