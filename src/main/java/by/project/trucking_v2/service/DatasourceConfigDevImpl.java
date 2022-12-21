package by.project.trucking_v2.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DatasourceConfigDevImpl implements DatasourceConfig{
    @Override
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}
