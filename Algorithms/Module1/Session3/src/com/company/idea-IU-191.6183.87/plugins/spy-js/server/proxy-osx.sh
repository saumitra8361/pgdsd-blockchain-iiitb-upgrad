#!/bin/bash

autod=""
bypass=""
autop=""

# populating variables from passed params
while echo $1 | grep ^- > /dev/null; do
    eval $( echo $1 | sed 's/-//g' | tr -d '\012')=$2
    shift
    shift
done

# determining active network service
SERVICE_INTERFACE=$(route get 0.0.0.0 2>/dev/null | awk '/interface: / {print $2}')
SERVICE_NAME=`networksetup -listnetworkserviceorder | grep "Device: "$SERVICE_INTERFACE"" | awk -F '[, ]' '{print $3}'`

# saving and displaying current settings
SERVICE_AUTODISC=`networksetup -getproxyautodiscovery "$SERVICE_NAME" | awk {'print $4'}`
printf "$SERVICE_AUTODISC;"
SERVICE_AUTOPROXY_ENABLED=`networksetup -getautoproxyurl "$SERVICE_NAME" | awk {'print $2'} | awk 'FNR == 2 {print}' | cut -d' ' -f2`
printf "$SERVICE_AUTOPROXY_ENABLED;"
SERVICE_AUTOPROXY_URL=`networksetup -getautoproxyurl "$SERVICE_NAME" | awk {'print $2'} | awk 'FNR == 1 {print}' | cut -d' ' -f2`
printf "$SERVICE_AUTOPROXY_URL;"
SERVICE_BYPASS=`networksetup -getproxybypassdomains "$SERVICE_NAME" | awk 'index($0,"There")==0' RS='#' |\
awk -v RS="" -v OFS=', ' '$1=$1' | awk '{ gsub (" ", "", $0); print}'`
printf "$SERVICE_BYPASS"

params=""
# modifying settings if they have changed
if [[ X"$SERVICE_AUTODISC" != X"$autod" ]];
then
    params="${params} -setproxyautodiscovery \"$SERVICE_NAME\" ${autod}";
fi

if [[ X"$SERVICE_BYPASS" != X"$bypass" ]];
then
    if [[ X"" = X"$bypass" ]];
	then params="${params} -setproxybypassdomains \"$SERVICE_NAME\" Empty";
	else params="${params} -setproxybypassdomains \"$SERVICE_NAME\" ${bypass}";
    fi
fi

if [[ X"$SERVICE_AUTOPROXY_ENABLED" != X"Yes" ]] || [[ X"$SERVICE_AUTOPROXY_URL" != X"$autop" ]];
then
    if [[ X"" = X"$autop" ]];
	then params="${params} -setautoproxystate \"$SERVICE_NAME\" Off";
	else params="${params} -setautoproxyurl \"$SERVICE_NAME\" ${autop}";
    fi
fi

eval networksetup $params