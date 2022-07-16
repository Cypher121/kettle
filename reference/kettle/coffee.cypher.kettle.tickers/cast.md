---
title: cast
---
//[kettle](../../index.html)/[coffee.cypher.kettle.tickers](index.html)/[cast](cast.html)



# cast



[jvm]\
fun &lt;[T](cast.html) : BlockEntity, [E](cast.html) : BlockEntity&gt; BlockEntityTicker&lt;[T](cast.html)&gt;.[cast](cast.html)(): BlockEntityTicker&lt;[E](cast.html)&gt;



Casts a BlockEntityTicker to the specified BlockEntity type [E](cast.html).



Mainly used when returning from BlockWithEntity.getTicker to return the correct generic type, when it's expected to match this ticker's.




