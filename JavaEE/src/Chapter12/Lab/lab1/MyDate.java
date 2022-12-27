package Chapter12.Lab.lab1;

/**
 * @author wxh
 * @description
 * @create 2022-12-22 9:48
 */
public class MyDate {

    private int month;
    private int day;
    private int year;

    public MyDate () {
    }

    public MyDate (int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth () {
        return month;
    }

    public void setMonth (int month) {
        this.month = month;
    }

    public int getDay () {
        return day;
    }

    public void setDay (int day) {
        this.day = day;
    }

    public int getYear () {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    @Override
    public String toString () {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

//    @Override
//    public int compareTo (Object o) {
//        if(o instanceof MyDate) {
//            MyDate bir = (MyDate) o;
//            if (this.year != bir.year) {
//                return Integer.compare(this.year, bir.year);
//            } else if (this.month != bir.month) {
//                return Integer.compare(this.month, bir.month);
//            } else {
//                return Integer.compare(this.day, bir.day);
//            }
//        } else {
//            throw new RuntimeException("Error!");
//        }
//    }
}
