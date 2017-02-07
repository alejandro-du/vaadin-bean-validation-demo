package com.example;

import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Alejandro Duarte
 */
@ConsistentDateRange
public class Meetup {

    @Size(min = 3, max = 512)
    private String name;

    private LocalDate start;

    private LocalDate end;

    @Override
    public String toString() {
        return name + " (" + start + " - " + end + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
