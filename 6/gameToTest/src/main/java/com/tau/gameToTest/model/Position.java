package com.tau.gameToTest.model;

import lombok.Data;

@Data
public class Position {
    private int column;
    private int row;

    public Position() {
        this.column = 0;
        this.row = 0;
    }

    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
