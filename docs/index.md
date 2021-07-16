# Kettle User Guide

In this guide you will find an overview of features provided by Kettle, as well as how to start using Kettle for your
own mod.

## Note on compatibility

This library is ultimately intended for use with Quilt mods. It will likely remain compatible with Fabric for a long
time, but no guarantees are given yet.

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
    modImplementation("coffee.cypher.kettle:kettle:latest_version")
}
```

2) Declare the dependency in your fabric.mod.json

```json
{
  "depends": {
    "kettle": ">=latest_version"
  }
}
```

## API Reference

To view the full API documentation, [follow this link.](reference/index.md)

## Extensions

Kettle includes a variety of extension functions and properties, such as:

* [Accessing inventories with operators and iterables](reference/kettle/coffee.cypher.kettle.inventory/index.md)
* [Idiomatic vector math](reference/kettle/coffee.cypher.kettle.math/index.md)
* [World access shorthands](reference/kettle/coffee.cypher.kettle.world/index.md)
* and more!

See the [API reference](reference/index.md) for the full list.

## Schedulers

Tick-based schedulers allow the user to control several concurrent tasks at once.
[TickingScheduler](reference/kettle/coffee.cypher.kettle.scheduler/-ticking-scheduler/index.md) can be manually
controlled,
while [TaskBlockEntityController](reference/kettle/coffee.cypher.kettle.tickers.task/-task-block-entity-ticker/index.md)
can be used directly as the BlockEntity ticker.

Schedulers allow for control of the task execution via
a [TaskHandle](reference/kettle/coffee.cypher.kettle.scheduler/-task-handle/index.md) and take
an [ExecutionConfiguration](reference/kettle/coffee.cypher.kettle.scheduler/-execution-configuration/index.md), which
specifies how each task will be repeated, as well as how much time it is allowed to spend each tick before being
suspended.

**Note: tasks, like all coroutines, operate on cooperative concurrency. Using `yield()` often will help prevent the task
from running too long in one tick.**