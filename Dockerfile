# 阶段1：构建应用
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

# 阶段2：运行应用
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# 设置时区并清理
RUN apk add --no-cache tzdata && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone && \
    apk del tzdata

# 复制JAR (使用明确名称)
COPY --from=builder /app/target/vlv-emsp.jar ./app.jar

EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=dev
ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]
