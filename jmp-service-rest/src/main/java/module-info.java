module com.gmail.iikaliada.rest {
    requires com.gmail.iikaliada.api;
    requires spring.context;
    requires spring.web;
    requires lombok;
    requires com.gmail.iikaliada.dto;
    requires spring.beans;
    requires java.persistence;
    requires io.swagger.v3.oas.annotations;
    exports com.gmail.iikaliada.controller;
    uses com.gmail.iikaliada.serivce.UserService;
    opens com.gmail.iikaliada.controller;
}