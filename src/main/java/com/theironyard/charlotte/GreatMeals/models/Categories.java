package com.theironyard.charlotte.GreatMeals.models;


//format used was mirrored the way yelp API has it listed
//alias: coffee, title: Tea & Coffee

public class Categories {
    public String alias;
    public String title;

    public Categories(String alias, String title) {
        this.alias = alias;
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
