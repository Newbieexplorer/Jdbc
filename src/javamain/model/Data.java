package javamain.model;

/**
 * Created by Виктор on 29.07.2016.
 */
public class Data {
    private int id;
    private String data;

    public Data(String id, String data) {
        this.id = Integer.parseInt(id);
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Data(int id, String data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }


}
