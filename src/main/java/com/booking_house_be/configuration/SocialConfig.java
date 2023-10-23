package com.booking_house_be.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
    ConnectionFactory<Facebook> connectionFactory = new FacebookConnectionFactory("170499366057048", "7fb4bacd8141c53cd9d21d39a1a317e4");

    @Bean
    public ConnectionFactory<Facebook> createConnectionFactory() {
        return connectionFactory;
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new InMemoryUsersConnectionRepository(connectionFactoryLocator);
    }
}

