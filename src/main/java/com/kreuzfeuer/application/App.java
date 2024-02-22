package com.kreuzfeuer.application;

import com.kreuzfeuer.application.ui.ConsoleInterface;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        new ConsoleInterface(new Scanner(System.in)).start();
    }
}
