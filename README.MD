## Example ServiceLoader
>this is an example of a ServiceLoader, for simple -library free- java dependency decoupling. Works great for connectors and plugin models in java.

[Java Docs | https://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html ](https://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html)


## Definitions
**Service** *The concept (consisting of an api and an impl)*
>A service is a set of programming interfaces and classes that provide access to some specific application functionality or feature. The service may simply define the interfaces for the functionality and a way to retrieve an implementation. In a word-processor example, a dictionary service can define a way to retrieve a dictionary and the definition of a word, but it does not implement the underlying feature set. Instead, it relies on a service provider to implement that functionality.

**Service Povider Interface (SPI)** *Part of the API*
>A service provider interface (SPI) is the set of public interfaces and abstract classes that a service defines. The SPI defines the classes and methods available to your application.

**Service Provider (impl)**
>A service provider implements the SPI. An application with extensible services will allow you, vendors, and perhaps even customers to add service providers without modifying the original application.



calling

```bash
java -cp test-consumer-1.0-SNAPSHOT.jar;test-impl-1.0-SNAPSHOT.jar;test-api-1.0-SNAPSHOT.jar com.swampfox.serviceapi.consumer.App
```

will show you 
```bash
CakeServiceProvide: Provider 1 - testy provider
Best Dynamic Cake
```

because `test-impl-1.0-SNAPSHOT.jar` is found with an impl of the service. try removing it from the classpath and you will see nothing is printed.

## notes

A couple of good resources:

[Baeldung](https://www.baeldung.com/java-spi)

[DZone](https://dzone.com/articles/play-with-java-serviceloader-forget-about-dependen)

## Helpful libraries
The trick to getting Service Loading to work is adding a service provider file in the META-INF/services directory. It's just a text file with the name of the service interface and the path to the impl class. But google made a library that can create this at build time with maven.
It's well explained on the repo, but the usage is:

### [AutoService](https://github.com/google/auto/tree/master/service)

```xml
<dependencies>
  <dependency>
    <groupId>com.google.auto.service</groupId>
    <artifactId>auto-service</artifactId>
    <version>${version}</version>
    <optional>true</optional>
  </dependency>
</dependencies>
```

usage

```java
package foo.bar;

import com.swampfox.serviceapi.CakeServiceProvider;

@AutoService(CakeServiceProvider.class)
final class MyImplCakeServiceProvider implements CakeServiceProvider {
  // …
}
```
