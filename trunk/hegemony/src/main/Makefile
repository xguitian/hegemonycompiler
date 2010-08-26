# You need CUP v0.10j (or newer) for this makefile to work
#
# CUP classes should be included in CLASSPATH 

CUP        = $(JAVA) $(JAVAFLAGS) java_cup.Main -interface <
JFLEX      = ../../jflex/bin/jflex
JAVA       = java
JAVAC      = javac
JAVAFLAGS  = -classpath $(CLASSPATH):../../

# --------------------------------------------------

all: test

test: lexer-output.txt
	@(diff lexer-output.txt lexer-output.good && echo "Test OK!") || echo "Test failed!"

lexer-output.txt: compile
	$(JAVA) $(JAVAFLAGS) hegemony.scanner.TestLexer order_test.txt > lexer-output.txt


compile: pre
	$(JAVAC) $(JAVAFLAGS) HegemonyParser.java TestLexer.java

pre: scanner parser unicode

parser: parser.java 

parser.java: Hegemony.cup
	$(CUP) Hegemony.cup

scanner: HegemonyScanner.java

HegemonyScanner.java: HegemonyScanner.l
	$(JFLEX) HegemonyScanner.l

unicode: UnicodeEscapes.java

UnicodeEscapes.java: unicode.flex
	$(JFLEX) unicode.flex

clean:
	rm -f *.class
	rm -f *~
	rm -f HegemonyScanner.java
	rm -f parser.java
	rm -f sym.java
	rm -f UnicodeEscapes.java
	rm -f lexer-output.txt
