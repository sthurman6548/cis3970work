#!/bin/bash

num=$1

if [ -z "$num" ]; then
	echo "Usage: ./client.sh <number_of_clients>"
	exit 1
fi

for ((i=1; i<=num; i++))
do
	java CounterClient &
done | sort -n > results.txt

wait

echo "Results saved to results.txt"
