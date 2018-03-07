Entry.class: Entry.java WordLadder.class
	javac Entry.java

WordLadder.class: ./components/WordLadder.java
	javac ./components/WordLadder.java -Xlint:unchecked

Test: WordLadderTest.java WordLadder.class
	javac -cp /opt/java/jdk-9.0.4/lib/junit-4.9.jar:. WordLadderTest.java

clean:
	rm ./components/WordLadder.class Entry.class WordLadderTest.class
