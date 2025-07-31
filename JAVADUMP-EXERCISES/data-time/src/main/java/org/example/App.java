package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.awt.SystemColor.text;


public class App 
{
    public static void main( String[] args ) {
        LocalTime current = LocalTime.now(); // system time
        int hour = 12;
        int minute = 15;
        int second = 35;

        LocalTime noon = LocalTime.of(hour, minute, second);

        LocalTime parsed = LocalTime.parse("12:15:35");

        LocalTime customformat = LocalTime.parse("2:30 PM",
                DateTimeFormatter.ofPattern("h:nm a")); //look it up or ask LLM

        LocalTime sample = LocalTime

    }
}
