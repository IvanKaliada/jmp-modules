module com.gmail.iikaliada.impl {
    requires spring.context;
    requires spring.beans;
    requires com.gmail.iikaliada.api;
    requires lombok;
    requires com.gmail.iikaliada.dto;
    requires modelmapper;
    requires spring.tx;
    exports com.gmail.iikaliada.impl;
    uses com.gmail.iikaliada.repository.UserRepository;
    uses com.gmail.iikaliada.repository.SubscriptionRepository;
    opens com.gmail.iikaliada.impl;
}