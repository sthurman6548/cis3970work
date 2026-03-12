#!/bin/bash

echo -n "Enter number of clients to run: "
read num

for (( i=1; i <=num; i++))
do
	java CounterClient &
done

wait 

echo "All clients finished."
