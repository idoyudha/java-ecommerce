#local-confluent-kafka-cp-zookeeper-headless
kafka-topics --zookeeper $1:2181 --topic payment-created --delete --if-exists
kafka-topics --zookeeper $1:2181 --topic payment-updated --delete --if-exists

kafka-topics --zookeeper $1:2181 --topic payment-created --create --partitions 3 --replication-factor 3 --if-not-exists
kafka-topics --zookeeper $1:2181 --topic payment-updated --create --partitions 3 --replication-factor 3 --if-not-exists
