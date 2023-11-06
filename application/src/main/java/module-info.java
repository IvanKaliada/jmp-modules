module com.gmail.iikaliada.application {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.core;
    requires spring.beans;
    requires com.gmail.iikaliada.api;
    requires com.gmail.iikaliada.rest;
    requires com.gmail.iikaliada.impl;
    requires com.gmail.iikaliada.dto;
    requires spring.context;
    opens com.gmail.iikaliada;
}