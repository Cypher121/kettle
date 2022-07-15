# Kettle Scheduling

One of the features provided by Kettle is a selection of task scheduling tools
allowing creation of configurable suspendable tasks. The tasks, similarly to the
[kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) library, use
coroutines to describe computations that can be stopped, delayed, and resume at will.

For example, the code below drops TNT on a random living player in the Overworld once a minute:
<details>
    <summary>Example</summary>
<div markdown="1">
```kotlin
//create a scheduler with a server world context
val scheduler = scheduler<ServerWorld> {
    //add a task
    task {
        //that runs infinitely and pauses
        //for 1 minute (1200 ticks) after every run
        run infinitely {
            pause = 60 * 20
        }

        action {
            //use the ServerWorld as `this`
            withContext {
                randomAlivePlayer?.let {
                    it.sendMessage(
                        Text.literal("Think fast"),
                        MessageType.SYSTEM
                    )

                    //suspend task for 1 second
                    sleepFor(20)

                    TntBlock.primeTnt(this, it.pos.up(2))
                }
            }
        }
    }
}

ServerTickEvents.START.register {
    if (server.registryKey == World.OVERWORLD) {
        //pass the ServerWorld as context and advance the tasks
        scheduler.tick(server)
    }
}
```
</div>
</details>

# Why use scheduling?

<details>
    <summary>Long-running tasks</summary>

Like other Kotlin coroutines, scheduled tasks can be suspended to pause the task.
Functions like [sleepFor](reference/kettle/coffee.cypher.kettle.scheduler/-task-context/sleep-for.md)
or [waitUntil](reference/kettle/coffee.cypher.kettle.scheduler/-task-context/wait-until.md)
cleanly describe how tasks behave over multiple ticks without having to resort
to manually splitting up the code and keeping track of conditions, states, and timers.

</details>

<details>
    <summary>Separating responsibilities</summary>

When using a scheduler, tasks can be given individual responsibilities, such as
energy transfer vs. consuming fuel or manipulating redstone output. This allows tasks
to contain their own state, start and pause individually, and even control one another.

</details>

<details>
    <summary>Functionality as "extensions"</summary>

When designing objects such as block entities, tasks allow moving all actions
and transient state out of the class, leaving behind a minimal data representation
that only takes care of storing permanent data, transferring it to/from NBT and network,
and responding to external events or API calls.

</details>

# Limitations

<details>
    <summary>Data serialization</summary>

Serializing the task's entire coroutine is generally not feasible, meaning retrieving
and inserting its internal state for NBT persistence or networking has to be done
manually. This can cause coroutines to lose some of their linearity if too much data needs
to be stored.

One way to handle this is to store all permanent/shared data on the saved/synchronized
object (e.g. block entity), so it can be used by serializing methods, and initialize values
within the task to those in the fields, instead of usual default values, as to expect
those values to contain data from previous iterations.

</details>

# Basics

The basic units of the scheduling API are:

* [Task](reference/kettle/coffee.cypher.kettle.scheduler/-task/index.md) containing the full
configuration, action, and current state of any given task.
A task can tick, given the correct context. It can be paused, stopped, started, or restarted
externally, or sleep or wait for a condition from inside the task.
* [TickingScheduler](reference/kettle/coffee.cypher.kettle.scheduler/-ticking-scheduler/index.md)
serving as a collection of tasks that require the same context.
It can receive a context or context update, using it to run all contained tasks.

Additional elements of interest are:

* [TaskTicker](reference/kettle/coffee.cypher.kettle.tickers.task/-task-ticker/index.md)
is a scheduler wrapper that can be directly used as a BlockEntityTicker.
In addition to providing access to the entity and other tick parameters, it allows
finding schedulers belonging to the same ticker on other block entities.
* [ExecutionConfiguration](reference/kettle/coffee.cypher.kettle.scheduler/-execution-configuration/index.md)
describes how many times the task should run, delay
before initial execution and every following one, as well how much real time the
task is allowed to run until `yield()` interrupts it.
* [TaskContext](reference/kettle/coffee.cypher.kettle.scheduler/-task-context/index.md)
serves as the execution environment on the task. It provides
access to suspension points like `sleepFor(ticks)` or `waitUntil(condition)`,
which allow the task to delay execution.

## Simple ticker example

For this example, we will create a block entity that fills a square centered
above itself with farmland. Let's define the objects:

```kotlin
class ExampleBlockEntity(blockPos: BlockPos, blockState: BlockState) : BlockEntity(
    exampleBEType, blockPos, blockState
)

//this example will not show parameters
//not relevant to Kettle
object ExampleBlock : BlockWithEntity() {
    override fun <T : BlockEntity> getTicker(
        world: World, state: BlockState, type: BlockEntityType<T>
    ): BlockEntityTicker<T> = exampleTicker.cast()
}
```

