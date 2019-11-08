package we.be.ibidlo.Ibidlo;

public class CountLevel {
    private int countlevel = 0;

    public void zerotwo(){  //Это всё Саня
        System.out.println("Число уровней сброшено");
        countlevel = 0;
    }

    public int getCountlevel(){
        return countlevel;
    }

    public void countlevelPlus(){
        System.out.println("Число уровней"+countlevel);
        countlevel++;
    }
}
