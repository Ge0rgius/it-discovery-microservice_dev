plugins { 
  java
  id("org.springframework.boot") version "3.1.4" apply false
}

  group = "it.discovery"

  apply(plugin = "java")

   java.sourceCompatibility = JavaVersion.VERSION_21
   java.targetCompatibility = JavaVersion.VERSION_21

   repositories {
     jcenter()
   }

   var springBootVersion = "3.1.0"
   
   dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))    
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")

        runtimeOnly("jakarta.xml.bind:jakarta.xml.bind-api")
        runtimeOnly("jakarta.annotation:jakarta.annotation-api")

        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok:1.18.30")

        runtimeOnly("com.h2database:h2")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
   } 

tasks.test {
    useJUnitPlatform()
}



