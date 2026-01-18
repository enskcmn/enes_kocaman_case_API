package api.payload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pet {
    private int id;
    private HashMap<String, String> category;
    private String name;
    private List<String> photoUrls;
    private HashMap <String, String> tag;
    private Status status;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Map<String, String> getCategory() {
        return category;
    }
    public void setCategory(HashMap<String, String> category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getPhotoUrls() {
        return photoUrls;
    }
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public HashMap<String, String> getTag() {
        return tag;
    }
    public void setTag(HashMap<String, String> tag) {
        this.tag = tag;
    }

}