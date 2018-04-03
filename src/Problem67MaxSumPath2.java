// By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
//
//3
//7 4
//2 4 6
//8 5 9 3
//
//That is, 3 + 7 + 4 + 9 = 23.
//
//Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
//
//NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem,
// as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years
// to check them all.
// There is an efficient algorithm to solve it. ;o)


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem67MaxSumPath2 {

    public static void main(String[] args) {
        // aantal regels in de file
        int nmbLines = 100;

        // Op iedere regels staat een getal meer dan de vorige.
        // Op de eerste regel 1 getal, op de 2e 2, etc.
        // totaal bevat het totaal aantal cijfers en lengte array

        int totaal = 0;
        for (int i = 0; i <= nmbLines; i++) {
            totaal += i;
        }

        // Creeer array lang genoeg voor al de cijfers
        int[] result = new int[totaal];

        // read integers from file and store them as integers in array digits
        Scanner file = null;

        try {
            file = new Scanner(new File("C:\\Users\\Reserve Account\\Documents\\GitHub\\Java\\Euler\\src\\getallen3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int nmbCounter = 0;
        while (file.hasNext()) {
            if (file.hasNextInt()) {
                result[nmbCounter] = file.nextInt();
                nmbCounter++;
            } else file.next();
        }

        //print last line with numbers
        for(int i=totaal-nmbLines; i<totaal; i++)
            System.out.print(result[i] + " ");

        int startCurrentLine = totaal - nmbLines;
        int startPrevLine;

        for (int currentLine = nmbLines - 1; currentLine > 0; currentLine--) {
            startPrevLine = startCurrentLine;
            startCurrentLine = startCurrentLine - currentLine;
            for (int j = 0; j < currentLine; j++) {
                // kijk welke van de 2 kinderen het grootst is
                if (result[startPrevLine + j] > result[startPrevLine + j + 1]) {
                    result[startCurrentLine + j] += result[startPrevLine + j];
                } else {
                    result[startCurrentLine + j] += result[startPrevLine + j + 1];
                }
            }
        }

        System.out.println(result[0]);
    }
}
