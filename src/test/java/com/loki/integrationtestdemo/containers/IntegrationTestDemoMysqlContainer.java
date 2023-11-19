package com.loki.integrationtestdemo.containers;

import org.testcontainers.containers.MySQLContainer;

public class IntegrationTestDemoMysqlContainer extends
        MySQLContainer<IntegrationTestDemoMysqlContainer> {

    private static final String IMAGE_VERSION = "mysql:5.7";
    private static IntegrationTestDemoMysqlContainer container;

    public IntegrationTestDemoMysqlContainer() {
        super(IMAGE_VERSION);
    }

    public static IntegrationTestDemoMysqlContainer getInstance() {
        if (container == null) {
            container = new IntegrationTestDemoMysqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
