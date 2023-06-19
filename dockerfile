# 使用官方的Java开发镜像作为基础镜像
FROM openjdk:8-jdk-alpine

# 添加一个卷，以便于在外部访问容器内的数据
VOLUME /tmp

# 设置应用程序的JAR文件作为`app.jar`
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# 启动应用程序
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
