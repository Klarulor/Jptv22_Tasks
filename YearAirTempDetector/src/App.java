import java.util.Scanner;

public class App {
    public void run(){
        System.out.println("1 - Получить температуру по дню\n2 - Вычислить среднию температуру по месяцу\n3 - Вычислить самую низкую температуру в месяце\n4 - Вычислить самую высокую температуру в месяце");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Номер решения: ");
        int t = scanner.nextInt();
        if(t< 1 || t > 4)
        {
            System.out.println("Не правильный номер задания");
            run();
            return;
        }
        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        if(month < 1 || month > 12)
        {
            System.out.println("Bad month");
            return;
        }
        switch (t){
            case 1:
                int totalDays = Storage.getDayCount(month);
                System.out.print("В этом месяце " + totalDays + " дней\nКакой день вам нужен?: ");
                int day = scanner.nextInt();
                int temp = 0;
                try{
                    temp = Storage.getWeather(month, day);
                }catch (Exception ex){
                    System.out.println("Bad day");
                    return;
                }
                System.out.println("В данный день температура была "+temp+" градусов");
                break;
            case 2:
                float avgTemp = Storage.getAvgMonthTemp(month-1);
                System.out.println("Средняя температура в этом месяце была "+avgTemp+" градусов");
                break;
            case 3:
                float lowTemp = Storage.getMostColdDay(month-1);
                System.out.println("Самая низкая температура в этом месяце была "+lowTemp+" градусов");
                break;
            case 4:
                float highTemp = Storage.getMostHotDay(month-1);
                System.out.println("Самая высокая температура в этом месяце была "+highTemp+" градусов");
                break;
        }
    }
}
