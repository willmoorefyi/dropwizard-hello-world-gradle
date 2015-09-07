# Dropwizard "hello-world" App using Gradle

This is the re-implementation of the dropwizard "hello-world" app found on 
https://dropwizard.github.io/dropwizard/getting-started.html, re-implemented using gradle instead
of maven due to my PTSD associated with XML after years of SOAP / WSDL / ESB / J2EE work.  Also
because I thought it would be interesting to compare how much simpler the gradle implementation
wound up being.

## How to run

Pull the github repo, then run "gradle shadowJar".  That will generate a fatjar that you can use
to run.  To run the file, from the root directory execute the following command:

```
java -jar build/libs/dropwizard-hello-world-gradle-all.jar server ./src/main/resources/hello-world.yml
```

This will load Jersey in server mode and feed in the hello-world application yaml file.  Yes this file
is packaged into the Jar.  Yes you can't load it as a resource file.  I guess just cause dropwizard? 
It seems a little hacky compared to the competition (spring-boot), but eh.

## Notes
* Built with the [John Rengelman Shadow Plugin for Gradle](https://github.com/johnrengelman/shadow/).
I've come to rely on this a ton.  Thanks John, whoever and wherever you are!
* Dropwizard version baked in to 0.8.4.  Rev in the build.gradle file
