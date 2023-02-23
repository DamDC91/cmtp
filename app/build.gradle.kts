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
