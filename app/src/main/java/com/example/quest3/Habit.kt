package com.example.quest3

import java.io.Serializable

class Habit : Serializable {
    lateinit var name : String
    lateinit var description : String
    var priority : Int = 0
    lateinit var type : String
    lateinit var countOfFinish : String
    lateinit var period : String
    constructor(name : String, description : String, priority : Int, type : String, countOfFinish : String, period : String) {
        this.name = name
        this.description = description
        this.priority = priority
        this.type = type
        this.countOfFinish = countOfFinish
        this.period = period
    }
    override fun toString(): String {
        return "Habit{" +
                "name='" + name + '\'' +
                ", description=" + description +
                ", fatherName='" + priority + '\'' +
                ", type=" + type + '\'' +
                ", countOfFinish=" + countOfFinish + '\'' +
                ", period=" + period + '\'' +
                '}';
    }
}