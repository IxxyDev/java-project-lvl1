.DEFAULT_GOAL := build-run

clean:
	./app/gradlew clean

build:
	./app/gradlew clean build

install:
	./app/gradlew clean install

run-dist:
	./build/install/app/bin/app

run:
	./app/gradlew run

test:
	./app/gradlew test

report:
	./app/gradlew jacocoTestReport

lint:
	./app/gradlew checkstyleMain checkstyleTest

update-deps:
	./app/gradlew useLatestVersions

dev:
	./app/gradlew clean
	./app/gradlew installDist
	./build/install/app/bin/app



build-run: build run

.PHONY: build