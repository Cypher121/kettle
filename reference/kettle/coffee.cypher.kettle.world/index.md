---
title: coffee.cypher.kettle.world
---
//[kettle](../../index.html)/[coffee.cypher.kettle.world](index.html)



# Package-level declarations



## Functions


| Name | Summary |
|---|---|
| [onClient](on-client.html) | [jvm]<br>inline fun BlockEntity.[onClient](on-client.html)(toRun: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Runs the given [toRun](on-client.html) block if this BlockEntity is contained on the logical client.<br>[jvm]<br>inline fun WorldView.[onClient](on-client.html)(toRun: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Runs the given [toRun](on-client.html) block if this WorldView represents a world on the logical client. |
| [onServer](on-server.html) | [jvm]<br>inline fun BlockEntity.[onServer](on-server.html)(toRun: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Runs the given [toRun](on-server.html) block if this BlockEntity is contained on the logical server.<br>[jvm]<br>inline fun WorldView.[onServer](on-server.html)(toRun: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Runs the given [toRun](on-server.html) block if this WorldView represents a world on the logical server. |
| [typedBlockEntity](typed-block-entity.html) | [jvm]<br>inline fun &lt;[T](typed-block-entity.html) : BlockEntity&gt; BlockView.[typedBlockEntity](typed-block-entity.html)(pos: BlockPos): [T](typed-block-entity.html)?<br>Returns the BlockEntity contained at the given [pos](typed-block-entity.html) in this BlockView, if it exists and is of type [T](typed-block-entity.html). |

