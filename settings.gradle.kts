pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "ValioBungee"

include(":RedisBungee-API")
project(":RedisBungee-API").projectDir = file("api")

include(":RedisBungee-Commands")
project(":RedisBungee-Commands").projectDir = file("commands")

include(":RedisBungee-Velocity")
project(":RedisBungee-Velocity").projectDir = file("proxies/velocity")

include(":RedisBungee-Bungee")
project(":RedisBungee-Bungee").projectDir = file("proxies/bungeecord/bungeecord-api")

include(":RedisBungee-Proxy-Bungee")
project(":RedisBungee-Proxy-Bungee").projectDir = file("proxies/bungeecord")

include(":RedisBungee-Velocity")
project(":RedisBungee-Velocity").projectDir = file("proxies/velocity/velocity-api")

include(":RedisBungee-Proxy-Velocity")
project(":RedisBungee-Proxy-Velocity").projectDir = file("proxies/velocity")




dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            name = "PaperMC"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
        maven {
            // hosts the bungeecord apis
            name = "sonatype"
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }

        maven {
            url = uri("https://jitpack.io")
        }

    }
    versionCatalogs {
        val jedisVersion = "5.2.0"
        val configurateVersion = "3.7.3"
        val guavaVersion = "31.1-jre"
        val okHttpVersion = "2.7.5"
        val caffeineVersion = "3.1.8"
        val adventureVersion = "4.17.0"
        val acf = "e2005dd62d" // use our own fork 'same upstream with jitpack file only'
        val bungeecordApiVersion = "1.21-R0.1-SNAPSHOT"
        val velocityVersion = "3.4.0-SNAPSHOT";


        create("libs") {

            library("guava", "com.google.guava:guava:$guavaVersion")
            library("jedis", "redis.clients:jedis:$jedisVersion")
            library("okhttp", "com.squareup.okhttp:okhttp:$okHttpVersion")
            library("configurate", "org.spongepowered:configurate-yaml:$configurateVersion")
            library("caffeine", "com.github.ben-manes.caffeine:caffeine:$caffeineVersion")

            library("adventure-api", "net.kyori:adventure-api:$adventureVersion")
            library("adventure-gson", "net.kyori:adventure-text-serializer-gson:$adventureVersion")
            library("adventure-legacy", "net.kyori:adventure-text-serializer-legacy:$adventureVersion")
            library("adventure-plain", "net.kyori:adventure-text-serializer-plain:$adventureVersion")
            library("adventure-miniMessage", "net.kyori:adventure-text-minimessage:$adventureVersion")

            library("acf-core", "com.github.ProxioDev.commands:acf-core:$acf")
            library("acf-bungeecord", "com.github.ProxioDev.commands:acf-bungee:$acf")
            library("acf-velocity", "com.github.ProxioDev.commands:acf-velocity:$acf")

            library("platform-bungeecord","net.md-5:bungeecord-api:$bungeecordApiVersion")
            library("adventure-platforms-bungeecord", "net.kyori:adventure-platform-bungeecord:4.3.2")

            library("platform-velocity", "com.velocitypowered:velocity-api:$velocityVersion")




        }


    }


}
