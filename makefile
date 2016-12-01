
install:
	javac src/producer_consumer/*.java -d ./ -classpath ./
	jar cvf ProducerConsumer.jar ./producer_consumer
	rm producer_consumer/*.class
	rmdir producer_consumer

doc:
	javadoc src/producer_consumer/*.java -sourcepath src/producer_consumer -d javadoc -classpath ./

run:
	java -cp "ProducerConsumer.jar" producer_consumer/ProducerConsumer

clean:
	rm -rf *~
	rm -rf javadoc/
	rm -f ProducerConsumer.jar
