# 1. 자바 21(또는 17) 환경 선택 (Render 무료플랜 안정성 기준)
FROM openjdk:21-jdk-slim
# 2. 빌드된 jar 파일을 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
# 3. 서버 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]