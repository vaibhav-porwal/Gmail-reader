package com.dishoom;

import com.google.common.collect.ImmutableList;
import in.vectorpro.dropwizard.swagger.SwaggerBundle;
import in.vectorpro.dropwizard.swagger.SwaggerBundleConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.List;
import lombok.Data;
import ru.vyarus.dropwizard.guice.GuiceBundle;

@Data
public class App extends Application<KoohooConfiguration> {

    private static List<String> packageNames = ImmutableList.of("com.dishoom");

    public static void main(String[]  args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(KoohooConfiguration koohooConfiguration, Environment environment) {
    }

    @Override
    public void initialize(Bootstrap<KoohooConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
            .enableAutoConfig(packageNames.get(0))
                .modules(new KoohooModule())
            .build());

        bootstrap.addBundle(new SwaggerBundle<KoohooConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(KoohooConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
}
