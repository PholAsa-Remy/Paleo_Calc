.PHONY: all clean

JFLEX_OUTPUT = paleo-lib/src/main/java/paleo/lib/parser/Lexer.java
JAR_NAME = paleo-calculator

all: lib calc

lib:
	if [ -f $(JFLEX_OUTPUT) ]; then rm $(JFLEX_OUTPUT)*; fi;
	cd paleo-lib && mvn package install

calc:
	cd paleo-calc && mvn compile test assembly:single
	cp paleo-calc/target/calc-0.1-jar-with-dependencies.jar \
	   $(JAR_NAME).jar

run:
	java -jar $(JAR_NAME).jar

clean:
	if [ -f $(JAR_NAME).jar ]; then rm $(JAR_NAME).jar; fi;
	cd paleo-lib && mvn clean
	cd paleo-calc && mvn clean

generate-doc:
	cd paleo-lib && mvn site
	cd paleo-calc && mvn site
