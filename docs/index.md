# Kettle User Guide

In this guide you will find an overview of features provided by Kettle, as well as various ways you can use it in your mod.

## Table of Contents
* [Including in your project](#including-in-your-project)
* [Extensions](#extensions)
* [Config DSL](#config-dsl)
* [Coroutines](#coroutines)

## Including in your project

Kettle currently supports two usage scenarios: using it as an external dependency and shading.  
Which one you should use depends on your goals, as described in pros/cons below.

**However, note that Kettle does not provide its own Kotlin standard library in either case. It's on you to supply a compatible one.**

### External dependency

In this scenario, Kettle is used as an external dependency for your mod and is handled by Forge and modpacks.

**Pros:**  
* Reduces the total size of the pack when multiple mods depend on Kettle
* Simplifies your own build

**Cons:**  
* Requires users to download and manage another JAR file
* Possible version conflicts with other mods

**How to:**

1) Declare a dependency on Kettle in your project  
```gradle
ext.kettle_version = '...'

dependencies {
    implementation "coffee.cypher.kettle:kettle:$kettle_version"
}
```
    
2) Provide a Kotlin Standard Library implementation  
  *Note: Kettle requires only the stdlib, not the kotlin-reflect library, and not any of the kotlinx extensions*  
  It's up to you how to go about this step, but since Kettle here is a standalone JAR, it will only recognize the standard `kotlin` package.  
  As shading common libraries without changing the package name is a bad practice, it's recommended that you use a separate provider, such as [Kottle](https://github.com/autaut03/kottle).
    
3) Declare a mod dependency in mods.toml  
```toml
[[dependencies.yourmodid]]
    modId="kettle"
    mandatory=true
    versionRange="[<version>,)"
    ordering="NONE"
    side="BOTH"
```
    
4) Declare a dependency in your CurseForge project, if you have one  
  Kettle can be found at Minecraft CurseForge under https://minecraft.curseforge.com/projects/kettle  
  Below is an example of a dependency declaration using [Matthew Prenger's CurseGradle plugin](https://github.com/matthewprenger/CurseGradle):  
```gradle
curseforge {
    project {
        relations {
            requiredDependency 'kettle'
        }
    }
}
```
    
### Shaded dependency

In this scenario, Kettle is included as a part of your own mod and is distributed in the same JAR.

**Pros:**  
* Gives you full control over the Kettle version used
* Does not require users to manage a separate JAR in their pack

**Cons:**  
* Complicates build setup and process, potentially slowing it down
* Inflates the size of each JAR that includes Kettle in this way

**How to:**

WIP (shade the :lib classifier, replace the `kotlin` package references in Kettle with the new location of stdlib)
