.PHONY: all

tests:
	./gradlew test --continue

debug-tests:
	./gradlew testDebugUnitTest --continue

release-tests:
	./gradlew testReleaseUnitTest --continue