#!/bin/bash
mysql_user="sjsyq"
mysql_password="sjsyq"
mysql_ip="10.0.0.11"
mysql_database="sjsyq"
time_create=$(date "+%y-%m-%d")
time_delete=$(date)
bak_dir="/home/data1/sql_bak"
if [  -d $bakdir];then
cd "$bak_dir"
#mysql -h"$mysql_ip" -u"$mysql_user" -p"$mysql_password" -e 'show databases;'
mysqldump -h"$mysql_ip" -u"$mysql_user" -p"$mysql_password" -B $mysql_database >"mysql$time_create.sql"  && echo "mysql$time_create.sql创建完成" >> ./sqlbak.log
else
mkdir -p "$bak_dir"
echo "mysql$time_create.sql创建失败" >>./sqlbak.log
fi



