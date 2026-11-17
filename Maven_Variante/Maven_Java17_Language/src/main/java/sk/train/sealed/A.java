package sk.train.sealed;

sealed class A permits B1, B2, B3 {  }

final class B1 extends A {}

sealed class B2 extends A permits C2 { }

final class C2 extends B2 {}

non-sealed class B3 extends A {}

class C3 extends B3 {}

