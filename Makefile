
SRC_DIR := src
BIN_DIR := bin
JAR_NAME := SnakeGame.jar
MANIFEST_FILE := manifest.txt

JAVA_FILES := $(wildcard $(SRC_DIR)/**/*.java)

all: clean compile jar run

clean:
	@if exist $(BIN_DIR) rd /s /q $(BIN_DIR)
	@mkdir $(BIN_DIR)

compile:
	@javac -d $(BIN_DIR) $(JAVA_FILES)

jar: compile
	@jar cfm $(JAR_NAME) $(MANIFEST_FILE) -C $(BIN_DIR) .

run: jar
	@java -jar $(JAR_NAME)

# Phony targets
.PHONY: clean compile jar run all