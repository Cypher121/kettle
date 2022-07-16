# Kettle User Guide

In this guide you will find an overview of features provided by Kettle, as well as how to start using Kettle for your
own mod.

## Note on compatibility

This library is intended for use with Quilt mods.
It will likely not be compatible with Fabric.

## Table of Contents

* [Getting started](#getting-started)
* [API Reference](#api-reference)
* [Extensions](#extensions)
* [Schedulers](#schedulers)

## Getting started

1) Include Kettle as a dependency for your project.

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    modImplementation("coffee.cypher.kettle:kettle:<latest_version>")
}
```

2) Declare the dependency in your quilt.mod.json

```json
{
  "depends": {
    "kettle": ">=<latest_version>"
  }
}
```

## API Reference

To view the full API documentation, [follow this link.](reference/index.md)

## Extensions

Kettle includes a variety of extension functions and properties, such as:

* [Accessing inventories with operators and iterables](reference/kettle/coffee.cypher.kettle.inventory/index.md)
* [Vector and box utilities](reference/kettle/coffee.cypher.kettle.math/index.md)
* [World access shorthands](reference/kettle/coffee.cypher.kettle.world/index.md)
* and more!

See the [API reference](reference/index.md) for the full list.

Note: more extensions are available in the [Quilt Kotlin Libraries](https://github.com/QuiltMC/quilt-kotlin-libraries/),
which is highly recommended for Kotlin development on Quilt!

## Schedulers

Tick-based schedulers allow the user to control several concurrent tasks at once.
[TickingScheduler](reference/kettle/coffee.cypher.kettle.scheduler/-ticking-scheduler/index.md) can be manually
controlled,
while [TaskTicker](build/docs/reference/kettle/coffee.cypher.kettle.tickers.task/-task-ticker/index.md)
can be used directly as the BlockEntity ticker.

Read more on schedulers, in the [Scheduling API Guide](schedulers.md).
