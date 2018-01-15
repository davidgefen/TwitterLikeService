package challenge.models;

/**
 * Created by davidbra on 6/30/17.
 */
public class UserModel extends DataModel {

    private String handle;
    private String name;

    public UserModel(int id, String handle, String name) {
        super.setId(id);
        this.handle = handle;
        this.name = name;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
