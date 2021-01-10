#!/bin/bash
#参考启动命令sh test.sh 2.0.0 1.0.0
time=$(date "+%Y-%m-%d %H:%M:%S")

echo "${time} 执行的文件名：$0";
echo "新版本号参数为：$1";
echo "旧版本号参数为：$2";


newVersion="$1"
oldVersion="$2"

echo "开始执行自动升级脚本……"

docker pull 192.168.1.110/fwh/fwh-test:"${newVersion}"
if [ $? -ne 0 ]; then    
    echo "失败：无法拉取容器fwh-test-""${newVersion}"
    exit
else    
    echo "成功：拉取容器fwh-test-""${newVersion}"
    docker stop fwh-test-"${oldVersion}"
	if [ $? -ne 0 ]; then    
	    echo "失败：无法停止容器fwh-test-""${oldVersion}"
	    exit
	else    
	    echo "成功：停止容器fwh-test-""${oldVersion}"
	    docker run -d --name fwh-test-"${newVersion}" -p 9000:9000 192.168.1.110/fwh/fwh-test:"${newVersion}"
		if [ $? -ne 0 ]; then    
		    echo "失败：无法启动容器fwh-test-""${newVersion}"
		    docker start fwh-test-"${oldVersion}"
		    if [ $? -ne 0 ]; then    
			    echo "失败：无法恢复容器fwh-test-""${oldVersion}""请联系管理员"
			else    
				echo "成功：成功恢复容器fwh-test-""${oldVersion}"
			fi
		    exit
		else    
		    echo "成功：启动容器fwh-test-""${newVersion}"
		    docker rm fwh-test-"${oldVersion}"
			if [ $? -ne 0 ]; then    
			    echo "失败：无法删除旧容器fwh-test-""${oldVersion}"
			else    
			    echo "成功：删除旧容器fwh-test-""${oldVersion}"
			fi

		fi

	fi
fi

echo "${time} 脚本执行完毕"
echo "OK"
