/**
 * Created by Maks on 3/24/2017.
 */
public class Fact {
    private int id;
    private String subject;
    private String relation;
    private String object;
    private String location;
    private String date;

    public Fact() {
    }

    public Fact(int id, String subject, String relation, String object, String location, String date) {
        this.id = id;
        this.subject = subject;
        this.relation = relation;
        this.object = object;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + id + ", subject: " + subject + ",relation: " + relation + ", object: " + object + ", location: " + location + ", date: " + date + "}";
    }
}
