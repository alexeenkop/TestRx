package palexp.cn.ua.testrx.http;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pALEXp on 28.04.2017.
 */

public class Sector {

    private String id = "";
    private String name = "";
    @SerializedName("child_sectors")
    private ArrayList<Sector> childSectors = new ArrayList<>();

    public Sector(String id, String name, ArrayList<Sector> childSectors) {
        this.id = id;
        this.name = name;
        this.childSectors = childSectors;
    }

    public Sector() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sector> getChildSectors() {
        return childSectors;
    }

    public void setChildSectors(ArrayList<Sector> childSectors) {
        this.childSectors = childSectors;
    }
}
