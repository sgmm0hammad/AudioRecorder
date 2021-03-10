# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.dimowner.audiorecorder.** { *; }

-keepattributes SourceFile,LineNumberTable        # Keep file names and line numbers.
-keep public class * extends java.lang.Exception  # Optional: Keep custom exceptions.


-keep class org.jaudiotagger.test.**{*;}
-keep class org.jaudiotagger.fix.**{*;}
-keep class org.jaudiotagger.audio.mp4.**{*;}
-keep class org.jaudiotagger.tag.datatype.**{*;}
-keep class org.jaudiotagger.tag.**{*;}
-keep class org.jaudiotagger.tag.asf.**{*;}
-keep class org.jaudiotagger.tag.flac.**{*;}
-keep class org.jaudiotagger.logging.**{*;}
-keep class org.jaudiotagger.tag.vorbiscomment.**{*;}