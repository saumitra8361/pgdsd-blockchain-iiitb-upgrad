#!/bin/bash
autom=""
autou=""
while echo $1 | grep ^- > /dev/null; do
   eval $( echo $1 | sed 's/-//g' | tr -d '\012')=$2
   shift
   shift
done
SERVICE_AUTOPROXY_MODE=`gsettings get org.gnome.system.proxy mode`
SERVICE_AUTOPROXY_URL=`gsettings get org.gnome.system.proxy autoconfig-url`
printf "$SERVICE_AUTOPROXY_MODE;$SERVICE_AUTOPROXY_URL"
gsettings set org.gnome.system.proxy mode ${autom}
gsettings set org.gnome.system.proxy autoconfig-url ${autou}