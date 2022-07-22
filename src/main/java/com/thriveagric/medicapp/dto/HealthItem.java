package com.thriveagric.medicapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class HealthItem {
    /// <summary>
    /// Item ID
    /// </summary>
    public int ID;

    public String Name;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "HealthItem{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }

    /// <summary>
    /// Item name
    /// </summary>
}

