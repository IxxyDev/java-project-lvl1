.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

lint:
	./gradlew checkstyleMain checkstyleTest

dev:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app
