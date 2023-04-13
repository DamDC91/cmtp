plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version("0.0.13")
}

repositories {
    mavenCentral()
}

javafx {
    version = "11"
    modules = mutableListOf("javafx.controls", "javafx.fxml")
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("javax.activation:javax.activation-api:1.2.0")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.2")
    runtimeOnly("org.openjfx:javafx-graphics:$javafx.version:win")
    runtimeOnly("org.openjfx:javafx-graphics:$javafx.version:linux")
    runtimeOnly("org.openjfx:javafx-graphics:$javafx.version:mac")
}


application {
    mainClass.set("cmtp.HelloWorld")
}

sourceSets {
    main {
        //java {
            //srcDirs("src/main/java")
        //}
    }
}
