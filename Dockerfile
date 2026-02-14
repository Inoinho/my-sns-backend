# 1. 빌드 단계 (Build Stage)
FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /app
COPY . .
# 윈도우에서 작성된 gradlew 파일에 실행 권한 부여 및 빌드
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

# 2. 실행 단계 (Run Stage)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# 빌드 단계에서 생성된 jar 파일만 쏙 가져오기
COPY --from=build /app/build/libs/*.jar app.jar
# 포트 설정 (Render는 기본적으로 10000번이나 8080을 권장합니다)
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]