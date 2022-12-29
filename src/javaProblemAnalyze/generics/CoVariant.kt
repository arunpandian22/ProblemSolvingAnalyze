package javaProblemAnalyze.generics

open class GrandParent { }

open class Parent : GrandParent() { }

class BabyChild : Parent() { }

//// Assuming `TaxPayer<Parent>` is covariant
//fun calculateHasNoGrandChildTax(taxPayer TaxPayer<Parent>) {
//    //some interesting calculations for only a Parent and a BabyChild
//}