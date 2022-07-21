package com.thriveagric.medicapp.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE");


    public final String gender;

    Gender(String status){
        this.gender = status;
    }

    @JsonValue
    public String getStatus() {
        return gender;
    }
}
