// You are given the following information, but you may prefer to do some research for yourself.
//
//1 Jan 1900 was a Monday.
//Thirty days has September,
//April, June and November.
//All the rest have thirty-one,
//Saving February alone,
//Which has twenty-eight, rain or shine.
//And on leap years, twenty-nine.
//A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
//How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?


import java.util.Calendar;

public class Problem19CountingSunday {

    static int[] daysInMonth;

    Problem19CountingSunday() {


    }

    public static boolean isLeapYear(int year) {
        if (year%4==0) {
            if (year%100==0) {
                if (year%400==0){
                    // deelbaar door 4, 100 en 400
                    return true;
                } else {
                    // deelbaar door 4, 100 en niet door 400
                    return false;
                }
            } else {
                // deelbaar door 4, niet door 100
                return true;
            }
        } else {
            // niet deelbaar door 4
            return false;
        }
    }

    public static int calculateNmbOfDays(int year, int month, int day) {
        // reference day is 1 jan 1900
        int nmbOfDays = day;
        int referenceYear = 1900;

        if (year<referenceYear) return -1;
        if ((month<1) || (month>12)) return -1;
        if ((day<1)|| (day>daysInMonth[month-1])) return -1;

        for(int i=referenceYear; i<year;i++){
            if (isLeapYear(i)){
                nmbOfDays += 366;
            } else {
                nmbOfDays += 365;
            }
        }

        for (int i=1;i<month;i++) {
            nmbOfDays += daysInMonth[i-1];
        }

        // correctie voor als datum in schrikkeljaar valt na februari
        if (isLeapYear(year) && month>2) nmbOfDays+=1;

        return nmbOfDays;
    }

    public static void main(String[] args) {

        // aantal dagen per maand
        daysInMonth = new int[12];
        daysInMonth[0]=31;
        daysInMonth[1]=28;
        daysInMonth[2]=31;
        daysInMonth[3]=30;
        daysInMonth[4]=31;
        daysInMonth[5]=30;
        daysInMonth[6]=31;
        daysInMonth[7]=31;
        daysInMonth[8]=30;
        daysInMonth[9]=31;
        daysInMonth[10]=30;
        daysInMonth[11]=31;

        // ga door de jaren
        int nmbOfSundays = 0;
        int chkSundays = 0;
        Calendar chkCalendar = Calendar.getInstance();

        // ga over de jaren
        for(int i=1901; i<=2000; i++) {
            // ga door de maanden
            for(int j=1; j<=12; j++) {
                if ((calculateNmbOfDays(i,j,1)%7)==0) {
                    nmbOfSundays++;
                }

                // let op: de maanden lopen n Clendar vanaf 0
                // de dagen tellen van 1 t/m 7, SUNDAY = 1
                chkCalendar.set(i,(j-1),1);
                if (chkCalendar.get(Calendar.DAY_OF_WEEK)==1) {
                    chkSundays++;
                }
            }
        }

        System.out.println("Aantal zondagen 1: " + nmbOfSundays);
        System.out.println("Aantal zondagen 2: " + chkSundays);
    }

}
