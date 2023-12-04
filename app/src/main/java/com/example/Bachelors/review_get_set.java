package com.example.Bachelors;

public class review_get_set {

    private String Name, Property, Address, Duration, Feedback;
    public float Rating;

    public review_get_set() {

    }

    public review_get_set (String Name, String Property, String Address, String Duration, String Feedback, float Rating) {
        this.Name = Name;
        this.Property = Property;
        this.Address = Address;
        this.Duration = Duration;
        this.Feedback = Feedback;
        this.Rating=Rating;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProperty() {
        return Property;
    }

    public void setProperty(String property) {
        Property = property;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address= address;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(float rating ) {
        this.Rating = rating;
    }

}




