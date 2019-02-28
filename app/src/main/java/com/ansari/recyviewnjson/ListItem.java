package com.ansari.recyviewnjson;

/**
 * Created by Ansari on 6/9/2017.
 */
public class ListItem {

    private String heading;
    private String desc;
    private String image_url;
    private String spouse;

    public String getHeading() {
        return heading;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage_url() {
        return image_url;
    }
    public String getSpouse() {
        return spouse;
    }

    public ListItem(String heading, String desc, String spouse,String image_url) {
        this.heading = heading;
        this.desc = desc;
        this.image_url= image_url;
        this.spouse = spouse;


    }
}
