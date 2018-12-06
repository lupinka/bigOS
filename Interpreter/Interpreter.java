package Interpreter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {

    private int A,B,C,D, program_counter, base, limit, PID;
    private String rozkaz;
    public Interpreter()
    {
        //A = klasaJonasza running getAX()
        //B = klasaJonasza.get_BX()
        //C = klasaJonasza.get_CX()
        //D = klasaJonasza.get_DX()
        //base = klasaJonasza.get_Base(),
        //limit = klasaJonasza.get_Limit(),
        //program_counter = klasaJonasza.get_Program_counter(),
        //PID = klasaJonasza.get_PID
        //getOrder()

    }
    public void display()
    {
        System.out.println("PID: "+PID);
        System.out.println("rejestr A: "+A);
        System.out.println("rejestr B: "+B);
        System.out.println("rejestr C: "+C);
        System.out.println("rejestr D: "+D);
        System.out.println("program_counter: "+program_counter);
    }
    public void getOrder()
    {
        //while(rozkaz nie jest caly)
        //rozkaz = rozkaz + pamiec[base + program_counter]
        System.out.println("wykonywany rozkaz: "+rozkaz);
    }
    public void executeOrder()
    {
        //if(!rozkaz.equals("AD")&&!rozkaz.equals("MO")&&itd.)
        //{
        //blad -koniec programu
        //}
        String x="", y="";
        //wyciagniecie z rozkazu nazwy rozkazu i danych (np. x,y)
        if (rozkaz.equals("AD"))
        {
            add(x,y);
        }
        if (rozkaz.equals("MO"))
        {
            mov(x,y);
        }
        if (rozkaz.equals("IC"))
        {

        }
        if (rozkaz.equals("JP"))
        {

        }
        if (rozkaz.equals("HT"))
        {
            //koniec programu
        }
        program_counter++;
    }
    public void mov(String x, String y)
    {
        Pattern rejestr = Pattern.compile("[A-D]");
        Matcher rejestrmatcherx = rejestr.matcher(x);
        Matcher rejestrmatchery = rejestr.matcher(y);
        if (!rejestrmatcherx.matches())
        {
            //blad - zakonczenie programu
        }
        Pattern liczba = Pattern.compile("\\d+");
        Matcher liczbamatcher = liczba.matcher(y);
        Pattern adres = Pattern.compile("\\[\\d+\\]");
        Matcher adresmatchery = adres.matcher(y);
        Matcher adresmatcherx = adres.matcher(x);
        if(!liczbamatcher.matches()&&!adresmatchery.matches()&&!rejestrmatchery.matches())
        {
            //blad - zakonczenie programu
        }
        if(liczbamatcher.matches())
        {
            if(x.equals("A"))
            {
                A = Integer.parseInt(y);
            }
            else if(x.equals("B"))
            {
                B = Integer.parseInt(y);
            }
            else if(x.equals("C"))
            {
                C = Integer.parseInt(y);
            }
            else if(x.equals("D"))
            {
                D = Integer.parseInt(y);
            }
            else if (adresmatcherx.matches())
            {
                //do pamieci o danym adresie = Integer.parseInt(y);
            }
        }
        if(adresmatchery.matches())
        {
            int dana = 0;
            //dana = pobieranie z pamieci
            if(x.equals("A"))
            {
                A = dana;
            }
            else if(x.equals("B"))
            {
                B = dana;
            }
            else if(x.equals("C"))
            {
                C = dana;
            }
            else if(x.equals("D"))
            {
                D = dana;
            }
        }
        if (y.equals("A"))
        {
            if(x.equals("A")){}
            else if(x.equals("B"))
            {
                B = A;
            }
            else if(x.equals("C"))
            {
                C = A;
            }
            else if(x.equals("D"))
            {
                D = A;
            }
            else if (adresmatcherx.matches())
            {
                //do pamieci o danym adresie = A;
            }
        }
        if (y.equals("B"))
        {
            if(x.equals("B")){}
            else if(x=="A")
            {
                A = B;
            }
            else if(x.equals("C"))
            {
                C = B;
            }
            else if(x.equals("D"))
            {
                D = B;
            }
            else if (adresmatcherx.matches())
            {
                //do pamieci o danym adresie = B;
            }
        }
        if(y.equals("C"))
        {
            if(x.equals("C")){}
            else if(x.equals("A"))
            {
                System.out.println("bardziej");
                A = C;
            }
            else if(x.equals("B"))
            {
                B = C;
            }
            else if(x.equals("D"))
            {
                D = C;
            }
            else if (adresmatcherx.matches())
            {
                //do pamieci o danym adresie = C;
            }
        }
        if (y.equals("D"))
        {
            if(x.equals("D")){}
            else if(x.equals("A"))
            {
                A = D;
            }
            else if(x.equals("B"))
            {
                B = D;
            }
            else if(x.equals("C"))
            {
                C = D;
            }
            else if (adresmatcherx.matches())
            {
                //do pamieci o danym adresie = D;
            }
        }
    }
    public void add(String x, String y)
    {
        Pattern rejestr = Pattern.compile("[A-D]");
        Matcher rejestrmatcherx = rejestr.matcher(x);
        Matcher rejestrmatchery = rejestr.matcher(y);
        if (!rejestrmatcherx.matches())
        {
            //blad - zakonczenie programu
        }
        Pattern liczba = Pattern.compile("\\d+");
        Matcher liczbamatcher = liczba.matcher(y);
        Pattern adres = Pattern.compile("\\[\\d+\\]");
        Matcher adresmatcher = adres.matcher(y);
        if(!liczbamatcher.matches()&&!adresmatcher.matches()&&!rejestrmatchery.matches())
        {
            //blad - zakonczenie programu
        }
        if(liczbamatcher.matches())
        {
            if(x.equals("A"))
            {
                A = A+Integer.parseInt(y);
            }
            else if(x.equals("B"))
            {
                B = B+Integer.parseInt(y);
            }
            else if(x.equals("C"))
            {
                C = C+Integer.parseInt(y);
            }
            else if(x.equals("D"))
            {
                D = D+Integer.parseInt(y);
            }
        }
        if(adresmatcher.matches())
        {
            int dana = 0;
            //dana = pobieranie z pamieci
            if(x.equals("A"))
            {
                A = A+dana;
            }
            else if(x.equals("B"))
            {
                B = B + dana;
            }
            else if(x.equals("C"))
            {
                C = C+dana;
            }
            else if(x.equals("D"))
            {
                D = D+dana;
            }
        }
        if (y.equals("A"))
        {
            if(x.equals("A")){}
            else if(x.equals("B"))
            {
                B = B+A;
            }
            else if(x.equals("C"))
            {
                C = C+A;
            }
            else if(x.equals("D"))
            {
                D = D+A;
            }
        }
        if (y.equals("B"))
        {
            if(x.equals("B")){}
            else if(x=="A")
            {
                A = A+B;
            }
            else if(x.equals("C"))
            {
                C = C+B;
            }
            else if(x.equals("D"))
            {
                D = D+B;
            }
        }
        if(y.equals("C"))
        {
            if(x.equals("C")){}
            else if(x.equals("A"))
            {
                System.out.println("bardziej");
                A = A+C;
            }
            else if(x.equals("B"))
            {
                B = B + C;
            }
            else if(x.equals("D"))
            {
                D = D + C;
            }
        }
        if (y.equals("D"))
        {
            if(x.equals("D")){}
            else if(x.equals("A"))
            {
                A = A + D;
            }
            else if(x.equals("B"))
            {
                B = B + D;
            }
            else if(x.equals("C"))
            {
                C = C + D;
            }
        }
    }
}