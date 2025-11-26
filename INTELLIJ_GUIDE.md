# IntelliJ IDEA에서 프로젝트 실행하기

## ✅ 문제 해결 완료

서브프로젝트의 `settings.gradle` 파일들을 모두 제거하여 IntelliJ가 올바르게 멀티 모듈 프로젝트를 인식하도록 수정했습니다.

## 🚀 프로젝트 실행 방법

### 1. IntelliJ에서 프로젝트 열기

**중요: 반드시 루트 디렉토리(`wooteco8th-`)를 열어야 합니다!**

```
File → Open → /Users/jins/Desktop/project/2024wootecho/wooteco8th- 선택
```

### 2. Gradle 동기화

- `View` → `Tool Windows` → `Gradle`
- 새로고침 버튼(🔄) 클릭
- 모든 서브프로젝트가 로드될 때까지 대기

### 3. Java SDK 설정 확인

- `File` → `Project Structure` (⌘;)
- `Project` → `SDK`: Java 21 선택
- `Modules` → 각 모듈의 Language level: 21 확인

### 4. 프로젝트 실행

#### 방법 1: Application.java에서 직접 실행 (추천)

1. 원하는 프로젝트의 `Application.java` 파일 열기
   - 예: `7-period/java-attendance-7-main/src/main/java/attendance/Application.java`
2. `main` 메서드 옆의 초록색 실행 버튼(▶️) 클릭
3. 또는 단축키: `Ctrl+Shift+R` (Mac) / `Ctrl+Shift+F10` (Windows)

#### 방법 2: Gradle 태스크로 실행

```bash
# 터미널에서
./gradlew :7-period:java-attendance-7-main:build
```

## 📁 프로젝트 구조

```
wooteco8th/
├── settings.gradle          # 루트 설정 (모든 서브프로젝트 정의)
├── build.gradle             # 공통 빌드 설정
└── [3~8]-period/           # 각 기수별 프로젝트
    └── java-xxx/
        ├── src/
        │   ├── main/java/
        │   └── test/java/
        └── build.gradle     # 서브프로젝트는 자동으로 상속
```

## 🔧 문제 해결

### "Cannot locate tasks" 오류가 나는 경우

1. **IntelliJ 캐시 삭제**
   ```
   File → Invalidate Caches → Invalidate and Restart
   ```

2. **.idea 폴더 삭제 후 재시작**
   ```bash
   cd /Users/jins/Desktop/project/2024wootecho/wooteco8th-
   rm -rf .idea .gradle
   # IntelliJ에서 프로젝트 다시 열기
   ```

3. **Gradle 재동기화**
   - Gradle 창에서 새로고침(🔄) 버튼 클릭

### 여전히 문제가 있는 경우

**확인 사항:**
- ✅ 루트 디렉토리(`wooteco8th-`)를 열었는지 확인
- ✅ 서브프로젝트를 직접 열지 않았는지 확인
- ✅ Java 21이 설치되어 있는지 확인

**올바른 실행 방법:**
```
✅ 올바름: IntelliJ에서 Application.java 파일 열고 실행 버튼 클릭
❌ 잘못됨: Gradle 태스크에서 ":7-period:java-attendance-7-main:attendance.Application.main()" 실행
```

## 💡 팁

- 각 프로젝트는 독립적으로 실행 가능합니다
- 모든 프로젝트는 동일한 Java 21 및 의존성 설정을 공유합니다
- 테스트는 구현 전이므로 실패할 수 있습니다 (정상)
