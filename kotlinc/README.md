# testkotlin

Nhỏ: dự án Kotlin đơn giản với unit test (JUnit 5).

Chạy test trên Windows (cần Gradle cài sẵn):

```
gradle test
```

Nếu muốn dùng Gradle Wrapper (khuyến nghị để đảm bảo phiên bản Gradle):

1. Tạo wrapper (cần Gradle cài sẵn):

```
gradle wrapper --gradle-version 8.5
```

2. Sau đó chạy trên Windows:

```
.\gradlew.bat test
```

Nội dung chính:

Examples and demos
------------------
I moved the example/demo Kotlin files out of the main source tree. If you want to keep example code, use the `examples/` folder in the project root. The `examples/` folder can store small demo programs that are not part of the build.

How to add an example:

1. Create `examples/` in the project root (already created by the repo assistant).
2. Add Kotlin files under `examples/`, for example `examples/Introduction.kt`.
3. Compile and run an example without Gradle:

```cmd
kotlinc examples\Introduction.kt -include-runtime -d intro.jar
java -jar intro.jar
```

Note: some demo files were removed to tidy the repository. If you need them restored, paste the source into `examples/` or ask me to recreate specific examples.
