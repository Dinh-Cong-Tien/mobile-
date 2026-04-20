# Examples — hướng dẫn nhanh

Thư mục này chứa các chương trình Kotlin mẫu (mỗi file có `main`) để bạn thử từng bài tập độc lập.

Yêu cầu trước khi chạy
- Java (JDK) và Kotlin compiler (`kotlinc`) phải có trong PATH.

Biên dịch và chạy một demo (cmd.exe):
```cmd
cd /d d:\testkotlin
kotlinc examples\Introduction.kt -include-runtime -d Introduction.jar
java -jar Introduction.jar
```

Biên dịch tất cả các demo thành các jar (cmd.exe, chạy trực tiếp trong terminal):
```cmd
cd /d d:\testkotlin
for %F in (examples\*.kt) do kotlinc %F -include-runtime -d %~nF.jar
```
(Trong batch file, dùng `%%F` thay cho `%F`.)

Gợi ý nhanh
- Nếu muốn chạy một demo trực tiếp từ source (không tạo jar), dùng `kotlinc -d out <file>` rồi `kotlin -classpath out <MainKt>`.
- Nếu bạn muốn, tôi có thể tạo sẵn các script `build-examples.bat` và `run-example.bat` để tự động hoá các bước trên.

Danh sách demo hiện có:
- AdvancedDice.kt
- BuildingVisualizer.kt
- CalculatorOps.kt
- GeometryFunctions.kt
- Introduction.kt
- PetInformation.kt
- ProductClass.kt
- SmartHomeWhen.kt
- UserInputLogic.kt
- WeatherCheck.kt
