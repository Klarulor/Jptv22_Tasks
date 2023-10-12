import java.util.Random;

public class Storage {
    public static int[][] temperatures = new int[12][];
    private static int[] _seasons = {
            5, 20, 5, 35, -5, 15, -30, 0
    };
    private static int[] _monthDays = {
            31,28,31,30,31,30,31,31,30,31,30,31
    };

    public static void fill(){
        Random rnd = new Random();
        for(int i = 0; i < 12; i++){
            int season = i / 4;
            int min = _seasons[season * 2];
            int max = _seasons[(season * 2) + 1];

            temperatures[i] = new int[_monthDays[i]];
            for(int j = 0; j < _monthDays[i]; j++){
                int t = rnd.nextInt(max-min) + min;
                temperatures[i][j] = t;
            }
        }
    }
    public static int getWeather(int month, int day) throws Exception {
        if(day < 1 || day >= temperatures[month].length)
            throw new Exception("BAD DAY!!");
        return temperatures[month][day];
    }
    public static int getMostColdDay(int month){
        int index = 0,t = 100;
        for(int i = 0; i < temperatures[month-1].length; i++){
            if(temperatures[month-1][i] < t)
            {
                index = i;
                t = temperatures[month-1][i];
            }
        }
        return index+1;
    }
    public static int getMostHotDay(int month){
        int index = 0,t = -100;
        for(int i = 0; i < temperatures[month-1].length; i++){
            if(temperatures[month-1][i] > t)
            {
                index = i;
                t = temperatures[month-1][i];
            }
        }
        return index+1;
    }
    public static float getAvgMonthTemp(int month){
        int tempSum = 0;
        for(int i = 0; i < temperatures[month-1].length; i++){
            tempSum += temperatures[month-1][i];
        }
        return tempSum / (float)temperatures[month-1].length;
    }
    public static int getDayCount(int month){
        return temperatures[month-1].length;
    }
}
