package com.distribuida.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.*;
import org.jdbi.v3.core.Jdbi;


// componente de CDI
@ApplicationScoped
public class DbConfig {
    // Opcion 2

    /*public void init (){
        System.out.println("Inicializando la base de datos");


        Config config = ConfigProvider.getConfig();

        String url = config.getValue("db.url", String.class);
        String username = config.getValue("db.username", String.class);
        String password = config.getValue("db.password", String.class);
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
    }*/
    public Jdbi conection () {
        Config config = ConfigProvider.getConfig();

        String url = config.getValue("db.url", String.class);
        String username = config.getValue("db.username", String.class);
        String password = config.getValue("db.password", String.class);

        return Jdbi.create(url, username, password);
    }

    public static Jdbi con2 () {
        Config config = ConfigProvider.getConfig();

        String username = config.getValue("db.username", String.class);
        String password = config.getValue("db.password", String.class);
        String url = config.getValue("db.url", String.class);
        String driver = config.getValue("db.driver", String.class);

        HikariConfig hc = new HikariConfig();
        hc.setUsername(username);
        hc.setPassword(password);
        hc.setJdbcUrl(url);
        hc.setMaximumPoolSize(4);
        hc.setDriverClassName(driver);

        return Jdbi.create(new HikariDataSource(hc));
    }

    public void test() {
    }
}