Note the `.cast()` call in `getTicker`: the ticker we will define requires a specific
block entity type, while the `getTicker` method is generic. In cases where the block
or block entity type in question make it certain what type of block entity is present,
the [cast](reference/kettle/coffee.cypher.kettle.tickers/cast.md) extension can be used
to cast the ticker to the correct generic `T`.

With that out of the way, let us implement a ticker:

```kotlin
//the compiler will often infer this
val exampleTicker = taskTicker<ExampleBlockEntity> {
    task {
        //this task will run immediately
        name = "Farmland"
        start = true

        //and only once
        run once {}

        //the code executed by the task
        action {
            //adds the tick parameters
            //as a context receiver
            withContext {
                //get a sequence of all block positions to be filled
                val positions = Box(pos.up()).expand(5, 0, 5).getContainedBlockPos()

                positions.forEach {
                    world.setBlockState(it, Blocks.FARMLAND.defaultState)
                    //place 2 blocks a second
                    sleepFor(10)
                }
            }
        }
    }
}
```

Provided the block and block entity are registered correctly, the block will
immediately create an 11x11 square of farmland above itself once placed.

Let's take a look at some of the code above:

[withContext](reference/kettle/coffee.cypher.kettle.scheduler/-task-context/with-context.md)
is a method of the `TaskContext` providing access
to the additional context argument. In this case, that argument is [TickerContext](reference/kettle/coffee.cypher.kettle.tickers.task/-ticker-context/index.md).
<details>
    <summary>Note on future changes to contexts</summary>

Once [context receivers](https://github.com/Kotlin/KEEP/blob/master/proposals/context-receivers.md)
are stabilized, this argument will instead
be provided to the lambda directly as a context. This likely not require
code changes immediately, but `withContext` will no longer be necessary and will
be deprecated.
</details>

[sleepFor](reference/kettle/coffee.cypher.kettle.scheduler/-task-context/sleep-for.md)
is a method of TaskContext allowing the task to suspend itself for
a specified number of ticks. The task is then recorded to a continuation and begins
counting down whenever the scheduler (in this case ticker) calls it.

`run once {}` creates a default [ExecutionConfiguration.Once](reference/kettle/coffee.cypher.kettle.scheduler/-execution-configuration/-companion/once.md),
meaning the task will not re-run once completed.

## Building on the task

For the second step, let's make changes to this task:

1) Place blocks as fast as possible, but don't take more than 10ms per tick to prevent lag.
2) Run the task every time an iron block is placed under the block entity, consuming the block.
3) Redstone signal pauses the task.

```kotlin
val exampleTicker = taskTicker<ExampleBlockEntity> {
    //hold a reference to this task
    //so it can be paused
    val farmTask = task {
        name = "Farmland"
        start = true

        //this task now runs infinitely
        run infinitely {
            //and yields after 10 ms
            yieldsAfterMs = 10
        }

        action {
            withContext {
                //only start once an iron block is detected
                waitUntil {
                    world.getBlockState(pos.down()).block == Blocks.IRON_BLOCK
                }

                world.removeBlock(pos.down(), false)

                val positions = Box(pos.up()).expand(5, 0, 5).getContainedBlockPos()

                positions.forEach {
                    world.setBlockState(it, Blocks.FARMLAND.defaultState)
                    //yield after every loop to
                    //let the scheduling pause after 10ms
                    yield()
                }
            }
        }
    }

    task {
        name = "Redstone Control"
        start = true

        action {
            waitUntil {
                world.getReceivedRedstonePower(pos) > 0
            }

            //pause the task on high redstone
            farmTask.pause()

            //check every 3 ticks
            waitUntil(checkEvery = 3) {
                world.getReceivedRedstonePower(pos) == 0
            }

            //and resume on low
            farmTask.resume()
        }
    }
}
```

With the second task having a reference to the first, it can pause and resume it
at will, allowing separation of the main logic from the additional redstone pause.

The farmland task now calls [waitUntil](reference/kettle/coffee.cypher.kettle.scheduler/-task-context/wait-until.md)
allowing it to remain suspended until
it detects an iron block. Similarly, Redstone Control makes use of this method,
while also reducing the frequency of the checks for resuming the task with the
`checkEvery` parameter.

In place of `sleepFor`, the Farmland task now calls [yield](reference/kettle/coffee.cypher.kettle.scheduler/-task-context/yield.md).
Unlike `sleepFor`,`yield` does not suspend the task unconditionally. However, if it detects that the
task has taken too long since it last resumed, as configured by `yieldsAfterMs`, it suspends the task until next tick.

**Note**: like other coroutines, tasks rely on cooperative multitasking, meaning
they have to allow control to be taken away from them and will not be stopped unexpectedly.
While yield is a useful tool for mitigating lag, you must call it yourself at key points,
such as within long-running loops, allowing the scheduler to take back control.
Additionally, you should expect that the operation may or may not continue on the
same tick and not make unsafe assumptions about whether your code is running continuously.
