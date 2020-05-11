#!/bin/bash
echo 'Running Script'
list=$(gcloud run revisions list --platform=managed --region=europe-north1 --project=sep6-276712)

# split result
IFS=$'\n' read -rd '' -a array <<< $list

for element in "${array[@]}";
do
    IFS=$'  ' read -rd '' -a line <<< $element
    len=${#line[@]}
    if [ $len -eq 7 ]
    then
        echo "Removing revision ${line[1]}"
        yes | gcloud run revisions delete ${line[1]} --platform=managed --region=europe-north1 --project=sep6-276712 
    fi
done