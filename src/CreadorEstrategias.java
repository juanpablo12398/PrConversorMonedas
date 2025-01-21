import java.util.HashMap;

public class CreadorEstrategias {
    public HashMap<Number,Estrategia> crearEstrategias(){
        HashMap<Number, Estrategia> estrateigas = new HashMap<>();
        Estrategia estrategia1 = new Estrategia
                ("USD","ARS");
        estrateigas.put(1,estrategia1);
        Estrategia estrategia2 = new Estrategia
                ("ARS","USD");
        estrateigas.put(2,estrategia2);
        Estrategia estrategia3 = new Estrategia
                ("USD","BRL");
        estrateigas.put(3,estrategia3);
        Estrategia estrategia4 = new Estrategia
                ("BRL","USD");
        estrateigas.put(4,estrategia4);
        Estrategia estrategia5 = new Estrategia
                ("USD","COP");
        estrateigas.put(5,estrategia5);
        Estrategia estrategia6 = new Estrategia
                ("COP","USD");
        estrateigas.put(6,estrategia6);

        return estrateigas;
    }

}
