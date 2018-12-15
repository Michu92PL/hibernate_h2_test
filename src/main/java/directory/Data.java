package directory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

//@NamedQuery(name = "Data.findById", query = "SELECT d FROM Data d WHERE d.id = :id")
@Entity
public class Data {

    @Id
    @GeneratedValue
    private long id;
    private String msg;

    public Data(String msg) {
        this.msg = msg;
    }

    public Data() {
    }

    public Data(long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}
