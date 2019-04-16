FROM azul/zulu-openjdk-alpine:11
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
# This application listens on the standard SpringBoot port 8080
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.expensetracker.ExpenseTrackerApplication"]