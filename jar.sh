#!/bin/bash 
DATE=$(date +"%y-%m-%d-%H:%M")
jar="yqApi-0.0.1-SNAPSHOT.jar"
#查看jar包的进程 以及端口号
kiall=$(ps -aux | grep $jar |grep -v 'grep'| awk '{print $2}')
kill $kiall
if [$? -eq 0];then
echo "进程成功杀死"
else
echo "进程error" 
exit 2
fi

PS=$(ps -aux | grep -q "$jar")
port=$(ss -ntupl | grep-q  9300)
if [ $PS -gt 1 ] && [ $port -eq 0 ];
echo  "已经查看进程端口完毕"
else
echo "还有没死掉的进程或者端口"
exit 2
fi

if [ -e $jar ];then
mv "$jar"  "$jar.bak$DATE"
else
echo "文件不存在"
exit 2
fi
#开始更改新的jar包成为旧的文件名
mv "$1" "$jar"
echo "更改jar完成 $jar"
nohup java -jar "$jar" &


PS1=$(ps -aux | grep -q  "$jar")
port1=$(ss -ntupl | grep -q 9300)
if [ $PS1 -gt 2 ] && [ $port -gt 1 ];
echo  "进程端口启动完毕 $PS1 $port1"
else
echo "启动失败"
exit 2
fi

tail -f nohup.out
