---
title: getSideAccess
---
//[kettle](../../index.html)/[coffee.cypher.kettle.inventory](index.html)/[getSideAccess](get-side-access.html)



# getSideAccess



[jvm]\
fun Inventory.[getSideAccess](get-side-access.html)(side: Direction): Inventory



Creates a proxy Inventory that only represents slots of this Inventory available from the specified [side](get-side-access.html).



Any changes to the proxy's contents will be applied to the base inventory's corresponding slots, and vice versa.



The size and slots of the proxy can change, if the base inventory changes which slots are accessible from the specified [side](get-side-access.html).




