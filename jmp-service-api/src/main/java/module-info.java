module com.gmail.iikaliada.api {
    requires spring.context;
    requires com.gmail.iikaliada.dto;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.sql;
    requires spring.core;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.webmvc;
    requires lombok;
    requires org.springdoc.openapi.common;
    requires io.swagger.v3.oas.models;
    requires io.swagger.v3.oas.annotations;
    exports com.gmail.iikaliada.serivce;
    exports com.gmail.iikaliada.entity;
    exports com.gmail.iikaliada.repository;
    exports com.gmail.iikaliada.converter;
    opens com.gmail.iikaliada.entity;
    opens com.gmail.iikaliada.configuration;
}