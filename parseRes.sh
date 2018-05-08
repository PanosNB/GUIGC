#! /bin/bash

for fileName in `ls $1`
do
	awk -v fileName="$fileName" '
		BEGIN {
			split(fileName, tokens, ".")
			count = 0
		} 

		{
			if (count>0){
				for (i in tokens) {
					printf("%s\t", tokens[i]);
				}
				printf("%d", count);
				for (i=1; i<=NF; i++){
					printf("\t%s", $i);
				}
				printf("\n");
			}
			count++;
		}

	' $fileName

done
