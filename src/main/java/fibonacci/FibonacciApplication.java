package fibonacci;

import fibonacci.health.TemplateHealthCheck;
import fibonacci.resources.FibonacciSumResource;
import fibonacci.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FibonacciApplication extends Application<FibonacciConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FibonacciApplication().run(args);
    }

    @Override
    public String getName() {
        return "Fibonacci Application";
    }

    @Override
    public void initialize(final Bootstrap<FibonacciConfiguration> bootstrap) {
       // Do Nothing now
    }

    @Override
    public void run(FibonacciConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource helloResource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final FibonacciSumResource fibonacciResource = new FibonacciSumResource(
                configuration.getTemplate(),
                configuration.getDefaultNumber()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(helloResource);
        environment.jersey().register(fibonacciResource);
    }

}
