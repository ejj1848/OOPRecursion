package OOPFinal.bo;

/**
 * Created by ericjohn1 on 7/12/2016.
 */
public class BaseBO {

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String test_method(){
        return "super method";
    }

}