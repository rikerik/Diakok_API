package business;

import java.util.ArrayList;
import java.util.List;
import model.Diak;

public class DiakIro {

    private List<Diak> diakList = new ArrayList<>();

    private static DiakIro sajatEgyed = new DiakIro();

    public static DiakIro getEgyed() {
        return sajatEgyed;
    }

    public String addDiak(Diak diak) {
        String ujId = Integer.toString(diakList.size() + 1);
        diakList.add(diak);
        return ujId;
    }

    public List<Diak> getdiakList() {
        return diakList;
    }

}
