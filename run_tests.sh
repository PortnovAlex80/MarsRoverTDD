#!/bin/bash

# Function to run the tests
run_tests() {
  echo "Running tests..."
  ./gradlew test
  exit_code=$?
  if [ $exit_code -eq 0 ]; then
    echo "All tests passed!"
  else
    echo "Some tests failed. Exiting..."
    exit 1
  fi
}

# Run the tests
run_tests
