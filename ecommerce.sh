#!/bin/bash

COMMON_FILE="infra/docker-compose/common.yml"
ZOOKEEPER_FILE="infra/docker-compose/zookeeper.yml"
KAFKA_CLUSTER_FILE="infra/docker-compose/kafka_cluster.yml"
INIT_KAFKA_FILE="infra/docker-compose/init_kafka.yml"
POSTGRES_FILE="infra/docker-compose/postgres.yml"

# Function to check if Docker is running
check_docker() {
    if ! docker info > /dev/null 2>&1; then
        echo "Docker is not running. Please start Docker and try again."
        exit 1
    fi
}

start_services() {
    echo "Starting all services..."
    docker compose -f "$COMMON_FILE" -f "$ZOOKEEPER_FILE" up -d
    docker compose -f "$COMMON_FILE" -f "$KAFKA_CLUSTER_FILE" up -d
    docker compose -f "$COMMON_FILE" -f "$INIT_KAFKA_FILE" up -d
    docker compose -f "$POSTGRES_FILE" -f "$INIT_KAFKA_FILE" up -d
}

show_status() {
    echo "Showing status of running containers..."
    docker compose -f "$COMMON_FILE" -f "$ZOOKEEPER_FILE" ps
    docker compose -f "$COMMON_FILE" -f "$KAFKA_CLUSTER_FILE" ps
    docker compose -f "$COMMON_FILE" -f "$INIT_KAFKA_FILE" ps
    docker compose -f "$POSTGRES_FILE" -f "$INIT_KAFKA_FILE" ps
}

stop_services() {
    echo "Stopping all services..."
    docker compose -f "$COMMON_FILE" -f "$ZOOKEEPER_FILE" down
    docker compose -f "$COMMON_FILE" -f "$KAFKA_CLUSTER_FILE" down
    docker compose -f "$COMMON_FILE" -f "$INIT_KAFKA_FILE" down
    docker compose -f "$POSTGRES_FILE" -f "$INIT_KAFKA_FILE" down
}

# Check if Docker is running
check_docker

# Parse command-line arguments
case "$1" in
    start)
        start_services
        show_status
        ;;
    stop)
        stop_services
        ;;
    restart)
        stop_services
        start_services
        show_status
        ;;
    status)
        show_status
        ;;
    *)
        echo "Usage: $0 {start|stop|restart|status}"
        exit 1
        ;;
esac
