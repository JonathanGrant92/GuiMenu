package main.java.guimenu;

public enum Options {
    A(1),B(2),C(3),QUIT(4),
    A1(5),B1(6),C1(7),CLOSE(8);

    private final int value;

    Options(int value) { this.value = value; }

    public int getValue() { return this.value; }
}
