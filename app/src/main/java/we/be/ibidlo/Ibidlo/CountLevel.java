package we.be.ibidlo.Ibidlo;

public class CountLevel {
    private static int countlevel;

    public static void zerotwo(){  //Это всё Саня
        System.out.println("Число уровней сброшено");
        countlevel = 0;
    }

    public static int getCountlevel(){
        return countlevel;
    }

    public static void countlevelPlus(){
        System.out.println("Число уровней до добавления"+countlevel);
        countlevel++;
        System.out.println("Число уровней после добавления"+countlevel);
    }
}
