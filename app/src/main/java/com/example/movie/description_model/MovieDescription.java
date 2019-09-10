package com.example.movie.description_model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDescription implements Parcelable {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;


    protected MovieDescription(Parcel in) {
        description = in.readString();
        title = in.readString();
    }

    public static final Creator<MovieDescription> CREATOR = new Creator<MovieDescription>() {
        @Override
        public MovieDescription createFromParcel(Parcel in) {
            return new MovieDescription(in);
        }

        @Override
        public MovieDescription[] newArray(int size) {
            return new MovieDescription[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeString(title);
    }
}
