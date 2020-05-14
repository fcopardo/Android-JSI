README
======

C - JS - Java bridge example

This subproject showcases how to connect the C to JS layer (JSI) with the C to java layer (JNI).

Parts:

android/app: Demo app. Just renders the usual hello world screen with a method call.
native/TurboDatabase/android: Library project exposing the method called by the app. While is a react-native module, it 
does not need to be, but it needs to consume ReactCommon C headers.

main/cpp: The C code.
main/java: The exposed java APIs.

Unlike regular RN projects, the binding in this case is a patch into the javascript engine (C), thus exposing your 
android code directly through the global javascript object. Regular JNI specs apply, so we can use C reflection to 
create any kind of java object directly. Crashes in the C side will show the RN C layer as the source of the failure, 
since the code is running from there.
