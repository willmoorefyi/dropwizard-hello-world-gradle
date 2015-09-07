package io.willmoore.sample.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.willmoore.sample.helloworld.health.TemplateHealthCheck;
import io.willmoore.sample.helloworld.resources.HelloWorldResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		//
	}

	@Override
	public void run(HelloWorldConfiguration configuration,
	                Environment environment) throws Exception {
		final HelloWorldResource resource = new HelloWorldResource(
				configuration.getTemplate(),
				configuration.getDefaultName());
		environment.jersey().register(resource);

		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
				configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
	}
}
