package sk.train.sealed;

sealed interface AIf permits B5, B2If, B3If {}

	final class B5 implements AIf {}

	non-sealed interface B2If extends AIf {}

	sealed interface B3If extends AIf permits C1 {}

		final class C1 implements B3If {}