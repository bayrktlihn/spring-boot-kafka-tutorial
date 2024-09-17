package io.bayrktlihn.springbootkafkatutorial.kafka;

public interface Publisher {

    <V> void publish(String topicName, String key, V value);


}
