# 基本运行
docker run -d -p 8080:8080 --name vlv-emsp-container vlv-emsp:1.0.0
# 带环境变量（示例）
docker run -d \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://db-host:3306/db \
  -e JAVA_OPTS="-Xmx512m" \
  vlv-emsp:1.0.0

# 查看日志
docker logs -f vlv-emsp-container