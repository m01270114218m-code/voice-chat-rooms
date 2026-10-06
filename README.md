# VoiceHub - تطبيق غرف دردشة صوتية احترافي

## نظرة عامة
VoiceHub هو تطبيق Android احترافي لـ غرف الدردشة الصوتية الحية مع واجهة عربية جميلة وحديثة.

## المميزات
✅ واجهة مستخدم عربية احترافية
✅ نظام تسجيل دخول وإنشاء حساب
✅ غرف دردشة صوتية حية
✅ التحكم بالميكروفون (تشغيل/إيقاف)
✅ قائمة الأعضاء النشطين
✅ نظام Socket.io للاتصالات الحقيقية
✅ دعم WebRTC للصوت
✅ حفظ الجلسات (DataStore)
✅ Material Design 3
✅ Dark/Light Mode Support

## المتطلبات
- Android 7.0+ (API 24)
- Android Studio 2024.1+
- Kotlin 1.9.24+
- Java 17+

## المكتبات المستخدمة
- **Jetpack Compose**: UI Framework
- **Hilt**: Dependency Injection
- **Retrofit**: HTTP Client
- **Socket.io**: Real-time Communication
- **WebRTC**: Audio Streaming
- **Room Database**: Local Data Storage
- **DataStore**: Secure Preferences
- **Material 3**: Design System

## التثبيت

### 1. استنساخ المستودع
```bash
git clone https://github.com/yourusername/voicehub.git
cd voicehub
```

### 2. فتح المشروع في Android Studio
```bash
open -a "Android Studio" .
```

### 3. تثبيت البرنامج على جهازك
- قم بتوصيل جهاز Android أو استخدم محاكي
- انقر على "Run" في Android Studio

## إعداد الخادم (Backend)

### 1. المتطلبات
```bash
Node.js 16+
npm أو yarn
```

### 2. التثبيت
```bash
cd backend
npm install
```

### 3. تشغيل الخادم
```bash
npm start
```

سيعمل الخادم على `http://localhost:3001`

## هيكل المشروع

```
voicehub/
├── app/
│   ├── src/main/java/com/voicehub/app/
│   │   ├── data/
│   │   │   ├── local/        # Local database
│   │   │   ├── remote/       # API & Network
│   │   │   ├── repository/   # Data repositories
│   │   │   ├── socket/       # Socket.io
│   │   │   └── webrtc/       # WebRTC
│   │   ├── di/               # Hilt modules
│   │   ├── presentation/
│   │   │   ├── screens/      # UI Screens
│   │   │   ├── viewmodel/    # ViewModels
│   │   │   └── navigation/   # Navigation
│   │   └── ui/theme/         # Theme & Colors
│   └── AndroidManifest.xml
├── backend/
│   ├── server.js
│   └── package.json
└── README.md
```

## استخدام التطبيق

### 1. تسجيل الدخول
- أدخل بريدك الإلكتروني وكلمة المرور
- أو قم بإنشاء حساب جديد

### 2. استعراض الغرف
- الصفحة الرئيسية تعرض جميع الغرف المتاحة
- انقر على أي غرفة للدخول إليها

### 3. داخل الغرفة
- شاهد قائمة الأعضاء النشطين
- تحكم بالميكروفون (مفتوح/مغلق)
- شارك الفيديو أو الرسائل النصية
- اترك الغرفة بالنقر على زر إغلاق المكالمة

## الصلاحيات المطلوبة

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS" />
```

## كيفية البناء للإطلاق

### 1. توليد Keystore
```bash
keytool -genkey -v -keystore voicehub-release.jks -keyalg RSA -keysize 2048 -validity 10000 -alias voicehub
```

### 2. إعدادات Gradle
أضف في `app/build.gradle.kts`:
```kotlin
signingConfigs {
    release {
        storeFile = file("voicehub-release.jks")
        storePassword = "your-password"
        keyAlias = "voicehub"
        keyPassword = "your-password"
    }
}
```

### 3. البناء
```bash
./gradlew assembleRelease
```

## Troubleshooting

### المشكلة: لا يمكن الاتصال بالخادم
**الحل**: تأكد من أن الخادم يعمل وأن رقم المنفذ صحيح

### المشكلة: لا يعمل الميكروفون
**الحل**: تحقق من صلاحيات التطبيق في إعدادات الجهاز

### المشكلة: خطأ في المصادقة
**الحل**: تأكد من صحة بيانات تسجيل الدخول

## المساهمة
نرحب بالمساهمات! يرجى:
1. عمل fork للمستودع
2. إنشاء فرع جديد
3. إرسال pull request

## الترخيص
MIT License

## الدعم
للتواصل أو الإبلاغ عن مشاكل:
- البريد الإلكتروني: support@voicehub.app
- GitHub Issues: [create an issue]

## المطورون
- **Name**: VoiceHub Team
- **GitHub**: @yourusername

---

**VoiceHub** - غرف صوتية احترافية 🎙️
