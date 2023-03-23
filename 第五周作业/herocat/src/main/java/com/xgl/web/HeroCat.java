package com.xgl.web;

public class HeroCat {
    public static void main(String[] args) throws Exception {
        CustomServer customServer = new CustomServer("com.hero.webapp");
        customServer.start();
    }
}
